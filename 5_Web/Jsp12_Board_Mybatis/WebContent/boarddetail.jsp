<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BoardDetail</h1>
	<table>
		<tr>
			<th>글 번호</th>
			<td>${dto.seq }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.regdate }</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td>${dto.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="30" rows="10" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="목록으로" onclick="location.href='board?command=list'">
				<input type="button" value="수정" 
					onclick="location.href='board?command=updateform&seq=${dto.seq}'">
				<input type="button" value="삭제"
					onclick="deleteBoard();">					
			</td>
		</tr>
		<script>
			function deleteBoard(){
				if(confirm("게시글을 삭제하시겠습니까?")){
					location.href="board?command=delete&seq="+${dto.seq};
				}
			}
		</script>
	</table>
</body>
</html>