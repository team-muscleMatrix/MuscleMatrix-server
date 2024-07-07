// 1. 삭제 버튼 누르면 뜨는 모달창
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


// 2. 검색창 눌렀을때 검색바에 아웃라인주기
const searchBar = document.querySelector("label.search-bar");
const mileageInput = document.querySelector("input.content-detail-num");
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

// 3. 검색어 입력란에 입력할때
function handleInputChange() {
  const inputValue = inputField.value.trim();

  if (inputValue !== "") {
    cancelButton.style.display = "flex";
    searchButton.style.display = "none";
  } else {
    cancelButton.style.display = "none";
    searchButton.style.display = "flex";
  }
}
// cancel-logo를 클릭했을 때 실행될 함수를 정의
function handleCancelClick() {
  inputField.value = "";
  cancelButton.style.display = "none";
  searchButton.style.display = "flex";
}
inputField.addEventListener("input", handleInputChange);
cancelButton.addEventListener("click", handleCancelClick);






// 4. 체크박스 js
const allCheck = document.querySelector(".all-check");
const checkboxes = document.querySelectorAll(".checkbox-input");
// 4-0. 체크박스 체크/해제 시 해당 li 태그에 checked 클래스 추가/제거
function toggleCheckedClass(li, isChecked) {
	if (isChecked) {
		li.classList.add("checked");
	} else {
		li.classList.remove("checked");
	}
}
// 4-1. all-check 체크 여부에 따라 checkbox-input 체크 여부 조절
allCheck.addEventListener("change", function() {
	checkboxes.forEach(function(checkbox) {
		checkbox.checked = allCheck.checked;
		toggleCheckedClass(checkbox.parentNode, allCheck.checked);
	});
});
// 4-2. checkbox-input 중 하나라도 체크가 해제되면 all-check 체크 해제
checkboxes.forEach(function(checkbox) {
	checkbox.addEventListener("change", function() {
		let allChecked = true;
		checkboxes.forEach(function(checkbox) {
			if (!checkbox.checked) {
				allChecked = false;
			}
		});
		allCheck.checked = allChecked;
		toggleCheckedClass(checkbox.parentNode, checkbox.checked);
	});
});
// 4-3. checkbox-input 모두 체크되면 all-check 체크
checkboxes.forEach(function(checkbox) {
	checkbox.addEventListener("change", function() {
		let allChecked = true;
		checkboxes.forEach(function(checkbox) {
			if (!checkbox.checked) {
				allChecked = false;
			}
		});
		allCheck.checked = allChecked;
		toggleCheckedClass(checkbox.parentNode, checkbox.checked);
	});
});

//5. 검색어 입력창에서 엔터가 눌렸을때 비동기통신 시작
function handleEnterKey(event) {
	if (event.keyCode === 13) { // 엔터키 코드는 13
		event.preventDefault(); // 기본 동작 방지 (새로고침 방지)
		const searchInput = document.querySelector(".search-bar.this");
		search(searchInput.value);
	}
}



//6. 체크박스 선택안되는 오류 해결하는 코드
//비동기통신결과로 DOM요소가 변하면 이미 선택자로 선택된 요소들이 오류나서
//비동기통신 할때마다 아래 함수를 호출할때마다 다시 선택하게 함
//체크박스 핸들러 업데이트 함수
function updateCheckboxHandlers() {
	const allCheck = document.querySelector(".all-check");
	const checkboxes = document.querySelectorAll(".checkbox-input");

	//위에서 작성한 로직 그대로 또 씀
	// 6-1. all-check 체크 여부에 따라 checkbox-input 체크 여부 조절
	allCheck.addEventListener("change", function() {
		checkboxes.forEach(function(checkbox) {
			checkbox.checked = allCheck.checked;
			toggleCheckedClass(checkbox.parentNode, allCheck.checked);
		});
	});
	// 6-2. 하나라도 체크가 해제되면 all-check 체크 해제
	checkboxes.forEach(function(checkbox) {
		checkbox.addEventListener("change", function() {
			let allChecked = true;
			checkboxes.forEach(function(checkbox) {
				if (!checkbox.checked) {
					allChecked = false;
				}
			});
			allCheck.checked = allChecked;
			toggleCheckedClass(checkbox.parentNode, checkbox.checked);
		});
	});
}


//7. 실제 검색을 통해 비동기 갱신
function search(text) {
	$.ajax({
		url: "/manager/teacher/search",
		type: "GET",
		data: { "text": text },
		success: function(frag) {
			$("#teacherList").replaceWith(frag);
			updateCheckboxHandlers();
		}
	});
}


//8. 강사 삭제기능 : 체크박스 선택하고 삭제버튼 누르고 확인눌렀을때 작동
// modal-confirm 버튼 클릭 이벤트 리스너 추가
const modalConfirmButton = document.querySelector(".modal-confirm button");
modalConfirmButton.addEventListener("click", sendCheckedTeacherIds);

