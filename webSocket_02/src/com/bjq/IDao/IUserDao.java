package com.bjq.IDao;

import Entity.User;
/**
 * 接口
 * @author bjq
 *
 */
public interface IUserDao {
	
	//根据账号查用户
		public User queryUserByNo(int sno) ;

	//判断用户是否存在
		public boolean isExist(int sno) ;
		
		public boolean  addUser(User user);
		
		public boolean  deleteUserbyno(int sno) ;
		//根据账号改信息
		public boolean  updateUser(int sno,User user) ;
		
		
}
