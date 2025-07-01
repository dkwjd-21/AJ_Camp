<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 작성</h1>
	<form action="board" method="post">
		<input type="hidden" name="command" value="write">
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
				<th>내용</th>
				<td><textarea type="text" name="content"></textarea></td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="완료">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>