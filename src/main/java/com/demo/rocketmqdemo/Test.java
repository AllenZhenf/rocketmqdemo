package com.demo.rocketmqdemo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static Logger logger=LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg(){
        DefaultMQProducer producer=ProducerTest.getProducer();
        for(int i=0;i<1000;i++){
            Message message=new Message("topic1","taga","orderID00"+i,("hello metaq"+i).getBytes());
            try {
                SendResult sendResult=producer.send(message);
                logger.info("sendResult:"+sendResult);
            } catch (MQClientException e) {
                e.printStackTrace();
            } catch (RemotingException e) {
                e.printStackTrace();
            } catch (MQBrokerException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
