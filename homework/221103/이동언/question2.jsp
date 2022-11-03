<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="question2" target="_blank" method="post">
		<label>제품명</label>
		<input type="text" name="name" required><br>	
		<label>수량</label>
		<input type="number" name="cnt" required><br>
		<label>생산일</label>
		<input type="date" name="productday" pattern="\d{4}-\d{1,2}-\d{1,2}" placeholder="0000-00-00"><br>
		<button>입력하기</button>
	</form>
</body>
</html>