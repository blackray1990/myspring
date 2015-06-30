<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="include.jsp" %>

<html>
<head>
	<title>系统登陆-view</title>
</head>



<link rel="stylesheet" type="text/css" href="style/common.css"> 

<body style="background-image: url('images/Desert.jpg');background-size:cover;" >	<!-- cover为自动填充 -->
tomcat8080端口
<div align="center" style="margin-top: 200px;">
	<input type="hidden" id="msg" value="${msg}"/>	<!-- 取得ModelMap中的信息 -->
	
	<form id="logon" method="post" action="logonsys.do">
	<div id="p" class="easyui-panel" style="width:300px;padding:10px;"  title="系统登陆" data-options="collapsible:false" align="left">   
		<div class="errorinfo">${errordtl }</div>
		<div>   
	        <label for="name">用户名:</label>   
	        <input class="easyui-validatebox" type="text" id="userName" name="userName" data-options="required:false" />   
	    </div><br/>
	    <div>   
	        <label for="email">密&nbsp;码:</label>   
	        <input class="easyui-validatebox" type="password" id="password" name="password" data-options="required:false" />   
	    </div><br/>
	    <div>   
	        <label for="email">验证码:</label>   
	        <input class="shorttext" type="text" name="kaptcha" />  
	        <img src="kaptcha.jpg" class="kaptcha" /> <br>
	    </div><br/>
	    <div id="remdiv"><input type="checkbox" id="rempass">7天内免登录</div>

	    <a href="#" class="easyui-linkbutton l-btn l-btn-large cuslarge" id="submitData">
	    	<span class="l-btn-left" style="padding-top: 3px;"><span class="l-btn-text">提交</span></span>
	    </a>
	</div> 
	</form>  
</div>
</body>

<script>
//加载入口模块
	seajs.use("<%=contextPath%>/scripts/default",function(page){
		page.init();
	});
</script>
</html>
