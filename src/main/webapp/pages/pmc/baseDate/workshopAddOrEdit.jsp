<!--
	作者:shallwe_wang
	日期:2017-8-9 11:07:42
	页面:车间增加或修改页面
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

</script>
<div>
	<!--车间表单-->
	<form id="workshopForm" method="post" ajax="true" action="<%=basePath %>workshop/${empty workshop.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${workshop.id}" />
		
		<table width="100%">
				<tr>
					<td class="title">车间名称:</td>
					<!--车间名称-->
					<td>
						<input type="text" id="workshopName" name="workshopName" style="width: 240px"
						 value="${workshop.workshopName}" required="true" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车间代码:</td>
					<!--车间代码-->
					<td>
						<input type="text" id="workshopCode" name="workshopCode" style="width: 240px"
						 value="${workshop.workshopCode}" required="true" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">车间描述:</td>
					<!--车间描述-->
					<td>
						<input type="text" id="descrition" name="descrition" value="${workshop.descrition}" 
						style="width: 240px" class="easyui-textbox"  >
					</td>
				</tr>
				
				<tr>
					<td class="title">工厂:</td>
					<!--工厂-->
					<td>
						<input type="text" id="plantId" class="easyui-combotree" required="true" name="plantId" value="${workshop.plantId}" 
						style="width: 240px"
						data-options="url:'<%=basePath %>plant/combotree',
									  panelHeight:'80', 
									  icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('clear');}}]"
						>
					</td>
				</tr>
			
		</table>
	</form>
</div>