<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>    

<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoard" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  myupdate 페이지에서 넘어오는 parameter 받아 dao를 통해 update를 진행 후 결과 처리 -->
<%
	int myno = Integer.parseInt(request.getParameter("myno"));
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoard dto = new MyBoard(myno, null, mytitle, mycontent, null);
	
	MyBoardDao dao = new MyBoardDao();
	int res = dao.update(dto);
	
	if(res>0){
%>	
	<script type="text/javascript">
		alert("글 수정 성공!");
		location.href = "selectone.jsp?myno=<%=dto.getMyno()%>";
	</script>
<%	
	}else{
%>		
	<script type="text/javascript">
		alert("글 수정 실패");
		location.href="myupdate.jsp?myno=<%=dto.getMyno() %>";
	</script>
<%		
	}
%>
</body>
</html>