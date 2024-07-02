// 삭제 버튼 누르면 뜨는 모달창
document.addEventListener("DOMContentLoaded", function () {
  const deleteButtons = document.querySelectorAll(".delete-button");
  const modalWrap = document.querySelector(".delete-modal-wrap");

  console.log(deleteButtons);

  deleteButtons.forEach(function (deleteButton) {
    deleteButton.addEventListener("click", (e) => {
      modalWrap.style.display = "flex";
    });
  });

  const cancelButton = document.querySelector(".modal-cancel button");
  const confirmButton = document.querySelector(".modal-confirm button");

  cancelButton.addEventListener("click", (e) => {
    modalWrap.style.display = "none";
  });

  confirmButton.addEventListener("click", (e) => {
    modalWrap.style.display = "none";
  });
});

// 검색창 눌렀을때 검색바에 아웃라인주기
const searchBar = document.querySelector("label.search-bar");

document.addEventListener("click", (e) => {
  if (e.target.closest("label.search-bar")) {
    searchBar.classList.add("search-bar-checked");
    return;
  }
  searchBar.classList.remove("search-bar-checked");
});

const inputField = document.querySelector(".search-bar input");
const cancelButton = document.querySelector(".search-bar .cancel-logo");
const searchButton = document.querySelector(".search-bar .search-logo");

// 입력 필드에 입력 내용이 변경될 때마다 실행될 함수를 정의합니다.
function handleInputChange() {
  const inputValue = inputField.value.trim(); // 입력 내용을 가져옵니다.

  // 입력 내용이 있을 때
  if (inputValue !== "") {
    cancelButton.style.display = "flex"; // cancel-logo를 보여줍니다.
    searchButton.style.display = "none"; // search-logo를 숨깁니다.
  } else {
    // 입력 내용이 없을 때
    cancelButton.style.display = "none"; // cancel-logo를 숨깁니다.
    searchButton.style.display = "flex"; // search-logo를 보여줍니다.
  }
}

// cancel-logo를 클릭했을 때 실행될 함수를 정의합니다.
function handleCancelClick() {
  inputField.value = ""; // 입력 필드 내용을 지웁니다.
  cancelButton.style.display = "none"; // cancel-logo를 숨깁니다.
  searchButton.style.display = "flex"; // search-logo를 보여줍니다.
}

// 입력 필드에 이벤트 리스너를 추가합니다.
inputField.addEventListener("input", handleInputChange);

// cancel-logo에 클릭 이벤트 리스너를 추가합니다.
cancelButton.addEventListener("click", handleCancelClick);

// 체크박스 js
const allCheck = document.querySelector(".all-check");
const checkboxes = document.querySelectorAll(".checkbox-input");

// all-check 체크 여부에 따라 checkbox-input 체크 여부 조절
allCheck.addEventListener("change", function () {
  checkboxes.forEach(function (checkbox) {
    checkbox.checked = allCheck.checked;
  });
});

// checkbox-input 중 하나라도 체크가 해제되면 all-check 체크 해제
checkboxes.forEach(function (checkbox) {
  checkbox.addEventListener("change", function () {
    let allChecked = true;
    checkboxes.forEach(function (checkbox) {
      if (!checkbox.checked) {
        allChecked = false;
      }
    });
    allCheck.checked = allChecked;
  });
});

// checkbox-input 모두 체크되면 all-check 체크
checkboxes.forEach(function (checkbox) {
  checkbox.addEventListener("change", function () {
    let allChecked = true;
    checkboxes.forEach(function (checkbox) {
      if (!checkbox.checked) {
        allChecked = false;
      }
    });
    allCheck.checked = allChecked;
  });
});





// 강사등록버튼
const addBtn = document.querySelector(".addBtn");
const addModal = document.querySelector(".musclematrix-layer.teacher");
const closeTeacherBtn = document.querySelector(".btn-close.teacher")

addBtn.addEventListener('click', function () {
  addModal.style.display = "block"
});

closeTeacherBtn.addEventListener("click", function () {
  addModal.style.display = "none"
})

// 강사 이미지 첨부란
document.addEventListener('DOMContentLoaded', function () {
  const teacherPic = document.querySelector('.teacher-pic');
  const teacherImageInput = document.getElementById('teacherImageInput');
  const teacherImage = document.getElementById('teacherImage');

  teacherPic.addEventListener('click', function () {
    teacherImageInput.click();
  });

  teacherImageInput.addEventListener('change', function (event) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = function (e) {
        teacherImage.src = e.target.result;
      }
      reader.readAsDataURL(file);
    }
  });
});

//강사 수정 버튼
const editBtn = document.querySelector(".editBtn");
editBtn.addEventListener('click', function () {
  addModal.style.display = "block"
});



// 기구등록
const addMachineBtn = document.querySelector(".addMachineBtn");
const addMachineModal = document.querySelector(".musclematrix-layer.machine");
const closeMacineBtn = document.querySelector(".btn-close.machine")

addMachineBtn.addEventListener('click', function () {
  addMachineModal.style.display = "block"
});

closeMacineBtn.addEventListener("click", function () {
  addMachineModal.style.display = "none"
})

// 강사 이미지 첨부란
document.addEventListener('DOMContentLoaded', function () {
  const machinePic = document.querySelector('.machine-pic');
  const machineImageInput = document.getElementById('machineImageInput');
  const machineImage = document.getElementById('machineImage');

  machinePic.addEventListener('click', function () {
    machineImageInput.click();
  });

  machineImageInput.addEventListener('change', function (event) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = function (e) {
        machineImage.src = e.target.result;
      }
      reader.readAsDataURL(file);
    }
  });
});





//  약력, 진행프로그램추가 태그 동적생성란
document.addEventListener('DOMContentLoaded', function() {
  const teacherForm = document.getElementById('.teacherForm');
  const addBackgroundBtn = document.getElementById('addBackgroundBtn');
  const addProgramBtn = document.getElementById('addProgramBtn');
  const teacherBackgroundList = document.getElementById('teacherBackgroundList');
  const teacherProgramList = document.getElementById('teacherProgramList');

  // 동적 입력 필드 추가 함수
  function addDynamicInput(listElement, inputName) {
    const li = document.createElement('li');
    const input = document.createElement('input');
    const removeBtn = document.createElement('button');

    input.type = 'text';
    input.name = `${inputName}[]`;
    input.required = true;
    input.addEventListener('input', adjustInputWidth);
    
    // 엔터 키 이벤트 처리
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        e.preventDefault(); // 엔터 키의 기본 동작을 막습니다.
        addDynamicInput(listElement, inputName); // 대신 새로운 입력 필드를 추가합니다.
      }
    });

    removeBtn.type = 'button';
    removeBtn.className = 'remove-btn';
    removeBtn.textContent = 'x';
    removeBtn.addEventListener('click', function() {
      listElement.removeChild(li);
    });

    li.appendChild(input);
    li.appendChild(removeBtn);
    listElement.appendChild(li);

    input.focus();
  }

  // 입력 필드 너비 조정 함수
  function adjustInputWidth() {
    this.style.width = (this.value.length + 1) * 8 + 'px';
  }

  // 약력 추가 버튼
  addBackgroundBtn.addEventListener('click', function() {
    addDynamicInput(teacherBackgroundList, 'teacher-background');
  });

  // 프로그램 추가 버튼
  addProgramBtn.addEventListener('click', function() {
    addDynamicInput(teacherProgramList, 'teacher-program');
  });
});




















