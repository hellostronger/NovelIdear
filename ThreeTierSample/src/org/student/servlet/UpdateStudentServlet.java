package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {
	
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;







	/**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
       
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//获取要修改的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		//修改后的内容 

		String name = request.getParameter("sname");
		int age =Integer.parseInt(request.getParameter("sage")) ;
		String address = request.getParameter("saddress");
		//
		Student student = new Student(name,age,address);
		
		
		
		IStudentService  service = new StudentServiceImpl();
		
		boolean result = service.updateStudentBySno(no, student);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		
		if(result) {
	//		out.println("修改成功");
			response.sendRedirect("QueryAllStudent");//修改完毕显示全部学生
		}else {
			out.println("修改失败");
		}
	}
		
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
