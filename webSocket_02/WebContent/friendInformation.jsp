<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entity.User"%>

<title>Insert title here</title>
</head>
<body>

<table border = "1px" method = "request">
		<tr>
		<th>账号</th>
		<th>昵称</th>
		<th>地址</th>
		
	<tr/>
	<%
	//获取request
	
	
	User user =(User)request.getAttribute("user");
	if(null!=user){
		%>	
		<tr>
		<td><%= user.getNo() %> </td>		
		<td> <%= user.getUserName() %>  </td>		
		<td> <%=user.getAddress() %>  </td>		
		</tr>
		
	<%
	
	}
	
	%>
	
		</table>

</body>
</html>