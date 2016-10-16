'use strict';

angular.module("smsApp.services", [ "ngResource" ]).factory("sms",
		function($resource) {
			return $resource('rest/todos/:id', {
				id : '@id'
			}, {
				update : {
					method : 'PUT'
				}
			});
		});