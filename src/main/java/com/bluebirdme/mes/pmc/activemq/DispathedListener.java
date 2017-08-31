package com.bluebirdme.mes.pmc.activemq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.fasterxml.jackson.databind.JavaType;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.bluebirdme.mes.pmc.entity.SpsOnline;
import com.bluebirdme.mes.pmc.service.ISpsOnlineService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * 
 * @author shallwe_wang
 * 
 *         WCS 料车上线完成信号监听器
 * 
 */
@Component
public class DispathedListener implements MessageListener {

	private final ObjectMapper mapper = new ObjectMapper();
	@Resource
	MesSender mesSender;

	@Resource
	ISpsOnlineService spsOnlineService;

	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message message) {

		String dispathedMsg = "";
		try {
			dispathedMsg = ((TextMessage) message).getText();
		} catch (JMSException e) {
			dispathedMsg = "";
		}
		if (dispathedMsg.startsWith("[")) {
			@SuppressWarnings("unchecked")
			List<SpsOnline> spsOnlineList;
			try {
				
				
				JavaType type=mapper.getTypeFactory().constructParametricType(ArrayList.class, SpsOnline.class);  
				
				spsOnlineList = (List<SpsOnline>) mapper.readValue(
						dispathedMsg, type);
				
				if (spsOnlineList.size() > 0) {
					String spsOnlineMsg = JSON.toJSONString(spsOnlineList);
					mesSender.send("PMC_MES_SPS_ONLINE_QUEUE", spsOnlineMsg);

					Object[] spsOnlineArray = new Object[spsOnlineList
							.size()];
					spsOnlineList.toArray(spsOnlineArray);
					spsOnlineService.save(spsOnlineArray);
				}
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (dispathedMsg.startsWith("{")) {

			SpsOnline spsOnline;
			try {
				spsOnline = mapper.readValue(dispathedMsg,
						SpsOnline.class);
				String spsOnlineMsg = JSON.toJSONString(spsOnline);

				mesSender.send("PMC_MES_SPS_ONLINE_QUEUE", spsOnlineMsg);

				spsOnlineService.save(spsOnline);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}