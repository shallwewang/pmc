<!--
	作者:shallwe_wang
	日期:2017-7-20 9:30:02
	页面:过点触发信息增加或修改页面
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
	<!--过点触发信息表单-->
	<form id="triggerPointForm" method="post" ajax="true" action="<%=basePath %>triggerPoint/${empty triggerPoint.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${triggerPoint.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">AVI扫描类型:</td>
					<!--AVI扫描类型-->
					<td>
						<input type="text" name="scanType"  class="easyui-combotree" id="scanType" value="${empty triggerPoint.scanType? '0':triggerPoint.scanType}"
						 data-options="valueField:'id',textField:'text',panelHeight:'150',
							data:[{'id':'0','text':'正常过点','iconCls':'platform-bullet_blue'},
							{'id':'1','text':'SetOut','iconCls':'platform-bullet_blue'},
							{'id':'2','text':'Hold','iconCls':'platform-bullet_blue'},
							{'id':'3','text':'UnHold','iconCls':'platform-bullet_blue'}]"
							style="height:30px;"
							>
					</td>
				</tr>
				<tr>
					<td class="title">车辆TPS码:</td>
					<!--车辆TPS码-->
					<td>
						<input type="text" id="tps" name="tps" value="${empty triggerPoint.tps?'00000013':triggerPoint.tps}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车辆扫描工位:</td>
					<!--车辆扫描工位-->
					<td>
						<input type="text" id="mesScanNo" name="mesScanNo" value="${empty triggerPoint.mesScanNo?'100':triggerPoint.mesScanNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">产线:</td>
					<!--产线-->
					<td>
						<input type="text" id="lineNo" name="lineNo" value="${empty triggerPoint.lineNo?'A':triggerPoint.lineNo}" class="textbox"  >
					</td>
				</tr>
				
				<tr>
					<td class="title">工厂代码:</td>
					<!--工厂代码-->
					<td>
						<input type="text" id="plantNo" name="plantNo" value="${empty triggerPoint.plantNo ?'2001':triggerPoint.plantNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车间代码:</td>
					<!--车间代码-->
					<td>
						<input type="text" id="workshopNo" name="workshopNo" value="${empty triggerPoint.workshopNo?'GA':triggerPoint.workshopNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">工控对应AVI扫描代码:</td>
					<!--工控对应AVI扫描代码-->
					<td>
						<input type="text" id="aviScanNo" name="aviScanNo" value="${empty triggerPoint.aviScanNo?'100':triggerPoint.aviScanNo}" class="textbox"  >
					</td>
				</tr>
			
		</table>
	</form>
</div>