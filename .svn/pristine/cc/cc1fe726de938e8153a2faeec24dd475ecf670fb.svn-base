
package com.bluebirdme.mes.pmc.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bluebirdme.mes.core.base.dao.IBaseDao;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.base.service.BaseServiceImpl;
import com.bluebirdme.mes.pmc.service.IPartService;
import com.bluebirdme.mes.pmc.dao.IPartDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-7-21 10:18:59
 */
@Service
@Transactional
public class PartServiceImpl extends BaseServiceImpl implements IPartService {
	
	@Resource IPartDao partDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return partDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return partDao.findPageInfo(filter, page);
	}

}
