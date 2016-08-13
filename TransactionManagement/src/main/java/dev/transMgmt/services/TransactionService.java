package dev.transMgmt.services;

import dev.transMgmt.bean.UserInfo;

public interface TransactionService {
	String getUserInfo();
	
	void updateUserInfo(UserInfo userInfo);

	Integer getMaxUserId();
}
