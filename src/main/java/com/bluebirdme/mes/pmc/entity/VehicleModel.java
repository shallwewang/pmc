package com.bluebirdme.mes.pmc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

@Desc("车辆类型")
@Entity
@Table(name = "pmc_model")
public class VehicleModel extends BaseEntity {

	@Desc("车辆类型")
	@Column
	private String modelName;

	@Column
	@Desc("车辆类型代码")
	private String modelCode;

	@Column
	@Desc("描述")
	private String descrition;
	@Column
	@Desc("修改时间")
	private Date changeTime;

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

	

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
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
