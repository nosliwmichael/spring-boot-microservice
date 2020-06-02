(() => {

    /* PUBLIC METHODS */
    codefy.modalInit = init;
    codefy.openModal = openModal;
    codefy.closeModal = closeModal;
    codefy.previousModal = previousModal;
    codefy.nextModal = nextModal;

    /* PUBLIC PROPERTIES */
    codefy.modalOpen;

    /* PRIVATE PROPERTIES */
    let modalBackdrop;
    let modalContent;
    let codeContent;
    let codeLinks;
    let selectedFileIndex;

    /* SELF INITIALIZE */
    init();

    function init() {
        selectedFileIndex = 0;
        codefy.modalOpen = false;

        modalBackdrop = document.getElementById('modalBackdrop');
        modalContent = document.getElementById('modalContent');
        codeContainer = document.getElementById('codeContainer');
        codeContent = document.getElementById('codeContent');
        codeLinks = Array.from(document.getElementsByClassName('code-link'));
    }

    /* PRIVATE METHODS */

    function openModal(index) {
        selectedFileIndex = index;
        let fileUrl = codeLinks[selectedFileIndex].href;
        let fileName = codeLinks[selectedFileIndex].innerText;
        codefy.sourceData(fileUrl)
        .then((response) => {
            codefy.populateContainer(response, codeContent);
            codeContent.className = `language-${getFileExtension(fileUrl)}`;
            document.getElementById('modalHeader').innerText = fileName;
            modalBackdrop.style.display = 'block';
            codefy.modalOpen = true;
            Prism.highlightElement(codeContent);
        })
        .catch(console.error);
    }

    /**
     * Hide modal.
     * Clear content.
     */
    function closeModal() {
        modalBackdrop.style.display = 'none';
        codeContent.innerText = '';
        codefy.modalOpen = false;
    }

    /**
     * Close modal.
     * Decrement selected index.
     * Open modal.
     */
    function previousModal() {
        if (selectedFileIndex > 0) {
            selectedFileIndex--;
            resetModal();
        } else {
            codeContainer.animate([
                { boxShadow: '-10px 0px 10px -5px red' },
                { boxShadow: 'none' }
            ], 1000)
        }
    }

    /**
     * Close modal.
     * Increment selected index.
     * Open modal.
     */
    function nextModal() {
        if (selectedFileIndex < codeLinks.length - 1) {
            selectedFileIndex++;
            resetModal();
        } else {
            codeContainer.animate([
                { boxShadow: '10px 0px 10px -5px red' },
                { boxShadow: 'none' }
            ], 1000)
        }
    }

    function resetModal() {
        closeModal();
        openModal(selectedFileIndex);
    }

    /**
     * Extract extension from url.
     */
    function getFileExtension(url) {
        return url.substr(url.lastIndexOf('.') + 1, url.length);
    }

})();