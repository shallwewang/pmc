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
import com.bluebirdme.mes.pmc.entity.Part;
import com.bluebirdme.mes.pmc.service.IPartService;
import com.google.gson.GsonBuilder;
import org.xdemo.superutil.thirdparty.gson.GsonTools;

/**
 * 零件信息Controller
 * @author shallwe_wang
 * @Date 2017-7-21 10:18:59
 */
@Controller
@RequestMapping("/part")
@Journal(name="零件信息")
public class PartController extends BaseController {

	// 零件信息页面
	final String index = "pmc/baseDate/part";
	final String addOrEdit="pmc/baseDate/partAddOrEdit";

	@Resource IPartService partService;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name="获取零件信息列表信息")
	@RequestMapping("list")
	public String getPart(Filter filter, Page page) throws Exception{
		return GsonTools.toJson(partService.findPageInfo(filter, page));
	}
	

	@Journal(name="添加零件信息页面")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView _add(Part part){
		return new ModelAndView(addOrEdit,model.addAttribute("part", part));
	}
	
	@ResponseBody
	@Journal(name="添加零件信息",logType=LogType.DB)
	@RequestMapping(value="add",method=RequestMethod.POST)
	@Valid
	public String add(Part part) throws Exception{
		partService.save(part);
		return GsonTools.toJson(part);
	}
	
	@Journal(name="编辑零件信息页面")
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView _edit(Part part){
		part=partService.findById(Part.class, part.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("part", part));
	}
	
	@ResponseBody
	@Journal(name="编辑零件信息",logType=LogType.DB)
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@Valid
	public String edit(Part part) throws Exception{
		partService.update(part);
		return GsonTools.toJson(part);
	}

	@ResponseBody
	@Journal(name="删除零件信息",logType=LogType.DB)
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String edit(String ids) throws Exception{
		partService.delete(Part.class,ids);
		return Constant.AJAX_SUCCESS;
	}

}