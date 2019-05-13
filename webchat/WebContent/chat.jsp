<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="js/jquery-1.8.3.min.js">
</script>
<script type="text/javascript">
var username = '${sessionScope.username}';
var ws;
var target = "ws://localhost:8080/webchat/chatSocket?username="+username;

window.onload = function(){
	//进入聊天室自动打开socket通道
	
	if ('WebSocket' in window) {
        ws = new WebSocket(target);
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(target);
    } else {
        alert('WebSocket is not supported by this browser.');
        return;
	}
	ws.onmessage=function(event){
		eval("var msg="+event.data+";");
		
		console.info(msg);
		
		//if(undefined!=msg.welcome)
		$("#content").append(msg.welcome);
		<%
		//System.out.println(msg.welcome);
		%>
		
		if(undefined!=msg.usernames){
			
			$("#userList").html("");
			$(msg.usernames).each(function(){
			$("#userList").append("<input type = checkbox value = '"+this+"' />"+this+"<br/>")
			});
		}
		
			if(null!=content){
			$("#content").append(msg.content);
		
			}
			
	}
	
}

	
	function subSend(){
	
	var ss = $("#userList :checked");
	var val = $("#msg").val();
	//console.info(ss.size());
	console.info(ss.size());
	var obj =null;
	if(ss.size()==0){
		 obj = {
			msg:val,
			type:1  //1广播 2单播
		}
	}else{
		 var to = $("#userList :checked").val();
		 obj = {
				to:to,
				msg:val,
				type:2  //1广播 2单播
			}
	}
	

	//	//ws.send(val);
	
	 

	
	//	$("#msg").val("");
	
		
		//var ss = $("#userList :checked");
		//console.info(ss.val());
	
		
		//var val = $("#msg").val();
	//	ws.send(val); 
	//	$("#msg").val("");
	
	
	var str = JSON.stringify(obj);//转
	ws.send(str); //传
	$("#msg").val("");
	console.info(str);
	}
	
</script>
</head>
<body>


<div id ="container" style="border:1px solid black;width:400px;height:400px;float:left;">

<div id ="content" style="height:350px;">
</div>
<div style ="border-top:1px solid black;width:400px;height:50px">
<input id="msg"/><button onclick="subSend();">send</button>
</div>
</div>
<div id = "userList" style = "border:1px solid black;width:100px;height:400px;float:left;"></div>



</body>
</html>