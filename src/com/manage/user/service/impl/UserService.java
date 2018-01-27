package com.manage.user.service.impl;

import com.manage.base.MyBatisDao;
import com.manage.sys.entity.SysMenuEntity;
import com.manage.sys.entity.SysMenuEntityCondition;
import com.manage.sys.entity.SysMenuEntityMapper;
import com.manage.user.domain.User;
import com.manage.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService extends MyBatisDao implements IUserService  {
	

	
	@Override
	public User loginUser() {
		SysMenuEntityCondition condition=new SysMenuEntityCondition();
		SysMenuEntityCondition.Criteria criteria=condition.createCriteria();
		criteria.andIdEqualTo("1232323");
		condition.setOrderByClause("insert_time desc");
		List<SysMenuEntity> list =  getSqlSession().getMapper(SysMenuEntityMapper.class) .selectByExample(condition);
		return null;
	}

}
