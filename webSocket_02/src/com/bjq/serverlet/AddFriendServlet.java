package com.bjq.serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjq.DaoImpl.UserDaoImpl;
import com.bjq.ServiceImpl.FriendServiceImpl;

import Entity.Friend;
import Entity.User;

/**
 * Servlet implementation class AddFriendServlet
 */
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddFriendServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		int to = Integer.parseInt(request.getParameter("to"));
		int from = Integer.parseInt(request.getParameter("from"));
		String giveName = request.getParameter("givename");
		UserDaoImpl userDao = new UserDaoImpl();
		User user =  userDao.queryUserByNo(to);
	    String friendUserName = user.getUserName();
	    System.out.println("start");
	    System.out.println(to);
	    System.out.println(from);
	    System.out.println(giveName);
	    System.out.println(friendUserName);
	    System.out.println("end");
	    
		Friend friend = new Friend(from, to,  friendUserName, giveName);
		
		FriendServiceImpl friendService = new FriendServiceImpl();
		boolean result = friendService.addFriend(friend);
		System.out.println(result);
		if(!result) {
			request.setAttribute("error", "adderror");
		}else {
			request.setAttribute("error", "noadderror");
		}
		request.getRequestDispatcher("AddFriend.jsp").forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
