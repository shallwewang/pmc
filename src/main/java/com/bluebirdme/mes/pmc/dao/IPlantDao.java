/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.dao;

import java.util.List;
import java.util.Map;

import com.bluebirdme.mes.core.base.dao.IBaseDao;

import org.springframework.stereotype.Repository;
/**
 * 
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:42
 */

public interface IPlantDao extends IBaseDao {
	List<Map<String, Object>> combotree();
}
