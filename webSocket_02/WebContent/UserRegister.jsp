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
	
var phoneNumber=document.getElementById("phoneNumber");
phoneNumber.onclick=function(){
	phoneNumber.value="";}
	
var address=document.getElementById("address");
address.onclick=function(){
	address.value="";}
	
var userName=document.getElementById("userName");
userName.onclick=function(){
	userName.value="";}
	
var password=document.getElementById("password");
password.onclick=function(){
	password.value="";}

var repassword=document.getElementById("repassword");
repassword.onclick=function(){
	repassword.value="";}

}
</script>


<title>Insert title here</title>
<style type="text/css">
div{text-align:center}
</style>

</head>
<body>

<div>  欢迎注册wechat
</div>


<%
		String error = (String)request.getAttribute("error");
		if(null!=error){
		if(error.equals("adderror")){
			%>
			
	    out.print("注册失败")
			<%
		}
			else if(error.equals("noadderror")){
				%>
				
				out.print("注册成功")	
				<% 	
			}
		}
		

%>




<div>
<form action ="AddUserServlet" method="post" >
      手机号码：<input type = "text" name = "phoneNumber" id="phoneNumber" value = "输入绑定手机号"/><br/>
                地址： <input type = "text" name = "address" id="address" value = "输入地址"/><br/>
                昵称： <input type = "text" name = "userName" id="userName" value = "输入昵称"/><br/>
                密码： <input type = "text" name = "password" id="password" value = "输入密码"/><br/>
	确认密码：<input type = "text"  id=  "repassword" value = "再次确认密码"  /><br/>
     <input type = "submit" value = "注册"/><br/>
     <a href = "index.jsp">返回登陆</a>

</form>
</div>


</body>
</html>