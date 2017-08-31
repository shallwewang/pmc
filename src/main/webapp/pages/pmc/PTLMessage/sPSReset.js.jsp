<!--
	作者:shallwe_wang
	日期:2017-7-20 23:00:54
	页面:SPS复位信息JS文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
//添加SPS复位信息
var addUrl=path+"sPSReset/add";
//编辑SPS复位信息
var editUrl=path+"sPSReset/edit";
//删除SPS复位信息
var deleteUrl=path+"sPSReset/delete";

//查询
function filter() {
	EasyUI.grid.search("dg","sPSResetSearchForm");
}

//添加SPS复位信息
var add = function() {
	var wid = Dialog.open("添加", 380, 250,addUrl, [
		EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("sPSResetForm",addUrl, function(data){
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

//编辑SPS复位信息
var edit = function(){
	var r=EasyUI.grid.getOnlyOneSelected("dg");
	var wid = Dialog.open("编辑", 380, 250, editUrl+"?id="+r.ID, [ 
	    EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("sPSResetForm", editUrl, function(data) {
			filter();
			Dialog.close(wid);
		})
	}), EasyUI.window.button("icon-cancel", "关闭", function() {
		Dialog.close(wid)
	}) ]);
}

//删除SPS复位信息
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