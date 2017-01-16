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
        
        function getUserDetails(username){
        	
        	$http({
		        method : "GET",
		        url : ContextRoot + '/getUserDetails/' + username + '.do',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
						
		    }).success(function(response) {
		    	$log.debug(response);
				callback(response);
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
