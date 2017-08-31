package com.bluebirdme.mes.pmc.activemq;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

import com.bluebirdme.mes.pmc.entity.AviCheck;
import com.bluebirdme.mes.pmc.service.IAviCheckService;
import com.alibaba.fastjson.JSON;

/**
 * 
 * @author shallwe_wang
 * <title>大循环检查监听器业务逻辑</title>
 * <ul>
 * <li>接受大循环检查消息，判段车辆过点情况</li>
 * <li>保存消息记录</li>
 * </ul>
 */
@Component
public class AviCheckListener implements MessageListener {
	@Resource
	IAviCheckService aviCheckService;

	@Override
	public void onMessage(Message message) {
		try {
			String msg = ((TextMessage) message).getText();
            System.out.println(msg);
			if (msg.startsWith("[")) {
				List<AviCheck> aviCheckList = JSON.parseArray(msg,
						AviCheck.class);
				Object[] AviChecks=new AviCheck[aviCheckList.size()];
				
				aviCheckService.save(aviCheckList.toArray(AviChecks));
			}else if(msg.startsWith("{")){
				 AviCheck  aviCheck  = JSON.parseObject(msg,
						AviCheck.class);
				aviCheckService.save(aviCheck);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}