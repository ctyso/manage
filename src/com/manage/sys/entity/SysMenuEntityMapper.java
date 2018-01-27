package com.manage.sys.entity;

import com.manage.sys.entity.SysMenuEntity;
import com.manage.sys.entity.SysMenuEntityCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuEntityMapper {
    int countByExample(SysMenuEntityCondition example);

    int deleteByExample(SysMenuEntityCondition example);

    int deleteByPrimaryKey(String id);

    int insert(SysMenuEntity record);

    int insertSelective(SysMenuEntity record);

    List<SysMenuEntity> selectByExample(SysMenuEntityCondition example);

    SysMenuEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMenuEntity record, @Param("example") SysMenuEntityCondition example);

    int updateByExample(@Param("record") SysMenuEntity record, @Param("example") SysMenuEntityCondition example);

    int updateByPrimaryKeySelective(SysMenuEntity record);

    int updateByPrimaryKey(SysMenuEntity record);
}