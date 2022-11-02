<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>키 : ${num1}</h1>
	<h1>몸무게 : ${num2}</h1>
	
	<c:choose>
		<c:when test="${result02 <= 90}">
			<h1>90이하 저체중</h1>
			<img src="../image/11.jpg">
		</c:when>
		<c:when test="${result02 > 90 && result02 <= 110}">
			<h1>90~110 정상</h1>
			<img src="../image/22.jpg">
		</c:when>
		<c:when test="${result02 > 110 && result02 <= 120}">
			<h1>110~120 과체중</h1>
			<img src="../image/33.jpg">
		</c:when>
		<c:when test="${result02 > 120}">
			<h1>120이상 과체중</h1>
			<img src="../image/44.jpg">
		</c:when>		
		<c:otherwise>
			<h3></h3>
		</c:otherwise>						
	</c:choose>
	
</body>
</html>