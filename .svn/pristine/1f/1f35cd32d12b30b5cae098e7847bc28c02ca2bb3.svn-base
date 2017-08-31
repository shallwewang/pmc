<!--
	作者:shallwe_wang
	日期:2017-7-20 9:30:02
	页面:过点触发信息JSP文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>过点触发信息</title>
  	<%@ include file="../../base/meta.jsp" %>
  	<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/layerDate/need/laydate.css">
    <script type="text/javascript" src="<%=basePath %>/resources/layerDate/laydate.js"></script>
	<%@ include file="triggerPoint.js.jsp" %>
	
  </head>

   <body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" style="overflow: auto;position: relative; height: 140px; width: 925px">
		<div id="toolbar">
			<jsp:include page="../../base/toolbar.jsp">
				<jsp:param value="add" name="ids"/>
				<jsp:param value="edit" name="ids"/>
				<jsp:param value="delete" name="ids"/>
				<jsp:param value="icon-add" name="icons"/>
				<jsp:param value="icon-edit" name="icons"/>
				<jsp:param value="icon-remove" name="icons"/>
				<jsp:param value="增加" name="names"/>
				<jsp:param value="编辑" name="names"/>
				<jsp:param value="删除" name="names"/>
				<jsp:param value="add()" name="funs"/>
				<jsp:param value="edit()" name="funs"/>
				<jsp:param value="doDelete()" name="funs"/>
			</jsp:include>
			<div style="border-top:1px solid #DDDDDD">
				<form action="#" id="triggerPointSearchForm">
					
					
					<label class="panel-title">搜索：</label>
					过点起始时间：<input type="text" name="filter[startDate]" id="startDate" value="" readonly="readonly" class="textbox laydate-icon">
					过点结束时间：<input type="text" name="filter[endDate]" id="endDate" value="" readonly="readonly" class="textbox laydate-icon">  
					
					
					
					<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" iconcls="icon-search" onclick="filter()">
						搜索
					</a>
				</form>
			</div>
		</div>
		<table id="dg" singleSelect="false" title="过点触发信息列表" class="easyui-datagrid"  url="${path}triggerPoint/list" toolbar="#toolbar" pagination="true" rownumbers="true" fitColumns="true" fit="true"
		data-options="onDblClickRow:dbClickEdit">
			<thead>
				<tr>
					<th field="ID" checkbox=true ></th>
					<th field="SCANTYPE" width="15" formatter="scanTypeFormatter">AVI扫描类型</th>
					<th field="TPS" width="15">车辆TPS码</th>
					<th field="MESSCANNO" width="15">车辆扫描工位</th>
					<th field="LINENO" width="15">产线</th>
					<th field="SCANTIME" width="15">过点时间</th>
					<th field="PLANTNO" width="15">工厂代码</th>
					<th field="WORKSHOPNO" width="15">车间代码</th>
					<th field="AVISCANNO" width="15">工控对应AVI扫描代码</th>
				</tr>
			</thead>
		</table>
	</div>
</body>