(function() {

	'use strict';

	angular
		.module('scraper.module')
		.controller('ScraperController', ScraperController);

	ScraperController.$inject = ['ScraperService', '$log'];

	function ScraperController(scraperService, $log) {

		let vm = this;
		let elementCriteria = {};

		/* EXPOSED PROPERTIES */
        vm.elementCriteriaForm = {
            url: null,
            id: null,
            classNames: null,
            tagName: null,
        };
		vm.elementResults = [];

		/* EXPOSED METHODS */
        vm.getResponse = getResponse;
        vm.parseResponse = parseResponse;
        vm.getResponseBody = getResponseBody;
        vm.parseResponseBody = parseResponseBody;
        vm.getElements = getElements;

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
            prepCriteria();
            scraperService.getElements(elementCriteria)
                .then(response => {
                    vm.elementResults = [];
                    response.data.forEach((d) => {
                        let element = createElement(d);
                        vm.elementResults.push({
                            tag: element.tagName,
                            id: element.id,
                            classes: element.className,
                            html: element.outerHTML,
                        });
                    });
                })
                .catch(error => {
                    $log.error(error);
                });
        }

        function prepCriteria() {
            for (const prop in vm.elementCriteriaForm) {
                if (vm.elementCriteriaForm[prop] === '') {
                    elementCriteria[prop] = null;
                } else {
                    elementCriteria[prop] = vm.elementCriteriaForm[prop];
                }
            }
            if (vm.elementCriteriaForm.classNames) {
                elementCriteria.classNames = convertStringToList(vm.elementCriteriaForm.classNames);
            }
        }

        function convertStringToList(str) {
            return str === '' ? null : str.split(/[ ,]+/)
                .map((c) => {
                    return c.trim();
                });
        }

        function convertStringToMap(str) {
            if (str === '') {
                return null;
            } else {
                let attrMap = {};
                let groups = str.match(/(?<={)(.*?)(?=})/g);
                groups.forEach(a => {
                    let name = a.match(/(.*?)(?==)/g)[0];
                    let attr = a.match(/(?<=")(.*?)(?=")/g)[0].split(' ');
                    attr.forEach(b => {
                        attrMap.push({
                            key: name,
                            value: b
                        });
                    });
                });
                return attrMap;
            }
        }

        function createElement(html) {
            let template = document.createElement('template');
            template.innerHTML = html.trim();
            return template.content.firstChild;
        }

	}

})();