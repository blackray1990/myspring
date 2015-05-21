<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = (String)session.getAttribute("contextPaths");
%>
<style>
	td {
		width: 70px;
	}
</style>
<script>
	function cleanCache(){
		alert("清除");
		$.ajax({
			   type: "POST",
			   url: "redis/cleancache.do",
			   data: "id=1",
			   success: function(msg){
			     alert( "Data clean: " + msg );
			   }
			});
	}
</script>
<body>
从redis中获取的数据：
	<table border="1" style>
		<tr><td>ID</td><td>${person.id }</td></tr>
		<tr><td>姓名</td><td>${person.name }</td></tr>
		<tr><td>电话</td><td>${person.phone }</td></tr>
		<tr><td>性别</td><td>${person.sex==1?"女":"男" }</td></tr>
		<tr><td>备注</td><td>${person.desc }</td></tr>
	</table>
	<input type="button" value="清除缓存" onclick="cleanCache()">
</body>
