(() => {

    /* PRIVATE PROPERTIES */
    let modalBackdrop;
    let modalCloseButton;
    let codeContainer;
    let codeLinks;
    let touchPos;

    /* SELF INITIALIZE */
    init();

    function init() {
        touchPos = { x: 0, y: 0 };

        modalBackdrop = document.getElementById('modalBackdrop');
        modalCloseButton = document.getElementById('modalCloseButton');
        codeContainer = document.getElementById('codeContainer');
        codeContent = document.getElementById('codeContent');
        codeLinks = Array.from(document.getElementsByClassName('code-link'));

        modalBackdrop.onclick = closeModalEvent;
        modalBackdrop.ontouchstart = touchStartEvent;
        modalBackdrop.ontouchend = touchEndEvent;
        modalCloseButton.onclick = closeModalEvent;
        document.onkeyup = keyEvent;
        
        codeLinks.forEach(codeLink => {
            codeLink.onclick = openModalEvent;
        })
    }

    /* EVENT HANDLERS */

    function openModalEvent(event) {
        event.preventDefault();
        codefy.openModal(codeLinks.indexOf(event.target));
    }

    function closeModalEvent(event) {
        if (event.target == modalBackdrop ||
            event.target == modalCloseButton) {
            codefy.closeModal();
        }
    }

    function keyEvent(event) {
        event = event || window.event;
        if (codefy.modalOpen) {
            if (event.keyCode == '27') {
                codefy.closeModal();
            }
            else if (event.keyCode == '37') {
                codefy.previousModal();
            } else if (event.keyCode == '39') {
                codefy.nextModal();
            }
        }
    }

    function touchStartEvent(event) {
        if (codefy.modalOpen && !event.path.includes(codeContainer)) {
            touchPos.x = event.touches[0].clientX;
            touchPos.y = event.touches[0].clientY;
        }
    }

    function touchEndEvent(event) {
        if (codefy.modalOpen && !event.path.includes(codeContainer)) {
            let xDiff = event.changedTouches[0].clientX - touchPos.x;
            let yDiff = event.changedTouches[0].clientY - touchPos.y;
            if (Math.abs(xDiff) > Math.abs(yDiff)) {
                if (30 < xDiff) {
                    codefy.previousModal();
                }
                else if (-30 > xDiff) {
                    codefy.nextModal();
                }
            }
        }
    }

})();