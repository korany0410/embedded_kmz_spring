<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coffee</title>
</head>
<body>
	<table border="1">
		<caption>CAFE-LIST</caption>
		<tr>
			<th>카페명</th>
			<th>주소</th>
			<th>매장번호</th>
			<th>임대료</th>
			<th>인건비</th>
		</tr>
		<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.name}</td>
			<td>${vo.address}</td>
			<td>${vo.tel}</td>
			<td>${vo.mon_rental}원</td>
			<td>${vo.labor_cost}원</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>