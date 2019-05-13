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
var phonenumber=document.getElementById("phonenumber");
phonenumber.onclick=function(){
	phonenumber.value="";}
var password=document.getElementById("password");
password.onclick=function(){
	password.value="";}
}
</script>

<title>Insert title here</title>

</head>
<body>

 <form action ="UpdateUserServlet" method="post"  >
账号：<input type = "text" name = "Id" id="Id" value = "输入账号"/><br/>
绑定手机：<input type= "text" name = "phonenumber" id = "phonenumber" value = "输入已绑手机号"><br/>
新密码：<input type = "text" name = "password" id=  "password" value = "请输入密码"  /><br/>
<input type = "submit" value = "修改"/><br/>
</form>

<%
String error = (String)request.getAttribute("error");
if(null!=error){
	
if(error.equals("adderror")){
	
	out.println("增加失败");
	Thread.sleep(5000);
	response.sendRedirect("update1.jsp");	
}
	else if(error.equals("noadderror")){
		out.println("增加成功");
		Thread.sleep(5000);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}


%>

</body>
</html>