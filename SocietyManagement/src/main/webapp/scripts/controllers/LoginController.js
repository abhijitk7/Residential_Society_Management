(function() {
	'use strict';

	angular.module('SocietyManagementSystem').controller('LoginController',
			LoginController);

	LoginController.$inject = [ '$location', 'AuthenticationService',
			'FlashService', '$log','$rootScope' ];
	function LoginController($location, AuthenticationService, FlashService,
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
					FlashService.Error('The user name or password is incorrect. Verify your user name, and then type your password again.');
				}else{
					var authToken = authenticationResult.token;
		            $rootScope.authToken = authToken;
		            if (vm.rememberMe) {
		                $cookieStore.put('authToken', authToken);
		            }
		                $rootScope.user = authenticationResult;
		                $location.path("/Home");
				}
	            vm.dataLoading = false;
	        });
			
			
			
//			AuthenticationService.Login(vm.username, vm.password, function(
//					response) {
//
//				$log.debug(response);
//
//				if (response === 'true') {
//					AuthenticationService.SetCredentials(vm.username,
//							vm.password);
//					$log.debug('Authentication successful ----->');
//					$location.path('/Home');
//				} else {
//					$log.debug('Authentication failed ----->');
//					FlashService.Error('Username or password is incorrect');
//					vm.dataLoading = false;
//				}
//			});
		};
	}

})();
