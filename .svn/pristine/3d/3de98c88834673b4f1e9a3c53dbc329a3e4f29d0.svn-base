<!--
	作者:shallwe_wang
	日期:2017-8-9 13:55:37
	页面:工厂增加或修改页面
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
	<!--工厂表单-->
	<form id="plantForm" method="post" ajax="true" action="<%=basePath %>plant/${empty plant.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${plant.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">工厂名称:</td>
					<!--工厂名称-->
					<td>
						<input type="text" id="plantName" name="plantName" value="${plant.plantName}"  required="true" class="easyui-textbox" style="width: 240px" >
					</td>
				</tr>
				<tr>
					<td class="title">工厂代码:</td>
					<!--工厂代码-->
					<td>
						<input type="text" id="plantCode" name="plantCode" value="${plant.plantCode}"  required="true" class="easyui-textbox" style="width: 240px" >
					</td>
				</tr>
				<tr>
					<td class="title">工厂描述:</td>
					<!--工厂描述-->
					<td>
						<input type="text" id="descrition" name="descrition" value="${plant.descrition}" class="easyui-textbox" style="width: 240px" >
					</td>
				</tr>
			
		</table>
	</form>
</div>