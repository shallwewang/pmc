/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.bluebirdme.mes.core.base.dao.BaseDaoImpl;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.sql.SQL;

import org.springframework.stereotype.Repository;

import com.bluebirdme.mes.pmc.dao.IWorkshopDao;

/**
 * 
 * @author shallwe_wang
 * @Date 2016年4月5日 下午4:35:34
 */
@Repository
public class WorkshopDaoImpl extends BaseDaoImpl implements IWorkshopDao {
	
	@Resource SessionFactory factory;

	@Override
	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public <T> Map<String, Object> findPageInfo(Filter filter, Page page) throws Exception {
		return this.findPageInfo(filter,page,"workshop-list");
	}

	@Override
	public List<Map<String, Object>> combotree() {
		String sql=SQL.get("workshop-combotree");
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	@Override
	public List<Map<String, Object>> tree( String plant) {
		Filter filter = new Filter();
		if (!StringUtils.isEmpty(plant))
			filter.set("plant", plant);
		try {
			SQLQuery query = getSession().createSQLQuery(
					SQL.get(filter.getFilter(), "workshop-tree"));
			Entry<String, String> entry = null;
			Iterator<Entry<String, String>> it = filter.getFilter().entrySet()
					.iterator();
			while (it.hasNext()) {
				entry = it.next();
				query.setParameter(entry.getKey(), entry.getValue());
			}
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			return query.list();
		} catch (Exception e) {
		}
		return new ArrayList<Map<String, Object>>();
	}
}
