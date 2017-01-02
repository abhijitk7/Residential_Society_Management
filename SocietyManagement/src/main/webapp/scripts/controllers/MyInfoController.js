/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 30 Dec 2016
    Description : Controller for view/Edit users info
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function () {
	
	'use strict';
	
	angular.module("SocietyManagementSystem").controller("MyInfoController",MyInfoController);
	
	
	MyInfoController.$inject=['UserService', '$state', '$rootScope', 'FlashService','$log'];
	
	function MyInfoController(UserService, $state, $rootScope, FlashService,$log){
		
		 var vm = this;
		 vm.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
		 vm.phoneNumber = /^(\+?(\d{1}|\d{2}|\d{3})[- ]?)?\d{3}[- ]?\d{3}[- ]?\d{4}$/;
		 
		 vm.saveUserInfo = saveUserInfo;
		 
		 function saveUserInfo() {
			 	$log.debug("Controller called...");
			 	$log.debug(vm.userDetails.pFirstName);
			 	$log.debug(vm.userDetails.pMiddleName);
			 	$log.debug(vm.userDetails.sFirstName);
	            vm.dataLoading = true;
		 }
		
	}
	
	
	
})();