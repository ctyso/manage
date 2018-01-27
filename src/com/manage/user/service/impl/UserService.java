package com.manage.user.service.impl;

import com.manage.base.MyBatisDao;
import com.manage.user.domain.User;
import com.manage.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends MyBatisDao implements IUserService  {
	

	
	@Override
	public User loginUser() {
	/*	MenuEntityExample menuEntityExample=new MenuEntityExample();
		MenuEntityExample.Criteria criteria=menuEntityExample.createCriteria();
		criteria.andIdEqualTo("123123");
		List<MenuEntity> list =  getSqlSession().getMapper(MenuEntityMapper.class) .selectByExample(menuEntityExample); */
		return null;
	}

}
