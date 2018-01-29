package com.manage.user.service.impl;

import com.manage.base.MyBatisDao;
import com.manage.sys.entity.SysMenuEntity;
import com.manage.user.domain.User;
import com.manage.user.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService extends MyBatisDao implements IUserService  {
	public static final String MAPPER_NAMESPACE = "com.manage.sys.sqlmapper.SysMenuMapper";
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public User loginUser() {
		List<SysMenuEntity> caseContentExtendList=sqlsession.selectList(MAPPER_NAMESPACE + ".findAll");

		
		/*SysMenuEntityCondition condition=new SysMenuEntityCondition();
		SysMenuEntityCondition.Criteria criteria=condition.createCriteria();
		criteria.andIdEqualTo("1232323");
		condition.setOrderByClause("insert_time desc");
		List<SysMenuEntity> list =  getSqlSession().getMapper(SysMenuEntityMapper.class) .selectByExample(condition);*/
		return null;
	}

}
