<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 글 보기</h1>
	
	<table>
		<tr>
			<th>번호</th>
			<td>${dto.myno }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.mydate}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="40" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정"
					onclick="location.href='myboard?command=updateform&myno=${dto.myno}'">
				<input type="button" value="삭제"
					onclick="chkDelete();">
					<!-- 삭제버튼 클릭 -> 컨트롤러에서 요청을 받아 dao를 통해 해당 게시글 삭제 진행 -> index.html로 이동 -->
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		function chkDelete(){
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href = 'myboard?command=delete&myno='+${dto.myno};
			}
		}
	</script>
</body>
</html>