// 체크정보들
function sendCheckedTeacherIds() {
	const checkedLis = document.querySelectorAll(".list-content.checked"); //체크 된것들만
	//가져와서 그값을 배열로 묶는다.
	const teacherIds = Array.from(checkedLis).map(li => li.getAttribute("teacher_id"));

	if (teacherIds.length === 0) {
		alert("선택된 댓글이 없습니다.");
		return;
	}
	
	//삭제 ajax통신
	//json데이터보내는 형식은 POST로 고정이다!!
	$.ajax({
		url: "/manager/teacher/delete/delete", // 서버 엔드포인트 URL
		type: "POST",
		contentType: "application/json",
		data: JSON.stringify({ teacherIds: teacherIds }), //키값은 "teacherIds"로 고정인 json데이터 전송
		//서버에서는  @RequestBody Map<String, Object> data 로 매개변수로 받는다.
		success: function(frag) {
			$("#teacherList").replaceWith(frag);
			updateCheckboxHandlers();
		},
		error: function(xhr, status, error) {
			console.error("실패:", error);
			alert("댓글 삭제 중 오류가 발생했습니다.");
		}
	});
}


// 9. 강사등록버튼
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







//10. 강사 수정 버튼
document.addEventListener('DOMContentLoaded', function() {
  const editBtn = document.querySelector(".editBtn");
  const editModal = document.querySelector(".musclematrix-layer.edit");
  const closeEditBtn = document.querySelector(".btn-close.edit");

  if (editBtn) {
    editBtn.addEventListener('click', function() {
      const checkedLis = document.querySelectorAll(".list-content.checked");

      if (checkedLis.length === 1) {
        const teacherId = checkedLis[0].dataset.teacherId; // 첫 번째 요소의 teacherId를 가져옴
			
        // 비동기 통신으로 서버에 데이터 전송
        $.ajax({
          url: "/manager/teacher/edit/edit", // 서버 엔드포인트 URL
          type: "POST",
          data: { teacherId: teacherId }, // teacherId를 키로 하는 데이터 전송
          success: function(frag) {
            $("#edit").replaceWith(frag);
            updateCheckboxHandlers();
          },
          error: function(xhr, status, error) {
            console.error("실패:", error);
            alert("강사 수정 중 오류가 발생했습니다.");
          }
        });
        
      } else if (checkedLis.length > 1) {
        alert("한명의 강사만 선택하세요.");
      } else {
        alert("체크한 강사가 없습니다.");
      }
    });
  } else {
    console.error(".editBtn 요소를 찾을 수 없습니다.");
  }

  if (closeEditBtn) {
    closeEditBtn.addEventListener("click", function() {
      editModal.style.display = "none";
    });
  } else {
    console.error(".btn-close.edit 요소를 찾을 수 없습니다.");
  }
});











//11. 기구 등록 버튼
document.addEventListener('DOMContentLoaded', function () {
    const addMachineBtn = document.querySelector(".addMachineBtn");
    const addMachineModal = document.querySelector(".musclematrix-layer.machine");
    const closeMacineBtn = document.querySelector(".btn-close.machine");

    addMachineBtn.addEventListener('click', function () {
        addMachineModal.style.display = "block";
    });

    closeMacineBtn.addEventListener('click', function () {
        addMachineModal.style.display = "none";
    });

    const machinePic = document.querySelector('.machine-pic');
    const machineImageInput = document.getElementById('machineImageInput');
    const machineImage = document.getElementById('machineImage');
    const machineForm = document.getElementById('machineForm');

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

    machineForm.addEventListener('submit', function (event) {
        event.preventDefault(); // 기본 제출 동작 방지

        const formData = new FormData(machineForm);
        const imageFile = machineImageInput.files[0];

        if (imageFile) {
            formData.append('file', imageFile);
        } else {
            console.error('파일이 선택되지 않았습니다.');
            alert('이미지 파일을 선택해주세요.');
            return;
        }

        // 기구 이름이 입력되었는지 확인
        const machineName = document.querySelector('textarea[name="machine-name"]').value.trim();
        if (!machineName) {
            alert('기구 이름을 입력해주세요.');
            return;
        }

        fetch('/manager/teacher/addmachine', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (response.redirected) {
                window.location.href = response.url; // 리다이렉트된 URL로 이동
            } else {
                return response.json().then(data => {
                    if (data.success) {
                        alert('기구가 성공적으로 등록되었습니다.');
                    } else {
                        console.error('기구 등록 실패:', data.message);
                        alert('기구 등록에 실패했습니다. 다시 시도해주세요.');
                    }
                });
            }
        })
        .catch(error => {
            console.error('기구 등록 중 오류 발생:', error);
            alert('기구 등록 중 오류가 발생했습니다. 다시 시도해주세요.');
        });
    });
});



// 12. 약력, 진행프로그램추가 태그 동적생성
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
    input.name = `${inputName}`;
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



















