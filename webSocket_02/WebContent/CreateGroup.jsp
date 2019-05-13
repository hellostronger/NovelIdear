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
<body>

<div>
<form action="CreateGroupServlet" method="post" >


类型： <input class="aa" type = "text" name = "type" id = "txt"> <br>
  <select id= "test" name ="type">
  <option value = "体育"> 体育</option>
  <option value = "娱乐"> 娱乐</option>
  <option value = "学习"> 学习</option>
  <option value = "二次元">二次元</option>
  <option value= "校园"> 校园</option>
   </select>
<input type = "submit" value = "建群"/><br/>

</form>
	



<%     

		String error = (String)request.getAttribute("error");
		if(null!=error){
		if(error.equals("adderror")){
			%>
			
	    out.print("账号或密码错误")
			<%
		}
			else if(error.equals("noadderror")){
				int no = Integer.parseInt(request.getAttribute("no"));
				request.setAttribute("no", no);
				request.getRequestDispatcher("UserShow.jsp").forward(request, response);
				%>
				
			   登陆成功	
				
				<% 	
			}
		}
		

%>

	


</div>

</body>
</html>