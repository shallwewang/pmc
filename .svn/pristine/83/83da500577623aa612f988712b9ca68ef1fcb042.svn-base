<!--
	作者:shallwe_wang
	日期:2017-8-9 13:55:37
	页面:工厂JSP文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>工厂</title>
  	<%@ include file="../../base/meta.jsp" %>
	<%@ include file="plant.js.jsp" %>
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
				<form action="#" id="plantSearchForm">
					
					
					<label class="panel-title">搜索：</label>
					工厂名称：<input type="text" name="filter[plantName]" id="plantName" value="" like="true" class="easyui-textbox">
					工厂代码：<input type="text" name="filter[plantCode]" id="plantCode" value="" like="true" class="easyui-textbox">
					
					
					<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" iconcls="icon-search" onclick="filter()">
						搜索
					</a>
				</form>
			</div>
		</div>
		<table id="dg" singleSelect="false" title="工厂列表" class="easyui-datagrid"  url="${path}plant/list" toolbar="#toolbar" pagination="true" rownumbers="true" fitColumns="true" fit="true"  data-options="onDblClickRow:dbClickEdit">
			<thead>
				<tr>
					<th field="ID" checkbox=true ></th>
					<th field="PLANTNAME" sortable="true" width="15">工厂名称</th>
					<th field="PLANTCODE" sortable="true" width="15">工厂代码</th>
					<th field="DESCRITION" sortable="true" width="15">工厂描述</th>
					<th field="CHANGETIME" sortable="true" width="15">修改时间</th>
					<th field="CREATETIME" sortable="true" width="15">创建时间</th>
					<th field="CREATEBY" sortable="true" width="15">创建人</th>
					<th field="CHANGEBY" sortable="true" width="15">修改人</th>
				</tr>
			</thead>
		</table>
	</div>
</body>