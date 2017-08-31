package generator;

import com.bluebirdme.mes.pmc.entity.Part;
import com.bluebirdme.mes.pmc.entity.Sps;
import com.bluebirdme.mes.pmc.entity.ServiceHeader;
import com.bluebirdme.mes.pmc.entity.XmlSps;
import com.bluebirdme.mes.pmc.util.*;
import java.util.*;

public class XmlTest {

	public static void main(String[] args) {
		
		ServiceHeader header=new ServiceHeader();
		header.setSrcSystem("PMC");
		header.setDestination("PTL");
		header.setRequestId("");
		
		XmlSps xmlsps = new XmlSps();
		
		xmlsps.setServiceHeader(header);
		
		List<Sps> spsList = new ArrayList<>();

		Sps sps = new Sps();
		sps.setPlantNo("");
		sps.setWorkshopNo("12");
		sps.setSheetNo("2160523NS01999");
		sps.setSheetStatus("发布");
		sps.setVin("231xxx");
		sps.setCsnGa("2");
		sps.setProduct("SV61");
		sps.setMaterialNo("VC01");
		sps.setPartkitNo("");
		sps.setScanTime("20170720161900");
		sps.setIssuesTime("20170720161900");
		sps.setReqeustTime("20170720161900");
		sps.setUlocNo("");
		List<Part> partList = new ArrayList<>();

		Part part = new Part();
		part.setPartNo("1");
		part.setPartNameC("1");
		part.setLayout("1");
		part.setLocNo("1");
		part.setUlocNo("1");
		part.setQty("1");
		
		partList.add(part);
		partList.add(part);
		
		sps.setParts(partList);
		
		spsList.add(sps);
		spsList.add(sps);
		xmlsps.setSpsList(spsList);
		 System.out.println(JaxbUtil.convertToXml(xmlsps));
		;
	}

}
