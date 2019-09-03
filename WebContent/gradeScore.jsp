<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
%>
<table>
	<tr>
		<td>학번</td>
		<td>주번</td>
		<td>이름</td>
		<td>국어</td>
		<td>영어</td>
		<td>수학</td>
		<td>사회</td>
		<td>총점</td>
		<td>평균</td>
	</tr>
<c:forEach items="${student}" var="dto">
	<tr>
		<td>${dto.hacbun}</td>
		<td>${dto.jubun}</td>
		<td>${dto.name}</td>
		<td>${dto.kor}</td>
		<td>${dto.eng}</td>
		<td>${dto.math}</td>
		<td>${dto.soci}</td>
		<td>${dto.kor+dto.eng+dto.math+dto.soci}</td>
		<td>${(dto.kor+dto.eng+dto.math+dto.soci) div 4}</td>
	</tr>
</c:forEach>
</table>



</body>
</html>