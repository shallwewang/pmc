package com.bluebirdme.mes.pmc.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.stereotype.Component;

@Component
public class PtLSpsListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		String msg = "";
		try {
			msg = ((TextMessage) message).getText();
			System.out.println(msg);
		} catch (JMSException e) {
			System.out.println(e.getMessage());
		}
	}

}
