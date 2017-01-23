/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 24 Dec 2016
    Description : Base for Dashboard module
    
    Change Log
    s.no      date    author     description     
 ===========================================================*/

var mainApp = angular.module('mainApp', ['ui.router']);


mainApp.config(["$stateProvider", function ($stateProvider) {

    //login page state
    $stateProvider.state('home', {
    	url:'/Home',
    	controller : 'HomeController',
		templateUrl : 'views/home.html',
		controllerAs : 'vm',
        data: {
            pageTitle: 'Register'
        }
    }).state('home.dashboard', {
        url: '/dashboard',
    	templateUrl : 'views/dashboard.html',
        data: {
            pageTitle: 'Dashboard'
        }
    }).state('home.myInfo', {
        url: '/myInfo',
        controller : 'MyInfoController',
    	templateUrl : 'views/personalInfo.html',
    	controllerAs : 'vm',
        data: {
            pageTitle: 'Personal Info'
        }
    });
    
}]);
