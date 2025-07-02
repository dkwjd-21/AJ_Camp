<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function signout(){
		if(confirm("정말로 탈퇴하시겠습니까?")){
			location.href='member?command=signout&no=${member.no}';
		}
	}
</script>
</head>
<body>
	<h1>${member.name}님의 마이페이지</h1>
	<table>
		<tr>
			<th>회원번호</th>
			<td>${member.no }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.name }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${member.pw }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member.phone }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='board?command=list'">돌아가기</button>
				<button onclick="signout();">탈퇴하기</button>
			</td>
		</tr>
	</table>
	<hr>
</body>
</html>