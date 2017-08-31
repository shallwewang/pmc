package com.bluebirdme.mes.pmc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.bluebirdme.mes.pmc.activemq.MesSender;
import com.bluebirdme.mes.pmc.entity.TriggerPoint;
import com.bluebirdme.mes.pmc.service.ITriggerPointService;

import org.xdemo.superutil.thirdparty.gson.GsonTools;

import com.alibaba.fastjson.JSON;
/**
 * 过点触发信息Controller
 * 
 * @author shallwe_wang
 * @Date 2017-7-20 9:30:01
 */
@Controller
@RequestMapping("/triggerPoint")
@Journal(name = "过点触发信息")
public class TriggerPointController extends BaseController {

	// 过点触发信息页面
	final String index = "pmc/MESMessage/triggerPoint";
	final String addOrEdit = "pmc/MESMessage/triggerPointAddOrEdit";

	@Resource
	ITriggerPointService triggerPointService;
	@Resource
	MesSender mesSender;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}

	@NoAuth
	@ResponseBody
	@Journal(name = "获取过点触发信息列表信息")
	@RequestMapping("list")
	public String getTriggerPoint(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(triggerPointService.findPageInfo(filter, page));
	}

	@Journal(name = "添加过点触发信息页面")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView _add(TriggerPoint triggerPoint) {
		return new ModelAndView(addOrEdit, model.addAttribute("triggerPoint", triggerPoint));
	}

	@ResponseBody
	@Journal(name = "添加过点触发信息", logType = LogType.CONSOLE)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@Valid
	public String add(TriggerPoint triggerPoint) throws Exception {
		 DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 triggerPoint.setScanTime(formatter.format(new Date()));
		String msg = JSON.toJSONString(triggerPoint);
		try {
			mesSender.send("PMC_MES_AVI_QUEUE", msg);
			triggerPointService.save(triggerPoint);
		}catch(Exception e) {
			  return ajaxError(e.getMessage()); 
		}
		return Constant.AJAX_SUCCESS;
	}

	@Journal(name = "编辑过点触发信息页面")
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView _edit(TriggerPoint triggerPoint) {
		triggerPoint = triggerPointService.findById(TriggerPoint.class, triggerPoint.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("triggerPoint", triggerPoint));
	}

	@ResponseBody
	@Journal(name = "编辑过点触发信息", logType = LogType.DB)
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Valid
	public String edit(TriggerPoint triggerPoint) throws Exception {
		 DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		triggerPoint.setScanTime(formatter.format(new Date()));
		String msg = JSON.toJSONString(triggerPoint);
		
		try {
			mesSender.send("PMC_MES_AVI_QUEUE", msg);
			triggerPointService.update(triggerPoint);
		}catch(Exception e) {
			  return ajaxError(e.getMessage()); 
		}
		return GsonTools.toJson(triggerPoint);
	}

	@ResponseBody
	@Journal(name = "删除过点触发信息", logType = LogType.DB)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String edit(String ids) throws Exception {
		triggerPointService.delete(TriggerPoint.class, ids);
		return Constant.AJAX_SUCCESS;
	}

}