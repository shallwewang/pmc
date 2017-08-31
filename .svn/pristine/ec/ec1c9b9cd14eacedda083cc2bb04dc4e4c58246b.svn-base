 package com.bluebirdme.mes.pmc.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bluebirdme.mes.core.base.dao.IBaseDao;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.base.service.BaseServiceImpl;
import com.bluebirdme.mes.pmc.service.ISpsResetService;
import com.bluebirdme.mes.pmc.dao.ISpsResetDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-7-20 23:00:54
 */
@Service
@Transactional
public class SpsResetServiceImpl extends BaseServiceImpl implements ISpsResetService {
	
	@Resource ISpsResetDao sPSResetDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return sPSResetDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return sPSResetDao.findPageInfo(filter, page);
	}

}
