package org.student.service.impl;

import org.student.dao.IStudentDao;
import org.student.dao.Impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	//左边接口右边实现类
	IStudentDao studentDao = new StudentDaoImpl();
	
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
		return 	studentDao.deleteStudentBySno(sno);
		}else {
			return false;
		}
		
		
	}
	
	//特别，不需要判断
	public  Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	
	public   java.util.List<Student> queryAllStudent(){
		return studentDao.queryAllStudents();	
	}
	
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno))
			return studentDao.updateStudent(sno, student);
		return false;
		
	}
	
	public boolean  addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("此人已存在!");
			return false;
			
		}
		
	}

	
	

}
