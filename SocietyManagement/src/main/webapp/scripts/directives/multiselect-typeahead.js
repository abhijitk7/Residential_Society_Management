angular.module('typeahead', [])
  .directive('typeahead', function () {
    return {
      restict: 'AEC',
      scope: {
        items: '='
      },
      require: 'ngModel',
      link: function(scope, elem, attrs, ngModel) {
        var blur = false;
        scope.focused = false;
        scope.list = [];
        scope.filteredItems = scope.items;
        scope.selPos = 0;
        
        scope.focusIn = function() {
          if (!scope.focused){
            scope.focused = true;
            blur = false;
            scope.selPos = 0;
          }
        };

        scope.focusOut = function() {
          scope.itemsearch = "";
          if (!blur) {
            scope.focused = false;
          } else {
            angular.element(elem).find('input')[0].focus();
            blur = false;
          }
        };
        
        // Change me for custom display name on select list
        scope.getDisplayItem = function(item) {
          return item[attrs.displayitem]; 
        };
        
        // Change me for custom display name on tags (chips)
        scope.getDisplayTag = function(item) {
          return item[attrs.displaytag];
        };
        
        scope.addItem = function(item) {
          if (item) {
            scope.list.push(item);
            scope.itemsearch = "";
            blur = true;
            if (scope.selPos >= scope.filteredItems.length-1) {
              scope.selPos--; // To keep hover selection
            }
            ngModel.$setViewValue(scope.list);
          }
        };
        
        scope.removeItem = function(item) {
          scope.list.splice(scope.list.indexOf(item), 1);
          ngModel.$setViewValue(scope.list);
        };

        scope.hover = function(index) {
          scope.selPos = index;
        };

        scope.keyPress = function(evt) {
          console.log(evt.keyCode);
          var keys = {
            38: 'up',
            40: 'down',
            8 : 'backspace',
            13: 'enter',
            9 : 'tab',
            27: 'esc'
          };
          
          switch (evt.keyCode) {
            case 27:
              scope.focusOut();
              break;
            case 13: 
              if(scope.selPos > -1) {
                scope.addItem(scope.filteredItems[scope.selPos]);
              }
              break;
            case 8: 
              if (!scope.itemsearch || scope.itemsearch.length == 0) {
                if (scope.list.length > 0) {
                  scope.list.pop();
                }
              }
              break;
            case 38: 
              if (scope.selPos > 0) {
                scope.selPos--;
              } 
              break;
            case 40: 
              if (scope.selPos < scope.filteredItems.length-1) {
                scope.selPos++; 
              }
              break;
            default:
              scope.selPos = 0;
              scope.focusIn();
          }
        };
      },
      template: '<div class="typeahead">\
        <ul data-ng-class="{\'focused\': focused}" \
            class="tags" data-ng-click="focusIn()">\
          <li class="tag" data-ng-repeat="s in list track by $index">\
            {{getDisplayTag(s)}} <span data-ng-click="removeItem(s)">x</span>\
          </li> \
          <li class="inputtag">\
            <input data-ng-blur="focusOut()" focus="{{focused}}" data-ng-model-options="{debounce: 500}" \
            type="text" data-ng-model="itemsearch" data-ng-keydown="keyPress($event)"/>\
          </li>\
        </ul>\
        <ul class="list" data-ng-show="focused">\
          <li data-ng-class="{\'active\': selPos == $index}" \
              data-ng-repeat="item in (filteredItems = (items | notin: list | filter: itemsearch | limitTo: 10)) track by $index" \
              data-ng-mousedown="addItem(item)" data-ng-mouseover="hover($index)">\
          {{getDisplayItem(item)}}\
          </li>\
        </ul>\
      </div>'
    };
  }).directive('focus', function () {
    return {
      restrict: 'A',
      link: function (scope, element, attrs) {
        attrs.$observe('focus', function (newValue) {
          if (newValue == 'true') {
            element[0].focus();
          }
        });
      }
    }
  }).filter('notin', function() {
    return function(listin, listout) {
      return listin.filter(function(el) { 
        return listout.indexOf(el) == -1;
      });
    };
  });



    
    