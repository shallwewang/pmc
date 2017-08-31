package com.bluebirdme.mes.pmc.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PTLSPSRESETDATATOPMC")
@XmlType(name = "PTLSPSRESETDATATOPMC",propOrder= {"serviceHeader","spsResetList"})
public class XmlSpsReset {
	@XmlElement(required = true, name = "SERVICEHEADER")
	private ServiceHeader serviceHeader;
	@XmlElement(required = true, name = "DATALIST")
	private List<SpsReset> spsResetList;
	public ServiceHeader getServiceHeader() {
		return serviceHeader;
	}

	public void setServiceHeader(ServiceHeader serviceHeader) {
		this.serviceHeader = serviceHeader;
	}

	public List<SpsReset> getSpsResetList() {
		return spsResetList;
	}

	public void setSpsResetList(List<SpsReset> spsResetList) {
		this.spsResetList = spsResetList;
	}

	
}
