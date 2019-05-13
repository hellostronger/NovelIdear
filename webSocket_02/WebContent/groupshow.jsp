<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Group"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type = "text/javascript"  src="js/jquery-1.8.3.js"></script>
<script type = "text/javascript">
$(document).ready(function(){
	$("tr:odd").css("background-color","lightgray");
})
</script>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>

<table border = "1px" method = "request">
		<tr>
		<th>群账号</th>
		<th>群名称</th>
		
		<%
		String error = (String)request.getAttribute("error");
		if(null!=error){
		if(error.equals("adderror")){
			%>

 out.print("alert('加群成功');");

     <%
		}
			else if(error.equals("noadderror")){
				%>
 alert("增加成功");
      <% 	
			}
		}
	
%>	
	<tr/>
	
	<% 
	//获取request
	
	List<Group> groups =(List<Group>)request.getAttribute("groups");
	if(null!=groups){
	for(Group group:groups){
		%>	
		<tr>
		<td> <a href="QueryGroupByNo?no=<%= group %>"><%= group.getNo() %></a> </td>
		<td><%= friend.getFriendUserName()%> </td>
		<td> <%= friend.getGiveName() %> </td>
		<td> <a href="DeleteFriendServlet?to<%= friend.getTo() %>">删除</a> </td>
		</tr>
		
	<%
	}
	}
	
	%>
	
		</table>
		<a href = "AddFriend.jsp">加好友</a>

</body>
</html>