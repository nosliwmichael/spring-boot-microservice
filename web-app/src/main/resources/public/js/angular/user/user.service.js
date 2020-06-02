(function() {
	
	'use strict';
	
	angular
		.module('user.module')
		.factory('UserService', UserService);
	
	UserService.$inject = ['$http', 'EndpointService'];
	
	function UserService($http, endpointService) {

		let USER_REST_ENDPOINT = endpointService.getUserEndpoints().REST_ENDPOINT;
		
		return {
				getAllUsers: getAllUsers,
				getUserById: getUserById,
		};
		
		function getAllUsers() {
			return $http.get(USER_REST_ENDPOINT);
		}
		
		function getUserById(userId) {
			return $http.get(USER_REST_ENDPOINT + userId);
		}
		
	}
	
})();