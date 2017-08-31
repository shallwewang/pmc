 package com.bluebirdme.mes.pmc.controller;

import com.alibaba.fastjson.JSON;
import com.bluebirdme.mes.core.base.controller.BaseController;

import org.apache.poi.ss.usermodel.DataFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluebirdme.mes.core.annotation.Journal;








import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.bluebirdme.mes.pmc.activemq.MesSender;
import com.bluebirdme.mes.pmc.entity.AviCheck;
import com.bluebirdme.mes.pmc.service.IAviCheckService;
import com.google.gson.GsonBuilder;

import org.xdemo.superutil.thirdparty.gson.GsonTools;

/**
 * 大循环校验信息Controller
 * @author shallwe_wang
 * @Date 2017-7-20 23:00:53
 */
@Controller
@RequestMapping("/aVICheck")
@Journal(name="大循环校验信息")
public class AviCheckController extends BaseController {

	// 大循环校验信息页面
	private final String index = "pmc/MESMessage/aVICheck";
	private final String addOrEdit="pmc/MESMessage/aVICheckAddOrEdit";
    private final DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Resource IAviCheckService aVICheckService;
	@Resource
	MesSender mesSender;
	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name="获取大循环校验信息列表信息")
	@RequestMapping("list")
	public String getAVICheck(Filter filter, Page page) throws Exception{
		return GsonTools.toJson(aVICheckService.findPageInfo(filter, page));
	}
	

	@Journal(name="添加大循环校验信息页面")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView _add(AviCheck aVICheck){
		return new ModelAndView(addOrEdit,model.addAttribute("aVICheck", aVICheck));
	}
	
	@ResponseBody
	@Journal(name="添加大循环校验信息",logType=LogType.DB)
	@RequestMapping(value="add",method=RequestMethod.POST)
	@Valid
	public String add(AviCheck aVICheck) throws Exception{
		aVICheck.setTime(dateFormat.format(new java.util.Date()));
		aVICheck.setSourceType("1");
		aVICheck.setAsyn("0");
		aVICheck.setFlag("1");
		try {
			//aVICheckService.save(aVICheck);
			mesSender.send("MES_PMC_AVI_CHECK_QUEUE", JSON.toJSONString(aVICheck));
		}catch(Exception e) {
			  return ajaxError(e.getMessage()); 
		}
		return Constant.AJAX_SUCCESS;
	}
	
	@Journal(name="编辑大循环校验信息页面")
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView _edit(AviCheck aVICheck){
		aVICheck=aVICheckService.findById(AviCheck.class, aVICheck.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("aVICheck", aVICheck));
	}
	
	@ResponseBody
	@Journal(name="编辑大循环校验信息",logType=LogType.DB)
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@Valid
	public String edit(AviCheck aVICheck) throws Exception{
		aVICheck.setTime(dateFormat.format(new java.util.Date()));
		aVICheck.setSourceType("1");
		aVICheck.setAsyn("0");
		aVICheck.setFlag("1");
		try{
			mesSender.send("MES_PMC_AVI_CHECK_QUEUE", JSON.toJSONString(aVICheck));
		}catch (Exception e){
			
		}
		return GsonTools.toJson(aVICheck);
	}

	@ResponseBody
	@Journal(name="删除大循环校验信息",logType=LogType.DB)
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String edit(String ids) throws Exception{
		aVICheckService.delete(AviCheck.class,ids);
		return Constant.AJAX_SUCCESS;
	}

}