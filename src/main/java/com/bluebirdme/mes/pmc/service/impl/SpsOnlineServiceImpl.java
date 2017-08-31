 package com.bluebirdme.mes.pmc.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bluebirdme.mes.core.base.dao.IBaseDao;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.base.service.BaseServiceImpl;
import com.bluebirdme.mes.pmc.service.ISpsOnlineService;
import com.bluebirdme.mes.pmc.dao.ISpsOnlineDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-7-20 23:00:54
 */
@Service
@Transactional
public class SpsOnlineServiceImpl extends BaseServiceImpl implements ISpsOnlineService {
	
	@Resource ISpsOnlineDao sPSOnlineDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return sPSOnlineDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return sPSOnlineDao.findPageInfo(filter, page);
	}

}
