package com.bluebirdme.mes.pmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

@Entity
@Table(name = "pmc_spsrst")
@Desc("大循环校验信息")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SPSRESET")
@XmlType(name = "SPSRESET", propOrder = { "plantNo", "sheetNo", "vin", "shipTime" })
public class SpsReset extends BaseEntity {
	@Column
	@Desc("工厂")
	@XmlElement(required = true,name="PART_NO")
	private String plantNo;
	
	@Column
	@Desc("物料单号")
	@XmlElement(required = true,name="SHEET_NO")
	private String sheetNo;
	
	@Column
	@XmlElement(required = true,name="VIN")
	@Desc("VIN号")
	private String vin;

	@Column
	@XmlElement(required = true,name="SHIP_TIME")
	@Desc("拣配时间")
	private String shipTime;

	public String getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(String plantNo) {
		this.plantNo = plantNo;
	}

	public String getSheetNo() {
		return sheetNo;
	}

	public void setSheetNo(String sheetNo) {
		this.sheetNo = sheetNo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getShipTime() {
		return shipTime;
	}

	public void setShipTime(String shipTime) {
		this.shipTime = shipTime;
	}
	
}
