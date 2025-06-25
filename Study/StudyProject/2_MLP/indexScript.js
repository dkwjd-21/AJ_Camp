
// Top 버튼 클릭시, 페이지의 가장 윗 부분으로 이동하는 메소드
function goToTop(){
    window.scrollTo({
        top : 0,
        behavior : 'smooth'
    });
}

// 북마크 버튼 클릭시, wish 페이지로 이동
function goToBMark(){
    window.location.href = "wish.html";
}


// 프로필수정 & 게시글 작성 취소
function cancel(){
    document.getElementById("editProfile").style.display = "none";
    document.getElementById("writeFeed").style.display = "none";
    overlayOff();
}

/* ---------------------- 프로필 수정 ---------------------- */ 
// 프로필 수정 버튼을 눌렀을 때 팝업 띄우기
function showEditProfile(){
    document.getElementById("editProfile").style.display = "block";
    overlayOn();
}
// 이미지 업로드 클릭
function uploadProImg() {
    // 숨겨진 input을 클릭
    document.getElementById("fileInput").click();
}
// 이미지 첨부 
function changeImage(event) {
  
}

/* ------------------------ 글쓰기 -------------------------------- */
// 피드작성을 눌렀을 때 팝업 띄우기
function showWriteForm(){
    document.getElementById("writeBtn").textContent = "작성중";
    document.getElementById("writeFeed").style.display = "block";
    overlayOn();
} 


/* ---------------------- 오버레이 관리 ---------------------- */ 
function overlayOn(){
    let overlay = document.getElementById("screenOverlay");
    overlay.classList.add("screenOverlay");
}
function overlayOff(){
    let overlay = document.getElementById("screenOverlay");
    overlay.classList.remove("screenOverlay");
}