(function() {

	'use strict';

	angular
		.module('scraper.module')
		.controller('ScraperController', ScraperController);

	ScraperController.$inject = ['ScraperService', '$log'];

	function ScraperController(scraperService, $log) {

		var vm = this;

		// Exposed properties
		vm.elementCriteria = {
		    url: null,
		    id: null,
		    classNames: null,
		    attributes: null,
		    tagName: null
		};

		// Exposed methods
        vm.getResponse = getResponse;
        vm.parseResponse = parseResponse;
        vm.getResponseBody = getResponseBody;
        vm.parseResponseBody = parseResponseBody;
        vm.getElements = getElements

        function getResponse() {
            scraperService.getResponse()
            .then(response => {
                $log.log(response);
            })
            .catch(error => {
                $log.error(error);
            });
        }

        function parseResponse() {
            scraperService.parseResponse()
            .then(response => {
                $log.log(response);
            })
            .catch(error => {
                $log.error(error);
            });
        }

        function getResponseBody() {
            scraperService.getResponseBody()
            .then(response => {
                $log.log(response);
            })
            .catch(error => {
                $log.error(error);
            });
        }

        function parseResponseBody() {
            scraperService.parseResponseBody()
            .then(response => {
                $log.log(response);
            })
            .catch(error => {
                $log.error(error);
            });
        }

        function getElements() {
            scraperService.getElements(vm.elementCriteria)
            .then(response => {
                $log.log(response);
            })
            .catch(error => {
                $log.error(error);
            });
        }

	}

})();