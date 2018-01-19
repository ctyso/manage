package com.manage.user.controller;

import com.manage.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired IUserService userService;

    @RequestMapping(value="/login.htm")
    public String login(){
    	System.err.println("jinlaile");
    	userService.loginUser();
        return "login";
    }
    
   
}
