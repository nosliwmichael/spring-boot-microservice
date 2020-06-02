(() => {

    // PUBLIC METHODS //
    codefy.modalInit = init;
    codefy.openModalEvent = openModalEvent;
    codefy.closeModalEvent = closeModalEvent;

    // PRIVATE PROPERTIES //
    let modalBackdrop;
    let modalCloseButton;
    let codeContainer;
    let codeContent;
    let codeLinks;
    let selectedFileIndex;
    let modalOpen;
    let touchPos;

    // SELF INITIALIZE //
    init();

    function init() {
        selectedFileIndex = 0;
        modalOpen = false;
        touchPos = { x: 0, y: 0 };

        modalBackdrop = document.getElementById('modalBackdrop');
        modalCloseButton = document.getElementById('modalCloseButton');
        codeContainer = document.getElementById('codeContainer');
        codeContent = document.getElementById('codeContent');
        codeLinks = Array.from(document.getElementsByClassName('code-link'));

        modalBackdrop.onclick = closeModalEvent;
        modalCloseButton.onclick = closeModalEvent;
        document.onkeyup = keyEvent;
        modalBackdrop.ontouchstart = touchStartEvent;
        modalBackdrop.ontouchend = touchEndEvent;
        
        codeLinks.forEach(codeLink => {
            codeLink.onclick = openModalEvent;
        })
    }

    /* EVENT HANDLERS */

    function openModalEvent(event) {
        event.preventDefault();
        selectedFileIndex = codeLinks.indexOf(event.target);
        openModal(selectedFileIndex);
    }

    function closeModalEvent(event) {
        if (event.target == modalBackdrop ||
            event.target == modalCloseButton) {
            closeModal();
        }
    }

    function keyEvent(event) {
        event = event || window.event;
        if (event.keyCode == '27') {
            closeModal();
        }
        else if (event.keyCode == '37') {
            previousModal();
        } else if (event.keyCode == '39') {
            nextModal();
        }
    }

    function touchStartEvent(event) {
        if (modalOpen && !event.path.includes(codeContainer)) {
            touchPos.x = event.touches[0].clientX;
            touchPos.y = event.touches[0].clientY;
        }
    }

    function touchEndEvent(event) {
        if (modalOpen && !event.path.includes(codeContainer)) {
            let xDiff = touchPos.x - event.changedTouches[0].clientX;
            let yDiff = touchPos.y - event.changedTouches[0].clientY;
            if (Math.abs(xDiff) > Math.abs(yDiff)) {
                if (xDiff > 0) {
                    previousModal();
                } else {
                    nextModal();
                }
            }
        }
    }

    /* PRIVATE METHODS */

    function openModal(index) {
        let fileUrl = codeLinks[index].href;
        let fileName = codeLinks[index].innerText;
        codefy.sourceData(fileUrl)
        .then((response) => {
            codefy.populateContainer(response, codeContent);
            codeContent.className = `language-${getFileExtension(fileUrl)}`;
            document.getElementById('modalHeader').innerText = fileName;
            modalBackdrop.style.display = 'block';
            modalOpen = true;
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
        modalOpen = false;
    }

    /**
     * Close modal.
     * Decrement selected index.
     * Open modal.
     */
    function previousModal() {
        closeModal();
        if (selectedFileIndex > 0) {
            selectedFileIndex--;
            openModal(selectedFileIndex);
        }
    }

    /**
     * Close modal.
     * Increment selected index.
     * Open modal.
     */
    function nextModal() {
        closeModal();
        if (selectedFileIndex < codeLinks.length - 1) {
            selectedFileIndex++;
            openModal(selectedFileIndex);
        }
    }

    /**
     * Extract extension from url.
     */
    function getFileExtension(url) {
        return url.substr(url.lastIndexOf('.') + 1, url.length);
    }

})();