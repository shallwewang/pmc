package com.bluebirdme.mes.pmc.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PMCSPSDATATOPTC")
@XmlType(name = "PMCSPSDATATOPTC",propOrder= {"serviceHeader","spsList"})
public class XmlSps {
	
	@XmlElement(required = true, name = "SERVICEHEADER")
	private ServiceHeader serviceHeader;
	
	@XmlElement(required = true, name = "DATALIST")
	private List<Sps> spsList;

	public List<Sps> getSpsList() {
		return spsList;
	}

	public void setSpsList(List<Sps> spsList) {
		this.spsList = spsList;
	}

	public ServiceHeader getServiceHeader() {
		return serviceHeader;
	}

	public void setServiceHeader(ServiceHeader serviceHeader) {
		this.serviceHeader = serviceHeader;
	}
	
	
}
