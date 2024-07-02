let currentWeek = 'MON';
let currentNum = '1';

document.addEventListener('DOMContentLoaded', () => {
    updateImageSrc();

    document.querySelectorAll('.date-tab .day').forEach(dayElement => {
        dayElement.addEventListener('click', () => {
            currentWeek = dayElement.getAttribute('data-week');

            updateUI();
            updateImageSrc();
        });
    });

    document.querySelectorAll('.list-box .select').forEach(selectElement => {
        selectElement.addEventListener('click', () => {
            currentNum = selectElement.getAttribute('data-num');

            updateUI();
            updateImageSrc();
        });
    });

    updateUI();
});

function updateUI() {
    document.querySelectorAll('.exe-info-wrap').forEach(infoWrap => {
        if (infoWrap.getAttribute('data-week') === currentWeek) {
            infoWrap.classList.add('active');
            infoWrap.classList.remove('unactive');
        } else {
            infoWrap.classList.add('unactive');
            infoWrap.classList.remove('active');
        }
    });

    document.querySelectorAll('.date-tab').forEach(tab => {
        const day = tab.querySelector('.day');
        if (day && day.getAttribute('data-week') === currentWeek) {
            tab.classList.add('active');
        } else {
            tab.classList.remove('active');
        }
    });

    document.querySelectorAll('.list-box .select').forEach(item => {
        if (item.getAttribute('data-num') === currentNum) {
            item.classList.add('active');
        } else {
            item.classList.remove('active');
        }
    });
}

function updateImageSrc() {
    const imgSrc = `../../staticfiles/images/${currentWeek}/K-00${currentNum}.png`;
    const activeImage = document.querySelector('.exe-info-wrap.active .image');
    if (activeImage) {
        activeImage.setAttribute('src', imgSrc);
    }
}