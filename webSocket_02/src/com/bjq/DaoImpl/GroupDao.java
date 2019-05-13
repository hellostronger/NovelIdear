package com.bjq.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjq.Util.DBUtil;
import com.mysql.jdbc.Statement;

import Entity.Group;

/**
 * 群成员表
 * @author bjq
 *
 */
public class GroupDao {
	
	
	//添加群
	  public  boolean addGroup(Group group){
		    String sql = "insert into group(groupno,no,id,mygroupname,type) values(?,?,?,?,?)";
			Object[] params = {group.getGroupno(),group.getNo(),group.getId(),group.getMygroupnameString(),group.getType()};
			return DBUtil.executeUpdate(sql, params);
	  }
	 
	//退群
	  public boolean deleteGroupbyno(int groupNo,int no) {
			String sql ="delect * from group where groupno = ? and no = ?  ";
			Object[] params = {groupNo,no};
			return DBUtil.executeUpdate(sql, params);
		}

	  
	   //查所在群
	  public Group queryGroup(int sno,int sGroupNo) {
		    Group group= null;
			ResultSet rs = null;
			PreparedStatement pstmt =null;
				try {
				String  sql = "select * from group where no = ? and groupNo = ?";
				 Object []params = {sno,sGroupNo};
				 rs = DBUtil.executeQuery(sql, params);//提出来在catch可以关闭
					 while(rs.next()) {
						int groupNo =  rs.getInt("groupNo");//账号
						int no =  rs.getInt("no");//
						int id =  rs.getInt("id ");//
						String myGroupName =  rs.getString("mygroupname");
						
				   group = new  Group( groupNo,no,id,myGroupName);
						
					 }
					 
					return  group;
				
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
	  
	  //判断用户是否已经在群
		public boolean isExist(int sno,int groupNo) {
			Group group = null;
			group = queryGroup(sno,groupNo);
			if(null == group) {
				//不存在
				return false;
			}
			
			return true;
		}

}
