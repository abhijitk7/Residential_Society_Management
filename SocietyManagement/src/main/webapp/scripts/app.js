(function() {
	'use strict';

	angular.module('SocietyManagementSystem', [ 'ngRoute', 'ngCookies' ])
			.config(config).run(run);

	config.$inject = [ '$routeProvider', '$locationProvider','$httpProvider' ];
	function config($routeProvider, $locationProvider,$httpProvider) {
		$routeProvider.when('/login', {
			templateUrl : 'views/login.html',
			controller : 'LoginController',
			controllerAs : 'vm'
		}).when('/register', {
			controller : 'RegisterController',
			templateUrl : 'views/registration.html',
			controllerAs : 'vm'
		}).when('/Home', {
			controller : 'HomeController',
			templateUrl : 'views/home.html',
			controllerAs : 'vm'
		}).when('/Dashboard', {
			templateUrl : 'views/dashboard.html'
		}).when('/error', {
			templateUrl : 'views/404.html'
		}).otherwise({
			redirectTo : '/login'
		});
		
		/* Register error provider that shows message on failed requests or redirects to login page on
                 * unauthenticated requests */
        $httpProvider.interceptors.push(function($q, $rootScope, $location,$log) {
            return {
                'responseError': function(rejection) {
                    var status = rejection.status;
                    var config = rejection.config;
                    var method = config.method;
                    var url = config.url;
                    if(status===505 ){
                    	$log.debug("505 Error occured...");
                    	$location.path("/error");
                    }
                	
                    return $q.reject(rejection);
                }
            };
        });

        /* Registers auth token interceptor, auth token is either passed by header or by query parameter
         * as soon as there is an authenticated user */
        $httpProvider.interceptors.push(function($q, $rootScope, $location,$log) {
            return {
                'request': function(config) {
                	
                	$log.debug("Interceptor called...");
                    var isRestCall = config.url.indexOf('.do') === 0;
                    if (isRestCall && angular.isDefined($rootScope.authToken)) {
                        var authToken = $rootScope.authToken;
                        if (smsAppConfig.useAuthTokenHeader) {
                        	$log.debug("Token passed through header...");
                            config.headers['X-Auth-Token'] = authToken;
                        } else {
                        	$log.debug("Token passed through query parameter ...");
                            config.url = config.url + "?token=" + authToken;
                        }
                    }
                    return config || $q.when(config);
                }
            };
        });
	}

	run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http','$log' ];
	function run($rootScope, $location, $cookieStore, $http,$log) {
	
	
		/* Reset error when a new view is loaded */
	    $rootScope.$on('$viewContentLoaded', function() {
	        delete $rootScope.error;
	    });
		
		$rootScope.$on('$locationChangeStart', function(event, next, current) {
				// redirect to login page if not logged in and trying to access a
				// restricted page
				if(current.includes("#/Home") && next.includes("#/login")){
					$rootScope.logout();
				}

				var restrictedPage = $.inArray($location.path(), [ '/login',
						'/register','/error' ]) === -1;
				
				var loggedIn = $rootScope.authToken;

				if (restrictedPage && loggedIn=== undefined) {
					$log.debug('U r not logged in...');
					$location.path('/login');
				}
			});
	
	    $rootScope.hasRole = function(role) {
	
	        if ($rootScope.user === undefined) {
	            return false;
	        }
	
	        if ($rootScope.user.roles[role] === undefined) {
	            return false;
	        }
	
	        return $rootScope.user.roles[role];
	    };
	
	    $rootScope.logout = function() {
	        delete $rootScope.user;
	        delete $rootScope.authToken;
	        $cookieStore.remove('authToken');
	        $location.path("/login");
	    };
	
	    /* Try getting valid user from cookie or go to login page */
	    var originalPath = $location.path();
	    $location.path("/login");
	    var authToken = $cookieStore.get('authToken');
	    $log.debug("Auth token is..."+authToken);
	    if (authToken !== undefined) {
	        $rootScope.authToken = authToken;
	        UserService.get(function(user) {
	            $rootScope.user = user;
	            $location.path(originalPath);
	        });
	    }
	
	    $rootScope.initialized = true;

	}

})();