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
import com.bluebirdme.mes.pmc.entity.VehicleModel;
import com.bluebirdme.mes.pmc.service.IVehicleModelService;
import com.google.gson.GsonBuilder;
import org.xdemo.superutil.thirdparty.gson.GsonTools;

/**
 * 车辆类型Controller
 * @author shallwe_wang
 * @Date 2017-8-9 11:07:43
 */
@Controller
@RequestMapping("/vehicleModel")
@Journal(name="车辆类型")
public class VehicleModelController extends BaseController {

	// 车辆类型页面
	final String index = "pmc/baseDate/vehicleModel";
	final String addOrEdit="pmc/baseDate/vehicleModelAddOrEdit";

	@Resource IVehicleModelService vehicleModelService;

	@Journal(name = "首页")
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return index;
	}
	
	@NoAuth
	@ResponseBody
	@Journal(name="获取车辆类型列表信息")
	@RequestMapping("list")
	public String getVehicleModel(Filter filter, Page page) throws Exception{
		return GsonTools.toJson(vehicleModelService.findPageInfo(filter, page));
	}
	

	@Journal(name="添加车辆类型页面")
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView _add(VehicleModel vehicleModel){
		return new ModelAndView(addOrEdit,model.addAttribute("vehicleModel", vehicleModel));
	}
	
	@ResponseBody
	@Journal(name="保存车辆类型",logType=LogType.DB)
	@RequestMapping(value="add",method=RequestMethod.POST)
	@Valid
	public String add(VehicleModel vehicleModel) throws Exception{
		vehicleModelService.save(vehicleModel);
		return GsonTools.toJson(vehicleModel);
	}
	
	@Journal(name="编辑车辆类型页面")
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView _edit(VehicleModel vehicleModel){
		vehicleModel=vehicleModelService.findById(VehicleModel.class, vehicleModel.getId());
		return new ModelAndView(addOrEdit, model.addAttribute("vehicleModel", vehicleModel));
	}
	
	@ResponseBody
	@Journal(name="编辑车辆类型",logType=LogType.DB)
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@Valid
	public String edit(VehicleModel vehicleModel) throws Exception{
		vehicleModelService.update(vehicleModel);
		return GsonTools.toJson(vehicleModel);
	}

	@ResponseBody
	@Journal(name="删除车辆类型",logType=LogType.DB)
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String edit(String ids) throws Exception{
		vehicleModelService.delete(VehicleModel.class,ids);
		return Constant.AJAX_SUCCESS;
	}

}