<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/meta.jsp"%>
<%@ include file="base/jstl.jsp"%>
<!DOCTYPE html>  
<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>PMC管理系统</title>   
    <link rel="stylesheet" type="text/css" href="<%=basePath %>resources/css/style.css"> 

	<style type="text/css">
	    body{
	        background-image: url(resources/images/login.jpg);
	        background-repeat: no-repeat;
	        background-position: center -100px
	    }
	
	    .login-box{
	        width: 1003px;
	        margin:203px auto 0 auto;
	        padding: 120px 0 0 0 
	    }
	    .login-input{
	        width: 330px;
	        height: 200px;
	        margin-left:624px;
	    }
	     .login-input ul{
	
	     }
	    .inputstyle{
	        width:272px;
	        height: 34px;
	        border: 0;
	        margin-left:38px;
	        margin-top: 12px;
	        outline:none
	    }
	    .subbtn{
	        border: 0;
	        background: #7ec6de;
	        height: 31px;
	        border-radius: 5px; 
	        margin-top:24px;
	        margin-right: 10px;
	        font-family: "微软雅黑";
	        color:#fff;
	        outline:none;
	        cursor: pointer;
	    }
	</style>
	<script type="text/javascript">
	    // 禁止登录页内嵌
		if(self!=top){
			top.location.href="<%=basePath%>";
		}
		
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
		
	</script>
</head>
<body >
	<div class="login-box">
		<form action="<%=basePath%>login" method="post" autocomplete="off"  style="min-width:400px;">
		    <div class="login-input">
		       <ul>
		            <li><input autocomplete="off" type="text" class="inputstyle" name="loginName" value="administrator"/></li>
		            <li><input autocomplete="off" type="password" class="inputstyle" name="password" value="123456" style="margin-top:39px" /></li>
		            <li><input type="submit" class="subbtn fl" style="width:315px;" value="登录" />
		            <div style="padding: 20px; text-align: center;   color: red;">${error }</div>
					<!-- <input type="submit" class="subbtn fr" style="width:190px" value="点击进入系统配置平台"/></li> -->
					<div style="text-align: right;vertical-align: middle;height:50px;line-height: 50px;padding-right:10px;display: none;">
							<label style="vertical-align:middle; font-size:12px;">语言</label>
							<select name="language">
							<option value="zh_CN" selected="selected">中文</option>
							<option value="en_US">English</option>
							<option value="th_TH">ไทย</option>
						</select>
						</div>
		        </ul>
		    </div>
	     </form>
	</div>
</body>
</html>