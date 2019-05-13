package com.bjq.IDao;

public interface IFriendDao {
	//根据账号添加好友
	public boolean addFriends(int from,int to,int statement) ;
	
	public boolean  deletefriend(int from,int to,int statement);

}
