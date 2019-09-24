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
      .tableBody{     border: 1px solid black; padding-left: 25px; width: 750px;}
    </style>
<title>성적표</title>
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
<div >
<table style="width: 750px" class="tableBody">
	<tr id="tableHead">
		<td>학기</td>
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
<%
	int i = 3 ; 
	int studentLength =Integer.parseInt(String.valueOf( request.getAttribute("studentLength")));
%>
<c:forEach items="${student}" var="dto">
	<%
	if(i % studentLength==0){
	%>
	</table>
	<table style="width: 750px" class="tableBody">
	<tr>
	<td colspan="10"><h3><%=(i-studentLength)/12+1 %>학년 <%=((i-studentLength)/studentLength)%4+1 %>	학기</h3> </td>
	</tr>
	<%	
	}
	 %>
	<tr style="border-bottom-width: 3px">
		<td ></td>
		<td>${dto.hacbun}</td>
		<td>${dto.jubun}</td>
		<td>${dto.name}</td>
		<td>${dto.kor}</td>
		<td>${dto.eng}</td>
		<td>${dto.math}</td>
		<td>${dto.soci}</td>
		<td>${dto.kor+dto.eng+dto.math+dto.soci}</td>
		<td>${(dto.kor+dto.eng+dto.math+dto.soci) div 4}</td>
	</tr >
<%
	i++;
%>
	</c:forEach> 
</table>
</div>
</div>

</body>
</html>