package com.bjq.ServiceImpl;

import com.bjq.DaoImpl.UserDaoImpl;

import Entity.User;

/**
 * Userservice层组装UserDao层的sql语句
 * @author bjq
 *
 */
public class UserServiceImpl {
	
	//UserDao实现类
	UserDaoImpl userDao = new UserDaoImpl();
	
	//查信息
	public  User queryUserByNo(int sno) {
		User user = null;
		//当该用户存在,返回用户信息,否则返回null
		if(userDao.isExist(sno)) {
		System.out.println("okko");
		 user = userDao.queryUserByNo(sno);
	    System.out.println(user.getNo());
		 return user;
		 
		}
		return null;
	}
	
	
	//注册用户
	public boolean  addUser(User user) {
		//拿传过来的账号查看是否已经注册，不存在就注册
		if(!userDao.isExist(user.getNo())) {
			userDao.addUser(user);
			return true;
		}else {
			return false;
			
		}
		
	}
	
	//用于判断登陆账号密码是否正确
	public boolean isUser(User user) {
		User p =  userDao.isUser(user);
		if(null==p) {
			return false;
		}
		return true;
	}
	
	//更改用户信息
	public boolean updateinformation(User user) {
		if(userDao.isExist(user.getNo())) {
		return userDao.updateUser(user);
		}
		return false;
	}
	
	//仅修改密码    返回false
	public boolean update(User user) {
		//不存在或存在但验证手机号失败
		if(!ismaster(user.getNo(), user.getPhoneNumber() )) {
			return false;
		}else {
			
			return userDao.updatepassword(user);
		}
	}
	
	
	
	
	//通过手机号码与账号验证，用于忘记密码
	public boolean ismaster(int no, String phoneNumber){//1,22
		User user = queryUserByNo(no);
		
		if(null==user) {
			System.out.println("okokok");
			return false;
		}else {//执行这
		
			if(!(user.getPhoneNumber().equals(phoneNumber))){
				System.out.println(user.getPhoneNumber());
				System.out.println(phoneNumber);
			    return false;
			}
		}
		return true;	
	}
}
