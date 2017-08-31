package com.bluebirdme.mes.pmc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

@Desc("工位")
@Entity
@Table(name = "pmc_uLocation")
public class UnitLocation extends BaseEntity {
	@Desc("工位名称")
	@Column
	private String uLocName;

	@Column
	@Desc("工位代码")
	private String uLocCode;

	@Column
	@Desc("工位描述")
	private String descrition;
	@Column
	@Desc("修改时间")
	private Date changeTime;

	@Column
	@Desc("工厂ID")
	private Long plantId;

	@Column
	@Desc("车间ID")
	private Long workshopId;

	@Desc("产线ID")
	@Column
	private Long lineId;

	
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
	
	public String getuLocName() {
		return uLocName;
	}

	public void setuLocName(String uLocName) {
		this.uLocName = uLocName;
	}

	public String getuLocCode() {
		return uLocCode;
	}

	public void setuLocCode(String uLocCode) {
		this.uLocCode = uLocCode;
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

	public Long getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
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
