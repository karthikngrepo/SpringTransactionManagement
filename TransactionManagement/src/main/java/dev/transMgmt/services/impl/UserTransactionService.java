package dev.transMgmt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dev.transMgmt.bean.UserInfo;
import dev.transMgmt.dao.IUserDao;
import dev.transMgmt.services.TransactionService;


public class UserTransactionService implements TransactionService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public String getUserInfo() {
		System.out.println("Fetching the user info !!!");
		
		return null;
	}
	
	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("Updating the user info !!!");
		userDao.insertUser(userInfo);
	}
	
	@Override
	public Integer getMaxUserId() {
		return userDao.getMaxUserId();
	}
}
