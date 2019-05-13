<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type = "text/javascript"  src="js/jquery-1.8.3.js"></script>


<!--点击隐藏 -->
<script type = "text/javascript">
window.onload=function(){
var Id=document.getElementById("Id");
Id.onclick=function(){
	Id.value="";}
var password=document.getElementById("password");
password.onclick=function(){
	password.value="";}
}
</script>


<title>Insert title here</title>
<style type="text/css">
div{text-align:center}
</style>
</head>
<body background ="timg.jpg">

<div>
<form action ="IsUserServlet" method="post"  >
账号：<input type = "text" name = "no" id="no" value = "输入账号"/><br/>
密码：<input type = "text" name = "password" id=  "password" value = "请输入密码"  /><br/>
<input type = "submit" value = "登陆"/><br/>
 <a href=update1.jsp>忘记密码</a> 
 <a href=UserRegister.jsp>立即注册</a> 

<%
		String error = (String)request.getAttribute("error");
		if(null!=error){
		if(error.equals("adderror")){
			%>
			
	    out.print("账号或密码错误")
			<%
		}
			else if(error.equals("noadderror")){
				request.getRequestDispatcher("UserShow.jsp").forward(request, response);
				%>
				
			   登陆成功	
				
				<% 	
			}
		}
		

%>

	

</form>
</div>

</body>
</html>