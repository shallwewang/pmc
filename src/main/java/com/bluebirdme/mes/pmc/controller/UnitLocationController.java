/**
 * 上海浩亚机电股份有限公司
 * MES事业部
 * 2017 CopyRight
 */
package com.bluebirdme.mes.pmc.controller;

import com.bluebirdme.mes.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bluebirdme.mes.core.annotation.Journal;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.bluebirdme.mes.core.annotation.NoAuth;
import com.bluebirdme.mes.core.annotation.support.LogType;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.valid.annotations.Valid;
import com.bluebirdme.mes.core.constant.Constant;
import com.bluebirdme.mes.pmc.entity.UnitLocation;
import com.bluebirdme.mes.pmc.service.IUnitLocationService;
import org.xdemo.superutil.thirdparty.gson.GsonTools;

/**
 * 工位Controller
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:43
 */
@Controller
@RequestMapping("/unitLocation")
@Journal(name="工位")
public class UnitLocationController extends BaseController {

	// 工位页面
	final String index = "pmc/baseDate/unitLocation";
	final String addOrEdit="pmc/baseDate/unitLocationAddOrEdit";

	@Resource IUnitLocationService unitLocationService;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name="获取工位列表信息")
	@RequestMapping("list")
	public String getUnitLocation(Filter filter, Page page) throws Exception{
		return GsonTools.toJson(unitLocationService.findPageInfo(filter, page));
	}
	
	@NoAuth
	@Journal(name = "获取工位信息")
	@RequestMapping(value = "combotree")
	@ResponseBody
	public String combotree() {
		return GsonTools.toJson(unitLocationService.combotree());
	}
	
	@NoAuth
	@Journal(name = "筛选产线信息")
	@RequestMapping(value = "tree")
	@ResponseBody
	public String tree(String line,String workshop,String plant) {
		return GsonTools.toJson(unitLocationService.tree(line,workshop,plant));
	}

	@Journal(name="添加工位页面")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView _add(UnitLocation unitLocation){
		return new ModelAndView(addOrEdit,model.addAttribute("unitLocation", unitLocation));
	}
	
	@ResponseBody
	@Journal(name="保存工位",logType=LogType.DB)
	@RequestMapping(value="add",method=RequestMethod.POST)
	@Valid
	public String add(UnitLocation unitLocation) throws Exception{
		unitLocationService.save(unitLocation);
		return GsonTools.toJson(unitLocation);
	}
	
	@Journal(name="编辑工位页面")
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView _edit(UnitLocation unitLocation){
		unitLocation=unitLocationService.findById(UnitLocation.class, unitLocation.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("unitLocation", unitLocation));
	}
	
	@ResponseBody
	@Journal(name="编辑工位",logType=LogType.DB)
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@Valid
	public String edit(UnitLocation unitLocation) throws Exception{
		unitLocationService.update(unitLocation);
		return GsonTools.toJson(unitLocation);
	}

	@ResponseBody
	@Journal(name="删除工位",logType=LogType.DB)
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String edit(String ids) throws Exception{
		unitLocationService.delete(UnitLocation.class,ids);
		return Constant.AJAX_SUCCESS;
	}

}