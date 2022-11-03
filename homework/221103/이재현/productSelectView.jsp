<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>productSelectView.jsp</title>
</head>
<body>
<h1>출력물</h1>
<table class='table table-striped'>
	<thead>
		<tr>
			<th>이름</th>
			<th>개수</th>
			<th>생산일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${arr }" var="arr">
			<tr>
				<td>${arr.productName }</td>
				<td>${arr.productCount }</td>
				<td>${arr.productDate }</td>
			</tr>
		</c:forEach>		
	</tbody>
</table>

</body>
</html>