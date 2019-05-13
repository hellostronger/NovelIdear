package com.bjq.serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjq.ServiceImpl.UserServiceImpl;

import Entity.User;


public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateUserServlet() {
        super();
      
    }

	//重写方法，取值
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no =Integer.parseInt( request.getParameter("Id"));
		String phoneNumber = request.getParameter("phonenumber");
		String pswd = request.getParameter("password");
		User user = new User(no, phoneNumber, pswd);
		
		UserServiceImpl userService = new UserServiceImpl();
		boolean result = userService.update(user);

		 //更改失败   result为false
		if(!result) {
			request.setAttribute("error", "adderror");
			request.getRequestDispatcher("update1.jsp").forward(request, response);
		}	else {
			request.setAttribute("error", "noadderror");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
