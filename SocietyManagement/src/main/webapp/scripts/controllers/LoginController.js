(function() {
	'use strict';

	app.controller("LoginController", [
			"$scope",
			"userService",
			'$location',
			function($scope, userService, $location) {

				$scope.userName = "";
				$scope.passWord = "";
				$scope.loginMessage = "";

				$scope.getValidUser = function() {

					userService.getUser($scope.userName, $scope.passWord,
							function(result) {
								if (result == "true") {
									$location.path('/Sucess');
								}
							});
				};
			} ]);
})();