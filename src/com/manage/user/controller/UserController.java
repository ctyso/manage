package com.manage.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annotation.Json;
import com.annotation.JspView;
import com.manage.base.layui.bean.DataTable;
import com.manage.base.layui.bean.PageInfo;
import com.manage.user.service.IUserService;

@Controller
@RequestMapping("/user/login/")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login.htm")
    @JspView
    public String login( HttpServletRequest request, HttpServletResponse response ) {
        System.err.println( "jinlaile" );
        userService.loginUser();
        return "user/login";
    }

    @RequestMapping(value = "/form.htm")
    @JspView
    public String form( HttpServletRequest request, HttpServletResponse response ) {
        userService.loginUser();
        return "demo/form";
    }

    /**
     * 数据表格响应格式 {code:...,count:...,data:...}
     */
    @RequestMapping(value = "/queryList.htm")
    @Json
    public Object queryList( HttpServletRequest request, HttpServletResponse response ) {
        // 分页对象，可以获取到当前页数和分页大小
        PageInfo pageInfo = new PageInfo( request );
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "id", "123" );
        map.put( "username", "cg" );
        map.put( "sex", "女" );
        map.put( "city", "龙岩" );
        map.put( "sign", "cgsb" );
        map.put( "experience", "0" );
        map.put( "score", "0" );
        map.put( "classify", "vegetables" );
        map.put( "wealth", "0" );
        list.add( map );
        return new DataTable( list );
    }

    @RequestMapping(value = "/layui.htm")
    @JspView
    public Object layui( HttpServletRequest request, HttpServletResponse response ) {
        return "layuidemo";
    }

    @RequestMapping(value = "/index.htm")
    @JspView
    public Object index( HttpServletRequest request, HttpServletResponse response ) {
        return "index";
    }

}
