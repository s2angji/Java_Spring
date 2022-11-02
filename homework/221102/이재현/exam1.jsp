<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam1.jsp</title>
</head>
<body>
	<h3>키 : ${height }</h3>
	<h3>몸무게 : ${weight }</h3>
	<h3>결과 : ${result}</h3>
	
	<c:choose>
		<c:when test="${result eq '저체중' }">
			<img alt="fat1" src="../image/fat1.jpg">
		</c:when>
		<c:when test="${result eq '정상' }">
			<img alt="fat2" src="../image/fat2.jpg">
		</c:when>
		<c:when test="${result eq '과체중' }">
			<img alt="fat3" src="../image/fat3.jpg">
		</c:when>
		<c:when test="${result eq '비만' }">
			<img alt="fat4" src="../image/fat4.jpg">
		</c:when>	
	</c:choose>
	
</body>
</html>