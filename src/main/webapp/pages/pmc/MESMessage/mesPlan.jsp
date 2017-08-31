<!--
	作者:shallwe_wang
	日期:2017-8-8 20:32:47
	页面:MES车身上线计划JSP文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>MES车身上线计划</title>
  	<%@ include file="../../base/meta.jsp" %>
	<%@ include file="mesPlan.js.jsp" %>
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
				<form action="#" id="mesPlanSearchForm">
					
					
					<label class="panel-title">搜索：</label>
					TPS号<input type="text" name="filter[tps]" like="true" class="easyui-textbox">
					<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" iconcls="icon-search" onclick="filter()">
						搜索
					</a>
				</form>
			</div>
		</div>
		<table id="dg" singleSelect="false" title="车身上线计划列表" class="easyui-datagrid"  url="${path}mesPlan/list" toolbar="#toolbar" pagination="true" rownumbers="true" fitColumns="true" fit="true"  data-options="onDblClickRow:dbClickEdit">
			<thead>
				<tr>
					<th field="ID" checkbox=true ></th>
					<th field="TPS" sortable="true" width="15">TPS号</th>
					<th field="VIN" sortable="true" width="15">车辆VIN</th>
					<th field="ORDERTYPE" sortable="true" width="15">定单类型</th>
					<th field="MODEL" sortable="true" width="15">车型平台</th>
					<th field="DATE" sortable="true" width="15">排产日期</th>
					<th field="SEQUENCE" sortable="true" width="15">排产顺序</th>
					<th field="LINENO" sortable="true" width="15">上线产线</th>
				</tr>
			</thead>
		</table>
	</div>
</body>