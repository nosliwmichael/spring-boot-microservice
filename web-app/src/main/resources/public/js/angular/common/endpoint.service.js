(function() {

    'use strict';

    angular
        .module('common.module')
        .factory('EndpointService', EndpointService);

    function EndpointService() {

        /* BASE URLS */
        let BASE_URL = '/web-app';
        let USER_BASE_ENDPOINT = BASE_URL + '/user';
        let SCRAPER_BASE_ENDPOINT = BASE_URL + '/scraper';

        /* USER ENDPOINTS */
        let USER_ENDPOINTS = {};
        USER_ENDPOINTS.BASE_ENDPOINT = USER_BASE_ENDPOINT;
        USER_ENDPOINTS.REST_ENDPOINT = USER_BASE_ENDPOINT + '/';

        /* SCRAPER ENDPOINTS */
        let SCRAPER_ENDPOINTS = {};
        SCRAPER_ENDPOINTS.BASE_ENDPOINT = SCRAPER_BASE_ENDPOINT;
        SCRAPER_ENDPOINTS.RESPONSE_ENDPOINT = SCRAPER_BASE_ENDPOINT + '/response';
        SCRAPER_ENDPOINTS.RESPONSE_PARSE_ENDPOINT = SCRAPER_ENDPOINTS.RESPONSE_ENDPOINT + '/_parse';
        SCRAPER_ENDPOINTS.RESPONSE_BODY_ENDPOINT = SCRAPER_ENDPOINTS.RESPONSE_ENDPOINT + '/body';
        SCRAPER_ENDPOINTS.RESPONSE_BODY_PARSE_ENDPOINT = SCRAPER_ENDPOINTS.RESPONSE_BODY_ENDPOINT + '/_parse';
        SCRAPER_ENDPOINTS.ELEMENTS_ENDPOINT = SCRAPER_BASE_ENDPOINT + '/elements';
        SCRAPER_ENDPOINTS.ELEMENTS_SCRAPE_ENDPOINT = SCRAPER_ENDPOINTS.ELEMENTS_ENDPOINT + '/_scrape';

        return {
            getUserEndpoints: getUserEndpoints,
            getScraperEndpoints: getScraperEndpoints,
        };

        function getUserEndpoints() {
            return USER_ENDPOINTS;
        }

        function getScraperEndpoints() {
            return SCRAPER_ENDPOINTS;
        }

    }

})();