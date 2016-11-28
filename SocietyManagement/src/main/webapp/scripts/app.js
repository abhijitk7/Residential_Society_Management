var app = angular.module('SocietyManagementSystem', [ 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'views/login.html',
				controller : 'LoginController'
			});
			$routeProvider.when('/404', {
				templateUrl : 'views/404.html'
			});
			$routeProvider.when('/Sucess', {
				templateUrl : 'views/test.html'
			});
			$routeProvider.otherwise({
				redirectTo : '/'
			});
		} ]);
