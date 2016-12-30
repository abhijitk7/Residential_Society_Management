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
            
        	UserService.Create(vm.user,function(response) {
        		
                if (response==='true') {
                    FlashService.Success('Registration successful', true);
                    $state.go('login');
                } else if(response===401) {
                    FlashService.Error("You are not authorised to perform this operation. Please contact system administrator.");
                    vm.dataLoading = false;
                }else if(response===401) {
                    FlashService.Error("Some thing went wrong at server side. Please contact system administrator");
                    vm.dataLoading = false;
                }
            });
                        
        }
    }

})();
