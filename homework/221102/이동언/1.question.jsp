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
	<h3>1.question</h3><br>
	<h3>키: ${height}</h3><br>
	<h3>몸무게: ${weight}</h3><br>
	<h3>결과: ${status}</h3><br>
	<h3>표준체중: ${pyojun }</h3><br>
	<h3>비만도: ${bimando }</h3><br>
	<c:choose>
		<c:when test="${status == '저체중'}">
			<img src="images/a.jpg">
		</c:when>
		<c:when test="${status == '정상'}">
			<img src="images/b.jpg">
		</c:when>
		<c:when test="${status == '과체중'}">
			<img src="images/c.jpg">
		</c:when>
		<c:when test="${status == '비만'}">
			<img src="images/d.jpg">
		</c:when>
	</c:choose>
</body>
</html>