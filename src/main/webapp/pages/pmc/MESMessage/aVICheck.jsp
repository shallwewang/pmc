<!--
	作者:shallwe_wang
	日期:2017-7-20 23:00:53
	页面:大循环校验信息JSP文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>大循环校验信息</title>
  	<%@ include file="../../base/meta.jsp" %>
	<%@ include file="aVICheck.js.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/layerDate/need/laydate.css">
    <script type="text/javascript" src="<%=basePath %>/resources/layerDate/laydate.js"></script>
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
				<form action="#" id="aVICheckSearchForm">
					
					
					<label class="panel-title">搜索：</label>
					TPS:<input type="text" name="filter[tps]"  like="true" id="tpsFilter"  class="easyui-textbox">
					MES处理结果:<input type="text" name="filter[retMsg]"  class="easyui-combotree" id="retMsgFilter"  data-options="valueField:'id',textField:'text',panelHeight:'150',
					data:[{'id':'','text':'全部','iconCls':'platform-bullet_blue'},{'id':'A00','text':'处理成功','iconCls':'platform-bullet_blue'},{'id':'C00','text':'接口异常','iconCls':'platform-bullet_blue'},
					{'id':'C01','text':'工艺路线检查失败','iconCls':'platform-bullet_blue'},{'id':'C04','text':'AVI工位编码错误','iconCls':'platform-bullet_blue'},
					{'id':'C05','text':'重复过点检查失败','iconCls':'platform-bullet_blue'},{'id':'S00','text':'SetOut成功','iconCls':'platform-bullet_blue'},
					{'id':'S01','text':'SetOut失败','iconCls':'platform-bullet_blue'},{'id':'H00','text':'Hold成功','iconCls':'platform-bullet_blue'},
					{'id':'H01','text':'Hold失败','iconCls':'platform-bullet_blue'}]">
					过点起始时间：<input type="text" name="filter[startDate]" id="startDate" value="" readonly="readonly" class="textbox laydate-icon">
					过点结束时间：<input type="text" name="filter[endDate]" id="endDate" value="" readonly="readonly" class="textbox laydate-icon">  
					<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small" iconcls="icon-search" onclick="filter()">
						搜索
					</a>
				</form>
			</div>
		</div>
		<table id="dg" singleSelect="false" title="大循环校验信息列表" class="easyui-datagrid"  url="${path}aVICheck/list" toolbar="#toolbar" pagination="true" rownumbers="true" fitColumns="true" fit="true">
			<thead>
				<tr>
					<th field="ID" checkbox=true ></th>
					<th field="SCANTYPE" width="15" formatter='scanTypeFormatter'>AVI数据类型</th>
					<th field="TPS" width="15">TPS</th>
					<th field="MESSCANNO" width="15">扫描点编号</th>
					<th field="TIME" width="15">过点时间</th>
					<th field="SOURCETYPE" width="15">信息来源</th>
					<th field="ASYN" width="15">异步同步标记</th>
					<th field="POSITIONFLG" width="15" formatter='positionFlgFormatter'>是否改变当前车位置</th>
					<th field="RETMSG" width="15" formatter='retMsgFormatter'>IMES处理结果</th>
					<th field="FLAG" width="15">Flag</th>
				</tr>
			</thead>
		</table>
	</div>
</body>