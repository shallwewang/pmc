<%-- 上传页面，包括文件显示--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/uploadify/uploadify.css">
<script type="text/javascript" src="<%=basePath%>/resources/uploadify/jquery.uploadify.min.js"></script>
<style>
.file {
	color: blue;
	height: 16px;
	line-height: 16px;
	display: inline-block;
	font-size: 16px;
	margin: 0;
	padding: 0;
	width:150px;
	white-space:nowrap;overflow:hidden;text-overflow:ellipsis;
}

.file_remove {
	color: rgb(174, 171, 173);
	font-size: 12px;
}

.upload_file_list {
	border-bottom: 1px solid rgb(0, 0, 255);
	margin: 2px;
	padding: 2px;
	display: inline-block;
}

.upload_file_list a {
	text-decoration: none;
}


</style>
<script type="text/javascript">

	var icons={"jpg":"icon-jpg","bmp":"icon-bmp","txt":"icon-txt","zip":"icon-zip","doc":"icon-doc","docx":"icon-docx","xls":"icon-xls","xlsx":"icon-xlsx","ppt":"icon-ppt","pptx":"icon-pptx","gif":"icon-gif","rar":"icon-rar","text":"icon-text"};
    var fpath="<%=basePath%>";
	$(function() {
		$("#file_upload").uploadify({
			buttonText		: 	'选择文件',
			/* buttonImage		:	fpath+'resources/uploadify/upload_bg.png', */
			buttonClass		:	'',
			auto			:	true,
			height			: 	30,
			swf 			: 	fpath + 'resources/uploadify/uploadify.swf',
			uploader 		: 	fpath + '/file/upload',
			width 			:	120,
			fileObjName 	:	'file',
			fileTypeExts	:	'*.gif; *.jpg; *.png;*.zip;*.doc;*.doc;*.docx;*.xls;*.xlsx;*.ppt;*.pptx;*.bmp;*.txt;*.rar;*.zip;',
			fileSizeLimit	:	'100MB',
			formData		:	{path:"<%=request.getParameter("path")%>"},
			removeTimeout	:	1,
			onUploadSuccess : function(file, data, response) {
				data=JSON.parse(data);
				if (Tip.hasError(data)) {
					return;
				}
				$("#files").append("<span id=\"list_"+data.id+"\" class=\"upload_file_list\"><span class=\"icon-icon "+(icons[data.suffix]==null?'icon-file':icons[data.suffix])+"\"></span><a id=\"file_"+data.id+"\" onmouseout=\"closeTips()\" onmouseover=\"showTips("+data.id+",'"+data.fileName+"')\" class=\"file\" href=\"<%=basePath%>file/download?id="+data.id+"&md5="+data.md5+"\">"+data.fileName+"</a><a title=\"删除\" class=\"file_remove\" href=\"javascript:void(0)\" onclick=\"deleteFile("+data.id+",'"+data.md5+"')\">删</a></span>");
			}
		});
		list();
	});
	
	function list(){
		$.ajax({
			url:fpath+"file/list",
			type:"post",
			data:{path:"<%=request.getParameter("path")%>"},
			dataType:"json",
			success:function(data){
				if(Tip.hasError(data)){
					return;
				}
				for(var i=0;i<data.length;i++){
					$("#files").append("<span id=\"list_"+data[i].id+"\" class=\"upload_file_list\"><span class=\"icon-icon "+(icons[data[i].suffix]==null?'icon-file':icons[data[i].suffix])+"\"></span><a id=\"file_"+data[i].id+"\" onmouseout=\"closeTips()\" onmouseover=\"showTips("+data[i].id+",'"+data[i].fileName+"')\" class=\"file\" href=\"<%=basePath%>file/download?id="+data[i].id+"&md5="+data[i].md5+"\">"+data[i].fileName+"</a><a title=\"删除\" class=\"file_remove\" href=\"javascript:void(0)\" onclick=\"deleteFile("+data[i].id+",'"+data[i].md5+"')\">删</a></span>");
				}
			}
		});
	}
	
	var index=null;
	
	function showTips(id,name){
		index=layer.tips(name, '#file_'+id,{
		    tips: [1, 'rgb(0, 159, 149)'] //还可配置颜色
		});
	}
	function closeTips(){
		if(index!=null){
			layer.close(index);
		}
	}
	
	function deleteFile(id,md5){
		top.layer.confirm('确定删除?', {
			icon: 3,
			title:'警告',
			shade: 0.5,
		    btn: ['删除','取消'], //按钮
		}, function(index){//第一个按钮
			$.ajax({
				url : fpath + "file/delete",
				type : "POST",
				data:{id:id,md5:md5},
				dataType : "json",
				success : function(data) {
					if(Tip.hasError(data)){
						return;
					}
					Tip.success("删除成功");
					$("#list_"+id).remove();
				}
			});
			layer.close(index);
		});
	}
	
</script>

<div>
	<div id="files">
		
	</div>
	<hr style="border:none;">
	<input style="width:100px;" type="file" name="file_upload" id="file_upload" />
</div>
