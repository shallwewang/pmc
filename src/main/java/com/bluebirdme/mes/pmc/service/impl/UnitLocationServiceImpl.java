/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bluebirdme.mes.core.base.dao.IBaseDao;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.base.service.BaseServiceImpl;
import com.bluebirdme.mes.pmc.service.IUnitLocationService;
import com.bluebirdme.mes.pmc.dao.IUnitLocationDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:43
 */
@Service
@Transactional
public class UnitLocationServiceImpl extends BaseServiceImpl implements IUnitLocationService {
	
	@Resource IUnitLocationDao unitLocationDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return unitLocationDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return unitLocationDao.findPageInfo(filter,page);
	}

	@Override
	public List<Map<String, Object>> combotree() {
		return null;
	}

	@Override
	public List<Map<String, Object>> tree(String line, String workshop,
			String plant) {
		return null;
	}

}
