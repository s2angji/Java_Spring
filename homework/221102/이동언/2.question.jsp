<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
	<h3>2.question</h3><br>
	<table>
		<th>요청사항</th>
		<th>내용</th>
		
		<tr>
			<td>고객명</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${telnum}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${email}</td>
		</tr>
		<tr>
			<td>사이즈</td>
			<td>${size}</td>
		</tr>
		<tr>
			<td>토핑</td>
			<td>
				<c:forEach var="aa" items="${topping}" varStatus="i">
					<c:choose>
						<c:when test="${i.last}">${aa}</c:when>
						<c:otherwise>${aa}, </c:otherwise>
					</c:choose>
				</c:forEach>
			
			</td>
		</tr>
		<tr>
			<td>요청시간</td>
			<td>${time}</td>
		</tr>
		<tr>
			<td>요청사항</td>
			<td>${needs}</td>
		</tr>
	</table>
</body>
</html>