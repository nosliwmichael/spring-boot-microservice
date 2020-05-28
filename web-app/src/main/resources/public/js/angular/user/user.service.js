(function() {
	
	'use strict';
	
	angular
		.module('user.module')
		.factory('UserService', UserService);
	
	UserService.$inject = ['$http'];
	
	function UserService($http) {
		let BASE_URL = '/aperture';
		let USER_ENDPOINT = BASE_URL + '/user/';
		
		let service = {
				getAllUsers: getAllUsers,
				getUserById: getUserById,
		};
		
		return service;
		
		function getAllUsers() {
			return $http.get(USER_ENDPOINT);
		}
		
		function getUserById(userId) {
			return $http.get(USER_ENDPOINT + userId);
		}
		
	}
	
})();