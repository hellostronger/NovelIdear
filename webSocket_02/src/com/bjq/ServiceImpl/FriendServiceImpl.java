package com.bjq.ServiceImpl;



import com.bjq.DaoImpl.FriendDao;

import Entity.Friend;

/**
 * 朋友表
 * @author bjq
 *
 */
public class FriendServiceImpl {
    FriendDao friendDao = new FriendDao();
    
    //加好友
    public boolean addFriend(Friend friend) {
    	return friendDao.addfriend(friend);
    }
    
    //删好友
    public boolean deleteFriend(int sFrom,int sTo) {
    	//判断两人之间是否存在朋友关系
    	if(friendDao.isFriend(sFrom, sTo)){
    		return friendDao.deleteUserbyno(sFrom, sTo);
    	}
    	return false;
    }
    
    public   java.util.List<Friend> queryAllFriend(int no){
		return friendDao.queryAllFriends(no);	
	}

}
