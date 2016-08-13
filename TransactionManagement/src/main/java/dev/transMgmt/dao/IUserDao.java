package dev.transMgmt.dao;

import dev.transMgmt.bean.UserAddnInfo;
import dev.transMgmt.bean.UserInfo;

public interface IUserDao {
	public void insertUser(UserInfo userInfo);

	void insertUserAddnInfo(UserAddnInfo userAddnInfo);

	public int getMaxUserId();
	
	public UserInfo getUserInfo();
}
