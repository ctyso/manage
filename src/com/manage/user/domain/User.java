package com.manage.user.domain;

import com.manege.base.BaseObject;

public class User extends BaseObject{
	
	//用户名
	private String userName;
	//密码
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
