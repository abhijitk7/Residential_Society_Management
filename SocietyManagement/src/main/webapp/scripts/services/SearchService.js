/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 19 Feb 2017
    Description : Factory service to search the data as per criteria
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function(){
	
	'use strict';
	
	angular.module('SocietyManagementSystem').factory("SearchService",SearchService);
	
	SearchService.$inject =[ '$http','$log', "ContextRoot" ];
	
	function SearchService($http,$log, ContextRoot){
		
		var service = {};
		
		$log.debug("Earch Data Service service initialised....");
		
		service.getMemberData=getMemberData;
		
		return service;
		
		function getMemberData(searchCriteria,callBack){
				
			$http({
		        method : "GET",
//		        url : ContextRoot + '/getMemberData' +'.do',
		        url : ContextRoot + '/json/searchResult.json',
		        data:searchCriteria
		    }).success(function(response) {
		    	callBack(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callBack(status);
			});
			
		}
		
	}
	
}
)();
