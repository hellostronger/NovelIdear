package com.bjq.socket;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.bjq.vo.ContentVo;
import com.bjq.vo.Message;
import com.google.gson.Gson;



@ServerEndpoint("/chatSocket")
//表示localhost://8080/websocket/chatsocket与wc一致

public class ChatSocket {
	private String username;
	private static Map<String, Session> map = new HashMap<String, Session>();

	private static List<Session> sessions = new ArrayList<Session>();
	private static List <String> names= new ArrayList<String>();
	
	@OnOpen
	public void open(Session session) {
		//当前的websocket的session对象,不是servlet的session
		String queryString = session.getQueryString();
		System.out.println(queryString);
		username = queryString.split("=")[1];
		
		this.names.add(username);
		this.sessions.add(session);
		this.map.put(this.username,session);
		String msg  = "欢迎"+this.username+"进入聊天室!!!<br/>";
		
		Message message = new Message();
		message.setWelcome(msg);
		message.setUsernames(this.names);
		
		this.broadcast(this.sessions,message.toJson());	
		System.out.println(names);
		
	}
	
	public void  broadcast(List<Session> ss, String msg) {
	for(Iterator iterator = ss.iterator();iterator.hasNext();){
		Session session = (Session)iterator.next();
		try {
			session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	@OnClose
	public void close(Session session ) {
		
		
		
		
		this.sessions.remove(session);
		this.names.remove(this.username);
		
		String msg  = "欢送"+this.username+"离开聊天室!!!<br/>";
		Message message = new Message();
		message.setWelcome(msg);
		message.setUsernames(this.names);
		
		
		broadcast(this.sessions,message.toJson());
	}
	
	private Gson gson = new Gson();
	@OnMessage
	public void message(Session session, String json) {
		ContentVo vo = gson.fromJson(json, ContentVo.class);
		
		if(vo.getType()==1) {
			//广播
			Message message = new Message();
			message.setContent(this.username,vo.getMsg());
			broadcast(sessions, message.toJson());
		}else {
			//单播
			String to = vo.getTo();
			Session to_session = this.map.get(to);
			
			Message message = new Message();
			message.setContent(this.username,"<font color = red >私聊"+vo.getMsg()+"</font>");
			try {
				to_session.getBasicRemote().sendText(message.toJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
