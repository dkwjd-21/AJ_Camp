<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.board.dao.BoardDao" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- parameter를 받아 dao를 통해 삭제 진행 후 결과 처리 -->
<%
	// 동일한 name의 파라미터가 다수 존재할 때 
	String[] seq = request.getParameterValues("chk");
	
	// 하나도 선택하지 않은 경우
	if(seq == null){
%>
		<script type="text/javascript">
			alert("삭제할 글을 1개 이상 선택해 주세요!");
			location.href="boardList.jsp";
		</script>
<%		
	} else {
		BoardDao dao = new BoardDao();
		int res = dao.multiDelete(seq);
		
		if(res==seq.length){
			// 다중 삭제 성공 처리 
%>
			<h1>체크한 글 <%=res%>개 모두 삭제 성공하였습니다.</h1>
			<button onclick="location.href='boardList.jsp'">확인</button>
<%				
		} else{
			// 다중 삭제 실패 처리
%>
			<h1>체크한 글 삭제를 실패하였습니다.</h1>
			<button onclick="location.href='boardList.jsp'">확인</button>
<%	
		}	
	}
%>	
	
</body>
</html>