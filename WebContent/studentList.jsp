<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
     <style>
      .container{   position: relative;   top:45px;  left: 100px; width: 800px;}
      .menu{  border: 3px solid gray; position: relative;   top:10px; width: 750px; font-size: 20px;padding: 25px}
      .head{   position: relative;   top:50px;  left: 20px; height: 100px;}
      .tableBody{     border: 3px solid black; padding: 25px; width: 750px;}
    </style>
<title>성적표</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div class="container">
<div class="menu">
	
	<a href = "<%=request.getContextPath()%>/studentList.do" >학생명부</a>       
	<a href = "<%=request.getContextPath()%>/index.jsp">성적입력</a>      
		<a href = "<%=request.getContextPath()%>/allStudentGrade.do">학기별 등수</a>      
	
</div>
<div class="head">
<h1>성적표</h1><br/><br/>
</div>
<div class="tableBody">
<table style="width: 750px">
	<tr>
		<td>학번</td>
		<td>주번</td>
		<td>이름</td>
	</tr>
<c:forEach items="${student}" var="dto">
	<tr>
		<td><a href = "<%=request.getContextPath()%>/gradeScore.do?hacbun=${dto.hacbun}&jubun=${dto.jubun}">${dto.hacbun}</a></td>
		<td>${dto.jubun}</td>
		<td>${dto.name}</td>
	</tr>
</c:forEach>
</table>
</div>
</div>

</body>
</html>