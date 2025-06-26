<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 쓰기</h1>
	<form action="controller.do" method="post">
	<input type="hidden" name="command" value="boardwrite">
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>제 목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내 용</th>
			<td>
				<textarea name="content" rows="10" cols="40" required></textarea>
			</td>
		</tr>
		<tr>
				<td colspan="2" align="center">
					<button type="submit">작성</button>
					<button type="button" onclick="location.href='controller.do?command=list'">취소</button>
				</td>
			</tr>
	</table>
	</form>
</body>
</html>