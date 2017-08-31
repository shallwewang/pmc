 
package com.bluebirdme.mes.pmc.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bluebirdme.mes.core.base.dao.BaseDaoImpl;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import org.springframework.stereotype.Repository;
import com.bluebirdme.mes.pmc.dao.ISpsDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2016年4月5日 下午4:35:34
 */
@Repository
public class SpsDaoImpl extends BaseDaoImpl implements ISpsDao {
	
	@Resource SessionFactory factory;

	@Override
	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return findPageInfo(filter, page, "spsPublish-list");
		}

}
