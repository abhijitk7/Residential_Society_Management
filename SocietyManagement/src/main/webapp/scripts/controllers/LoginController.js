(function() {
	'use strict';

	app.controller("LoginController", [
			"$scope",
			"userService",
			function($scope, userService) {

				$scope.userName = "";
				$scope.passWord = "";

				$scope.getValidUser = function() {

					userService.getUser($scope.userName, $scope.passWord,
							function(result) {
								$scope.isValid = result;
							});
				};
			} ]);
})();