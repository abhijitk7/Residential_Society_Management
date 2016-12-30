(function() {
	'use strict';

	angular.module('SocietyManagementSystem').controller('HomeController',
			HomeController);

	HomeController.$inject = [ '$location', 'UserService',
			'FlashService', '$log','$rootScope' ];
	function HomeController($location, UserService, FlashService,
			$log,$rootScope) {
		
		var vm = this;

		vm.updateLogon = updateLogon;
		

		function updateLogon(userId) {
			
			
			UserService.updateLastLogOn(userId,function(result) {
				
				$log.debug("User id received is "+userId+" status "+result);
				if(result==='false'){
					$log.debug('Logout Failed failed ----->');
					FlashService.Error('Failed to log out user. Please Contact System Administrator...');
				}else{
					FlashService.Success("User Logged out Successfully.")
				}
	           
	        });
			

		};
	}

})();
