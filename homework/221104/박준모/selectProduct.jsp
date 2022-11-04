<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>제품 목록</title>
</head>
<body>
	<div class="container" style="text-align: center;">
		<h3>제품 목록</h3><br>
	    <table class='table table-striped'>
        	<thead>
        		<tr>
        			<th>제품명</th>
        			<th>수량</th>
        			<th>생산일</th>
       			</tr>
        	</thead>
       		<tbody>
       			<c:forEach var="n" items="${arr}">
       				<tr>
       					<td>${n.product}</td>
       					<td>${n.count}</td>
       					<td>${n.date}</td>
   					</tr>
       			</c:forEach>
       		</tbody>
   		</table>
   		<br>
   		<a href="../productHome.html">홈으로 가기</a>
   	</div>
</body>
</html>