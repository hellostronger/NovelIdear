package com.bjq.DaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjq.Util.DBUtil;
import com.mysql.jdbc.Statement;

import Entity.Friend;
/**
 *朋友表底层数据库操作
 * @author bjq
 *
 */
public class FriendDao{
	
	//添加好友
	  public  boolean addfriend(Friend friend){
		  final int a = 1;
	
		 String sql = "insert into friend (fromone,toone,addornot,friendusername,givename,acceptname)values(?,?,?,?,?,?)";
        
		   
			Object[] params = {friend.getFrom(),friend.getTo(),a,friend.getFriendUserName(),friend.getGiveName(),friend.getAcceptName()};
			System.out.println(sql);
			return DBUtil.executeUpdate(sql, params);
	  }
	  
	//删除好友
	  public boolean deleteUserbyno(int from,int to) {
			String sql ="delect * from  friend where from = ? and to = ?  ";
			Object[] params = {from,to};
			return DBUtil.executeUpdate(sql, params);
	  }
	  
	  //查找一对好友
	  public Friend  queryFriend(int sFrom,int sTo) {
		    Friend friend  = null;
			ResultSet rs = null;
			PreparedStatement pstmt =null;
				try {
				String  sql = "select * from friend where from = ? and to = ? and statement = ?";
				 Object []params = {sFrom,sTo};
				 rs = DBUtil.executeQuery(sql, params);//提出来在catch可以关闭
					 while(rs.next()) {
						int from = rs.getInt("from");
						int to = rs.getInt("to");
						int statement = rs.getInt("statement");
					 friend = new Friend( from, to,  statement);
					 }
					 
					return friend;
				
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
	  
	  
	  //判断
	  public boolean isFriend(int sFrom,int sTo) {
		  Friend friend = null;
		  friend = queryFriend(sFrom, sTo);
		  if(null==friend) {
			  friend = queryFriend(sTo,sFrom );
			  if(null==friend)
				  return false;
		  }else {
			  return true;
		  }
		  return false;  
	  }
	  
	  
	  
	  public List<Friend> queryAllFriends(int sno) {
	  PreparedStatement pstmt =null;
		 List<Friend> friends  =  new ArrayList<Friend> ();
		 ResultSet rs = null;
		 final int  a = 1;//statement为1就表示
		try {
			String sql = "select * from friend where from = ? and statement = ?";
			 Object []params = {sno,a};
			rs = DBUtil.executeQuery(sql,params);//提出来在catch可以关闭
			 while(rs.next()) {
				if(rs.getInt("statement")!=a) {
				int no =  rs.getInt("no");
				int from = rs.getInt("from");
				int to = rs.getInt("to");
				Friend friend = new Friend(no,from,to);
				friends.add(friend);
			 }
			 }
			 return friends;
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
