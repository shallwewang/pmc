package com.bluebirdme.mes.pmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import com.alibaba.fastjson.annotation.JSONField;
import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.core.base.entity.BaseEntity;

@Entity
@Table(name = "pmc_avicheck")
@Desc("大循环校验信息")
public class AviCheck extends BaseEntity {
	@Column(columnDefinition="")
	@Desc("AVI数据类型")
	//0-扫描过点 1-setout
	@JSONField
	private String scanType;
	
	@Column
	@Desc("TPS")
	@JSONField
	private String tps;
	
	@Column
	@Desc("扫描点编号")
	@JSONField
	private String mesScanNo;
	
	@Column
	@Desc("过点时间")
	@JSONField
	private String time;
	
	@Column
	@Desc("信息来源")
	@JSONField
	//信息来源（默认为1）
	private String sourceType;

	@Column
	@Desc("异步同步标记")
	@JSONField
	//异步同步标记（ 默认为0）
	private String asyn;
	
	@Column
	@Desc("是否改变当前车位置")
	@JSONField
	//是否改变当前车位置（默认为0）
	private String positionFlg;
	
	
	@Column
	@Desc("IMES处理结果")
	@JSONField
	/**
	 * "RetMsg的返回值和意义：
	 * A00-处理成功
	 * C00-接口异常
	 * C01-工艺路线检查失败
	 * C04- AVI工位编码错误
	 * C05- 重复过点检查失败
	 * S00- SetOut成功
	 * S01- SetOut失败"
	 */
	private String retMsg;
	
	@Column
	@Desc("工厂编号")
	@JSONField
	private String flag;

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getAsyn() {
		return asyn;
	}

	public void setAsyn(String asyn) {
		this.asyn = asyn;
	}

	public String getPositionFlg() {
		return positionFlg;
	}

	public void setPositionFlg(String positionFlg) {
		this.positionFlg = positionFlg;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
