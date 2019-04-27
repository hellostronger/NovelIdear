package org.student.service;

import org.student.entity.Student;

public interface IStudentService {
	
	public boolean deleteStudentBySno(int sno) ;
	
	//特别，不需要判断
	public  Student queryStudentBySno(int sno) ;
	
	
	public   java.util.List<Student> queryAllStudent();
	
	public boolean updateStudentBySno(int sno,Student student) ;
		
	
	public boolean  addStudent(Student student) ;
		


}
