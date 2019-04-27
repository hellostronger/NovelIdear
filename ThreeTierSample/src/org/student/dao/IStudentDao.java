package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	

	//根据学号查人
	public Student queryStudentBySno(int sno) ;

//判断此人是否存在
	public boolean isExist(int sno) ;

	public boolean  addStudent(Student student) ;
		

	public boolean  deleteStudentBySno(int sno) ;
	//根据学生学号改信息
	public boolean  updateStudent(int sno,Student student) ;
	
	public List<Student> queryAllStudents();
}
