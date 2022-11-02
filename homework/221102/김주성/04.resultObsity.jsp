<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>결과:${result}</h1>

	<choose>
	 
	<when test=" ${result<=90}">
	<h3>저체중</h3>
	<img src="image/low.jpg">
    </when> 
    
    <when test="90<= ${result <=110}">
	<h3>정상</h3>
	<img src="image/ave.jpg">
	</when>
	 
	<when test="110<=${result<=120}">
	<h3>과체중</h3>
	<img src="image/over.jpg">
	</when>
	 
	<when test="120 <= ${result}">
	<h3>비만</h3>
	<img src="image/big.jpg">
	</when>
	 
	</choose>


<%-- 	<if test=" ${result}<=90">
	<h3>저체중</h3>
	<img src="image/low.jpg">
	<if> <if test="90<= ${result} <=110">
	<h3>정상</h3>
	<img src="image/ave.jpg">
	<if> <if test="110<=${result}<=120">
	<h3>과체중</h3>
	<img src="image/over.jpg">
	<if> <if test="120 <= ${result}">
	<h3>비만</h3>
	<img src="image/big.jpg"> <if> --%>
</body>
</html>