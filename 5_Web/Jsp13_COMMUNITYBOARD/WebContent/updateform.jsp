<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BOARD UPDATE [${dto.no }]</h1>
	<form action="board" method="post">
	<input type="hidden" name="command" value="update">
	<input type="hidden" name="no" value="${dto.no }">
	<table>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${dto.regdate }" pattern="yyyy년 MM월 dd일"/></td>
		</tr>                                                   
		<tr>
			<th>작성자</th>
			<td>${dto.name }</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${dto.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="30" rows="10" name="content">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="돌아가기"
					onclick="location.href='board?command=detail&no=${dto.no}'">
				<input type="submit" value="수정완료">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>