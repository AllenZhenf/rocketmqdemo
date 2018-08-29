package com.demo.rabbitmqdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Allen
 * @create 2018-08-22 上午 11:54
 * @desc 测试controller
 **/
@Controller
public class UserTest {
    @Autowired
    private UserSender userSender;

    @RequestMapping(value="/test")
    @ResponseBody
    public void test(){
        userSender.send();
    }
}
