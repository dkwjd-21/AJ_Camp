<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 
	core 		: c		http://java.sun.com/jsp/jstl/core
	formatting 	: fmt 	http://java.sun.com/jsp/jstl/fmt
	sql 		: sql	http://java.sun.com/jsp/jstl/sql
	functions 	: fn	http://java.sun.com/jsp/jstl/functions
	xml 		: x		http://java.sun.com/jsp/jstl/xml
	
	core 태그 : 조건문, 반복문, 변수...
	formattings 태그 : 날짜, 숫자 등의 포맷
	
 -->    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Page</h1>
	<table>
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>			
		</tr>
		<c:forEach items="${list }" var="score">
			<tr>
				<td>
					<!-- eq:== ne:!= empty:비었나 -->
					<c:if test="${score.name == '이름1' }">
						<c:out value="홍길동"></c:out>
					</c:if>
					<c:choose>
						<c:when test="${score.name eq '이름2' }">
							<c:out value="${score.name }님!"></c:out>
						</c:when>
						<c:when test="${score.name eq '이름3'}">
							<c:out value="${score.name }님@@"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value=" 누구지?"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:set var="test" value="val"></c:set>
	
	<c:out value="${test}"></c:out>
	
	${test }
	
	<c:forEach var="i" begin="0" end="10" step="1">
		<h4>${i }</h4>
	</c:forEach>
	
	<!--  -->
	<fmt:parseDate var="day" value="2025-06-25" pattern="yyyy-MM-dd"></fmt:parseDate>
	${day }
	<br>
	<fmt:formatDate value="${day }" pattern="MM/dd/yy"/>
</body>
</html>