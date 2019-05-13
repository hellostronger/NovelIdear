package com.bjq.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjq.Util.DBUtil;
import com.mysql.jdbc.Statement;

import Entity.User;

/**
 * 继承IUserDao接口，实现与数据库之间具体操作
 * @author bjq
 *
 */
public  class UserDaoImpl {

	//根据账号查用户
	public User queryUserByNo(int sno) {
		User user = null;
		ResultSet rs = null;
		PreparedStatement pstmt =null;
			try {
			String  sql = "select * from user where no = ?";
			 Object []params = {sno};
			 rs = DBUtil.executeQuery(sql, params);//提出来在catch可以关闭
				 while(rs.next()) {
					int no =  rs.getInt("no");
					String  phoneNumber = rs.getString("phonenumber");
				    String   userName = rs.getString("username");
				    String  password = rs.getString("password");
					String address =  rs.getString("address");
					user = new User(no, phoneNumber,  userName,  password,  address);
				 }
				 
				return  user;
			
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

	
	//判断用户是否存在
	public boolean isExist(int sno) {
		User user = null;
		 user = queryUserByNo(sno) ;
		 if(null!=user) {
			 return true;
		 }
		 return false;
		 
	}


	

	//根据账号注销用户
	public boolean deleteUserbyno(int sno) {
		String sql ="delect * from  user where no = ? ";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}


	//传进更改后的值更改个人信息
	public boolean updateUser(User user) {
		
		String  sql  = "update user set phonenumber = ?,password = ?,address = ?,username = ?where no = ?";
		Object []params = {user.getPhoneNumber(),user.getPswd(),user.getAddress(),user.getUserName(),user.getNo()};
		return	DBUtil.executeUpdate(sql, params);
	}
	

	 //添加用户,因为no是主键非空，而且属性自增，所以自动生成用户账号
	public boolean  addUser(User user) {
		String sql = "insert into user(phonenumber,password,address,username) values(?,?,?,?)";
		Object[] params = {user.getPhoneNumber(),user.getPswd(),user.getAddress(),user.getUserName()};
		return DBUtil.executeUpdate(sql, params);
	
	}

	//更改密码，仅用于忘记密码
	public boolean updatepassword(User user) {
		String sql ="update user set password = ? where no = ?";
		Object[] params = {user.getPswd(),user.getNo()};
		return	DBUtil.executeUpdate(sql, params);
	}
	
	//判断登陆账号密码是否匹配
	public User isUser(User user){
		if(isExist(user.getNo())) {
			//数据库存在此账号
			User ago =  queryUserByNo(user.getNo());
			if(ago.getPswd().equals(user.getPswd())) {
				//输入密码与数据库中的密码一致
				return ago;
			}
		}else {//此账号不存在
			return null;
		}
		return null;
	}

}
