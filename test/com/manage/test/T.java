package com.manage.test;

import base.BaseServiceTestRemote;
import com.manage.user.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 卢春文 on 2018/1/25.
 */
public class T extends BaseServiceTestRemote{
    @Autowired
    private IUserService userService;
    
    @Test
    public void  T(){
        System.out.print("Sdsdsdsd");
        userService.loginUser();
    }
}
