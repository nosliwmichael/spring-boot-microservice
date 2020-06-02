(function() {

    'use strict';

    angular
        .module('common.module', [])
        .constant('CSRF', {
            header: _csrf_header.content,
            token: _csrf_token.content,
        });

})();