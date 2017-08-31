<!--
	作者:shallwe_wang
	日期:2017-8-9 11:07:43
	页面:工位JS文件
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
//添加工位
var addUrl=path+"unitLocation/add";
//编辑工位
var editUrl=path+"unitLocation/edit";
//删除工位
var deleteUrl=path+"unitLocation/delete";

var dialogWidth=430,dialogHeight=300;

//查询
function filter() {
	EasyUI.grid.search("dg","unitLocationSearchForm");
}

//添加工位
var add = function() {
	var wid = Dialog.open("添加", dialogWidth, dialogHeight,addUrl, [
		EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("unitLocationForm",addUrl, function(data){
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

//编辑工位
var edit = function(){
	var r=EasyUI.grid.getOnlyOneSelected("dg");
	var wid = Dialog.open("编辑", dialogWidth, dialogHeight, editUrl+"?id="+r.ID, [ 
	    EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("unitLocationForm", editUrl, function(data) {
			filter();
			Dialog.close(wid);
		})
	}), EasyUI.window.button("icon-cancel", "关闭", function() {
		Dialog.close(wid)
	}) ]);
}

/**
 * 双击行，弹出编辑
 */
var dbClickEdit=function(index,row){
	var wid = Dialog.open("编辑", dialogWidth, dialogHeight, editUrl+"?id="+row.ID, [ 
	    EasyUI.window.button("icon-save", "保存", function() {
		EasyUI.form.submit("unitLocationForm", editUrl, function(data) {
			filter();
			Dialog.close(wid);
		})
	}), EasyUI.window.button("icon-cancel", "关闭", function() {
		Dialog.close(wid)
	}) ]);
}

//删除工位
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

var ztree = null;
var setting ={
		data:{
			simpleData:{
				enable:true,
				idKey:"id",
				children:"children"
			},
			key:{
				name:"text"
			}
		
		}
		
};
$(document).ready(function(){
	$.ajax({
		url:path+"unitLocationTree/myULocationTreeList",
		type:"get",
		dataType:"json",
		success:function(data){
			if(Tip.hasError(data)){
				alert("cuowu");
				return;
			}
			ztree = ZTree.init("unitLocationTree",setting,data,true);
		}
	});
//$('#unitLocationTree').tree({
//	url:path+"unitLocationTree/myULocationTreeList"
//})
});
</script>