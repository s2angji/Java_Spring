<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품목록</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
</head>
<body>

<div class="container">
  <h2>제품 목록</h2>

	<table class="table table-dark table-hover">
		<thead class="thead-light">
		<tr>
			<th>제품명</th><th>수량</th><th>생산일</th>
		</tr>
		</thead>
		<tbody>

		<c:forEach var="rs" items="${arr}">		
			<tr>
				<td>${rs.product_name}</td><td>${rs.product_ea}</td><td>${rs.product_date}</td>
			</tr>		
		</c:forEach>			
			
		</tbody>
	</table>
  
  	<button onclick="location.href='/firstLec/exam2_1_productInsert.html'">계속 제품입력</button>	
	
</div>
  
</body>
</html>