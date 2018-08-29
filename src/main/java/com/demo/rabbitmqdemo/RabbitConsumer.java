package com.demo.rabbitmqdemo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
* @Description: rabbitmq消费者
* @Author: Allen
* @CreateDate: 2018/8/16
*/
public class RabbitConsumer {
        private final static String QUEUE_NAME = "rabbitMQ.test";

        public static void main(String[] args) throws IOException, TimeoutException {
            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ地址
//            factory.setHost("192.168.0.47");
//            factory.setPort(5672);
            factory.setUsername("root");
            factory.setPassword("root");
            Address []addresses=new Address[]{new Address("192.168.0.47",5672),new Address("192.168.0.47",5673),new Address("192.168.0.47",5674)};
            //创建一个新的连接
            Connection connection = factory.newConnection(addresses);
            //创建一个通道
            Channel channel = connection.createChannel();
            //声明要关注的队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("Customer Waiting Received messages");
            //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
            // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Customer Received '" + message + "'");
                    //反序列化获取对象
//                    User user=(User)SerializationUtils.deserialize(body);
//                    System.out.println(user.getUsername());
                }
            };
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(QUEUE_NAME, true, consumer);

            //手动一条条取
//            GetResponse response= channel.basicGet(QUEUE_NAME,true);
//            String message=new String(response.getBody(),"UTF-8");
//            System.out.println(response.getMessageCount()+"   "+message);
//            channel.basicQos(1);
        }
}
