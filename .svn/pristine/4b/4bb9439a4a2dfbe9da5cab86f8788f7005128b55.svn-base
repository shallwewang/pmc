package com.bluebirdme.mes.pmc.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.bluebirdme.mes.core.annotation.Desc;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "srcSystem", "destination", "requestId"})
@Desc("ServiceHeader")
public class ServiceHeader {
	@XmlElement(required = true, name = "SRCSYSTEM",defaultValue="PMC")
	private String srcSystem;
	@XmlElement(required = true,name="DESTINATION",defaultValue="PTL")
	private String destination;
	@XmlElement(required = true,name="REQUESTID",defaultValue="")
	private String requestId;
	
	
	public String getSrcSystem() {
		return srcSystem;
	}

	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
