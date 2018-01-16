package com.manage.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.user.domain.User;
import com.manage.user.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService  {

	@Override
	public User loginUser() {
		System.err.println("进入service");
		return null;
	}

}
