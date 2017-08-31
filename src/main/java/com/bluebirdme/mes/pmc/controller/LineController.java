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
import com.bluebirdme.mes.pmc.entity.Line;
import com.bluebirdme.mes.pmc.service.ILineService;
import com.google.gson.GsonBuilder;

import org.xdemo.superutil.thirdparty.gson.GsonTools;

/**
 * 产线Controller
 * 
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:42
 */
@Controller
@RequestMapping("/line")
@Journal(name = "产线")
public class LineController extends BaseController {

	// 产线页面
	final String index = "pmc/baseDate/line";
	final String addOrEdit = "pmc/baseDate/lineAddOrEdit";

	@Resource
	ILineService lineService;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}

	@NoAuth
	@ResponseBody
	@Journal(name = "获取产线列表信息")
	@RequestMapping("list")
	public String getLine(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(lineService.findPageInfo(filter, page));
	}

	@NoAuth
	@ResponseBody
	@Journal(name = "获取产线列表信息for Combotree")
	@RequestMapping("combotree")
	public String combotree() {
		return GsonTools.toJson(lineService.combotree());
	}
	@NoAuth
	@Journal(name = "筛选产线信息")
	@RequestMapping(value = "tree")
	@ResponseBody
	public String patternTree(String workshop,String plant) {
		return GsonTools.toJson(lineService.tree(workshop,plant));
	}

	@Journal(name = "添加产线页面")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView _add(Line line) {
		return new ModelAndView(addOrEdit, model.addAttribute("line", line));
	}

	@ResponseBody
	@Journal(name = "保存产线", logType = LogType.DB)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@Valid
	public String add(Line line) throws Exception {
		lineService.save(line);
		return GsonTools.toJson(line);
	}

	@Journal(name = "编辑产线页面")
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView _edit(Line line) {
		line = lineService.findById(Line.class, line.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("line", line));
	}

	@ResponseBody
	@Journal(name = "编辑产线", logType = LogType.DB)
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Valid
	public String edit(Line line) throws Exception {
		lineService.update(line);
		return GsonTools.toJson(line);
	}

	@ResponseBody
	@Journal(name = "删除产线", logType = LogType.DB)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String edit(String ids) throws Exception {
		lineService.delete(Line.class, ids);
		return Constant.AJAX_SUCCESS;
	}

}