<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>   

<%@ page import="com.board.dao.BoardDao" %> 
<%@ page import="com.board.dto.BoardDto" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- param를 받아 dao에 delete 실행 후 결과 처리 -->
<% 
	// int seq = Integer.parseInt(request.getParameter("seq"));
	
	// int res = new BoardDao().delete(seq);
	// 삭제 진행시 muldelete() 활용하여 삭제 
	String[] seq = request.getParameterValues("seq");
	int res = new BoardDao().multiDelete(seq);
	
	if(res>0){
		// 삭제 성공 처리
%>
		<script type="text/javascript">
			alert("글 삭제 성공!");
			location.href="boardList.jsp";
		</script>
<%		
	} else {
		// 삭제 실패 처리
%>
		<script type="text/javascript">
			alert("글 삭제 실패ㅠㅠ");
			location.href="boarddetail.jsp?seq=<%=seq%>";
		</script>
<%		
	}
%>	
</body>
</html>