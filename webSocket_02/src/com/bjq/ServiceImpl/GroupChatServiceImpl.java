package com.bjq.ServiceImpl;

import com.bjq.DaoImpl.GroupChatDao;

import Entity.GroupChat;



public class GroupChatServiceImpl {
	GroupChatDao  groupChatDao = new GroupChatDao();
	
	public boolean sendGroupChat(GroupChat groupChat) {
		return  groupChatDao.addgroupchat(groupChat);
	}
	

}
