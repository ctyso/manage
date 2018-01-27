package com.manage.sys.entity;

import com.manage.sys.entity.SysMenuEntity;
import com.manage.sys.entity.SysMenuEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuEntityMapper {
    int countByExample(SysMenuEntityExample example);

    int deleteByExample(SysMenuEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysMenuEntity record);

    int insertSelective(SysMenuEntity record);

    List<SysMenuEntity> selectByExample(SysMenuEntityExample example);

    SysMenuEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMenuEntity record, @Param("example") SysMenuEntityExample example);

    int updateByExample(@Param("record") SysMenuEntity record, @Param("example") SysMenuEntityExample example);

    int updateByPrimaryKeySelective(SysMenuEntity record);

    int updateByPrimaryKey(SysMenuEntity record);
}