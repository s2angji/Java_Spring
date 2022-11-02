<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	
	<fieldset>
	<c:choose>
		<c:when test="${bmi <=90}">
				<h3> 저체중입니다 </h3>
				<img alt="저체중" src="image/1.png" width="200" height="200">
		</c:when>
		<c:when test="${bmi >90 && bmi <=110}">
				<h3> 정상입니다</h3>
				<img alt="정상" src="image/2.png" width="200" height="200">
		</c:when>
		<c:when test="${bmi >110 && bmi <= 120}">
				<h3> 과체중입니다</h3>
				<img alt="과제중" src="image/3.png" width="200" height="200">
		</c:when>
		<c:otherwise>
				<h3>비만입니다.  </h3>
				<img alt="비만" src="image/4.png" width="200" height="200">
		</c:otherwise>	
	</c:choose>
	</fieldset>
	
	
</body>
</html>