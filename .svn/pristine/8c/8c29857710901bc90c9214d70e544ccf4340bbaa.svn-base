package com.bluebirdme.mes.pmc.activemq;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import org.springframework.stereotype.Component;

/**
 * 
 * @author shallwe_wang
 * 消息队列异常监听器
 * 
 */
@Component
public class JmsExceptionListener implements ExceptionListener {

	@Override
	public void onException(JMSException e) {
		e.printStackTrace();
	}

}