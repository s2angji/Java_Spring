<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="name" value="홍길동"/>
<c:set var="age" value="20"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름:${name}</h1>
	<h1>나이:${age}</h1>
	
	<c:if test="${name=='이순신'}">
		<h3>이순신입니다.</h3>
		<img src="image/a.jpg">
	</c:if>
	<c:if test="${name=='홍길동'}">
		<h3>홍길동입니다.</h3>
	</c:if>
	
	<c:choose>
		<c:when test="${name=='이순신'}">
			<h3>이순신임</h3>
		</c:when>
		<c:when test="${name=='홍길동'}">
			<h3>홍길동임</h3>
		</c:when>
		<c:otherwise>
			<h3>나머지...</h3>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="n" begin="1" end="10" step="1">
		<h3>${n}</h3>
	</c:forEach>
</body>
</html>