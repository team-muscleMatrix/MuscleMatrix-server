/* 슬라이드 1*/
// const nextbtn1 = document.querySelector(".mach-box.this1 .swiper-button-next")
// const prevbtn1 = document.querySelector(".mach-box.this1 .swiper-button-prev")
// const slideUI1 = document.querySelector(".bot-wrap.this1");

// //총 6개 보여줄때의 xdegree값들
// var xdegree = 0;
// nextbtn1.addEventListener("click",()=>{
//     xdegree -= 281;
//     console.log("xdegree = " + xdegree);
//     if(xdegree === -281){ prevbtn1.style.display = "block"; } 
//     with (slideUI1.style) {
//         transform = `translateX(${xdegree}px)`;
//         transition = "transform 0.3s ease 0s";
//     }
//     // if(xdegree === -562) nextbtn1.style.display ="none;"
//     xdegree === -562 ? (nextbtn1.style.display = "none") : (nextbtn1.style.display = "block");
// });

// prevbtn1.addEventListener("click", () => {
//     xdegree += 281;
//     console.log("xdegree = " + xdegree);
//     if(xdegree === 0){ 
//         prevbtn1.style.display = "none"; 
//         nextbtn1.style.display = "block"
//     };
//     with (slideUI1.style) {
//         transform = `translateX(${xdegree}px)`;
//         transition = "transform 0.3s ease 0s";
//     }
//     xdegree === -1405 && (nextbtn1.style.display = "block");
// });

// 전체슬라이드
// 슬라이드 1
const nextbtn1 = document.querySelector(".mach-box.this1 .swiper-button-next");
const prevbtn1 = document.querySelector(".mach-box.this1 .swiper-button-prev");
const slideUI1 = document.querySelector(".bot-wrap.this1");

// 슬라이드 2
const nextbtn2 = document.querySelector(".mach-box.this2 .swiper-button-next");
const prevbtn2 = document.querySelector(".mach-box.this2 .swiper-button-prev");
const slideUI2 = document.querySelector(".bot-wrap.this2");

// 슬라이드 3
const nextbtn3 = document.querySelector(".mach-box.this3 .swiper-button-next");
const prevbtn3 = document.querySelector(".mach-box.this3 .swiper-button-prev");
const slideUI3 = document.querySelector(".bot-wrap.this3");

const setupSlider = (nextBtn, prevBtn, slideUI) => {
    let xdegree = 0;

    nextBtn.addEventListener("click", () => {
        xdegree -= 281;
        console.log("xdegree = " + xdegree);
        if (xdegree === -281) {
            prevBtn.style.display = "block";
        }
        with (slideUI.style) {
            transform = `translateX(${xdegree}px)`;
            transition = "transform 0.3s ease 0s";
        }
        xdegree === -562 ? (nextBtn.style.display = "none") : (nextBtn.style.display = "block");
    });

    prevBtn.addEventListener("click", () => {
        xdegree += 281;
        console.log("xdegree = " + xdegree);
        if (xdegree === 0) {
            prevBtn.style.display = "none";
            nextBtn.style.display = "block";
        }
        with (slideUI.style) {
            transform = `translateX(${xdegree}px)`;
            transition = "transform 0.3s ease 0s";
        }
        xdegree === -1405 && (nextBtn.style.display = "block");
    });
};

// 각각의 슬라이드에 대해 setupSlider 함수 호출
setupSlider(nextbtn1, prevbtn1, slideUI1);
setupSlider(nextbtn2, prevbtn2, slideUI2);
setupSlider(nextbtn3, prevbtn3, slideUI3);

