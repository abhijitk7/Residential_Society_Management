/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 13 May 2017
    Description : Controller for Dashboard
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function(){
	
	'use strict';
	
	angular.module('SocietyManagementSystem').controller('DashBoardController',
			DashBoardController);

	DashBoardController.$inject = [ '$location', 'UserService','$log','$rootScope','$cookieStore','toaster'];
	function DashBoardController($location, UserService,$log,$rootScope,$cookieStore,toaster) {
		
		var vm = this;
		
		(function initController(){
			
	 		debugger;
			
		 	UserService.getUserRequests($rootScope.user.userId,function(response){
		 				 		
			 	if(response===401) {
                    toaster.pop('error', "", "You are not authorised to perform this operation. Please contact system administrator.");
                }else if(response===500) {
                	toaster.pop('error', "", "Some thing went wrong at server side. Please contact system administrator.");
                } else{
                	vm.requests=response;
                }
		 	});
		})();
	}
	
})();