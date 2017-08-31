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




import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xdemo.superutil.j2se.StringUtils;

import com.bluebirdme.mes.core.annotation.Journal;
import com.bluebirdme.mes.core.annotation.NoAuth;
import com.bluebirdme.mes.core.annotation.support.LogType;
import com.bluebirdme.mes.core.base.controller.BaseController;
import com.bluebirdme.mes.core.base.entity.Filter;
import com.bluebirdme.mes.core.base.entity.Page;
import com.bluebirdme.mes.core.exception.BusinessException;
import com.bluebirdme.mes.core.valid.annotations.Valid;
import com.bluebirdme.mes.core.constant.Constant;
import com.bluebirdme.mes.pmc.entity.MesPlan;
import com.bluebirdme.mes.pmc.service.IMesPlanService;
import com.google.gson.GsonBuilder;
import org.xdemo.superutil.thirdparty.gson.GsonTools;

/**
 * MES计划Controller
 * @author shallwe_wang
 * @Date 2017-8-8 20:32:46
 */
@Controller
@RequestMapping("/mesPlan")
@Journal(name="MES计划")
public class MesPlanController extends BaseController {

	// MES计划页面
	final String index = "pmc/MESMessage/mesPlan";
	final String addOrEdit="pmc/MESMessage/mesPlanAddOrEdit";

	@Resource IMesPlanService mesPlanService;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name="获取MES计划列表信息")
	@RequestMapping("list")
	public String getMesPlan(Filter filter, Page page) throws Exception{
		return GsonTools.toJson(mesPlanService.findPageInfo(filter, page));
	}
	

	@Journal(name="添加MES计划页面")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView _add(MesPlan mesPlan){
		return new ModelAndView(addOrEdit,model.addAttribute("mesPlan", mesPlan));
	}
	
	@ResponseBody
	@Journal(name="保存MES计划",logType=LogType.DB)
	@RequestMapping(value="add",method=RequestMethod.POST)
	@Valid
	public String add(MesPlan mesPlan) throws Exception{
		mesPlanService.save(mesPlan);
		return GsonTools.toJson(mesPlan);
	}
	
	@Journal(name="编辑MES计划页面")
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView _edit(MesPlan mesPlan){
		mesPlan=mesPlanService.findById(MesPlan.class, mesPlan.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("mesPlan", mesPlan));
	}
	
	@ResponseBody
	@Journal(name="编辑MES计划",logType=LogType.DB)
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@Valid
	public String edit(MesPlan mesPlan) throws Exception{
		mesPlanService.update(mesPlan);
		return GsonTools.toJson(mesPlan);
	}

	@ResponseBody
	@Journal(name="删除MES计划",logType=LogType.DB)
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String edit(String ids) throws Exception{
		mesPlanService.delete(MesPlan.class,ids);
		return Constant.AJAX_SUCCESS;
	}

}