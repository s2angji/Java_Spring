<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr><th>이름</th><th>나이</th><th>생일</th></tr>
			</thead>
			<tbody>
				<tr><td>연습1</td><td>1</td><td>1900-01-01</td></tr>
				<tr><td>연습2</td><td>2</td><td>1900-02-01</td></tr>
				<c:forEach var="n" items="${arr}">
					<tr><td>${n.name}</td><td>${n.age}</td><td>${n.birth}</td></tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
