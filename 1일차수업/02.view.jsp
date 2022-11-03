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
	<h1>이름:${myname}</h1>
	<h1>나이:${myage}</h1>
	<h1>생일:${mybirth}</h1>
	<ul>
		<c:forEach var="n" items="${myarr}">
			<li>${n}</li>
		</c:forEach>
	</ul>
</body>
</html>