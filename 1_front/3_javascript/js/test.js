// 함수 test 생성
function test()
{
    window.alert("외부 작성 방식!")
}

// 웹 페이지가 "다 완전히 로드된 뒤" 실행되는 코드를 지정
window.onload=()=>
{
    alert("윈도우 로딩 후!!!")
}

// onload=()=> 랑 동일. arrow function
// window.onload=function()
//     {
//         alert("윈도우 로딩 후!!!")
//     }