<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
<div class="container">
  <table class="table table-striped table-bordered"> 
		<thead>
			<tr><th>이름</th><th>나이</th><th>생일</th></tr>
		</thead>
		<tbody>
			<c:forEach var="n" items="${arr}">
				<tr><td>${n.name}</td><td>${n.age}</td><td>${n.birth}</td></tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>

