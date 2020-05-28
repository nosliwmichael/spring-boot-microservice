(function() {

	'use strict';

	angular
		.module('scraper.module')
		.controller('ScraperController', UserController);

	ScraperController.$inject = ['ScraperService', '$log'];

	function ScraperController(scraperService, $log) {
		var vm = this;

		// Exposed properties

		// Exposed methods

	}

})();