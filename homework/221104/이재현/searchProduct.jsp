<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectUserMyBatisView.jsp</title>
</head>
<body>
<h1>검색결과</h1>
<c:choose>
	<c:when test="${fn:length(arr) < 1 }">
		<h2>검색결과가 없습니다</h2>
	</c:when>
	<c:otherwise>
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
	</c:otherwise>
	
</c:choose>
</body>
</html>
