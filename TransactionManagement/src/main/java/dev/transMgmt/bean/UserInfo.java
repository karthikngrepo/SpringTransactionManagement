package dev.transMgmt.bean;

public class UserInfo {
	
	private Integer id;
	
	private String name;
	
	private String firstName;
	
	private String address;
	
	private String city;
	
	private UserAddnInfo addnUserInfo;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public UserAddnInfo getAddnUserInfo() {
		return addnUserInfo;
	}
	
	public void setAddnUserInfo(UserAddnInfo addnUserInfo) {
		this.addnUserInfo = addnUserInfo;
	}
}
