/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 13 Feb 2017
    Description : Controller for Amenity Booking
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function() {
	
	'use strict';

	angular.module('SocietyManagementSystem').controller('ManageRequestsController',BookingController);

	ChangeRoleController.$inject = [ '$location', 'StaticDataService','$log','toaster','SubmissionService', '$rootScope','UserService'];
	
	function ChangeRoleController($location, StaticDataService,$log,toaster,SubmissionService, $rootScope,UserService) {
		
		var vm = this;
		
	}
	
})();