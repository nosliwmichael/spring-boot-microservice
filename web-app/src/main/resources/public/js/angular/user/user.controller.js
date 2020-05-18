(function() {
	
	'use strict';
	
	angular
		.module('user')
		.controller('UserController', UserController);
	
	UserController.$inject = ['UserService', '$log'];
	
	function UserController(userFactory, $log) {
		var vm = this;
		
		// Exposed properties
		vm.userResults;
		
		// Exposed methods
		vm.userSearch = userSearch;
		vm.getAllUsers = getAllUsers;
		vm.getUserById = getUserById;
		
		function userSearch(userId) {
			if (userId) {
				getUserById(userId);
			} else {
				getAllUsers();
			}
		}
		
		function getAllUsers() {
			userFactory.getAllUsers()
			.then(response => {
				$log.log(response);
				vm.userResults = response.data;
			})
			.catch(error => {
				$log.error(error);
			});
		}
		
		function getUserById(userId) {
			userFactory.getUserById(userId)
			.then(response => {
				$log.log(response);
				vm.userResults = [response.data];
			})
			.catch(error => {
				$log.error(error);
			});
		}
		
	}
	
})();