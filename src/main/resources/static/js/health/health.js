/* 슬라이드 1*/
 const nextbtn1 = document.querySelector(".mach-box.this1 .swiper-button-next");
 const prevbtn1 = document.querySelector(".mach-box.this1 .swiper-button-prev");
 const slideUI1 = document.querySelector(".bot-wrap.this1");

 // 총 6개 보여줄 때의 xdegree 값들
 var xdegree = 0;
 prevbtn1.style.display = "none"; 

 nextbtn1.addEventListener("click", () => {
     xdegree -= 281;
     console.log("xdegree = " + xdegree);
     if (xdegree === -281) prevbtn1.style.display = "block"; 
     slideUI1.style.transform = `translateX(${xdegree}px)`;
     slideUI1.style.transition = "transform 0.3s ease 0s";
     xdegree === -562 ? (nextbtn1.style.display = "none") : (nextbtn1.style.display = "block");
 });

 prevbtn1.addEventListener("click", () => {
     xdegree += 281;
     console.log("xdegree = " + xdegree);
     if (xdegree === 0) { 
         prevbtn1.style.display = "none"; 
         nextbtn1.style.display = "block";
     }
     slideUI1.style.transform = `translateX(${xdegree}px)`;
     slideUI1.style.transition = "transform 0.3s ease 0s";
     xdegree === -1405 && (nextbtn1.style.display = "block");
 });

//슬라이드 2
 const nextbtn2 = document.querySelector(".mach-box.this2 .swiper-button-next");
 const prevbtn2 = document.querySelector(".mach-box.this2 .swiper-button-prev");
 const slideUI2 = document.querySelector(".bot-wrap.this2");

 var xdegree2 = 0;
 prevbtn2.style.display = "none"; 

 nextbtn2.addEventListener("click", () => {
     xdegree2 -= 281;
     console.log("xdegree2 = " + xdegree2);
     if (xdegree2 === -281) prevbtn2.style.display = "block";
     slideUI2.style.transform = `translateX(${xdegree2}px)`;
     slideUI2.style.transition = "transform 0.3s ease 0s";
     xdegree2 === -562 ? (nextbtn2.style.display = "none") : (nextbtn2.style.display = "block");
 });

 prevbtn2.addEventListener("click", () => {
     xdegree2 += 281;
     console.log("xdegree2 = " + xdegree2);
     if (xdegree2 === 0) {
         prevbtn2.style.display = "none";
         nextbtn2.style.display = "block";
     }
     slideUI2.style.transform = `translateX(${xdegree2}px)`;
     slideUI2.style.transition = "transform 0.3s ease 0s";
     xdegree2 === -1405 && (nextbtn2.style.display = "block");
 });
 
 
 //슬라이드3
 const nextbtn3 = document.querySelector(".mach-box.this3 .swiper-button-next");
 const prevbtn3 = document.querySelector(".mach-box.this3 .swiper-button-prev");
 const slideUI3 = document.querySelector(".bot-wrap.this3");

 var xdegree3 = 0;
 prevbtn3.style.display = "none"; 

 nextbtn3.addEventListener("click", () => {
     xdegree3 -= 281;
     console.log("xdegree3 = " + xdegree3);
     if (xdegree3 === -281) prevbtn3.style.display = "block";
     slideUI3.style.transform = `translateX(${xdegree3}px)`;
     slideUI3.style.transition = "transform 0.3s ease 0s";
     xdegree3 === -562 ? (nextbtn3.style.display = "none") : (nextbtn3.style.display = "block");
 });

 prevbtn3.addEventListener("click", () => {
     xdegree3 += 281;
     console.log("xdegree3 = " + xdegree3);
     if (xdegree3 === 0) {
         prevbtn3.style.display = "none";
         nextbtn3.style.display = "block";
     }
     slideUI3.style.transform = `translateX(${xdegree3}px)`;
     slideUI3.style.transition = "transform 0.3s ease 0s";
     xdegree3 === -1405 && (nextbtn3.style.display = "block");
 });