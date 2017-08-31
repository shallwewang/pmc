package generator;

import com.alibaba.fastjson.JSON;
import com.bluebirdme.mes.pmc.entity.SpsReset;
import com.bluebirdme.mes.pmc.entity.ServiceHeader;
import com.bluebirdme.mes.pmc.entity.XmlSpsReset;
import com.bluebirdme.mes.pmc.util.*;

import java.util.*;

import javax.xml.bind.JAXBException;

public class XmlSpsResetTest {

	public static void main(String[] args) throws JAXBException {
		
		ServiceHeader header=new ServiceHeader();
		header.setSrcSystem("PTL");
		header.setDestination("PMC");
		header.setRequestId("");
		
		XmlSpsReset xmlsps = new XmlSpsReset();
		
		xmlsps.setServiceHeader(header);
		
		List<SpsReset> spsResetList = new ArrayList<>();

		
		SpsReset reset=new SpsReset();
		reset.setPlantNo("001");
		reset.setSheetNo("001");
		reset.setVin("000186");
		reset.setShipTime("20170808220312");
		
		spsResetList.add(reset);
		spsResetList.add(reset);
		
		xmlsps.setSpsResetList(spsResetList);
		String xmlString =JaxbUtil.convertToXml(xmlsps);
		XmlSpsReset xmlsps1=JaxbUtil.converyToJavaBean(xmlString, XmlSpsReset.class);
		System.out.println(JSON.toJSONString(xmlsps1.getSpsResetList()));
		 System.out.println(xmlString);
		;
	}

}
