package org.student.dao.Impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

import com.mysql.jdbc.Statement;

//根据学号查学生
public class StudentDaoImpl implements IStudentDao {
	
	//根据学号查人
	public Student queryStudentBySno(int sno) {
	Student student = null;
	ResultSet rs = null;
	PreparedStatement pstmt =null;
		try {
		String  sql = "select * from student where sno = ?";
		 Object []params = {sno};
		 rs = DBUtil.executeQuery(sql, params);//提出来在catch可以关闭
			 while(rs.next()) {
				int no =  rs.getInt("sno");
			 String  name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address =  rs.getString("saddress");
				student = new Student(no,name,age,address);
			 }
			 
			return  student;
		
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
  
	

		
		

//判断此人是否存在
	public boolean isExist(int sno) {
			return true;
		}

	
	public boolean  addStudent(Student student) {
		String sql = "insert into student (sno,sname,sage,saddress) values(?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	
	}
	
	public boolean  deleteStudentBySno(int sno) {
		String sql ="delect * from  student where sno = ? ";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
		
	}
	
	//根据学生学号改信息
	public boolean  updateStudent(int sno,Student student) {
	String  sql  = "update student set sname = ?,sage = ?,saddress = ?where sno = ?";
	Object []params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
	return	DBUtil.executeUpdate(sql, params);
		
	}
	
	public List<Student> queryAllStudents() {
		 PreparedStatement pstmt =null;
		 List<Student> students  =  new ArrayList<Student> ();
		 ResultSet rs = null;
		try {
			
			String sql = "select * from student ";
		    rs = DBUtil.executeQuery(sql, null);//提出来在catch可以关闭
			 while(rs.next()) {
				int no =  rs.getInt("sno");
			 String  name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address =  rs.getString("saddress");
				Student student = new Student(no,name,age,address);
				students.add(student);
			 }
			 
			return  students;
		
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
  
 

