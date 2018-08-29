package com.demo.rabbitmqdemo.fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @create 2018-08-29 上午 10:11
 * @desc
 **/

@Controller
public class FanoutController {

    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping(value="/fanoutTest")
    @ResponseBody
    public void fanoutTest() {
        fanoutSender.send();
    }
}
