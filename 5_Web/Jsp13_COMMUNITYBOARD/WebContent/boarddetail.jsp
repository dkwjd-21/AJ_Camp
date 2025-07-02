<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delBoard(){
		if(confirm("게시글을 삭제하시겠습니까?")){
			location.href='board?command=delete&writer=${dto.name}&no=${dto.no }';
		}
	}
</script>
</head>
<body>
	<h1>BOARD DETAIL [${dto.no }]</h1>
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
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="30" rows="10" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="3">
				<button onclick="location.href='board?command=list'">목록</button>
				<button onclick="location.href='board?command=updateform&writer=${dto.name}&no=${dto.no }'">수정</button>
				<button onclick="delBoard();">삭제</button>
			</td>
		</tr>
	</table>
	
</body>
</html>