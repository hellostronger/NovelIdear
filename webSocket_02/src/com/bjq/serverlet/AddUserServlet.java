package com.bjq.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjq.ServiceImpl.UserServiceImpl;

import Entity.User;


public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddUserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String phoneNumber = request.getParameter("phoneNumber");
		String pswd = request.getParameter("password");
		String address = request.getParameter("address");
		User user  = new User(phoneNumber, userName, pswd, address);
		
		System.out.println(phoneNumber);
		System.out.println(userName);
		System.out.println(pswd);
		System.out.println(address);
		
		UserServiceImpl userService = new UserServiceImpl();
		boolean result = userService.addUser(user);
		System.out.println(result);
		if(!result) {
			request.setAttribute("error", "adderror");
		}else {
			request.setAttribute("error", "noadderror");
		}
		request.getRequestDispatcher("UserRegister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
