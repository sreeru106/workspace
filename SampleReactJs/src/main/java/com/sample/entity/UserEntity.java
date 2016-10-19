package com.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_userinfo")
public class UserEntity {

	@Id
	@Column(name="user_id")
	private int userId;
	
	
//	public UserEntity(int userId, String userName, String userAge) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.userAge = userAge;
//	}
//	
//
//	public UserEntity() {
//		super();
//		// TODO Auto-generated constructor stub
//	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_age")
	private String userAge;
	
	
	
}
