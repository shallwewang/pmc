package com.bluebirdme.mes.pmc.activemq;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.bluebirdme.mes.pmc.entity.SpsReset;
import com.bluebirdme.mes.pmc.entity.XmlSpsReset;
import com.bluebirdme.mes.pmc.service.ISpsResetService;
import com.bluebirdme.mes.pmc.util.JaxbUtil;

/**
 * 
 * @author shallwe_wang PTL发送给PMC的SPS Complete信号监听器
 * 
 * 
 */
@Component
public class SpsCompleteListener implements MessageListener {

	@Resource
	MesSender mesSender;

	@Resource
	ISpsResetService spsResetService;

	@Override
	public void onMessage(Message message) {
		String ptl_Pmc_SpsComplete_Msg = "";
		try {
			ptl_Pmc_SpsComplete_Msg = ((TextMessage) message).getText();
		} catch (JMSException e) {
			ptl_Pmc_SpsComplete_Msg = "";
		}

		XmlSpsReset xmlspsReset = null;
		try {

			xmlspsReset = JaxbUtil.converyToJavaBean(ptl_Pmc_SpsComplete_Msg,
					XmlSpsReset.class);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		try {
			if (null != xmlspsReset) {
				// Send message to MES
				List<SpsReset> spsResetList = xmlspsReset.getSpsResetList();
				String spsResetMsg = JSON.toJSONString(spsResetList);
				mesSender.send("PMC_MES_SPS_RESET_QUEUE", spsResetMsg);
				// Save the message detail
				Object[] spsResetArray = new SpsReset[spsResetList.size()];
				spsResetList.toArray(spsResetArray);
				spsResetService.save(spsResetArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}