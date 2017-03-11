(function() {
	'use strict';

	angular.module('SocietyManagementSystem').controller('HomeController',
			HomeController);

	HomeController.$inject = [ '$location', 'UserService',
			'FlashService', '$log','$rootScope' ,'toaster'];
	function HomeController($location, UserService, FlashService,
			$log,$rootScope,toaster) {
		
		var vm = this;

		vm.updateLogon = updateLogon;
		

		function updateLogon(userId) {
			
			
			UserService.updateLastLogOn(userId,function(result) {
				
				$log.debug("User id received is "+userId+" status "+result);
				if(result==='false'){
					$log.debug('Logout Failed failed ----->');
					toaster.pop('error', "", "Failed to log out user. Please Contact System Administrator");
				}else{
					toaster.pop('success', "", "User Logged out Successfully.");
				}
	           
	        });
			

		};
	}

})();
