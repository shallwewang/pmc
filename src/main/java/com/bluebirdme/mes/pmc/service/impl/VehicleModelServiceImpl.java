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
import com.bluebirdme.mes.pmc.service.IVehicleModelService;
import com.bluebirdme.mes.pmc.dao.IVehicleModelDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:43
 */
@Service
@Transactional
public class VehicleModelServiceImpl extends BaseServiceImpl implements IVehicleModelService {
	
	@Resource IVehicleModelDao vehicleModelDao;
	
	@Override
	protected IBaseDao getBaseDao() {
		return vehicleModelDao;
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return vehicleModelDao.findPageInfo(filter,page);
	}

}
