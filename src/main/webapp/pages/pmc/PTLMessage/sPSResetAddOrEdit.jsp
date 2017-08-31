<!--
	作者:shallwe_wang
	日期:2017-7-20 23:00:54
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
	<form id="sPSResetForm" method="post" ajax="true" action="<%=basePath %>sPSReset/${empty sPSReset.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${sPSReset.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">工厂:</td>
					<!--工厂-->
					<td>
						<input type="text" id="plantNo" name="plantNo" value="${empty sPSReset.plantNo ?'1600':sPSReset.plantNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">物料单号:</td>
					<!--物料单号-->
					<td>
						<input type="text" id="sheetNo" name="sheetNo" value="${empty sPSReset.sheetNo ?'021600SPS170320191':sPSReset.sheetNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">VIN号:</td>
					<!--VIN号-->
					<td>
						<input type="text" id="vin" name="vin" value="${empty sPSReset.vin ?'LSKG5GC1XGA238126':sPSReset.vin}" class="textbox"  >
					</td>
				</tr>
			
		</table>
	</form>
</div>