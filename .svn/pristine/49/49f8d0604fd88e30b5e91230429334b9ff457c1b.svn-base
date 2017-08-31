 package com.bluebirdme.mes.pmc.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bluebirdme.mes.core.base.dao.IBaseDao;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.base.service.BaseServiceImpl;
import com.bluebirdme.mes.pmc.service.ITriggerPointService;
import com.bluebirdme.mes.pmc.dao.ITriggerPointDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-7-20 9:30:02
 */
@Service
@Transactional
public class TriggerPointServiceImpl extends BaseServiceImpl implements ITriggerPointService {
	
	@Resource ITriggerPointDao triggerPointDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return triggerPointDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return triggerPointDao.findPageInfo(filter, page);
	}

}
