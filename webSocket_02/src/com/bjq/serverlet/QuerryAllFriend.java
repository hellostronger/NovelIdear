package com.bjq.serverlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjq.ServiceImpl.FriendServiceImpl;

import Entity.Friend;


public class QuerryAllFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QuerryAllFriend() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		FriendServiceImpl friendService = new FriendServiceImpl();
		List<Friend> friends = new ArrayList<>();
		friends  = friendService.queryAllFriend(no);  
		request.setAttribute("friends", friends);//别名friends，friends泛型
		request.getRequestDispatcher("friendshow.jsp").forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
