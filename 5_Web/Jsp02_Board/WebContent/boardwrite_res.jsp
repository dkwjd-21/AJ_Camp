<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.board.dto.BoardDto" %>
<%@ page import="com.board.dao.BoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- param으로 넘어오는 데이터 받은 후에 dao를 통해 insert 진행, 결과 화면처리 -->
<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDto dto = new BoardDto(0, writer, title, content, null);
	BoardDao dao = new BoardDao();
	int res = dao.insert(dto);
	
	if(res>0){
%>
		<h1>글쓰기 성공</h1>
		<button onclick="location.href='boardList.jsp'">확인</button>
<%			
	}else{
%>
		<h1>글쓰기 실패</h1>
		<button onclick="location.href='boardwrite.jsp'">확인</button>
<%		
	}
%>
	
</body>
</html>