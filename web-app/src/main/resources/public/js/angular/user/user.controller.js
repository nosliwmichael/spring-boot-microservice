(function() {
	
	'use strict';
	
	angular
		.module('user')
		.controller('UserController', UserController);
	
	UserController.$inject = ['UserService', '$log'];
	
	function UserController(userFactory, $log) {
		var vm = this;
		
		// Exposed properties
		vm.userResult;
		
		// Exposed methods
		vm.getUserById = getUserById;
		
		function getUserById(userId) {
			userFactory.getUserById(userId)
			.then(response => {
				$log.log(response);
				vm.userResult = response.data;
			})
			.catch(error => {
				$log.error(error);
			});
		}
		
	}
	
})();