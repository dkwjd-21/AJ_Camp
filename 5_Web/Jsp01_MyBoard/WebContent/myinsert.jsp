<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- db에 저장할 데이터를 입력 받을 form 작성 -->
	<h1>Write Page</h1>
	<form action="myinsert_res.jsp" method="post">
		<tr>
			<th>NAME</th>
			<td><input type="text" name="myname"></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><input type="text" name="mytitle"></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" name="mycontent"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="입력">
				<input type="button" value="취소" onclick="history.back();">
			</td>
		</tr>
	</form>
</body>
</html>