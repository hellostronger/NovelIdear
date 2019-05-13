package com.bjq.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc工具类，具备通用性
 * @author bjq
 *
 */

public class DBUtil{

	private static final String URL = "jdbc:mysql://localhost:3307/webchat";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	public static Connection connection = null;
	public static PreparedStatement pstmt =null;
	public static ResultSet rs = null;
	
	
	//获取连接
	public  static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
	}
	
	//关闭全部
		public static void closeAll(ResultSet rs, Statement stmt,Connection connection) {
			
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
			
	
	
	//创建pstmt
	public static PreparedStatement cratePreparedStatement(String sql, Object[]params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if(params!=null) {
		for(int i = 0;i<params.length;i++) {
			pstmt.setObject(i+1,params[i]);
		}
		}
		return pstmt;
	}
	
	//通用增删改
	public static boolean  executeUpdate(String sql,Object[]params) {
	try {
		
		pstmt = cratePreparedStatement( sql, params);
		int count =  pstmt.executeUpdate();
		if(count >0 )
			return true;
		else
			return false;
	
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return false;
	} catch (SQLException e) {	
		e.printStackTrace();
		return false;
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally {
		closeAll(null, (Statement)pstmt, connection); 
	}
	
}
	//通用的查，返回一个集合
	public  static ResultSet executeQuery(String sql,Object[]params) {
		
		
		try {
		pstmt = cratePreparedStatement( sql, params);
		rs = pstmt.executeQuery();
		return rs;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return  rs;
		} catch (SQLException e) {	
			e.printStackTrace();
			return   rs;
		}catch (Exception e) {
			e.printStackTrace();
			return  rs;
		}

	}
	

}
