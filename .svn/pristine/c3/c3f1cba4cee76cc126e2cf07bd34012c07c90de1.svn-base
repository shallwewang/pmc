<!--
	作者:shallwe_wang
	日期:2017-7-20 23:00:53
	页面:大循环校验信息增加或修改页面
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
	<!--大循环校验信息表单-->
	<form id="aVICheckForm" method="post" ajax="true" action="<%=basePath %>aVICheck/${empty aVICheck.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${aVICheck.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">AVI数据类型:</td>
					<!--AVI数据类型-->
					<td>
						<input type="text" id="scanType" name="scanType" value="${aVICheck.scanType}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">TPS:</td>
					<!--TPS-->
					<td>
						<input type="text" id="tps" name="tps" value="${aVICheck.tps}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">扫描点编号:</td>
					<!--扫描点编号-->
					<td>
						<input type="text" id="mesScanNo" name="mesScanNo" value="${aVICheck.mesScanNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">是否改变当前车位置:</td>
					<!--是否改变当前车位置-->
					<td>
						<input type="text" id="positionFlg" name="positionFlg" value="${aVICheck.positionFlg}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">IMES处理结果:</td>
					<!--IMES处理结果-->
					<td>
						<input type="text" id="retMsg" name="retMsg" value="${aVICheck.retMsg}" class="textbox"  >
					</td>
				</tr>
			
		</table>
	</form>
</div>