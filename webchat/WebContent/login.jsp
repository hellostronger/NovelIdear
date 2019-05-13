<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action ="IsUser" method="post"  onsubmit = "return check()" >
账号：<input type = "text" name = "Id" id="Id" value = "输入账号"/><br/>
密码：<input type = "text" name = "password" id=  "password" /><br/>
<input type = "submit" value = "登陆"/><br/>



	
<%
String error = (String)request.getAttribute("error");
String Id = request.getParameter("Id");
String password = request.getParameter("password");
if(error!=null){
	
if(error.equals("adderror")){
	response.sendRedirect("UserRegister.jsp");	
}
	else if(error.equals("noadderror")){
		//把id传到个人层
		request.setAttribute("Id",Id);
		request.setAttribute("password",password);
		request.getRequestDispatcher("SendWeiBo.jsp").forward(request, response);
		
	}

}


%>

</form>


</body>
</html>