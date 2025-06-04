
// 오늘 날짜 저장
let today = new Date();
// 페이지 로드 후 실행할 이벤트
window.onload = () => {        
    // tbody에 이벤트 적용 
    // addEventListner : 클릭되었을때 타깃의 태그네임이 td면 배경색상 변경 
    document.getElementById("calenderTbody").addEventListener("click", function(e){
        if(e.target.tagName == "TD"){
            clickedTd(e.target);
        }
    });


}
// build Calender 
function buildCalendar(){
    // tr 행
    let row = null;
    // td 셀
    let cell = null;
    // cnt : 달력에 현재까지 추가된 날짜 셀의 개수
    let cnt = 0;
    // tbody 태그
    let cTBody = document.getElementById("calenderTbody");
    // 제목(오늘 날짜)
    let cTitle = document.getElementById("leftDate").children[0];
    // 제목 innerHTML
    cTitle.innerHTML = today.getFullYear()+"년 "+(today.getMonth()+1)+"월";
    
    
    let firstDate = new Date(today.getFullYear(), today.getMonth(), 1);   
    let lastDate = new Date(today.getFullYear(), today.getMonth()+1, 0);   
    // 작성할 테이블을 초기화
    // 이부분 하지 않으면 prev, next 했을 때 삭제되지 않고 셀이 계속 생김
    while(cTBody.rows.length> 0){    // 고정행을 tbody에 넣었음. 행이 남아있으면 삭제.
        cTBody.deleteRow(cTBody.rows.length-1);            // 가장 마지막 행을 삭제함
    }
    // 달의 첫 날까지 빈 셀을 생성
    row = cTBody.insertRow();
    for(i=0;i<firstDate.getDay();i++){
        cell = row.insertCell();
        cnt++;
    }
    // 본격적으로 달력에 요일 채우기
    for(i=1;i<=lastDate.getDate();i++){
        cell = row.insertCell();
        cnt++;
        cell.setAttribute('id', i);         // 셀에 ID 부여 (날짜 1, 2, 3...)
        cell.innerHTML = i;                 // 날짜 숫자 출력 
        cell.align = "center";              // 가운데 정렬
        if(cnt%7 == 0){ 
            // 전체 셀 개수 7개마다 줄 바꿈                    
            row = cTBody.insertRow();
        }
    }
    // 달력의 마지막 날 뒤 빈칸 행으로 채우기
    if(cnt%7 != 0){
        for(i=0;i<7-(cnt%7);i++){
            cell = row.insertCell();
        }
    }
    // 오늘에 해당하는 td에 default 색상 채우기
    let defaultTd = document.getElementById(today.getDate());
    console.log(defaultTd);
    defaultTd.style.backgroundColor="skyblue";
}
// prev Calender (이전 달)
function prevCalendar(){
    today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
    buildCalendar();
}
// next Calender (다음 달)
function nextCalendar(){
    today = new Date(today.getFullYear(), today.getMonth()+1, today.getDate());
    buildCalendar();
}
// default Month (현재 날짜로 이동)
function defaultCalender(){
    today = new Date();
    buildCalendar();
}

// td 클릭 이벤트 - 배경 색상 변경
function clickedTd(td)
{
    // console.log("click", td);
    let tds = document.getElementsByTagName("td");
    for(let i=0; i<tds.length; i++)
    {
        if(tds[i] == td)
        {
            tds[i].style.backgroundColor = "skyblue";
            // today의 date를 선택한 td의 아이디(날짜 값)로 변경. 
            today.setDate(td.id);
        }
        else
        {
            tds[i].style.backgroundColor = "white";
        }
    }
}
// 카테고리 + 버튼 누르면 할 일 추가
function button(btn)
{
    console.log("button click!", btn);
    
    // btn의 parent "div"의 형제로 요소 추가 - div 요소 생성해서 추가
    let newDiv = document.createElement("div");
    newDiv.className = "btnDiv";
    
    let sectionDiv = btn.parentNode.parentNode;
    console.log(sectionDiv);

    // checkbox
    let eleChk = document.createElement("input");
    eleChk.className = "eleChk";
    eleChk.setAttribute("type", "checkbox");
    
    // text input 
    let eleInp = document.createElement("input");
    eleInp.className = "eleInp";
    eleInp.setAttribute("type", "text");
    eleInp.setAttribute("placeholder", "할 일 입력");
    
    // ... span
    let eleDiv = document.createElement("div");
    eleDiv.className = "eleDiv";
    eleDiv.textContent = "✦";
    eleDiv.onclick = editList;

    newDiv.append(eleChk);
    newDiv.append(eleInp);
    newDiv.append(eleDiv);

    sectionDiv.append(newDiv);
}

let currentTarget = null;
// 할일 리스트의 eleInp & eleDiv 클릭시 이벤트 
function editList(){
    // 제목변경과 삭제를 위해 저장
    currentTarget = this;

    let editDiv = document.getElementById("editList");
    // 타이틀 변경하기 
    let content = this.parentNode.children[1].value;    // input에 저장된 value 값
    editDiv.children[0].textContent = content;   

    // show 
    editDiv.classList.add("show");    
    // overlay on
    let overlay = document.getElementById("overlay");
    overlay.classList.add("overlay");
}
// 할일 리스트의 제목 변경
function editTitle(){
    let editDiv = document.getElementById("editList");
    let originCon = editDiv.children[0].textContent;
    
    let content = prompt("수정할 내용을 작성해주세요!", originCon);
    if(content!=null){
        // input 태그의 value 값 수정      
        currentTarget.parentNode.children[1].value = content;        
        editDiv.classList.remove("show");
        // overlay off
        let overlay = document.getElementById("overlay");
        overlay.classList.remove("overlay");        
    }
}
// 할일 리스트 제거 
function delList(){
    let editDiv = document.getElementById("editList");

    let isDelete = confirm("정말 삭제하시겠습니까?");    
    if(isDelete){
        editDiv.classList.remove("show");
        // 리스트 삭제
        currentTarget.parentNode.remove();    
        // overlay off
        let overlay = document.getElementById("overlay");
        overlay.classList.remove("overlay");    
    }
}

// 카테고리 팝업
function categoryPopUp(){
    let category = document.getElementById("editCategory");
    category.style.opacity=1;
    category.style.visibility="visible";
}

// 카테고리 메뉴 클릭 
function category(){
    // 임의로 닫는 메뉴로 사용 
    let category = document.getElementById("editCategory");
    category.style.opacity=0;
    category.style.visibility="hidden";
}

