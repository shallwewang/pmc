package com.bluebirdme.mes.pmc.util;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Table;

import org.xdemo.superutil.j2se.PathUtils;
import org.xdemo.superutil.j2se.StringUtils;

import com.bluebirdme.mes.core.annotation.Desc;
import com.bluebirdme.mes.platform.entity.EasyMenu;

/**
 * 开发辅助类
 * 
 * @author Goofy
 * @Date 2016年4月7日 下午9:04:57
 */
public class DevHelper {

	/**
	 * 生成Controller,Service,Dao
	 * 
	 * @param entity
	 *            实体类Class
	 * @param author
	 *            作者
	 * @throws Exception 
	 */
	public static <T> void genCSD(Class<T> entity, String author) throws Exception {
		Desc desc = entity.getAnnotation(Desc.class);
		if(desc==null){
			throw new Exception("在类"+entity.getName()+"上找不到@Desc注解");
		}
		String table = desc.value();
		String clazz = entity.getName();
		String array[] = clazz.split("\\.");
		String basePackage = "";
		for (int i = 0; i < array.length; i++) {
			if (i > array.length - 3)
				break;
			basePackage += ((i == 0 ? "" : ".") + array[i]);
		}
		String controllerPackage = basePackage + ".controller";

		String entityName = array[array.length - 1];

		// 文件基本路径
		// 正确路径E:\workspace\bjzx\src\main\java\com\bluebirdme\mes\dailyFunction\controller
		// 获取到的路径E:/workspace/bjzx/target/classes/com/bluebirdme/mes/dailyFunction/controller/
		// 替换target/classes为src/main/java
		final String fileBasePath = PathUtils.getClassDrivePath(entity).replace("entity/", "").replace("target/test-classes/", "src/main/java").replace("target/classes", "src/main/java");
		
		// controller begin...............
		String controllerPath = fileBasePath + "controller/";
		String module=PathUtils.getClassDrivePath(entity).replace("/entity/", "");
		module=module.substring(module.lastIndexOf("/")+1);
		Map<String, String> controllerData = new HashMap<String, String>();
		controllerData.put("package", controllerPackage);
		controllerData.put("package2", entity.getName());
		controllerData.put("package3",basePackage+".service");
		controllerData.put("entity", entityName);
		controllerData.put("entity2", StringUtils.firstCharToLowerCase(entityName));
		controllerData.put("date", new Date().toLocaleString());
		controllerData.put("author", author);
		controllerData.put("table", table);
		controllerData.put("module", module);
		new File(controllerPath).mkdirs();
		Utils.generateToFile("controller.ftl", controllerPath + entityName + "Controller.java", controllerData);
		System.out.println("[成功]"+controllerPath + entityName + "Controller.java");
		// controller end.......................................

		// service begin>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Map<String, String> serviceData = new HashMap<String, String>();
		String servicePackage = basePackage + ".service";
		serviceData.put("package", servicePackage);
		serviceData.put("entity", entityName);
		serviceData.put("date", new Date().toLocaleString());
		serviceData.put("author", author);
		String servicePath = fileBasePath + "service/";
		new File(servicePath).mkdirs();
		Utils.generateToFile("service.ftl", servicePath + "I" + entityName + "Service.java", serviceData);
		System.out.println("[成功]"+servicePath + "I" + entityName + "Service.java");
		// service end<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		// service impl begin>>>>>>>>>>>>>>>>>>>>>>
		Map<String, String> serviceImplData = new HashMap<String, String>();
		String serviceImplPath = fileBasePath + "service/impl/";
		String serviceImplPackage = basePackage + ".service.impl";
		serviceImplData.put("package", serviceImplPackage);
		serviceImplData.put("package2", servicePackage);
		serviceImplData.put("package3", basePackage + ".dao");
		serviceImplData.put("date", new Date().toLocaleString());
		serviceImplData.put("entity", entityName);
		serviceImplData.put("entity2", StringUtils.firstCharToLowerCase(entityName));
		serviceImplData.put("author", author);
		new File(serviceImplPath).mkdirs();
		Utils.generateToFile("serviceImpl.ftl", serviceImplPath + entityName + "ServiceImpl.java", serviceImplData);
		System.out.println("[成功]"+serviceImplPath + entityName + "ServiceImpl.java");
		// service impl end<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		// Dao begin>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		String daoPath = fileBasePath + "dao/";
		Map<String, String> daoData = new HashMap<String, String>();
		String daoPackage = basePackage + ".dao";
		daoData.put("package", daoPackage);
		daoData.put("date", new Date().toLocaleString());
		daoData.put("entity", entityName);
		daoData.put("author", author);
		new File(daoPath).mkdirs();
		Utils.generateToFile("dao.ftl", daoPath + "I" + entityName + "Dao.java", daoData);
		System.out.println("[成功]"+daoPath + "I" + entityName + "Dao.java");
		// Dao end<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		// Dao impl begin>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		String daoImplPath = fileBasePath + "dao/impl/";
		Map<String, String> daoImplData = new HashMap<String, String>();
		String daoImplPackage = basePackage + ".dao.impl";
		daoImplData.put("package", daoImplPackage);
		daoImplData.put("package2", daoPackage);
		daoImplData.put("date", new Date().toLocaleString());
		daoImplData.put("entity", entityName);
		daoImplData.put("author", author);
		daoImplData.put("entity2", StringUtils.firstCharToLowerCase(entityName));
		new File(daoImplPath).mkdirs();
		Utils.generateToFile("daoImpl.ftl", daoImplPath + entityName + "DaoImpl.java", daoImplData);
		System.out.println("[成功]"+daoImplPath + entityName + "DaoImpl.java");
		// Dao impl end<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	}

	/**
	 * 生成JS和JSP
	 * 
	 * @param entity
	 * @param title
	 * @throws Exception 
	 */
	public static <T> void genJsJsp(Class<T> entity, String author) throws Exception {

		Desc desc = entity.getAnnotation(Desc.class);
		if(desc==null){
			throw new Exception("在类"+entity.getName()+"上找不到@Desc注解");
		}
		String table = desc.value();

		Field fields[] = entity.getDeclaredFields();
		Desc d = null;

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		Column column=null;
		for (Field f : fields) {
			map = new HashMap<String, String>();
			d = f.getAnnotation(Desc.class);
			
			column=f.getAnnotation(Column.class);
			if(column==null)continue;
			
			map.put("field", f.getName().toUpperCase());
			map.put("field2", f.getName());
			
			if(!column.nullable()){
				map.put("required", "true");
			}
			map.put("title", d.value());
			list.add(map);
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("table", table);
		data.put("entity", Utils.firstCharToLowerCase(entity.getSimpleName()));
		data.put("list", list);
		data.put("author",author);
		data.put("date",new Date().toLocaleString());

		// 正确路径E:\workspace\bjzx\src\main\java\com\bluebirdme\mes\dailyFunction\controller
		// 获取到的路径E:/workspace/bjzx/target/classes/com/bluebirdme/mes/dailyFunction/entity/
		// 替换target/classes为src/main/java
		String module=PathUtils.getClassDrivePath(entity).replace("/entity/", "");
		module=module.substring(module.lastIndexOf("/")+1);
		String fileBasePath = PathUtils.getClassPath().substring(1).replace("target/classes/", "").replace("target/test-classes/", "")+"src/main/webapp/pages/"+module+"/";
		new File(fileBasePath).mkdirs();
		Utils.generateToFile("jsp.ftl", fileBasePath+Utils.firstCharToLowerCase(entity.getSimpleName())+".jsp", data);
		System.out.println("[成功]"+fileBasePath+Utils.firstCharToLowerCase(entity.getSimpleName())+".jsp");
		//生产js.jsp
		Utils.generateToFile("js.jsp.ftl", fileBasePath+Utils.firstCharToLowerCase(entity.getSimpleName())+".js.jsp", data);
		System.out.println("[成功]"+fileBasePath+Utils.firstCharToLowerCase(entity.getSimpleName())+".js.jsp");
		//生成**AddOrEdit.jsp
		Utils.generateToFile("addOrEdit.jsp.ftl", fileBasePath+Utils.firstCharToLowerCase(entity.getSimpleName())+"AddOrEdit.jsp", data);
		System.out.println("[成功]"+fileBasePath+Utils.firstCharToLowerCase(entity.getSimpleName())+"AddOrEdit.jsp");
	}
	
	/**
	 * 生成SQL的XML配置文件
	 * 
	 * @param clazz 实体类Class
	 * @param author
	 *            作者
	 * @throws Exception 
	 */
	public static <T> void genSqlXml(Class<T> clazz, String author) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Desc desc = clazz.getAnnotation(Desc.class);
		if(desc==null){
			throw new Exception("在类"+clazz.getName()+"上找不到@Desc注解");
		}
		Map<String, String> map=new HashMap<String, String>();
		
		
		String Entity=clazz.getSimpleName();
		String entity=StringUtils.firstCharToLowerCase(Entity);
		String time=sdf.format(new Date());
		String name=desc.value();
		
		Table table=clazz.getAnnotation(Table.class);
		map.put("Entity", Entity);
		map.put("entity", entity);
		map.put("entity_table_name", table.name());
		map.put("time", time);
		map.put("author", author);
		map.put("name", name);
		String xml=PathUtils.getClassPath().substring(1).replace("target/classes/", "").replace("target/test-classes/", "")+"src/main/resources/SQLFiles/"+entity+".xml";
		Utils.generateToFile("sql.ftl", xml, map);
	}
	
	public static <T> void genAll(Class<T> entity, String author) throws Exception{
		genCSD(entity, author);
		genJsJsp(entity, author);
		genSqlXml(entity, author);
	}

}
