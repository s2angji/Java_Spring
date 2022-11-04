<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>입력화면</h3>
	<form action="test/insertProduct">
		<label>제품명 : </label>
		<input type="text" name="productName"/><br>
		<label>수량 : </label>
		<input type="text" name="productCount"/><br>
		<label>생산일 : </label>
		<input type="date" name="productionDate"/><br>
		<button>입력</button>
	</form>
</body>
</html>