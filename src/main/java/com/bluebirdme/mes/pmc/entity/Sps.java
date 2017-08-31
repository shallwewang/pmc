package com.bluebirdme.mes.pmc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.alibaba.fastjson.annotation.JSONField;
import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

@Desc("SPS随车料单")
@Entity
@Table(name = "pmc_sps_sheet")
/***
 * { "csnGa": "GA1000113149", "issuesTime": "20170721094947", "materialNo":
 * "6169SMAFD152000D", "partkitNo": "sxcs", "parts": [], "plantNo": "1600",
 * "product": "SV61", "scanTime": "20170721094947", "sheetNo":
 * "021600fx161114000", "sheetStatus": "2", "ulocNo": "CAG010A", "vin":
 * "LSKG4GC16GA237820", "workshopNo": "GA1" }
 * 
 * @author wang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SPS")
@XmlType(name = "sps", propOrder = { "plantNo", "workshopNo", "sheetNo", "sheetStatus", "vin", "csnGa", "product",
		"materialNo", "partkitNo", "scanTime", "issuesTime", "reqeustTime", "ulocNo","parts" })
public class Sps extends BaseEntity {
	@Column
	@Desc("工厂编号")
	@XmlElement(required = true, name = "PLANT_NO")
	@JSONField(name="plantNo")
	private String plantNo;

	@Column
	@XmlElement(required = true, name = "WORKSHOP_NO")
	@Desc("车间编号")
	@JSONField(name="workshopNo")
	private String workshopNo;

	@Column
	@XmlElement(required = true, name = "SHEET_NO")
	@Desc("sheet编号")
	@JSONField(name="sheetNo")
	private String sheetNo;

	@Column
	@XmlElement(required = true, name = "SHEET_STATUS")
	@Desc("SPS状态")
	@JSONField(name="sheetStatus")
	private String sheetStatus;

	@Column
	@XmlElement(required = true, name = "VIN")
	@Desc("VIN")
	@JSONField(name="vin")
	private String vin;

	@Column
	@XmlElement(required = true, name = "CSN_GA")
	@Desc("总装号")
	@JSONField(name="csnGa")
	private String csnGa;

	@Column
	@XmlElement(required = true, name = "PRODUCT")
	@Desc("产品编号")
	@JSONField(name="product")
	private String product;

	@Column
	@XmlElement(required = true, name = "MATERIAL_NO")
	@Desc("物料编号")
	@JSONField(name="materialNo")
	private String materialNo;

	@Column
	@XmlElement(required = true, name = "PARTKIT_NO")
	@Desc("工厂编号")
	@JSONField(name="partkitNo")
	private String partkitNo;

	@Column
	@XmlElement(required = true, name = "SCAN_TIME")
	@Desc("过点时间")
	@JSONField(name="scanTime")
	private String scanTime;

	@Column
	@XmlElement(required = true, name = "ISSUES_TIME")
	@Desc("发布时间")
	@JSONField(name="issuesTime")
	private String issuesTime;

	@Column
	@XmlElement(required = true, name = "REQEUST_TIME")
	@Desc("需求时间")
	@JSONField(name="reqTime")
	private String reqeustTime;
	
	@Column
	@XmlElement(required = true, name = "ULOCNO")
	@Desc("上线位置")
	@JSONField(name="ulocNo")
	private String ulocNo;

	@Transient
	@XmlElement(required = true, name = "PARTLIST")
	@Desc("零件清单")
	@JSONField(name="parts")
	private List<Part> parts;

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

	public String getSheetNo() {
		return sheetNo;
	}

	public void setSheetNo(String sheetNo) {
		this.sheetNo = sheetNo;
	}

	public String getSheetStatus() {
		return sheetStatus;
	}

	public void setSheetStatus(String sheetStatus) {
		this.sheetStatus = sheetStatus;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getCsnGa() {
		return csnGa;
	}

	public void setCsnGa(String csnGa) {
		this.csnGa = csnGa;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getPartkitNo() {
		return partkitNo;
	}

	public void setPartkitNo(String partkitNo) {
		this.partkitNo = partkitNo;
	}

	public String getScanTime() {
		return scanTime;
	}

	public void setScanTime(String scanTime) {
		this.scanTime = scanTime;
	}

	public String getIssuesTime() {
		return issuesTime;
	}

	public void setIssuesTime(String issuesTime) {
		this.issuesTime = issuesTime;
	}

	public String getReqeustTime() {
		return reqeustTime;
	}

	public void setReqeustTime(String reqeustTime) {
		this.reqeustTime = reqeustTime;
	}

	public String getUlocNo() {
		return ulocNo;
	}

	public void setUlocNo(String ulocNo) {
		this.ulocNo = ulocNo;
	}

}
