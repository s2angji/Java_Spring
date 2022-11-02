<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>키:${tall}</h1>
		<h1>몸무게:${weight}</h1>
		<h1>결과:${result}</h1>
		
		<c:if test="${result == '저체중'}">
		<img src="../image/1.png">
		</c:if>
		<c:if test="${result == '정상'}">
		<img src="../image/2.png">
		</c:if>
		<c:if test="${result == '과체중'}">
		<img src="../image/3.png">
		</c:if>
		<c:if test="${result == '비만'}">
		<img src="../image/4.png">
		</c:if>
		
</body>
</html>