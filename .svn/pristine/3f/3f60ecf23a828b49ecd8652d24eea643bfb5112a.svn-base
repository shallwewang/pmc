/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bluebirdme.mes.core.base.dao.IBaseDao;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.base.service.BaseServiceImpl;
import com.bluebirdme.mes.pmc.service.IMesPlanService;
import com.bluebirdme.mes.pmc.dao.IMesPlanDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-8-8 20:32:47
 */
@Service
@Transactional
public class MesPlanServiceImpl extends BaseServiceImpl implements IMesPlanService {
	
	@Resource IMesPlanDao mesPlanDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return mesPlanDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return mesPlanDao.findPageInfo(filter,page);
	}

}
