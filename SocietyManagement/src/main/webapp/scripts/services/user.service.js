(function () {
    'use strict';

    angular
        .module('SocietyManagementSystem')
        .factory('UserService', UserService);

    UserService.$inject = ['$http','ContextRoot','$log'];
    function UserService($http,ContextRoot,$log) {
        var service = {};

        service.Create = Create;
        service.updateLastLogOn = updateLastLogOn;
        service.getUserDetails=getUserDetails;
        service.updateUserInfo=updateUserInfo;
        
        return service;

        function Create(user,callback) {

        	// Writing it to the server
            $http({
		        method : "POST",
		        url : ContextRoot + '/createUser.do',
		        data:user,
		        headers: {'Content-Type': 'application/json'}
		    }).success(function(response) {
		    	$log.debug(response);
				callback(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callback(status);
			});
        }
        
        function updateUserInfo(userInfo,callback) {

        	// Writing it to the server
            $http({
		        method : "POST",
		        url : ContextRoot + '/updateUserInfo.do',
		        data:userInfo,
		        headers: {'Content-Type': 'application/json'}
		    }).success(function(response) {
		    	$log.debug(response);
				callback(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callback(status);
			});
        }
        
        function getUserDetails(userId,callback){
        	
        	$http({
		        method : "GET",
		        url : ContextRoot + '/userById/' + userId + '.do',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
						
		    }).success(function(data, status, headers, config) {
		    	$log.debug("First name from server is ="+data.primFirstName);
				callback(data);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callback(status);
			});
        }

        function updateLastLogOn(userId,callback) {
        	$http({
		        method : "POST",
		        url : ContextRoot + '/updateLastLogon/' + userId + '.do',
		        headers: {'Content-Type': 'application/json'}
						
		    }).success(function(response) {
		    	$log.debug(response);
				callback(response);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callback(status);
			});
        }

    }

})();
