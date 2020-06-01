(function() {

	'use strict';

	angular
		.module('scraper.module')
		.factory('ScraperService', ScraperService);

	ScraperService.$inject = ['$http', 'CommonService', 'EndpointService'];

	function ScraperService($http, commonService, endpointService) {

		/* REQUEST CONFIGURATION */
		let csrfConfig = commonService.getCSRFConfig();

		/* SCRAPER ENDPOINTS */
		let RESPONSE_ENDPOINT = endpointService.getScraperEndpoints().RESPONSE_ENDPOINT;
		let RESPONSE_PARSE_ENDPOINT = endpointService.getScraperEndpoints().RESPONSE_PARSE_ENDPOINT;
		let RESPONSE_BODY_ENDPOINT = endpointService.getScraperEndpoints().RESPONSE_BODY_ENDPOINT;
		let RESPONSE_BODY_PARSE_ENDPOINT = endpointService.getScraperEndpoints().RESPONSE_BODY_PARSE_ENDPOINT;
		let ELEMENTS_SCRAPE_ENDPOINT = endpointService.getScraperEndpoints().ELEMENTS_SCRAPE_ENDPOINT;

		return {
				getResponse: getResponse,
				parseResponse: parseResponse,
				getResponseBody: getResponseBody,
				parseResponseBody: parseResponseBody,
				getElements: getElements
		};

		function getResponse() {
			return $http.post(RESPONSE_ENDPOINT);
		}

		function parseResponse() {
			return $http.post(RESPONSE_PARSE_ENDPOINT);
		}

		function getResponseBody() {
			return $http.post(RESPONSE_BODY_ENDPOINT);
		}

		function parseResponseBody() {
			return $http.post(RESPONSE_BODY_PARSE_ENDPOINT);
		}

		function getElements(elementCriteria) {
			return $http.post(ELEMENTS_SCRAPE_ENDPOINT, elementCriteria, csrfConfig);
		}

	}

})();