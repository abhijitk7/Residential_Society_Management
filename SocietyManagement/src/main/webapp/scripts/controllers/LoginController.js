(function() {
	'use strict';

	angular.module('SocietyManagementSystem').controller('LoginController',
			LoginController);

	LoginController.$inject = [ '$location', 'AuthenticationService',
			'FlashService', '$log' ];
	function LoginController($location, AuthenticationService, FlashService,
			$log) {
		var vm = this;

		vm.login = login;

		(function initController() {
			// reset login status
			AuthenticationService.ClearCredentials();
		})();

		function login() {
			vm.dataLoading = true;
			AuthenticationService.Login(vm.username, vm.password, function(
					response) {

				$log.debug(response);

				if (response === 'true') {
					AuthenticationService.SetCredentials(vm.username,
							vm.password);
					$log.debug('Authentication successful ----->');
					$location.path('/Home');
				} else {
					$log.debug('Authentication failed ----->');
					FlashService.Error('Username or password is incorrect');
					vm.dataLoading = false;
				}
			});
		}
		;
	}

})();
