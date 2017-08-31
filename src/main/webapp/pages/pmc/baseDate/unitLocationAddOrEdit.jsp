<!--
	作者:shallwe_wang
	日期:2017-8-9 11:07:43
	页面:工位增加或修改页面
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
var workshopUrl = path + 'workshop/tree';
var lineUrl = path + 'line/tree';
var plantValue;
var workshopValue;
$(function(){
	$("#plant").combotree({'onChange':function(newValue,oldValue){
		$.ajax({
			url : workshopUrl,
			type : "post",
			dataType : 'json',
			data : {
				"plant" : newValue
			},
			success : function(resp) {
				plantValue=newValue;
				$("#workshop").combotree('loadData', resp);
			}
		});
		
	}
   });
	
	$("#workshop").combotree({'onChange':function(newValue,oldValue){
		$.ajax({
			url : lineUrl,
			type : "post",
			dataType : 'json',
			data : {
				"workshop" : newValue,
				"plant" : plantValue
			},
			success : function(resp) {
				workshopValue=newValue;
				$("#line").combotree('loadData', resp);
			}
		});
		
	}
   });
 }
);
</script>
<div>
	<!--工位表单-->
	<form id="unitLocationForm" method="post" ajax="true" action="<%=basePath %>unitLocation/${empty unitLocation.id ?'add':'edit'}" autocomplete="off" >
		
		<input type="hidden" name="id" value="${unitLocation.id}" />
		
		<table  width="100%">
				<tr>
					<td class="title">工位名称:</td>
					<!--工位名称-->
					<td>
						<input type="text" id="uLocName" name="uLocName" value="${unitLocation.uLocName}" required="true" style="width: 240px" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">工位代码:</td>
					<!--工位代码-->
					<td>
						<input type="text" id="uLocCode" name="uLocCode" value="${unitLocation.uLocCode}" required="true" style="width: 240px"  class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">工位描述:</td>
					<!--工位描述-->
					<td>
						<input type="text" id="descrition" name="descrition" value="${unitLocation.descrition}" style="width: 240px" class="easyui-textbox"  >
					</td>
				</tr>
				<tr>
					<td class="title">工厂:</td>
					<!--工厂-->
					<td>
						<input type="text" id="plant" class="easyui-combotree" required="true" name="plantId" value="${unitLocation.plantId}" 
						style="width: 240px"
						data-options="url:'<%=basePath %>plant/combotree',
									  panelHeight:'80', 
									  icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('clear');}}]"
						>
					</td>
				</tr>
				<tr>
					<td class="title">车间:</td>
					<!--车间-->
					<td>
						<input type="text" id="workshop" class="easyui-combotree" required="true" name="workshopId" value="${unitLocation.workshopId}" 
						style="width: 240px"
						data-options="url:'<%=basePath %>workshop/combotree',
									  panelHeight:'80', 
									  icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('clear');}}]"
						>
					</td>
				</tr>
				<tr>
					<td class="title">产线:</td>
					<td>
						<input type="text" id="line" class="easyui-combotree" required="true" name="lineId" value="${unitLocation.lineId}" 
						style="width: 240px"
						data-options="url:'<%=basePath %>line/combotree',
									  panelHeight:'80', 
									  icons: [{iconCls:'icon-clear',handler: function(e){$(e.data.target).textbox('clear');}}]"
						>
					</td>
				</tr>
		</table>
	</form>
</div>