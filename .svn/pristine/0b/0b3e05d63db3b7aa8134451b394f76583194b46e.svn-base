 package com.bluebirdme.mes.pmc.controller;

import com.bluebirdme.mes.core.base.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluebirdme.mes.core.annotation.Journal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.bluebirdme.mes.pmc.entity.SpsReset;
import com.bluebirdme.mes.pmc.service.ISpsResetService;
import com.google.gson.GsonBuilder;

import org.xdemo.superutil.thirdparty.gson.GsonTools;

import com.alibaba.fastjson.JSON;
/**
 * 大循环校验信息Controller
 * 
 * @author shallwe_wang
 * @Date 2017-7-20 23:00:54
 */
@Controller
@RequestMapping("/sPSReset")
@Journal(name = "大循环校验信息")
public class SpsResetController extends BaseController {

	// 大循环校验信息页面
	final String index = "pmc/PTLMessage/sPSReset";
	final String addOrEdit = "pmc/PTLMessage/sPSResetAddOrEdit";

	@Resource
	ISpsResetService sPSResetService;
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
	public String getSPSReset(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(sPSResetService.findPageInfo(filter, page));
	}

	@Journal(name = "添加大循环校验信息页面")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView _add(SpsReset sPSReset) {
		return new ModelAndView(addOrEdit, model.addAttribute("sPSReset", sPSReset));
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@Valid
	public String add(SpsReset sPSReset) throws Exception {
		DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sPSReset.setShipTime(formatter.format(new Date()));
		String msg = JSON.toJSONString(sPSReset);
		try {
			
		    mesSender.send("PMC_MES_SPS_RESET_QUEUE", msg);
			sPSResetService.save(sPSReset);
		} catch (Exception e) {
			return ajaxError(e.getMessage());
		}
		return Constant.AJAX_SUCCESS;
	}

	@Journal(name = "编辑大循环校验信息页面")
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView _edit(SpsReset sPSReset) {
		sPSReset = sPSResetService.findById(SpsReset.class, sPSReset.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("sPSReset", sPSReset));
	}

	@ResponseBody
	@Journal(name = "编辑大循环校验信息", logType = LogType.DB)
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Valid
	public String edit(SpsReset sPSReset) throws Exception {
		DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sPSReset.setShipTime(formatter.format(new Date()));
		String msg = JSON.toJSONString(sPSReset);
		try {
			
			 	mesSender.send("PMC_MES_SPS_RESET_QUEUE", msg);
			sPSResetService.update(sPSReset);
			} catch (Exception e) {
				return ajaxError(e.getMessage());
			}
			return Constant.AJAX_SUCCESS;
		
	}

	@ResponseBody
	@Journal(name = "删除大循环校验信息", logType = LogType.DB)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String edit(String ids) throws Exception {
		sPSResetService.delete(SpsReset.class, ids);
		return Constant.AJAX_SUCCESS;
	}

}