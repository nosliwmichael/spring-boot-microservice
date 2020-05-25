(() => {

    // PUBLIC METHODS //
    codefy.staticInit = init;

    // SELF INITIALIZE //
    init();

    /**
     * Fetch elements with [data-codefy] attributes.
     * Get source data as text.
     * Populate container with source data.
     */
    function init() {
        let containers = document.querySelectorAll("[data-codefy]");
        if (containers.length > 0) {
            containers.forEach(c => {
                codefy.sourceData(c.dataset.codefy)
                .then((response) => {
                    codefy.populateContainer(response, c);
                })
                .catch(console.error);
            });
        }
    };

})();