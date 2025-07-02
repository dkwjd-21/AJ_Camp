<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>COMMUNITY BOARD</h1>
	<h3 style="display: inline-block;">${member.name}님 환영합니다.</h3>
	<button onclick="location.href='member?command=mypage'">마이페이지</button>
	<button onclick="location.href='index.html'">로그아웃</button>
	<table>
		<tr>
			<td colspan="3">
				<button onclick="location.href='board?command=insertform'">새 글 작성하기</button>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.no }</td>
				<td>${dto.name }</td>
				<td><a href="board?command=detail&no=${dto.no }">${dto.title }</a></td>
				<td><fmt:formatDate value="${dto.regdate }" pattern="yy-MM-dd"/></td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>