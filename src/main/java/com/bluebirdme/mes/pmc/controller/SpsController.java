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
import com.bluebirdme.mes.pmc.entity.Sps;
import com.bluebirdme.mes.pmc.service.ISpsService;
import org.xdemo.superutil.thirdparty.gson.GsonTools;
/**
 * SPS随车料单Controller
 * @author shallwe_wang
 * @Date 2017-7-20 23:00:53
 */
@Controller
@RequestMapping("/sPS")
@Journal(name="SPS随车料单")
public class SpsController extends BaseController {

	// SPS随车料单页面
	final String index = "pmc/MESMessage/sPS";
	final String addOrEdit="pmc/MESMessage/sPSAddOrEdit";

	@Resource ISpsService sPSService;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name="获取SPS随车料单列表信息")
	@RequestMapping("list")
	public String getSPS(Filter filter, Page page) throws Exception{
		return GsonTools.toJson(sPSService.findPageInfo(filter, page));
	}
	

	@Journal(name="添加SPS随车料单页面")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView _add(Sps sPS){
		return new ModelAndView(addOrEdit,model.addAttribute("sPS", sPS));
	}
	
	@ResponseBody
	@Journal(name="添加SPS随车料单",logType=LogType.DB)
	@RequestMapping(value="add",method=RequestMethod.POST)
	@Valid
	public String add(Sps sPS) throws Exception{
		sPSService.save(sPS);
		return GsonTools.toJson(sPS);
	}
	
	@Journal(name="编辑SPS随车料单页面")
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView _edit(Sps sPS){
		sPS=sPSService.findById(Sps.class, sPS.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("sPS", sPS));
	}
	
	@ResponseBody
	@Journal(name="编辑SPS随车料单",logType=LogType.DB)
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@Valid
	public String edit(Sps sPS) throws Exception{
		sPSService.update(sPS);
		return GsonTools.toJson(sPS);
	}

	@ResponseBody
	@Journal(name="删除SPS随车料单",logType=LogType.DB)
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String edit(String ids) throws Exception{
		sPSService.delete(Sps.class,ids);
		return Constant.AJAX_SUCCESS;
	}

}