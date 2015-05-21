<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>笔记管理系统</title>
</head>
<%@ include file="../include.jsp" %>

<script>

</script>
<style>
	td {
		width:300px;
	}
	th {
		width:300px;
	}
</style>
<body style="text-align: center">   
<br>
通过spring自动切换数据源至ext扩展数据源：<br/><br/><br/>
	  <table class="easyui-datagrid" style="width:auto" data-options="singleSelect:true,left:'50px'">
		  <thead>
		  	<tr>
		  		<th data-options="field:'ln'">登录名</th>
		  		<th data-options="field:'lt'">登录时间</th>
		  		<th data-options="field:'ip'">登录IP地址</th>
		  		<th data-options="field:'remark'">详情</th>
		  	</tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${entityList }" var="entity">
		  		<tr>
		  			<td>${entity.loginName }</td>
		  			<td>${entity.lastLoginTime }</td>
		  			<td>${entity.ipAdd }</td>
		  			<td>${entity.remark }</td>
		  		</tr>
		  	</c:forEach>
		  </tbody>
	  </table>
</body> 
</html>