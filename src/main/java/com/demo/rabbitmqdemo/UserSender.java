package com.demo.rabbitmqdemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Allen
 * @create 2018-08-22 上午 11:46
 * @desc 生产者
 **/
@Component
public class UserSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        User user=new User();
        user.setUsername("allen");
        user.setAge(23);
        System.out.println("user send : " + user.getUsername()+"/"+user.getAge());
        for(int i=0;i<100;i++){
            this.amqpTemplate.convertAndSend("rabbitMQ.test", user);
        }
    }
}
