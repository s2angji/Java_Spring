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
	<h1>고객명:${name}</h1>
	<h1>전화번호:${tel}</h1>
	<h1>E-mail:${email}</h1>
	<h1>피자 사이즈:${size}</h1>
	<h1>토핑선택:${topping}</h1>
	<h1>희망배송시간:${time}</h1>
	<h1>배송시요청사항:${txt}</h1>
</body>
</html>