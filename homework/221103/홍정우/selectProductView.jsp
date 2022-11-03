<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body class="container">
	<table border="1" class="table">
		<thead>
			<tr>
				<th>상품명</th>
				<th>수량</th>
				<th>생산일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${result }" var="item">
				<tr>
					<td>${item.name }</td><td>${item.cnt }</td><td>${item.birth }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>