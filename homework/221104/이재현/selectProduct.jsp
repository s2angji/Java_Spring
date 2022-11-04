<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectUserMyBatisView.jsp</title>
</head>
<body>
<h1>출력물</h1>
<table>
	<thead>
		<tr>
			<th>상품명</th>
			<th>상품수</th>
			<th>생산일자</th>
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