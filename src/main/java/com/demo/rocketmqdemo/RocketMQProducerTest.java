package com.demo.rocketmqdemo;

import org.apache.rocketmq.common.message.Message;

public class RocketMQProducerTest {

    public static void main(String[] args) {

        String mqNameServer = "192.168.0.47:9876";
        String mqTopics = "MQ-MSG-TOPICS-TEST";

        String producerMqGroupName = "PRODUCER-MQ-GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();


        for (int i = 0; i < 5; i++) {

            Message message = new Message();
            message.setBody(("I send message to RocketMQ " + i).getBytes());
            mqProducer.send(message);
        }


    }
}
