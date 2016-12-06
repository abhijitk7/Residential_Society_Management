(function() {
	'use strict';

	angular.module('SocietyManagementSystem', [ 'ngRoute', 'ngCookies' ])
			.config(config).run(run);

	config.$inject = [ '$routeProvider', '$locationProvider' ];
	function config($routeProvider, $locationProvider) {
		$routeProvider.when('/login', {
			templateUrl : 'views/login.html',
			controller : 'LoginController',
			controllerAs : 'vm'
		}).when('/register', {
			controller : 'RegisterController',
			templateUrl : 'views/registration.html',
			controllerAs : 'vm'
		}).when('/Home', {
			templateUrl : 'views/home.html'
		}).when('/Dashboard', {
			templateUrl : 'views/dashboard.html'
		}).when('/404', {
			templateUrl : 'views/404.html'
		}).otherwise({
			redirectTo : '/login'
		});
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http' ];
	function run($rootScope, $location, $cookieStore, $http) {
		// keep user logged in after page refresh
		$rootScope.globals = $cookieStore.get('globals') || {};
		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic '
					+ $rootScope.globals.currentUser.authdata; // jshint
			// ignore:line
		}

		$rootScope.$on('$locationChangeStart', function(event, next, current) {
			// redirect to login page if not logged in and trying to access a
			// restricted page
			var restrictedPage = $.inArray($location.path(), [ '/login',
					'/register' ]) === -1;
			var loggedIn = $rootScope.globals.currentUser;
			if (restrictedPage && !loggedIn) {
				$location.path('/login');
			}
		});
	}

})();