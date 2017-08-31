package com.bluebirdme.mes.pmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

//T+3 Plan lock brefore 2 hours
//the branch plan is not the final sorted sequence 
@Entity
@Table(name = "pmc_mesPlan")
@Desc("MES计划")
public class MesPlan extends BaseEntity {
	@Column
	@Desc("TPS号")
	@JSONField
	private String tps;
	
	@Column
	@Desc("车辆VIN")
	@JSONField
	private String vin;
	
	@Column
	@Desc("定单类型")
	@JSONField
	private String orderType;
	
	@Column
	@JSONField
	@Desc("车型平台")
	private String model;
	
	@Column
	@JSONField
	@Desc("排产日期")
	private String date;
	
	@Column
	@JSONField
	@Desc("排产顺序")
	private String sequence;
	
	@Column
	@JSONField
	@Desc("上线产线")
	private String lineNo;
	
	public String getTps() {
		return tps;
	}
	public void setTps(String tps) {
		this.tps = tps;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
}
