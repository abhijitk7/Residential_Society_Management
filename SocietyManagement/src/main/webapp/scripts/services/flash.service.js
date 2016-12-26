(function() {
	'use strict';

	angular.module('SocietyManagementSystem').factory('FlashService',
			FlashService);

	FlashService.$inject = [ '$rootScope', '$log' ];
	function FlashService($rootScope, $log) {

		var service = {};

		service.Success = Success;
		service.Error = Error;

		initService();

		return service;

		function initService() {
			$log.debug("Flash service initialised...")
			$rootScope.$on('$locationChangeStart', function() {
				clearFlashMessage();
			});

			function clearFlashMessage() {
				var flash = $rootScope.flash;
				if (flash) {
					if (!flash.keepAfterLocationChange) {
						delete $rootScope.flash;
					} else {
						// only keep for a single location change
						flash.keepAfterLocationChange = false;
					}
				}
			}
		}

		function Success(message, keepAfterLocationChange) {
			$log.debug("Success method called *****" + message);
			$rootScope.flash = {
				message : message,
				type : 'success',
				keepAfterLocationChange : keepAfterLocationChange
			};
		}

		function Error(message, keepAfterLocationChange) {
			$log.debug("Error method called *****" + message);
			$rootScope.flash = {

				message : message,
				type : 'error',
				keepAfterLocationChange : keepAfterLocationChange
			};
		}
	}

})();