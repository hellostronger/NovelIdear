package com.bjq.ServiceImpl;

import com.bjq.DaoImpl.GroupDao;

import Entity.Group;

/**
 * 对群成员的操作
 * @author bjq
 *
 */
public class GroupServiceImpl {
	GroupDao groupDao = new GroupDao();
	

	//添加群,返回true添加成功，返回false添加失败
	public boolean addGroup(Group group) {
		//不存在
		if(!groupDao.isExist(group.getNo(), group.getGroupno())) {
			return groupDao.addGroup(group);
		}
			return  false;
	}
	
	
	//退群
	public boolean deletgroup(int no,int groupNo) {
		if(!groupDao.isExist(no,groupNo)) {
			return groupDao.deleteGroupbyno(groupNo, no);
		}
			return  false;
	}
		
	//更改群名
	public boolean updateGroupName(Group group) {
		return false;
	}

}
