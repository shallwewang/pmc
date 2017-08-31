package com.bluebirdme.mes.pmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

@Entity
@Table(name = "pmc_trgrPot")
@Desc("过点触发信息")
public class TriggerPoint extends BaseEntity {
	@Column
	@Desc("AVI扫描类型")
	private String scanType;
	@Column
	@Desc("车辆TPS码")
	private String tps;
	@Column
	@Desc("车辆扫描工位")
	private String mesScanNo;
	@Column
	@Desc("产线")
	private String lineNo;
	@Column
	@Desc("过点时间")
	private String scanTime;
	@Column
	@Desc("工厂代码")
	private String plantNo;
	@Column
	@Desc("车间代码")
	private String workshopNo;
	@Column
	@Desc("工控对应AVI扫描代码")
	private String aviScanNo;

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getTps() {
		return tps;
	}

	public void setTps(String tps) {
		this.tps = tps;
	}

	public String getMesScanNo() {
		return mesScanNo;
	}

	public void setMesScanNo(String mesScanNo) {
		this.mesScanNo = mesScanNo;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public String getScanTime() {
		return scanTime;
	}

	public void setScanTime(String scanTime) {
		this.scanTime = scanTime;
	}

	public String getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(String plantNo) {
		this.plantNo = plantNo;
	}

	public String getWorkshopNo() {
		return workshopNo;
	}

	public void setWorkshopNo(String workshopNo) {
		this.workshopNo = workshopNo;
	}

	public String getAviScanNo() {
		return aviScanNo;
	}

	public void setAviScanNo(String aviScanNo) {
		this.aviScanNo = aviScanNo;
	}

}
