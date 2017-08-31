package com.bluebirdme.mes.pmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

import java.util.Date;

@Desc("工厂")
@Entity
@Table(name = "pmc_plant")
public class Plant extends BaseEntity {
	@Desc("工厂名称")
	@Column
	private String plantName;

	@Column
	@Desc("工厂代码")
	private String plantCode;

	@Column
	@Desc("工厂描述")
	private String descrition;
	
	@Column
	@Desc("修改时间")
	private Date changeTime;


	@Desc("创建时间")
	@Column
	private Date createTime;

	@Column
	@Desc("创建人")
	private Long createBy;

	@Column
	@Desc("修改人")
	private Long changeBy;
	@Desc("flag")
	@Column
	private String flag;
	
	@Desc("自由字段1")
	@Column
	private String desc1;
	
	@Desc("自由字段2")
	@Column
	private String desc2;
	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantCode() {
		return plantCode;
	}

	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(Long changeBy) {
		this.changeBy = changeBy;
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
