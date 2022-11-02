<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
	display: flex;
	border: 1px solid black;
}
.values {
	display: flex;
	flex-direction: column;
	border-right: 1px solid black;
}
</style>
</head>
<body>
	<div class="container">
		<div class="values">
			<h1>키:${height}</h1>
			<h1>몸무게:${weight}</h1>
			<h1>결과:${result}</h1>
		</div>

		<c:if test="${result=='저체중'}">
			<img src="../image/1.png">
		</c:if>
		<c:if test="${result=='정상'}">
			<img src="../image/2.png">
		</c:if>
		<c:if test="${result=='과체중'}">
			<img src="../image/3.png">
		</c:if>
		<c:if test="${result=='비만'}">
			<img src="../image/4.png">
		</c:if>
	</div>
</body>
</html>