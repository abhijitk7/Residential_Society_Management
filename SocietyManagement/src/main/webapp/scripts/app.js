(function() {
	'use strict';

	angular.module('SocietyManagementSystem',
			[ 'ngRoute', 'angularModalService' ]).config(
			[ '$routeProvider', function($routeProvider) {
				$routeProvider.when('/', {
					templateUrl : 'views/login.html',
					controller : 'LoginController'
				});
				$routeProvider.when('/404', {
					templateUrl : 'views/404.html'
				});
				$routeProvider.otherwise({
					redirectTo : '/'
				});
			} ]);
})();