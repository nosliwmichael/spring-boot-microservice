/* Initialize codefy with an IIFE (Immediately Invoked Function Expression) */
(() => {

    /**
     * Fetch elements with [data-codefy] attributes.
     * Get source data as text.
     * Populate container with source data.
     */
    (() => {
        let containers = document.querySelectorAll("[data-codefy]");
        if (containers.length > 0) {
            containers.forEach(c => {
                sourceData(c.dataset.codefy)
                .then((response) => {
                    populateContainer(response, c);
                })
                .catch(console.error);
            });
        }
    })();

    /**
     * Perform an AJAX request to an endpoint.
     * Returns response as string if successful.
     * Returns null if unsuccessful.
     * @param {string} url 
     */
    function sourceData(url) {
        return new Promise((resolve, reject) => {
            let xhttp = new XMLHttpRequest();
            xhttp.open('GET', url);
            xhttp.onreadystatechange = () => {
                if (xhttp.readyState === xhttp.DONE) {
                    if (xhttp.status === 200) {
                        resolve(xhttp.responseText);
                    } else {
                        reject("Could not fetch resource from " + url);
                    }
                }
            };
            xhttp.send();
        });
    }

    function populateContainer(response, container) {
        let codeNode = document.createElement('code');
        let textNode = document.createTextNode(response);
        codeNode.appendChild(textNode);
        container.appendChild(codeNode);
    }

})();