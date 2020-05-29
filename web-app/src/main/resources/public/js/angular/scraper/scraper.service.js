(function() {

	'use strict';

	angular
		.module('scraper.module')
		.factory('ScraperService', ScraperService);

	ScraperService.$inject = ['$http'];

	function ScraperService($http) {

		let BASE_URL = '/aperture';
		let SCRAPER_ENDPOINT = BASE_URL + '/scraper';
		let RESPONSE_ENDPOINT = SCRAPER_ENDPOINT + '/response';
		let RESPONSE_PARSE_ENDPOINT = RESPONSE_ENDPOINT + '/_parse';
		let RESPONSE_BODY_ENDPOINT = RESPONSE_ENDPOINT + '/body';
		let RESPONSE_BODY_PARSE_ENDPOINT = RESPONSE_BODY_ENDPOINT + '/_parse';
		let ELEMENTS_ENDPOINT = SCRAPER_ENDPOINT + '/elements';
		let ELEMENTS_SCRAPE_ENDPOINT = ELEMENTS_ENDPOINT + '/_scrape';

		let service = {
				getResponse: getResponse,
				parseResponse: parseResponse,
				getResponseBody: getResponseBody,
				parseResponseBody: parseResponseBody,
				getElements: getElements
		};

		return service;

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
			return $http.post(ELEMENTS_SCRAPE_ENDPOINT, elementCriteria);
		}

	}

})();