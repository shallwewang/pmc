package com.bluebirdme.mes.pmc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

@Desc("车间")
@Entity
@Table(name="pmc_workshop")
public class Workshop extends BaseEntity {
	@Desc("车间名称")
	@Column
	private String workshopName;
	
	@Column
	@Desc("车间代码")
	private String workshopCode;
	
	@Column
	@Desc("车间描述")
	private String descrition;
	@Column
	@Desc("修改时间")
	private Date changeTime;
	
	@Column
	@Desc("工厂ID")
	private Long plantId;
	
	@Column
	@Desc("创建人")
	private Long createBy;
	
	
	@Desc("创建时间")
	@Column
	private Date createTime;

	@Desc("flag")
	@Column
	private String flag;
	
	@Desc("自由字段1")
	@Column
	private String desc1;
	
	@Desc("自由字段2")
	@Column
	private String desc2;
	public String getWorkshopName() {
		return workshopName;
	}


	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}


	public String getWorkshopCode() {
		return workshopCode;
	}


	public void setWorkshopCode(String workshopCode) {
		this.workshopCode = workshopCode;
	}


	public String getDescrition() {
		return descrition;
	}


	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}


	public Date getChangeTime() {
		return changeTime;
	}


	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}


	public Long getPlantId() {
		return plantId;
	}


	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}


	public Long getCreateBy() {
		return createBy;
	}


	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public String getDesc1() {
		return desc1;
	}


	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}


	public String getDesc2() {
		return desc2;
	}


	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}
}
