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

import com.bluebirdme.mes.core.annotation.Journal;
import com.bluebirdme.mes.core.annotation.NoAuth;
import com.bluebirdme.mes.core.annotation.support.LogType;
import com.bluebirdme.mes.core.base.controller.BaseController;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.exception.BusinessException;
import com.bluebirdme.mes.core.valid.annotations.Valid;
import com.bluebirdme.mes.core.constant.Constant;
import com.bluebirdme.mes.pmc.entity.Workshop;
import com.bluebirdme.mes.pmc.service.IWorkshopService;
import com.google.gson.GsonBuilder;

import org.xdemo.superutil.thirdparty.gson.GsonTools;

/**
 * 车间Controller
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:42
 */
@Controller
@RequestMapping("/workshop")
@Journal(name="车间")
public class WorkshopController extends BaseController {

	// 车间页面
	final String index = "pmc/baseDate/workshop";
	final String addOrEdit="pmc/baseDate/workshopAddOrEdit";

	@Resource IWorkshopService workshopService;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name="获取车间列表信息")
	@RequestMapping("list")
	public String getWorkshop(Filter filter, Page page) throws Exception{
		return GsonTools.toJson(workshopService.findPageInfo(filter, page));
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name = "获取车间列表信息")
	@RequestMapping("combotree")
	public String combotree() {
		return GsonTools.toJson(workshopService.combotree());
	}
	
	@Journal(name = "筛选车间列表信息")
	@RequestMapping(value = "tree")
	@ResponseBody
	public String patternTree(String plant) {
		return GsonTools.toJson(workshopService.tree(plant));
	}
	
	@Journal(name="添加车间页面")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView _add(Workshop workshop){
		return new ModelAndView(addOrEdit,model.addAttribute("workshop", workshop));
	}
	
	@ResponseBody
	@Journal(name="保存车间",logType=LogType.DB)
	@RequestMapping(value="add",method=RequestMethod.POST)
	@Valid
	public String add(Workshop workshop) throws Exception{
		workshopService.save(workshop);
		return GsonTools.toJson(workshop);
	}
	
	@Journal(name="编辑车间页面")
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView _edit(Workshop workshop){
		workshop=workshopService.findById(Workshop.class, workshop.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("workshop", workshop));
	}
	
	@ResponseBody
	@Journal(name="编辑车间",logType=LogType.DB)
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@Valid
	public String edit(Workshop workshop) throws Exception{
		workshopService.update(workshop);
		return GsonTools.toJson(workshop);
	}

	@ResponseBody
	@Journal(name="删除车间",logType=LogType.DB)
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String edit(String ids) throws Exception{
		workshopService.delete(Workshop.class,ids);
		return Constant.AJAX_SUCCESS;
	}

}