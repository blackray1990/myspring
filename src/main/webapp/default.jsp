<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>系统登陆</title>
</head>
<link rel="stylesheet" type="text/css" href="plugins/easyui-1.3.6/themes/gray/easyui.css">   
<link rel="stylesheet" type="text/css" href="plugins/easyui-1.3.6/themes/icon.css">   
<script type="text/javascript" src="plugins/easyui-1.3.6/jquery.min.js"></script>   
<script type="text/javascript" src="plugins/easyui-1.3.6/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="plugins/jquery.json-2.2.min.js"></script> 
<script>
	$(document).ready(function(){
		
		var msg = $("#msg").val();
		if(msg=="failure"){
			$.messager.alert('提示','<br/> 登陆失败，用户名或密码错误！','info');    
		}
	});
	
</script>
<style>
	.com-btn {
		color: black;
		background: linear-gradient(to bottom, #FFF 0px, #EEE 100%) repeat-x scroll 0% 0% transparent;
		border: 1px solid #BBB;
		border-radius: 5px;	<!--边框圆角-->
	}
</style>
<body style="background-image: url('images/Desert.jpg');background-size:cover;">	<!-- cover为自动填充 -->
<div align="center" style="margin-top: 200px;">
	<input type="hidden" id="msg" value="${msg}"/>	<!-- 取得ModelMap中的信息 -->
	
	<form id="logon" method="post" action="logonsys.do">
	<div id="p" class="easyui-panel" style="width:300px;padding:10px;"  title="系统登陆" data-options="collapsible:false" align="center">   
		<div>   
	        <label for="name">用户名:</label>   
	        <input class="easyui-validatebox" type="text" name="userName" data-options="required:false" />   
	    </div><br/>
	    <div>   
	        <label for="email">密&nbsp;&nbsp;码:</label>   
	        <input class="easyui-validatebox" type="password" name="password" data-options="required:false" />   
	    </div><br/>
	    <input class="com-btn" type="submit" value="提交" style="height:40px;width:80px;">
	</div> 
	</form>  
</div>
</body>
</html>