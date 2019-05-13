package com.bjq.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoSocket {
	
	
	public EchoSocket(){
	System.out.println("EchoSocket.EchoSocket()");
	}
	
	
	@OnOpen 
	public void open(Session session) {
		System.out.println("sessionid:"+session.getId());
		
		
	}
	
	@OnClose
	public void close(Session session) {
		System.out.println("session."+session.getId()+"关闭了");
	}

	@OnMessage
	public void mesage(Session session,String msg) {
		System.out.println("客户端"+msg);
		try {
			session.getBasicRemote().sendText("服务器：欢迎使用军强云");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
