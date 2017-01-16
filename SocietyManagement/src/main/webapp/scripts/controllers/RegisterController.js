/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 30 Dec 2016
    Description : Controller for registring users
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function () {
    'use strict';

    angular
        .module('SocietyManagementSystem')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$state', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $state, $rootScope, FlashService) {
        var vm = this;
        
        vm.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
        vm.passWordFormat=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;

        vm.register = register;

        function register() {
        	
            vm.dataLoading = true;
            
            //Construct JSON object to send with AJAX call
            var user=
	           {
     		  "userName": vm.user.email,
     		  "password": vm.user.password,
     		  "userInfo": {
     		    "emailId":vm.user.email,
     		    "primFirstName":vm.user.userInfo.pFirstName,
     		    "primMiddleName":vm.user.userInfo.pMiddleName,
     		    "primLastName":vm.user.userInfo.pLastName
     		  },
     		 "roles":[{"roleId":2}]   //By default when user registers he will be added as Member
		 	};
            
        	UserService.Create(user,function(response) {
        		
                if (response==='true') {
                    FlashService.Success('Registration successful', true);
                    $state.go('login');
                } else if(response===401) {
                    FlashService.Error("You are not authorised to perform this operation. Please contact system administrator.");
                    vm.dataLoading = false;
                }else if(response===500) {
                    FlashService.Error("Some thing went wrong at server side. Please contact system administrator");
                    vm.dataLoading = false;
                }
            });
                        
        }
    }

})();
