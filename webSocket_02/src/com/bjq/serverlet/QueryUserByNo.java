package com.bjq.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.bjq.ServiceImpl.UserServiceImpl;

import Entity.User;


public class QueryUserByNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QueryUserByNo() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//要加那个人的账号
		int no = Integer.parseInt(request.getParameter("no"));
		UserServiceImpl userservice = new UserServiceImpl();
	    //查要加用户信息确认是不是要加那个人 
		User user  = userservice.queryUserByNo(no);
		response.setCharacterEncoding("utf-8");
		request.setAttribute("user",user);
		//放进request域，因为request域可以保留数据，而response重定向只是转页面不能保留数据
		//因此不能用response
		request.getRequestDispatcher("AddFriend.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
