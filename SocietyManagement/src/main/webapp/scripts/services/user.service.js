(function () {
    'use strict';

    angular
        .module('SocietyManagementSystem')
        .factory('UserService', UserService);

    UserService.$inject = ['$http','ContextRoot','$log'];
    function UserService($http,ContextRoot,$log) {
        var service = {};

        service.Create = Create;
        service.Update = Update;
        
        return service;

        function Create(user) {
        	var dataObj = {
        			userName : user.email,
    				passWord : user.password,
    				role:'Admin'
    		};
        	// Writing it to the server
            return $http.post(ContextRoot + '/CreateUser.do',dataObj).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
