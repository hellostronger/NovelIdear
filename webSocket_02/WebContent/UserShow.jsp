<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 int No = Integer.parseInt(request.getParameter("no")); //拿到IsUser传进来的本次登陆账号
%>
<a href="friendshow.jsp?no=No">查看好友</a><br/><br/>
<a href="groupshow.jsp">查看群聊</a><br/><br/>
<a href="my.jsp">查看个人信息</a>

</body>
</html>