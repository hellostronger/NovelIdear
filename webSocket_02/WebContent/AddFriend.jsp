 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type = "text/javascript"  src="js/jquery-1.8.3.js"></script>
<script type = "text/javascript">
$(document).ready(function(){
	$("tr:odd").css("background-color","lightgray");
})
</script>

<title>Insert title here</title>
<title>Insert title here</title>
<style type="text/css">
div{text-align:center}
</style>

</head>
<body>

<div>

<form action ="QueryUserByNo" method="post"  onsubmit = "return check()" >

加好友账号：<input type = "text" name = "no" id="no" value = "输入朋友账号"/><br/>
<input type = "submit" value = "搜素"/><br/>
</form>
</div>


<%
		User user = (User)request.getAttribute("user");
		if(null!=user){
		
			%>
			
	    out.print("查无此人")
			<%
		}
			if(null!=user){
			%>
	   <table border = "1px" method = "request">
		<tr>
		<th>账号</th>
		<th>昵称</th>
		<th>地址</th>
		<th>操作</th>
		
	<tr/>
	

	
	<%
	//获取request

	
	
		%>	
		<tr>
		<td> <%= user.getNo() %></td>		<!-- 账号 -->
		<td> <%= user.getUserName() %></td>	<!-- 昵称 -->
		<td> <%= user.getAddress() %></td>	<!--  地址-->
		</tr>
		<% 	
			}
%>
</table>
		
<form action="AddFriendServlet" method="post" >
自己账号：<input type = "text" name = "from" id="from" value = "输入自己账号"/><br/>
对方账号：<input type = "text" name = "to" id=  "to" value = "输入好友账号" /><br/>
发送备注：<input type = "text" name = "acceptname" id=  "acceptname"  value = "输入对方看的备注"/><br/>
添加对方备注：<input type = "text" name = "givename" id=  "givename" value= "备注对方是谁"/><br/>
<input type = "submit" value = "确认加好友"/><br/>

</form>


<%
		String error = (String)request.getAttribute("error");
		if(null!=error){
		if(error.equals("adderror")){
			%>
			
	    out.print("加好友成功");
			<%
		}
			else if(error.equals("noadderror")){
				%>
				
				out.print("加好友失败")	;
				<% 	
			}
		}
		

%>


</body>
</html>