<!--
	作者:shallwe_wang
	日期:2017-7-20 23:00:53
	页面:SPS随车料单JSP文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SPS随车料单</title>
  	<%@ include file="../../base/meta.jsp" %>
	<%@ include file="sPS.js.jsp" %>
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
				<form action="#" id="sPSSearchForm">
					
					
					<label class="panel-title">搜索：</label>
					<input type="text" name="filter[**]" like="true" class="easyui-textbox">
					
					
					
					<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" iconcls="icon-search" onclick="filter()">
						搜索
					</a>
				</form>
			</div>
		</div>
		<table id="dg" singleSelect="false" title="SPS随车料单列表" class="easyui-datagrid"  url="${path}sPS/list" toolbar="#toolbar" pagination="true" rownumbers="true" fitColumns="true" fit="true">
			<thead>
				<tr>
					<th field="ID" checkbox=true ></th>
					<th field="PLANTNO" width="15">工厂编号</th>
					<th field="WORKSHOPNO" width="15">车间编号</th>
					<th field="SHEETNO" width="15">sheet编号</th>
					<th field="SHEETSTATUS" width="15">SPS状态</th>
					<th field="VIN" width="15">VIN</th>
					<th field="CSNGA" width="15">总装号</th>
					<th field="PRODUCT" width="15">产品编号</th>
					<th field="MATERIALNO" width="15">物料编号</th>
					<th field="PARTKITNO" width="15">工厂编号</th>
					<th field="SCANTIME" width="15">过点时间</th>
					<th field="ISSUESTIME" width="15">发布时间</th>
					<th field="REQEUSTTIME" width="15">需求时间</th>
					<th field="ULOCNO" width="15">上线位置</th>
				</tr>
			</thead>
		</table>
	</div>
</body>