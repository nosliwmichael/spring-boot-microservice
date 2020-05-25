(() => {

    // PUBLIC METHODS //
    codefy.modalInit = init;
    codefy.openModal = openModal;
    codefy.closeModal = closeModal;

    // PRIVATE PROPERTIES //
    let modalBackdrop;
    let codeContent;
    let modalCloseButton;

    // SELF INITIALIZE //
    init();

    function init() {
        modalBackdrop = document.getElementById('modalBackdrop');
        codeContent = document.getElementById('codeContent');
        modalCloseButton = document.getElementById('modalCloseButton');
        let codeLinks = document.getElementsByClassName('code-link');

        modalBackdrop.onclick = closeModal;
        modalCloseButton.onclick = closeModal;
        
        Array.from(codeLinks).forEach(codeLink => {
            codeLink.onclick = openModal;
        })
    }

    /**
     * Open modal.
     * Load content.
     * @param {Event} event
     */
    function openModal(event) {
        modalBackdrop.style.display = 'block';
        let fileUrl = event.target.href;
        let fileName = event.target.innerText;
        codefy.sourceData(fileUrl)
        .then((response) => {
            codefy.populateContainer(response, codeContent);
            codeContent.className = `language-${getFileExtension(fileUrl)}`;
            document.getElementById('modalHeader').innerText = fileName;
            Prism.highlightElement(codeContent);
        })
        .catch(console.error);
        event.preventDefault();
    }

    /**
     * Close modal.
     * Clear content.
     * @param {Event} event
     */
    function closeModal(event) {
        if (event.target == modalBackdrop ||
            event.target == modalCloseButton) {
            modalBackdrop.style.display = 'none';
            codeContent.innerText = '';
        }
    }

    /**
     * Extract extension from url.
     */
    function getFileExtension(url) {
        return url.substr(url.lastIndexOf('.') + 1, url.length);
    }

})();