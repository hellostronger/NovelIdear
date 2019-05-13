<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Friend"%>
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
		<th>好友账号</th>
		<th>昵称</th>
		<th>备注名字</th>
		<th>操作</th>
		<%
		String error = (String)request.getAttribute("error");
		if(null!=error){
		if(error.equals("adderror")){
			%>
 alert("增加成功");
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
	
	List<Friend> friends =(List<Friend>)request.getAttribute("friends");
	if(null!=friends){
	for(Friend friend:friends){
		%>	
		<tr>
		<td> <a href="QueryUserByNo?no=<%= friend.getTo() %>"><%= friend.getTo() %></a> </td>
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