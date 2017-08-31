<!--
	作者:shallwe_wang
	日期:2017-7-20 9:30:02
	页面:过点触发信息JS文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
//添加过点触发信息
var addUrl=path+"triggerPoint/add";
//编辑过点触发信息
var editUrl=path+"triggerPoint/edit";
var dialogWidth=450,dialogHeight=260;
//删除过点触发信息
var deleteUrl=path+"triggerPoint/delete";
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


var dbClickEdit=function(index,row){
	var wid = Dialog.open("编辑", dialogWidth, dialogHeight, editUrl+"?id="+row.ID, [ 
	    EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("triggerPointSearchForm", editUrl, function(data) {
			filter();
			Dialog.close(wid);
		})
	}), EasyUI.window.button("icon-cancel", "关闭", function() {
		Dialog.close(wid)
	}) ]);
}
//查询
function filter() {
	EasyUI.grid.search("dg","triggerPointSearchForm");
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
//添加过点触发信息
var add = function() {
	var wid = Dialog.open("添加", 380, 250,addUrl, [
		EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("triggerPointForm",addUrl, function(data){
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

//编辑过点触发信息
var edit = function(){
	var r=EasyUI.grid.getOnlyOneSelected("dg");
	var wid = Dialog.open("编辑", 380, 250, editUrl+"?id="+r.ID, [ 
	    EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("triggerPointForm", editUrl, function(data) {
			filter();
			Dialog.close(wid);
		})
	}), EasyUI.window.button("icon-cancel", "关闭", function() {
		Dialog.close(wid)
	}) ]);
}

//删除过点触发信息
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