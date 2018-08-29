package com.demo.rocketmqdemo;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

import java.util.function.Consumer;

public class ConsumerTest {
    private volatile static DefaultMQPushConsumer consumer=null;

    private ConsumerTest(){}

    public static DefaultMQPushConsumer getConsumer(){
        if(consumer==null){
            synchronized (consumer){
                if(consumer==null){
                    consumer=new DefaultMQPushConsumer();
                    consumer.setNamesrvAddr("192.168.0.47");
                    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
                }
            }
        }
        return consumer;
    }

}
