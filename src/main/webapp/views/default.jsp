<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>系统登陆-</title>
</head>
<%@ include file="include.jsp" %>
<link rel="stylesheet" type="text/css" href="style/common.css"> 

<script>
	$(document).ready(function(){
		
		var username = $.cookie("userName");
		var password = $.cookie("password");
		if(username&&password){
			$("#userName").val(username);
			$("#password").val(password);
			$("#remdiv").append("<input type='hidden' name='auto' value='1'/>");
			$("#logon").submit();
		}
		
		var msg = $("#msg").val();
		if(msg=="failure"){
			$.messager.alert('提示','<br/> 登陆失败，用户名或密码错误！','info');    
		}
		//刷新验证码
		$(".kaptcha").click(function(){
			$(this).attr("src","kaptcha.jpg?"+Math.floor(Math.random()*100));
		});
		//登录
		$("#submitData").click(function(){
			if($("#rempass").is(":checked")){
				$.cookie("userName","hejinsheng",{expires:7});	//保存7天
				$.cookie("password","123456",{expires:7});
			}else{
				$.cookie("userName","");
				$.cookie("password","");
			}
			$("#logon").submit();
		});
	});
	
</script>

<body style="background-image: url('images/Desert.jpg');background-size:cover;">	<!-- cover为自动填充 -->
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
</html>