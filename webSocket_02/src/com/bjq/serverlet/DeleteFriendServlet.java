package com.bjq.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjq.ServiceImpl.FriendServiceImpl;
import com.bjq.ServiceImpl.UserServiceImpl;

import Entity.Friend;
import Entity.User;

public class DeleteFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFriendServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int to = Integer.parseInt(request.getParameter("to"));
		int from = Integer.parseInt(request.getParameter("no"));
		Friend friend = new Friend();
	
		FriendServiceImpl friendService = new FriendServiceImpl();
		boolean result =  friendService.deleteFriend(from, to);
		
		
		System.out.println(from);
		System.out.println(to);
		System.out.println(result);
		
		if(!result) {
			request.setAttribute("error", "adderror");
		}else {
			request.setAttribute("error", "noadderror");
		}
		request.getRequestDispatcher("friendshow.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
