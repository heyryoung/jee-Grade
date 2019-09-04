<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form id = "student" action="<%=request.getContextPath()%>/write.do">
	<table>
	<tr>
	<td width="230px">주민번호 </td><td> <input  type = "text"  name="jubun"/></td>
	</tr>
	<tr>
	<td width="230px">이름</td>	 <td><input  type = "text"  name="name"/></td>
	</tr>
	<tr>
	<td width="230px">국어</td>	 <td><input  type = "text"  name="kor"/></td>
	</tr>
	<tr>
	<td width="230px">영어</td>	 <td><input  type = "text"  name="eng"/></td>
	</tr>
	<tr>
	<td width="230px">수학</td>	 <td><input  type = "text"  name="math"/></td>
	</tr>
	<tr>	
	<td width="230px">사회</td>	 <td><input  type = "text"  name="soci"/></td>
	</tr>
	<tr>
	<td>
	<input type="submit" value="전송"/>
	</td>
	</tr>
	</table>

</form>
	</div>
	</div>
<script>
	$("#student").submit(function(){
	});
	
</script>

</body>

</html>