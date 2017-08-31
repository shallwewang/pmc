/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.xdemo.superutil.j2se.MapUtils;

import com.bluebirdme.mes.core.base.dao.IBaseDao;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.base.service.BaseServiceImpl;
import com.bluebirdme.mes.core.sql.SQL;
import com.bluebirdme.mes.pmc.service.IPlantService;
import com.bluebirdme.mes.pmc.dao.IPlantDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:42
 */
@Service
@Transactional
public class PlantServiceImpl extends BaseServiceImpl implements IPlantService {
	
	@Resource IPlantDao plantDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return plantDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return plantDao.findPageInfo(filter,page);
	}

	@Override
	public List<Map<String, Object>>  combotree() {
		List<Map<String, Object>> listMap = plantDao.combotree();
		Map<String, Object> ret = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : listMap) {
			ret = new HashMap<String, Object>();
			ret.put("id", MapUtils.getAsString(map, "ID"));
			ret.put("text", MapUtils.getAsStringIgnoreCase(map, "PLANTNAME"));
			result.add(ret);
		}
		return result;
	}

}
