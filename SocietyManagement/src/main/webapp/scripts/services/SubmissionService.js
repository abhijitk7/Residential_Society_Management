/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 22 April 2017
    Description : service to save/retrive the data in database
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/

(function(){
	
'use strict';
	
	angular.module('SocietyManagementSystem').factory("SubmissionService",SubmissionService);
	
	SubmissionService.$inject =[ '$http','$log', "ContextRoot" ];
	
	function SubmissionService($http,$log, ContextRoot){
		
		var service = {};
		
		$log.debug("SubmissionService Data Service service initialised....");
		
		service.saveBooking=saveBooking;
		
		return service;
		

        function saveBooking(bookingDetails,callback) {

        	// Writing it to the server
            $http({
		        method : "POST",
		        url : ContextRoot + '/users/booking.do',
		        data:bookingDetails,
		        headers: {'Content-Type': 'application/json'}
		    }).success(function(data, status, headers, config) {
				callback(status);
			}).error(function(data, status, headers, config){
				callback(status);
			});
        }
        
		
		
	}
	
	
	
	
})();