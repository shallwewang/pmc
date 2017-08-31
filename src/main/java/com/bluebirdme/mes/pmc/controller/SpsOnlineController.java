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
import com.bluebirdme.mes.pmc.entity.SpsOnline;
import com.bluebirdme.mes.pmc.service.ISpsOnlineService;

import org.xdemo.superutil.thirdparty.gson.GsonTools;

import com.alibaba.fastjson.JSON;

/**
 * 大循环校验信息Controller
 * 
 * @author shallwe_wang
 * @Date 2017-7-20 23:00:53
 */
@Controller
@RequestMapping("/sPSOnline")
@Journal(name = "大循环校验信息")
public class SpsOnlineController extends BaseController {

	// 大循环校验信息页面
	final String index = "pmc/WCSMesage/sPSOnline";
	final String addOrEdit = "pmc/WCSMesage/sPSOnlineAddOrEdit";

	@Resource
	ISpsOnlineService sPSOnlineService;
	@Resource
	MesSender mesSender;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}

	@NoAuth
	@ResponseBody
	@Journal(name = "获取大循环校验信息列表信息")
	@RequestMapping("list")
	public String getSPSOnline(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(sPSOnlineService.findPageInfo(filter, page));
	}

	@Journal(name = "添加大循环校验信息页面")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView _add(SpsOnline sPSOnline) {
		return new ModelAndView(addOrEdit, model.addAttribute("sPSOnline",
				sPSOnline));
	}

	@ResponseBody
	@Journal(name = "添加大循环校验信息", logType = LogType.DB)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@Valid
	public String add(SpsOnline sPSOnline) throws Exception {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sPSOnline.setOnlineTime(formatter.format(new Date()));
		String msg = JSON.toJSONString(sPSOnline);
		try {

			mesSender.send("PMC_MES_SPS_ONLINE_QUEUE", msg);
			sPSOnlineService.save(sPSOnline);
		} catch (Exception e) {
			return ajaxError(e.getMessage());
		}
		return Constant.AJAX_SUCCESS;
	}

	@Journal(name = "编辑大循环校验信息页面")
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView _edit(SpsOnline sPSOnline) {
		sPSOnline = sPSOnlineService.findById(SpsOnline.class,
				sPSOnline.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("sPSOnline",
				sPSOnline));
	}

	@ResponseBody
	@Journal(name = "编辑大循环校验信息", logType = LogType.DB)
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Valid
	public String edit(SpsOnline sPSOnline) throws Exception {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sPSOnline.setOnlineTime(formatter.format(new Date()));
		String msg = JSON.toJSONString(sPSOnline);
		try {
			mesSender.send("PMC_MES_SPS_ONLINE_QUEUE", msg);
			sPSOnlineService.update(sPSOnline);
		} catch (Exception e) {
			return ajaxError(e.getMessage());
		}
		return Constant.AJAX_SUCCESS;
	}

	@ResponseBody
	@Journal(name = "删除大循环校验信息", logType = LogType.DB)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String edit(String ids) throws Exception {
		sPSOnlineService.delete(SpsOnline.class, ids);
		return Constant.AJAX_SUCCESS;
	}

}