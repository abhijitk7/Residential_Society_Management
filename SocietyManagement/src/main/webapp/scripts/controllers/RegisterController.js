(function () {
    'use strict';

    angular
        .module('SocietyManagementSystem')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = register;

        function register() {
            vm.dataLoading = true;
            if(vm.user.password===vm.user.confPassword){
            	UserService.Create(vm.user)
                .then(function (response) {
                    if (response==='true') {
                        FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
            }else{
            	FlashService.Error("Password and Confirm password should match");
                vm.dataLoading = false;
            }
            
        }
    }

})();
