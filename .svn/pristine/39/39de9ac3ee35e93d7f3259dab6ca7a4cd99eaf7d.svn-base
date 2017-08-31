<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
	String path = request.getContextPath();

	String site = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PMC管理系统</title>

<link rel="stylesheet" type="text/css" href="<%=site%>/resources/ui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=site%>/resources/ui/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=site%>/resources/themes/platform.css">
<link rel="stylesheet" type="text/css" href="<%=site%>/resources/ui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=site%>/resources/ui/themes/addition/addition-icon.css">

<script type="text/javascript" src="<%=site%>/resources/ui/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=site%>/resources/ui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=site%>/resources/ui/js/jquery.portal.js"></script>
<script type="text/javascript" src="<%=site%>/resources/ui/js/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=site%>/resources/ui/js/js.js"></script>
<script type="text/javascript" src="<%=site%>resources/uipack/ui.dialog.js"></script>
<script type="text/javascript" src="<%=site%>resources/ext/easyui.ext.js"></script>
<script type="text/javascript" src="<%=site%>resources/ext/jquery.ext.js"></script>
<script type="text/javascript" src="<%=site%>resources/uipack/ui.tip.js"></script>
<script type="text/javascript" src="<%=site%>resources/uipack/ui.loading.js"></script>
<script type="text/javascript" src="<%=site%>resources/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">

var UA = navigator.userAgent.toLowerCase();
var browerKernel = {
    isWebkit: function() {
        if (/webkit/i.test(UA)) return true;
        else return false;
    },
    isFirefox: function() {
        if (/firefox/i.test(UA)) return true;
        else return false;
	}
}

if(!browerKernel.isWebkit()){
	alert("您当前浏览器无法兼容本系统！\n推荐使用Google Chrome 浏览器！\n\n其它兼容浏览器：\n360浏览器极速模式\n搜狗高速浏览器3\n世界之窗极速版\n猎豹浏览器\nQQ浏览器\n其它浏览器请自测");
}

	var path="<%=site%>";
	var userId=${userId};
	//获取项目名称
	var projectName="${pageContext.request.contextPath}";
	$(document).ready(function(){
		projectName=projectName.substring(1);
		$("#projectName").html(projectName);
	});
	var loginPath="<%=site%>login";
	var path="<%=site%>";
	var tipLoading="<spring:message code="Tip.Loading" />";
	var tipSubmiting="<spring:message code="Tip.Submiting" />";
	var tipInfo="<spring:message code="Tip.Info" />";
	var tipYes="<spring:message code="Tip.Yes" />";
	var tipNo="<spring:message code="Tip.No" />";
	var tipLock="<spring:message code="Tip.Lock" />";
	var tipUnlock="<spring:message code="Tip.Unlock" />";
	var tipSuccess="<spring:message code="Tip.Success" />";
	var tipError="<spring:message code="Tip.Error" />";
	var tipConfirm="<spring:message code="Tip.Confirm" />";
	var tipSelectATreeNode="<spring:message code="Tip.SelectATreeNode" />";
	var tipSelectAtLeastOne="<spring:message code="Tip.SelectAtLeastOne" />";
	var tipSelectOnlyOne="<spring:message code="Tip.SelectOnlyOne" />";
	var buttonAddMore="<spring:message code="Button.AddMore" />";
	
</script>
</head>
<body class="easyui-layout" style="min-width:1029px;">
	<div data-options="region:'north',border:false" class="top">
		<div class="shousuo uparrow"></div>
		<div class="logo" style="width:290px;"></div>
		<div class="menu-block">
			<div class="top-menu" id="menu-top"></div>
		</div>
		<div class="clear"></div>
		<div class="top-info">
			<span class="fl">&nbsp;&nbsp;&nbsp;&nbsp;欢迎 [ <font style='color:red;font-size:13px;font-weight:bolder;'>${userName }</font> ] 登陆系统&nbsp;&nbsp;</span>
			<span class="fr">
				<span id="ctime" style="margin-right:20px;"></span>
				<span class="pwd-icon"><a href="javascript:void(0)" id="modifyPassword" target="_blank">修改密码</a></span>
				<span class="exit-icon"><a href="javascript:void(0)" id="loginOut" target="_blank">退出系统</a></span>
			</span>
		</div>
	</div>
	<div id="leftTitle" data-options="region:'west',split:true,title:'系统设置'" style="width:200px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true,border:false,onSelect:doSelect"></div>
	</div>
	<div data-options="region:'center',border:false" style="overflow:hidden">
		<div id="tt" class="easyui-tabs" fit="true">
			<div title="首页" style="padding:5px;">

			</div>
		</div>
	</div>

	<!-- TAB右键点击菜单 -->
	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
</body>
</html>
