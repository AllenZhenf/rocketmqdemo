package com.demo.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Allen
 * @create 2018-08-22 上午 11:49
 * @desc 消费者
 **/

@Component
@RabbitListener(queues = "rabbitMQ.test")
public class UserReceiver {

    @RabbitHandler
    public void process(User user){
        System.out.println("userReceiver1"+user.getUsername()+"/"+user.getAge());
    }
}
