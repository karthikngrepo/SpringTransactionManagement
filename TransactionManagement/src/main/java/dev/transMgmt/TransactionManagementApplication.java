package dev.transMgmt;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.transMgmt.bean.UserAddnInfo;
import dev.transMgmt.bean.UserInfo;
import dev.transMgmt.dao.IUserDao;
import dev.transMgmt.dao.impl.UserDao;
import dev.transMgmt.services.TransactionService;
import dev.transMgmt.services.impl.UserTransactionService;

@EnableTransactionManagement
@SpringBootApplication
public class TransactionManagementApplication {

	@Bean
	IUserDao userDao() {
		return new UserDao();
	}
	
	@Bean
	TransactionService transactionservice() {
		return new UserTransactionService();
	}
	
	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		System.out.println("Creating JdbcTemplate bean");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication
				.run(TransactionManagementApplication.class, args);
		
		TransactionService txService = (TransactionService) ctx
				.getBean("transactionservice");

		//-----------------------------------------//
		//Preparing the bean for positive scenario
		int maxUserId = txService.getMaxUserId();
		UserInfo userInfo = new UserInfo();
		userInfo.setId(maxUserId);
		userInfo.setName("User"+maxUserId);
		userInfo.setFirstName("firstName"+maxUserId);
		userInfo.setCity("city"+maxUserId);
		userInfo.setAddress("address"+maxUserId);
		
		UserAddnInfo addnInfo = new UserAddnInfo();
		addnInfo.setEmail("user"+maxUserId+"@usermail.com");
		addnInfo.setPhone("123456789");
		addnInfo.setUserId(maxUserId);
		userInfo.setAddnUserInfo(addnInfo);
		
		txService.updateUserInfo(userInfo);
		
		//------------------------------------------//
		//Preparing the bean for Rollback scenario
		maxUserId = maxUserId + 1;
		userInfo = new UserInfo();
		userInfo.setId(maxUserId);
		userInfo.setName("User"+maxUserId);
		userInfo.setFirstName("firstName"+maxUserId);
		userInfo.setCity("city"+maxUserId);
		userInfo.setAddress("address"+maxUserId);
		
		addnInfo = new UserAddnInfo();
		addnInfo.setEmail("user"+maxUserId+"@usermail.com");
		addnInfo.setPhone("Invalid value"); //Passing the invalid value for int column
		addnInfo.setUserId(maxUserId);
		userInfo.setAddnUserInfo(addnInfo);
		
		txService.updateUserInfo(userInfo);//This transaction rollback due to runtime SQL exception
	}
}
