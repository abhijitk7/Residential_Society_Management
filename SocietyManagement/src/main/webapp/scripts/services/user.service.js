﻿(function () {
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
        service.getUserRequests=getUserRequests;
        
        return service;

        function Create(user,callback) {

        	// Writing it to the server
            $http({
		        method : "POST",
		        url : ContextRoot + '/users/create.do',
		        data:user,
		        headers: {'Content-Type': 'application/json'}
		    }).success(function(data, status, headers, config) {
				callback(status);
			}).error(function(data, status, headers, config){
				callback(status);
			});
        }
        
        function updateUserInfo(userInfo,callback) {
        	
        	debugger;

        	// Writing it to the server
            $http({
		        method : "POST",
		        url : ContextRoot + '/users/userInfo/update.do',
		        data:userInfo,
		        headers: {'Content-Type': 'application/json'}
		    }).success(function(data, status, headers, config) {
				callback(status);
			}).error(function(data, status, headers, config){
				callback(status);
			});
        }
        
        function getUserDetails(userId,callback){
        	
        	$http({
		        method : "GET",
		        url : ContextRoot + '/users/' + userId + '.do',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
						
		    }).success(function(data, status, headers, config) {
				callback(data);
			}).error(function(data, status, headers, config){
				callback(status);
			});
        }

        function updateLastLogOn(userId,callback) {
        	$http({
		        method : "POST",
		        url : ContextRoot + '/users/lastLogon/update/' + userId + '.do',
		        headers: {'Content-Type': 'application/json'}
						
		    }).success(function(data, status, headers, config) {
		    	$log.debug(status);
				callback(status);
			}).error(function(data, status, headers, config){
				$log.debug(status);
				callback(status);
			});
        }
        
        function getUserRequests(userId,callback) {
        	$http({
		        method : "GET",
		        url : ContextRoot + '/users/requests/' + userId + '.do',
		        headers: {'Content-Type': 'application/json'}
						
		    }).success(function(data, status, headers, config) {
				callback(data);
			}).error(function(data, status, headers, config){
				callback(status);
			});
        }

    }

})();
