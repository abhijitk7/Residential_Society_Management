(function() {
	'use strict';

	angular.module('SocietyManagementSystem').controller(
			'LoginController',
			[ '$scope', 'commonService', 'ContextRoot',
					function($scope, commonService, ContextRoot) {

						$scope.whoAmI = function() {
							var url = ContextRoot + "/getUserDetails";
							var promise = commonService.ajaxCall(url, 'GET');
							promise.then(function(data) {
								$scope.user = data;
							});
						};

					} ]);
})();