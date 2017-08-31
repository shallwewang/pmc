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

@Desc("零件信息")
@Entity
@Table(name = "pmc_part")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PART")
@XmlType(name = "PART", propOrder = { "partNo", "partNameC", "locNo", "layout", "ulocNo", "qty" })
public class Part extends BaseEntity {
	
	@Column
	@XmlElement(required = true,name="PART_NO")
	@Desc("零件编号")
	private String partNo;
	
	@Column
	@XmlElement(required = true,name="PART_NAME_C")
	@Desc("零件中文名称")
	private String partNameC;
	
	@Column
	@XmlElement(required = true,name="LOC_NO")
	@Desc("批次号")
	private String locNo;
	
	@Column
	@XmlElement(required = true,name="LAYOUT")
	@Desc("layout")
	private String layout;
	
	@Column
	@XmlElement(required = true,name="ULOC_NO")
	@Desc("位置")
	private String ulocNo;
	
	@Column
	@XmlElement(required = true,name="QTY")
	@Desc("数量")
	private String qty;

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPartNameC() {
		return partNameC;
	}

	public void setPartNameC(String partNameC) {
		this.partNameC = partNameC;
	}

	public String getLocNo() {
		return locNo;
	}

	public void setLocNo(String locNo) {
		this.locNo = locNo;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getUlocNo() {
		return ulocNo;
	}

	public void setUlocNo(String ulocNo) {
		this.ulocNo = ulocNo;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}
	
}
