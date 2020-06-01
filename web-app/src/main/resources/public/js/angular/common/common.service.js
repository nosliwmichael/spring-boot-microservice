(function() {

    'use strict';

    angular
        .module('common.module')
        .factory('CommonService', CommonService);

    CommonService.$inject = ['CSRF'];

    function CommonService(CSRF) {

        return {
            getCSRFConfig: getCSRFConfig,
        };

        function getCSRFConfig() {
            return {
                headers: {
                    [CSRF.header]: CSRF.token,
                },
            };
        }

    }

})();