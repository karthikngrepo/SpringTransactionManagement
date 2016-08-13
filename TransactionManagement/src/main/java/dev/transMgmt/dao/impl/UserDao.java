package dev.transMgmt.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dev.transMgmt.bean.UserAddnInfo;
import dev.transMgmt.bean.UserInfo;
import dev.transMgmt.dao.IUserDao;

@Transactional(readOnly=true)
public class UserDao implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public void insertUser(UserInfo userInfo) {
		System.out.println("Inserting user in dao !!!");
		String insertQuery = "INSERT INTO user_info "
				+ "(id, name, FirstName, Address, City) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?)";

		jdbcTemplate.update(insertQuery, userInfo.getId(), 
				userInfo.getName(),	userInfo.getFirstName(), 
				userInfo.getAddress(), userInfo.getCity());
		System.out.println("Successfully added user info into to DB");
		
		insertUserAddnInfo(userInfo.getAddnUserInfo());
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public void insertUserAddnInfo(UserAddnInfo userAddnInfo) {
		System.out.println("Inserting additinal user info in dao !!!");
		String insertQuery = "INSERT INTO user_addn_info (email, phone, user_id) "
				+ "VALUES (?, ?, ?)";

		jdbcTemplate.update(insertQuery, userAddnInfo.getEmail(), 
				userAddnInfo.getPhone(), userAddnInfo.getUserId());
		System.out.println("Successfully added additional user into to DB");
	}

	@Override
	public int getMaxUserId() {
		System.out.println("Fecthing the max user id from DB !!!");
		String maxUserIdQuery = "SELECT max(id)+1 FROM user_info";
		int maxUserId = jdbcTemplate.queryForObject(
				maxUserIdQuery, Integer.class);
		System.out.println("maxUserId from DB : "+maxUserId);
		return maxUserId;
	}
	
	@Override
	public UserInfo getUserInfo() {
		System.out.println("Extracting the user info from DB !!!");
		
		//TODO - Implementation yet to be provided
		throw new UnsupportedOperationException(
				"Implemantion yet to be provided");
	}
}