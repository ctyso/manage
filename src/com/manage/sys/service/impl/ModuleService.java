package com.manage.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.sys.entity.Module;
/**
 * 处理层
 * @author SmartChenwx
 *
 */
@Service
public class ModuleService {
	@Autowired
	private SqlSession sqlsession;
	
	/**
	 * 根据查询条件获取所有菜单数据
	 * @param map
	 * @return
	 */
	public List<Module> findAll(Map<String,Object> map){
		List<Module> list = sqlsession.selectList("com.manage.sys.sqlmapper.ModuleMapper.findAllByParams",map);
		return list;
	}
	
	/**
	 * 获取所有菜单数据
	 * @param map
	 * @return
	 */
	public List<Module> findAll(){
		List<Module> list = sqlsession.selectList("com.manage.sys.sqlmapper.ModuleMapper.findAll");
		return list;
	}
}
