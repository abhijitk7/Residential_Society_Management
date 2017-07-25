/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 13 Feb 2017
    Description : Controller for Amenity Booking
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function() {
	
	'use strict';

	angular.module('SocietyManagementSystem').controller('BookingController',BookingController);

	BookingController.$inject = [ '$location', 'StaticDataService','$log','toaster','SubmissionService', '$rootScope','UserService'];
	
	function BookingController($location, StaticDataService,$log,toaster,SubmissionService, $rootScope,UserService) {
		
		var vm = this;
		
		vm.saveBooking=saveBooking;
		
		(function initController() {
			
				$log.debug("Booking controller initialised......");
				 		 				
				StaticDataService.getAmenityList(function(response){
					 
				 	if(response===401) {
	                    toaster.pop('error', "", "You are not authorised to perform this operation. Please contact system administrator.");
	                }else if(response===500) {
	                	toaster.pop('error', "", "Some thing went wrong at server side. Please contact system administrator.");
	                } else{
	                	vm.amenities=response;
	                } 
			 
		 	 	});
				
				UserService.getUserDetails($rootScope.user.userId,function(response){
					 
				 	if(response===401) {
	                    toaster.pop('error', "", "You are not authorised to perform this operation. Please contact system administrator.");
	                }else if(response===500) {
	                	toaster.pop('error', "", "Some thing went wrong at server side. Please contact system administrator.");
	                } else{
	                	vm.user=response;
	                } 
			 
		 	 	});
				
		})();
		
		
		
		function saveBooking(){
			
			$log.debug("Save Booking info called ......");
			
			var bookingDetails={
					"comments":vm.comments,
					"fromDateTime":vm.fromDateTime,
					"toDateTime":vm.toDateTime,
					"status":vm.selectedStatus,
					"amenity":vm.selectedAmenity,
					"active":true,
					"requestedByUserInfoId":vm.user,
					"lastUpdatedBy":vm.user
					//$rootScope.user.userId
				};
			
			SubmissionService.saveBooking(bookingDetails,function(response){
				
			 	if(response===401) {
		            toaster.pop('error', "", "You are not authorised to perform this operation. Please contact system administrator.");
		        }else if(response===500) {
		        	toaster.pop('error', "", "Some thing went wrong at server side. Please contact system administrator.");
		        } else if(response===200){
		        	toaster.pop('Success', "", "Your booking submitted successfully.");
		        } 
		 
		 	});
		
		}
		
	}

})();