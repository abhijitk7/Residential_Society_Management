/*==========================================================
    Author      : Abhijit Kulkarni
    Date Created: 13 Feb 2017
    Description : Controller for Search members
    
    Change Log
    s.no      date    author     description     
    
 ===========================================================*/
(function () {
	
	'use strict';
	
	angular.module("SocietyManagementSystem").controller("MemberSearchController",MemberSearchController);
	
	
	MemberSearchController.$inject=['$rootScope', 'FlashService','$log','$scope','SearchService'];
	
	function MemberSearchController($rootScope, FlashService,$log,$scope,SearchService){
		
		var vm = this;
		 
		vm.searchMember=searchMember;
		
		vm.loading = false;
		
		vm.buttonText="Search";
		
		function searchMember(){
			
			$log.debug("Search member method called..");
			
			vm.buttonText="Searching...";
			
			vm.loading = true;
			
			SearchService.getMemberData(vm.searchCriteria,function(response) {

				if(response===401) {
                    FlashService.Error("You are not authorised to perform this operation. Please contact system administrator.");
                }else if(response===500) {
                    FlashService.Error("Some thing went wrong at server side. Please contact system administrator");
                } else{
                	
                	vm.membersInfo=response;
                	
                	vm.buttonText="Search";
                	
                	vm.loading = false;

                } 
                
            });
			
		}
	}
	
	
	
})();