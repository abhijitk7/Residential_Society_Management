/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 13 Feb 2017
    Description : Controller for Login to app
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function() {
	'use strict';

	angular.module('SocietyManagementSystem').controller('LoginController',
			LoginController);

	LoginController.$inject = [ '$state', 'AuthenticationService',
			'FlashService', '$log','$rootScope' ];
	function LoginController($state, AuthenticationService, FlashService,
			$log,$rootScope) {
		
		var vm = this;
		
		vm.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;

		vm.login = login;
		
		

		(function initController() {
			// reset login status
			AuthenticationService.ClearCredentials();
		})();

		function login() {
			vm.dataLoading = true;
			
			AuthenticationService.Login(vm.username,vm.password, function(authenticationResult) {

				if(authenticationResult===401){
					$log.debug('Authentication failed ----->');
					FlashService.Error('Username and/or password are invalid ! Verify your user name, and then type your password again.');
				}else{
					var authToken = authenticationResult.token;
		            $rootScope.authToken = authToken;
		            if (vm.rememberMe) {
		                $cookieStore.put('authToken', authToken);
		            }
		            	$rootScope.isLoggedIn = true
		                $rootScope.user = authenticationResult;
		                $state.go('home');
		                $state.go('home.dashboard');
				}
	            vm.dataLoading = false;
	        });

		};
	}

})();
