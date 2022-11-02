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
	<h1>고객명 : ${myname}</h1>
	<h1>전화번호 : ${mytel}</h1>
	<h1>이메일 : ${email}</h1>
	<h1>피자사이즈 : ${color}</h1>
	<h1>토핑선택</h1>
	<ul>
	<c:forEach var="n" items="${myarr}">
		<li>${n}</li>
	</c:forEach>
	</ul>
	<h1>희망배송시간 : ${mytime}</h1>
	<h1>배송요청사항 : ${mytxt}</h1>
</body>
</html>