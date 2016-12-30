/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 24 Dec 2016
    Description : Base for Registration module
    
    Change Log
    s.no      date    author     description     
    

 ===========================================================*/

var register = angular.module('register', ['ui.router']);


register.config(["$stateProvider", function ($stateProvider) {

    //login page state
    $stateProvider.state('register', {
        url: '/register',
        controller : 'RegisterController',
    	templateUrl : 'views/registration.html',
    	controllerAs : 'vm',
        data: {
            pageTitle: 'Register'
        }
    });
    
}]);
