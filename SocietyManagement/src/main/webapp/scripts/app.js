(function() {
	'use strict';

	angular.module('smsApp',
			[ 'ngRoute', 'smsApp.services', 'smsApp.controllers' ]).config(
			function($routeProvider) {
				$routeProvider.when('/', {
					templateUrl : 'views/login.html',
					controller : 'TodoListCtrl'
				}).when('/404', {
					templateUrl : 'views/404.html'
				}).otherwise({
					redirectTo : '/'
				})
			});
})();
