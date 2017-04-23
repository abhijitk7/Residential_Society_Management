(function() {
	'use strict';
	
	angular.module('SocietyManagementSystem').factory("StaticDataService",StaticDataService);
	
	StaticDataService.$inject =[ '$http','$log', "ContextRoot" ];
	
	function StaticDataService($http,$log,ContextRoot){
		
		var service = {};
		
		$log.debug("Static Data Service service initialised....");
		
		service.getListOfFlats=getListOfFlats;
		service.getListOfParkingSlots=getListOfParkingSlots;
		service.getAmenityList=getAmenityList;
		service.getStatusList=getStatusList;
		
		return service;
		
		function getListOfFlats(callBack){
			
			$http({
		        method : "GET",
		        url : ContextRoot + '/getFlats' +'.do',
		    }).success(function(response) {
		    	callBack(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callBack(status);
			});
		}
		
		function getListOfParkingSlots(callBack){
			
			$http({
		        method : "GET",
		        url : ContextRoot + '/getParkingslots' +'.do',
		    }).success(function(response) {
		    	callBack(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callBack(status);
			});
			
		}
		
		function getStatusList(callBack){
			
			$http({
		        method : "GET",
		        url : ContextRoot + '/data/booking/status' +'.do',
		    }).success(function(response) {
		    	callBack(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callBack(status);
			});
			
		}
		
		function getAmenityList(callBack){
			
			$http({
		        method : "GET",
		        url : ContextRoot + '/data/amenities' +'.do',
		    }).success(function(response) {
		    	callBack(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callBack(status);
			});
			
		}

	}
	
})();
