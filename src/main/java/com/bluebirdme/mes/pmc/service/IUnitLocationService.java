/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.service;

import java.util.List;
import java.util.Map;

import com.bluebirdme.mes.core.base.service.IBaseService;

/**
 * 
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:43
 */
public interface IUnitLocationService extends IBaseService {
List<Map<String, Object>> combotree();
	
List<Map<String, Object>> tree(String line,String workshop,String plant);
}
