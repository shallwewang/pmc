<!--
	作者:shallwe_wang
	日期:2017-8-8 20:32:47
	页面:MES计划增加或修改页面
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
	<!--MES计划表单-->
	<form id="mesPlanForm" method="post" ajax="true" action="<%=basePath %>mesPlan/${empty mesPlan.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${mesPlan.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">TPS号:</td>
					<!--TPS号-->
					<td>
						<input type="text" id="tps" name="tps" value="${mesPlan.tps}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车辆VIN:</td>
					<!--车辆VIN-->
					<td>
						<input type="text" id="vin" name="vin" value="${mesPlan.vin}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">定单类型:</td>
					<!--定单类型-->
					<td>
						<input type="text" id="orderType" name="orderType" value="${mesPlan.orderType}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车型平台:</td>
					<!--车型平台-->
					<td>
						<input type="text" id="model" name="model" value="${mesPlan.model}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">排产日期:</td>
					<!--排产日期-->
					<td>
						<input type="text" id="date" name="date" value="${mesPlan.date}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">排产顺序:</td>
					<!--排产顺序-->
					<td>
						<input type="text" id="sequence" name="sequence" value="${mesPlan.sequence}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">上线产线:</td>
					<!--上线产线-->
					<td>
						<input type="text" id="lineNo" name="lineNo" value="${mesPlan.lineNo}" class="easyui-textbox"  >
					</td>
				</tr>
			
		</table>
	</form>
</div>