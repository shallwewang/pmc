package com.bluebirdme.mes.pmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "pmc_spsonline")
@Desc("大循环校验信息")
public class SpsOnline extends BaseEntity{
	
	@Column
	@JsonProperty("PLANTNO")
	@Desc("工厂")
	private String plantNo;
	
	@Column
	@Desc("物料单号")
	@JsonProperty("SHEETNO")
	private String sheetNo;
	
	@Column
	@Desc("VIN号")
	@JsonProperty("VIN")
	private String vin;

	@Column
	@Desc("上线时间")
	@JsonProperty("ONLINETIME")
	private String onlineTime;

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

	public String getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}

}
