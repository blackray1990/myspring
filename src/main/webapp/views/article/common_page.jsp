<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include.jsp" %>
<html>
<style>
	.above {
		background:#F5F5F5;float:right;
    	position:fixed !important; top:10px;
    	position:absolute; z-index:300; top:expression(offsetParent.scrollTop+100);right:30px;
    	}
	.onoff{
		text-align:center; 
		background-color: #eaeaea;
		border: 1px solid black;
		cursor: pointer;
		width:40px;
	}
	.content {
		overflow: auto;
		background-color: #fafafa;
		margin-left: 20px;
		margin-right: 20px;
		border: 1px gray solid;
		min-height: 200px;
	}
</style>
<body>
	<div align="center" style="font-weight: bold;font-size: large;"><div id="showtitle"></div></div><br/>
	<div id="switch" class="above onoff">取消4</div>
	<div id="content" style="height:100%;"></div>
	

	<div style="margin-left: 20px;margin-top: 10px;" id="panel">
	标题：<input type="text" id="title" value="${article.title}" readonly="readonly"/>
		<textarea id="inputArea"  style="height:180px;width: 600px;" ></textarea>
		<a id="art-submit" href="#" class="easyui-linkbutton" data-options="size:'small'" style="width:70px;position: relative;top:-25px;left:65%">发布</a>
	</div>
		
	
</body>
<script>
//加载入口模块
	seajs.use("<%=contextPath%>/scripts/article/common_page",function(page){
		page.init({
			"id":"${article.id}",
			"title":"${article.title}",
			"content":"${article.content}"
			});
	});
</script>
</html>