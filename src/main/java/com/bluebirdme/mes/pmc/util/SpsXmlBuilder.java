package com.bluebirdme.mes.pmc.util;

import java.util.List;
import com.bluebirdme.mes.pmc.entity.ServiceHeader;
import com.bluebirdme.mes.pmc.entity.Sps;
import com.bluebirdme.mes.pmc.entity.XmlSps;

public class SpsXmlBuilder {

	public String toXmlString(List<Sps> spsList) {
		ServiceHeader header = new ServiceHeader();
		header.setSrcSystem("PMC");
		header.setDestination("PTL");
		header.setRequestId("");
		
		XmlSps xmlsps = new XmlSps();
		xmlsps.setServiceHeader(header);
		xmlsps.setSpsList(spsList);

		return JaxbUtil.convertToXml(xmlsps);
	}
}
