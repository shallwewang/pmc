<!--
	作者:shallwe_wang
	日期:2017-7-21 10:18:59
	页面:零件信息增加或修改页面
-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<style type="text/css">
	//CSS 代码
</style>
<script type="text/javascript">
	//JS代码
</script>
<div>
	<!--零件信息表单-->
	<form id="partForm" method="post" ajax="true" action="<%=basePath %>part/${empty part.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${part.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">零件编号:</td>
					<!--零件编号-->
					<td>
						<input type="text" id="partNo" name="partNo" value="${part.partNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">零件中文名称:</td>
					<!--零件中文名称-->
					<td>
						<input type="text" id="partNameC" name="partNameC" value="${part.partNameC}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">批次号:</td>
					<!--批次号-->
					<td>
						<input type="text" id="locNo" name="locNo" value="${part.locNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">layout:</td>
					<!--layout-->
					<td>
						<input type="text" id="layout" name="layout" value="${part.layout}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">位置:</td>
					<!--位置-->
					<td>
						<input type="text" id="ulocNo" name="ulocNo" value="${part.ulocNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">数量:</td>
					<!--数量-->
					<td>
						<input type="text" id="qty" name="qty" value="${part.qty}" class="textbox"  >
					</td>
				</tr>
			
		</table>
	</form>
</div>