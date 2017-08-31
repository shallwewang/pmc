/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bluebirdme.mes.core.base.dao.BaseDaoImpl;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;

import org.springframework.stereotype.Repository;

import com.bluebirdme.mes.pmc.dao.IUnitLocationDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2016年4月5日 下午4:35:34
 */
@Repository
public class UnitLocationDaoImpl extends BaseDaoImpl implements IUnitLocationDao {
	
	@Resource SessionFactory factory;

	@Override
	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return this.findPageInfo(filter,page,"unitLocation-list");
	}

	@Override
	public List<Map<String, Object>> combotree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> tree(String line, String workshop,
			String plant) {
		// TODO Auto-generated method stub
		return null;
	}

}
