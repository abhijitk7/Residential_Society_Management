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
	
	
	MyInfoController.$inject=['UserService','StaticDataService', '$state', '$rootScope', 'FlashService','$log'];
	
	function MyInfoController(UserService,StaticDataService, $state, $rootScope, FlashService,$log){
		
		 var vm = this;

		 vm.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
		 vm.phoneNumber = /^(\+?(\d{1}|\d{2}|\d{3})[- ]?)?\d{3}[- ]?\d{3}[- ]?\d{4}$/;
		 
	     vm.passWordFormat=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
		 
		 vm.saveUserInfo = saveUserInfo;
		 
		 
		 (function initController() {
			 // reset login status
			 $log.debug("My Info controller initialised......");
			 
			 StaticDataService.getListOfFlats(function(response) {

	                if(response===401) {
	                    FlashService.Error("You are not authorised to perform this operation. Please contact system administrator.");
	                }else if(response===500) {
	                    FlashService.Error("Some thing went wrong at server side. Please contact system administrator");
	                } else{
	                	vm.flatList=response;
	                }
	          });
			 
			 StaticDataService.getListOfParkingSlots(function(response) {

				 	if(response===401) {
	                    FlashService.Error("You are not authorised to perform this operation. Please contact system administrator.");
	                }else if(response===500) {
	                    FlashService.Error("Some thing went wrong at server side. Please contact system administrator");
	                } else{
	                	vm.parkingSlotList=response;
	                }
	          });

		})();
		 
		 function saveUserInfo() {
			 	$log.debug("MyInfo Controller called...");
			 			 	
	            vm.dataLoading = true;
	            var user=
	           {
        		  "userName": vm.user.email,
        		  "password": vm.user.password,
        		  "userInfo": {
        		    "primaryM1": vm.user.userInfo.primaryM1,
        		    "alterEmailId":vm.user.userInfo.alterEmailId,
        		    "emailId":vm.user.email,
        		    "isBoardMember":vm.user.userInfo.isBoardMember,
        		    "flatNumber":13,
        		    "isSecondaryOwner":vm.user.userInfo.isSecondaryOwner,
        		    "secondaryM2":vm.user.userInfo.secondaryM2,
        		    "primFirstName":vm.user.userInfo.pFirstName,
        		    "primMiddleName":vm.user.userInfo.pMiddleName,
        		    "primLastName":vm.user.userInfo.pLastName,
        		    "secFirstName":vm.user.userInfo.sFirstName,
        		    "secMiddleName":vm.user.userInfo.sMiddleName,
        		    "secLastName":vm.user.userInfo.sLastName,
        		    "correspondanceAddress":vm.user.userInfo.correspondanceAddress,
        		    "userTypeId":1
        		  }
		 		};
	            
	            UserService.Create(user,function(response) {
	            	
	            	
	        		
	                if (response==='true') {
	                    FlashService.Success('Registration successful', true);
	                    $state.go('login');
	                } else if(response===401) {
	                    FlashService.Error("You are not authorised to perform this operation. Please contact system administrator.");
	                    vm.dataLoading = false;
	                }else if(response===500) {
	                    FlashService.Error("Some thing went wrong at server side. Please contact system administrator");
	                    vm.dataLoading = false;
	                }
	            });
		 }
		
	}
	
	
	
})();