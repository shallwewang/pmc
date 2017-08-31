package com.bluebirdme.mes.pmc.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @author shallwe_wang
 * WCS 料车上线中完成信号监听器
 * 
 */
@Component
public class InDispathsListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("接收到消息:" + ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}