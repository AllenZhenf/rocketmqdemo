package com.demo.rabbitmqdemo;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
* @Description: rabbitmq生产者
* @Author: Allen
* @CreateDate: 2018/8/16
*/
public class RabbitProducer {
    public final static String QUEUE_NAME="rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
//        factory.setHost("192.168.0.47");
        factory.setUsername("root");
        factory.setPassword("root");
//         factory.setPort(5673);
        Address[]addresses=new Address[]{new Address("192.168.0.47",5672),new Address("192.168.0.47",5673),new Address("192.168.0.47",5674)};
        //创建一个新的连接
        Connection connection = factory.newConnection(addresses);
        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列
        //b durable 队列持久化设为true
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //设置每个消费者在同一个时间点最多处理多少个message
        //channel.basicQos(1);
        String message = "Hello RabbitMQ";
        //发送消息到队列中
        for(int i=0;i<100;i++){
            //第一个s:exchange null则默认direct
            //第二个：队列名
            //第四个：具体消息内容
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));

            //传递对象
//            User user=new User();
//            user.setAge(25);
//            user.setUsername("allen");
//            channel.basicPublish("",QUEUE_NAME,null, SerializationUtils.serialize(user));
        }
        System.out.println("Producer Send +'" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }

}