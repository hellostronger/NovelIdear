package com.bjq.DaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjq.Util.DBUtil;
import com.mysql.jdbc.Statement;

import Entity.Chat;

/**
 * 两人之间的信息表操作
 * @author bjq
 *
 */
public class ChatDao {
	
	      //发一条两人间信息就往chat表增加一行
		  public  boolean addchat(Chat chat){
			  String sql = "insert into chat(from,to,time,message) values(?,?,?,?)";
				Object[] params = {chat.getFrom(),chat.getTo(),chat.getTime(),chat.getMessage()};
				return DBUtil.executeUpdate(sql, params);
		  }
		  
		  
		  //查两人之间的记录
		  public Chat queryChat(int sno) {
			  Chat chat = null;
				ResultSet rs = null;
				PreparedStatement pstmt =null;
					try {
					String  sql = "select * from chat where from = ?";
					 Object []params = {sno};
					 rs = DBUtil.executeQuery(sql, params);//提出来在catch可以关闭
						 while(rs.next()) {
							int from =  rs.getInt("from");//账号
							int to =  rs.getInt("to");//
							long time =  rs.getInt("time");//
							String message =  rs.getString("message");
							
					 chat = new  Chat( from,  to, time, message);
							
						 }
						 
						return  chat;
					
					} catch (SQLException e) {	
						e.printStackTrace();
						return  null;
					}catch (Exception e) {
						e.printStackTrace();
						return null;
					}finally {
						DBUtil.closeAll(rs,(Statement) pstmt, DBUtil.connection);
						}
		  }


}
