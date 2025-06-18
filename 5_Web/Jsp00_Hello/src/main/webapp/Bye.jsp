<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int no=123; %>
	<h1>Bye.jsp... <%=no %></h1>
	
	<%
	for(int i=0; i<5; i++){
	%>
		<h3>반복합시다!!</h3>
	
	<%
	}
	%>
	
	<br>
	
	<%
	if(10>5){
	%>	
		<h1>if문 조건이 true</h1>
	
	<%	
	}	
	%>
	
</body>
</html>