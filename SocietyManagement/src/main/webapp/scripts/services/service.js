'use strict';

app.service("userService", [
		"$log",
		"$http",
		"ContextRoot",
		function($log, $http, ContextRoot) {

			$log.debug("Get User Service initialised");

			this.getUser = function(userName, passWord, callBackResult) {

				$log.debug("User name is " + userName);
				$log.debug("User name is " + passWord);

				$log.debug("Get User Service initialised");

				$http(
						{
							url : ContextRoot + '/authenticateUser/' + userName
									+ '/' + passWord + '.do',
							method : 'GET'
						}).then(function(resp) {
					// Success function
					callBackResult(resp.data);
					$log.debug("User retrived Successfully...");
				}).then(function(resp) {
					// failure function
					$log.error("failure in retriving user...");
				});
			}

		} ]);