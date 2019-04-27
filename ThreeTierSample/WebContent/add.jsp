<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type = "text/javascript"  src="js/jquery-1.8.3.js"></script>
<script type = "text/javascript">
function check(){
	var sno = $("#sno").val();
	var sname = $("#sname").val();
	var sage = $("#sage").val();
	var saddress = $("#saddress").val();
	if(!(sno>0&&sno<101)){
		alert("学号有误，必须是0-100")
		return false;
	}  
	
	
	
	return true;
}

$(document).ready(function(){
	$("tr:odd").css("background-color","lightgray");
	
	
	
	
});
</script>
<title>Insert title here</title>
</head>
<body>
<form action=" ADDStudentServlet" method="post"  onsubmit = "return check()" >
账号：<input type = "text" name = "sno" id="sno"/><br/>
密码：<input type = "text" name = "sname" id=  "sname" /><br/>
年龄:<input type = "text" name = "sage" id = "sage"/><br/>
地址：<input type = "text" name = "saddress" id = "saddress"/><br/>
<input type = "submit" value = "新增"/><br/>

</form>
</body>
</html>