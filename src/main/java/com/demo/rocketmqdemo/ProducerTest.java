package com.demo.rocketmqdemo;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

public class ProducerTest {
    private volatile static DefaultMQProducer producer=null;

    private ProducerTest(){}

    public static DefaultMQProducer getProducer(){
        if(producer==null){
            synchronized (ProducerTest.class){
                if(producer==null){
                    producer=new DefaultMQProducer("testGroup");
                    producer.setNamesrvAddr("192.168.0.47:9876");
                    try {
                        producer.start();
                    } catch (MQClientException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return producer;
    }


}
