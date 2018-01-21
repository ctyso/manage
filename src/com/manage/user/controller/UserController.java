package com.manage.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annotation.Json;
import com.annotation.JspView;
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
        return "login";
    }

    @RequestMapping(value = "/queryList.htm")
    @Json
    public Object queryList( HttpServletRequest request, HttpServletResponse response ) {
        return "的还会";
    }

}
