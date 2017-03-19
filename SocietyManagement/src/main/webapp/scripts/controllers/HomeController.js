/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 13 Feb 2017
    Description : Controller for Home page
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function() {
	'use strict';

	angular.module('SocietyManagementSystem').controller('HomeController',
			HomeController);

	HomeController.$inject = [ '$location', 'UserService','$log','$rootScope','$cookieStore','toaster'];
	function HomeController($location, UserService,$log,$rootScope,$cookieStore,toaster) {
		
		var vm = this;

		vm.updateLogon = updateLogon;
		

		function updateLogon(userId) {

			UserService.updateLastLogOn(userId,function(result) {	
				$log.debug("User id received is "+userId+" status "+result);
				if(result!==200){
					toaster.pop('error', "", "Failed to log out user properly. Please Contact System Administrator");
				}else{
					toaster.pop('success', "", "User Logged out Successfully.");
					delete $rootScope.user;
			        delete $rootScope.authToken;
			        $cookieStore.remove('authToken');
			        $location.path("/login");
				}
	        });
		};
	}

})();
