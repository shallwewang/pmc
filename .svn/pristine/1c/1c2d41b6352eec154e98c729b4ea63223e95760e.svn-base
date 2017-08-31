<!--
	作者:shallwe_wang
	日期:2017-7-20 23:00:53
	页面:大循环校验信息JS文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
//添加大循环校验信息
var addUrl=path+"aVICheck/add";
//编辑大循环校验信息
var editUrl=path+"aVICheck/edit";
//删除大循环校验信息
var deleteUrl=path+"aVICheck/delete";

$(document).ready(function(){
	laydate({
	    elem: '#startDate',
	    event: 'focus',
	    format: 'YYYY-MM-DD hh:mm:ss',
	    istime: true
	});
	
	laydate({
	    elem: '#endDate',
	    event: 'focus',
	    format: 'YYYY-MM-DD hh:mm:ss',
	    istime: true
	});
	 
	
	 
});
//过滤查询
function filter() {
	var filterData = {
			"filter[tps]" : "like:" +$("#tpsFilter").val(),
			"filter[retMsg]" :  $("#retMsgFilter").combotree('getValue'),
			"filter[startDate]" : $("#startDate").val(),
			"filter[endDate]" :  $("#endDate").val()
		};
	
	$("#dg").datagrid("reload", filterData);
}

function scanTypeFormatter(val,row){
	switch (val){
	case "0":
		return '过点';
	case "1":
		return 'SetOut';
	case "2":
		return 'Hold';
	case "3":
		return 'UnHold';
		default:
			return val;
	}
}


function positionFlgFormatter(val,row){
	if (val == 0){
		return '否';
	} else {
		return '是';
	}
}

function retMsgFormatter(val,row){
	switch(val){
		case "A00":
			return "处理成功";
		case "C00":
			return "接口异常";
		case "C01":
			return "工艺路线检查失败";
		case "C02":
			return "车辆Hold工位失败";
		case "C04":
			return "AVI工位编码错误";
		case "C05":
			return "重复过点检查失败";
		case "S00":
			return "SetOut成功";
		case "S01":
			return "SetOut失败";
		case "H00":
			return "Hold成功";
		case "H01":
			return "Hold失败";
		case "U00":
			return "UnHold成功";
		case "U01":
			return "UnHold失败";
			default:
				return val;
	}
}
//添加大循环校验信息
var add = function() {
	var wid = Dialog.open("添加", 380, 300,addUrl, [
		EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("aVICheckForm",addUrl, function(data){
			filter();
			if(Dialog.isMore(wid)){
				Dialog.close(wid);
				add();
			}else{
				Dialog.close(wid);
			}
		})
	}), EasyUI.window.button("icon-cancel", "关闭", function() {
		Dialog.close(wid)
	}) ],function(){Dialog.more(wid);}
	);
}

//编辑大循环校验信息
var edit = function(){
	var r=EasyUI.grid.getOnlyOneSelected("dg");
	var wid = Dialog.open("编辑", 380, 300, editUrl+"?id="+r.ID, [ 
	    EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("aVICheckForm", editUrl, function(data) {
			filter();
			Dialog.close(wid);
		})
	}), EasyUI.window.button("icon-cancel", "关闭", function() {
		Dialog.close(wid)
	}) ]);
}

//删除大循环校验信息
var doDelete = function(){
	var r=EasyUI.grid.getSelections("dg");
	if(r.length == 0){
		Tip.warn("<spring:message code="Tip.SelectAtLeastOne" />");
		return;
	}
		
	var ids=[];
	for(var i=0;i<r.length;i++){
		ids.push(r[i].ID);
	}
	Dialog.confirm(function(){
		JQ.ajax(deleteUrl, "post", {
			ids : ids.toString()
		}, function(data){
			filter();
		});
	});
}
</script>