package com.bluebirdme.mes.pmc.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
/**
 * @author shallwe_wang
 * 用于向MES的消息队列服务器发送消息
 */
@Component
public class PmcSender {
	@Autowired
	@Qualifier("jmsPMCTemplate")
    private JmsTemplate jmsPMCTemplate;//通过@Qualifier修饰符来注入对应的bean
     
    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void send(String queueName,final String message)throws JmsException{
    	jmsPMCTemplate.convertAndSend(queueName, message);
    }
}
