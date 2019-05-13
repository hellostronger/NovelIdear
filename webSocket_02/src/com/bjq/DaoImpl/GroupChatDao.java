package com.bjq.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjq.Util.DBUtil;
import com.mysql.jdbc.Statement;

import Entity.GroupChat;

/**
 * 群聊记录表底层操作
 * @author bjq
 *
 */
public class GroupChatDao {
	
	  //发一条两人间信息就往chat表增加一行
	  public  boolean addgroupchat(GroupChat groupChat){
		  String sql = "insert into groupchat values(?,?,?,?)";
			Object[] params = {groupChat.getGroupno(),groupChat.getFromno(),groupChat.getTime(),groupChat.getMessage()};
			return DBUtil.executeUpdate(sql, params);
	  }
	  
	  
	  //查群聊记录
	  public GroupChat queryChat(int sno) {
		  GroupChat  groupChat = null;
			ResultSet rs = null;
			PreparedStatement pstmt =null;
				try {
				String  sql = "select * from group where fromno = ?";
				 Object []params = {sno};
				 rs = DBUtil.executeQuery(sql, params);//提出来在catch可以关闭
					 while(rs.next()) {
						int groupno =  rs.getInt("groupno");//账号
						int fromno =  rs.getInt("fromno");//
						long time =  rs.getInt("time");//
						String message =  rs.getString("message");
				 groupChat = new  GroupChat(groupno,fromno,time,message);	
					 }
					 
					return  groupChat;
				
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
