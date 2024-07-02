const abousContents = document.querySelectorAll(".aboutus-content-divdivdiv");
const frontContents = document.querySelectorAll(".aboutus-content-figure");
const backContents = document.querySelectorAll(".back-div");

abousContents.forEach((abousContent, i) => {
  abousContent.addEventListener("mouseover", () => {
    frontContents[i].style.display = "hidden";
    backContents[i].style.transform = "none";
  });
});

abousContents.forEach((abousContent, i) => {
  abousContent.addEventListener("mouseout", () => {
    frontContents[i].style.display = "block";
    backContents[i].style.transform = "rotateY(180deg)";
  });
});
