package com.bluebirdme.mes.pmc.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import com.alibaba.druid.util.StringUtils;

/**
 * 
 * @author shallwe_wang
 * 用于向MES的消息队列服务器发送消息
 */
@Component
public class MesSender {
	@Autowired
	@Qualifier("jmsMESTemplate")
	private JmsTemplate jmsMESTemplate;

	/**
	 * 发送一条消息到指定的队列（目标）
	 * 
	 * @param queueName
	 *            队列名称
	 * @param message
	 *            消息内容
	 */
	public void send(String queueName, final String message) {
		if (!StringUtils.isEmpty(queueName)) {
			switch (queueName) {
			case "PMC_MES_AVI_QUEUE":
			case "PMC_MES_SPS_RESET_QUEUE":
			case "PMC_MES_SPS_ONLINE_QUEUE":
			case "MES_PMC_VEHICLE_SEQUENCE_QUEUE":
			case "MES_PMC_AVI_CHECK_QUEUE":
				if (!StringUtils.isEmpty(message)) {
					jmsMESTemplate.convertAndSend(queueName, message);
				}
				System.out.println(new java.util.Date());
				System.out.println(queueName);
				System.out.println(message);
				break;
			default:
				break;
			}

		}
	}
}
