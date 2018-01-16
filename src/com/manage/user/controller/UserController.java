package com.manage.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manage.user.service.IUserService;
import com.manage.user.service.impl.UserService;


@Controller
@RequestMapping("/user/login/")
public class UserController {
	@Autowired IUserService userService;

    @RequestMapping(value="/login.htm")
    public String login(){
    	System.err.println("jinlaile");
    	userService.loginUser();
        return "login";
    }
    
   
}
