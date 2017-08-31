<!--
	作者:shallwe_wang
	日期:2017-8-9 11:07:43
	页面:车辆类型增加或修改页面
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
	<!--车辆类型表单-->
	<form id="vehicleModelForm" method="post" ajax="true" action="<%=basePath %>vehicleModel/${empty vehicleModel.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${vehicleModel.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">车辆类型:</td>
					<!--车辆类型-->
					<td>
						<input type="text" id="modelName" name="modelName" value="${vehicleModel.modelName}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车辆类型代码:</td>
					<!--车辆类型代码-->
					<td>
						<input type="text" id="modelCode" name="modelCode" value="${vehicleModel.modelCode}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">描述:</td>
					<!--描述-->
					<td>
						<input type="text" id="descrition" name="descrition" value="${vehicleModel.descrition}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">修改时间:</td>
					<!--修改时间-->
					<td>
						<input type="text" id="changeTime" name="changeTime" value="${vehicleModel.changeTime}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">创建人:</td>
					<!--创建人-->
					<td>
						<input type="text" id="createBy" name="createBy" value="${vehicleModel.createBy}" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">创建时间:</td>
					<!--创建时间-->
					<td>
						<input type="text" id="createTime" name="createTime" value="${vehicleModel.createTime}" class="easyui-textbox"  >
					</td>
				</tr>
			
		</table>
	</form>
</div>