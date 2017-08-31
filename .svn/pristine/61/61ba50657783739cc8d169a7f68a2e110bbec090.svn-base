package com.bluebirdme.mes.pmc.activemq;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import com.alibaba.fastjson.JSON;
import com.bluebirdme.mes.pmc.entity.Part;
import com.bluebirdme.mes.pmc.entity.Sps;
import com.bluebirdme.mes.pmc.service.ISpsService;
import com.bluebirdme.mes.pmc.util.SpsXmlBuilder;
import com.google.gson.Gson;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

@Component
public class SpsListener implements MessageListener {

	@Resource
	PmcSender pmcSender;
	Gson gson = new Gson();
	@Resource
	ISpsService sPSService;

	// private SpsXmlBuilder spsXmlBuilder=new SpsXmlBuilder();
	// Gson gson=new Gson();
	@Override
	public void onMessage(Message message) {
		String msg = "";
		try {
			msg = ((TextMessage) message).getText();
			System.out.println(msg);
		} catch (JMSException e) {
			msg = "";
		}
		if (msg.startsWith("[")) {
			// 向PTL发送XML消息
			List<Sps> spsList = JSON.parseArray(msg, Sps.class);
			SpsXmlBuilder spsXmlBuilder = new SpsXmlBuilder();
			String ptlMsg = spsXmlBuilder.toXmlString(spsList);
			System.out.println(ptlMsg);
			try {
				pmcSender.send("PMC.PTL.SPS", ptlMsg);
			} catch (JmsException e) {
				e.printStackTrace();
			}
			// 向WCS发送GSON消息
			Gson gson = new Gson();
			String wcsMsg = gson.toJson(spsList);
			try {
				pmcSender.send("PMC.WCS.SPS", wcsMsg);
			} catch (JmsException e) {
				e.printStackTrace();
			}

			// 保存消息记录
			Object[] spsArray = new Sps[spsList.size()];
			//sPSService.save(spsArray);
			Object[] partArray = null;
			List<Part> partList = null;
			for (Sps sps : spsList) {
				if (sps.getParts() != null) {
					partList = sps.getParts();
					partArray=new Part[partList.size()];
					partList.toArray(partArray);
					
					sPSService.save(partArray);
					partList = null;
					partArray=null;
				}
			}
			partArray = null;
		} else if (msg.startsWith("{")) {
			Sps sps = JSON.parseObject(msg, Sps.class);
			// 向PTL发送XML消息
			List<Sps> spsList = new ArrayList<Sps>();
			spsList.add(sps);
			SpsXmlBuilder spsXmlBuilder = new SpsXmlBuilder();
			String ptlMsg = spsXmlBuilder.toXmlString(spsList);
			try {
				pmcSender.send("PMC.PTL.SPS", ptlMsg);
			} catch (JmsException e) {
				e.printStackTrace();
			}
			// 向WCS发送GSON消息
			Gson gson = new Gson();
			String wcsMsg = gson.toJson(spsList);
			try {
				pmcSender.send("PMC.WCS.SPS", wcsMsg);
			} catch (JmsException e) {
				e.printStackTrace();
			}
			// 保存消息记录
			sPSService.save(sps);
			List<Part> parts = sps.getParts();
			Object[] partArray=new Part[parts.size()];
			sPSService.save(parts.toArray(partArray));
		}

	}
}