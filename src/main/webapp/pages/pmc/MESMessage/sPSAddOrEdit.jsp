<!--
	作者:shallwe_wang
	日期:2017-7-20 23:00:53
	页面:SPS随车料单增加或修改页面
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
	<!--SPS随车料单表单-->
	<form id="sPSForm" method="post" ajax="true" action="<%=basePath %>sPS/${empty sPS.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${sPS.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">工厂编号:</td>
					<!--工厂编号-->
					<td>
						<input type="text" id="plantNo" name="plantNo" value="${sPS.plantNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车间编号:</td>
					<!--车间编号-->
					<td>
						<input type="text" id="workshopNo" name="workshopNo" value="${sPS.workshopNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">sheet编号:</td>
					<!--sheet编号-->
					<td>
						<input type="text" id="sheetNo" name="sheetNo" value="${sPS.sheetNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">SPS状态:</td>
					<!--SPS状态-->
					<td>
						<input type="text" id="sheetStatus" name="sheetStatus" value="${sPS.sheetStatus}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">VIN:</td>
					<!--VIN-->
					<td>
						<input type="text" id="vin" name="vin" value="${sPS.vin}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">总装号:</td>
					<!--总装号-->
					<td>
						<input type="text" id="csnGa" name="csnGa" value="${sPS.csnGa}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">产品编号:</td>
					<!--产品编号-->
					<td>
						<input type="text" id="product" name="product" value="${sPS.product}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">物料编号:</td>
					<!--物料编号-->
					<td>
						<input type="text" id="materialNo" name="materialNo" value="${sPS.materialNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">工厂编号:</td>
					<!--工厂编号-->
					<td>
						<input type="text" id="partkitNo" name="partkitNo" value="${sPS.partkitNo}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">过点时间:</td>
					<!--过点时间-->
					<td>
						<input type="text" id="scanTime" name="scanTime" value="${sPS.scanTime}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">发布时间:</td>
					<!--发布时间-->
					<td>
						<input type="text" id="issuesTime" name="issuesTime" value="${sPS.issuesTime}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">需求时间:</td>
					<!--需求时间-->
					<td>
						<input type="text" id="reqeustTime" name="reqeustTime" value="${sPS.reqeustTime}" class="textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">上线位置:</td>
					<!--上线位置-->
					<td>
						<input type="text" id="ulocNo" name="ulocNo" value="${sPS.ulocNo}" class="textbox"  >
					</td>
				</tr>
			
		</table>
	</form>
</div>