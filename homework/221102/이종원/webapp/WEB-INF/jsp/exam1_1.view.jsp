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
	<h1>키 : ${myheight}</h1>
	<h1>몸무게 : ${myweight}</h1>
	<h1>진단결과 : ${result}</h1>	
	<h1>결과이미지 : <img src="/firstLec/image/${img}"/></h1>	
	
</body>
</html>