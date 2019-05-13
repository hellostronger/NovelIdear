package com.bjq.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjq.ServiceImpl.UserServiceImpl;

import Entity.User;

/**
 * Servlet implementation class IsUserServlet
 */
public class IsUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public IsUserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String passWord = request.getParameter("password");
		System.out.println(no);
		System.out.println(passWord);
		User user  = new User(no, passWord);
		UserServiceImpl userService = new UserServiceImpl();
		boolean result = userService.isUser(user);
		if(!result) {
			request.setAttribute("error", "adderror");
		}else {//登陆成功跳转到用户界面
			request.setAttribute("no", no);//把登陆账号的本账号传过去
			request.setAttribute("error", "noadderror");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
