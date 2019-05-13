package com.bjq.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjq.DaoImpl.UserDaoImpl;
import com.bjq.ServiceImpl.FriendServiceImpl;
import com.bjq.ServiceImpl.GroupServiceImpl;

import Entity.Friend;
import Entity.Group;
import Entity.User;


public class AddGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddGroupServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));//加入或创建的人
		int id = Integer.parseInt(request.getParameter("id"));//群地位
		int groupNo= Integer.parseInt(request.getParameter("groupno"));//群号
		String groupName = request.getParameter("groupname");//群号
		Group group = new Group(groupNo, no, id, groupName);
		GroupServiceImpl  groupService = new GroupServiceImpl();
		boolean result = groupService.addGroup(group);
		if(!result) {
			request.setAttribute("error", "adderror");
		}else {
			request.setAttribute("error", "noadderror");
		}
		request.getRequestDispatcher("groupshow.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
