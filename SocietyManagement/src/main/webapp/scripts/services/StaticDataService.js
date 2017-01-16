(function() {
	'use strict';
	
	angular.module('SocietyManagementSystem').factory("StaticDataService",StaticDataService);
	
	StaticDataService.$inject =[ '$http','$log', "ContextRoot" ];
	
	function StaticDataService($http,$log,ContextRoot){
		
		var service = {};
		
		$log.debug("Static Data Service service initialised....");
		
		service.getListOfFlats=getListOfFlats;
		service.getListOfParkingSlots=getListOfParkingSlots;
		
		return service;
		
		function getListOfFlats(callBack){
			
			$http({
		        method : "GET",
		        url : ContextRoot + '/getFlats' +'.do',
		    }).success(function(response) {
		    	$log.debug(response);
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
		    	$log.debug(response);
		    	callBack(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callBack(status);
			});
			
		}

	}
	
})();
