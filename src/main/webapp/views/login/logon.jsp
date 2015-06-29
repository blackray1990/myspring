<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include.jsp" %>
<html>
<head>
<title>笔记管理系统</title>
</head>


<body class="easyui-layout">   
	
    <div id="north" data-options="region:'north'" style="overflow: hidden;height:120px;border-top: none;background-size:cover;background-image: url('images/header2.jpg')">
    	<div style="right: 20px;position: absolute;">欢迎你：${username } &nbsp;<a href="#" id="logout">退出登录</a></div>
    	<div style="margin-top: 10px;margin-left: 10px;width:75px;font-family: 黑体;">
    		<img src="images/cook_java.jpg" style="height: 100px;"><br/>
    	</div>
    </div>   
    <div data-options="region:'south'" style="height:auto;"><div align="center">BlackRay版权所有</div></div>      
    <div data-options="region:'west',title:'菜单项',split:false" style="width:200px;">
    	<ul id="tt" class="easyui-tree" data-options="url:'menu/loadmenu.do'"></ul>  
    </div>   
    <div data-options="region:'center'" style="padding:0px;background:#eee;">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true">   
		    <div id="tab0" title="主页" style="padding:20px;text-align: center;background-position: center;background-repeat: no-repeat;"><!-- background-image: url('images/lizhi.jpg'); -->
		        <font size="4" color="green">欢迎来到知识的海洋！ </font>
		    </div>  
		</div> 
		
    </div>   
</body> 

<script>
	seajs.use("<%=contextPath%>/scripts/login/logon",function(page){
		page.init();
	});
</script>
</html>