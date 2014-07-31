<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<script>
$('#users').datagrid({
	toolbar: '#tb'
});
$(function(){

})

/**
 * 密码初始化
 */
function initPassword(option){
	var rows = $('#users').datagrid('getChecked');	//所有选中行
	if(rows==null){
		$.messager.alert("提示","请先选中一行");
		return ;
	}
	var userid = rows[0].id;	//id对应的是data-options中的field	第一选中行
	if(confirm("确认进行此操作？")){
		$.ajax({
			url:'user/initordelete.do',
			data:'id='+userid+"&option="+option,
			success:function(data){
				if(option=='init'){
					$.messager.alert("提示","密码初始化成功！");
				}
				if(option=='delete'){
					$.messager.alert("提示","用户已删除！");
					var tab = $('#tabs').tabs('getSelected');
					tab.panel('refresh','user/queryusers.do');	//刷新面板
				}
			}
		});
	}

}

//编辑对话框
function operateUser(option){
	$("#userreset").click();	//清空表单信息
	$('#infowindow').show();
	$('#infowindow').dialog({    
	    title: '编辑用户',         
	    cache: false,      
	    modal: true   
	});    
}

//保存新增或修改
function saveUserInfo(){
	var params = $("#userinfo").serialize();
	var temp = $("#musername").validatebox('isValid');
	if(!temp){
		$.messager.alert("提示","请正确填写！");
		return false;
	}
	$.ajax({
		url:'user/operation.do',
		data:params,
		success:function(data){
			$.messager.alert("提示","信息保存成功！");
			$("#infowindow").panel('destroy');	//销毁窗口 注：一定要销毁，否则会有多个相同的div
			var tab = $('#tabs').tabs('getSelected');
			tab.panel('refresh','user/queryusers.do');	//刷新面板
		}
	});
}
</script>
<style>
		.com-btn {
		color: black;
		background: linear-gradient(to bottom, #FFF 0px, #EEE 100%) repeat-x scroll 0% 0% transparent;
		border: 1px solid #BBB;
		border-radius: 0px;
		cursor: pointer;
		height:40px;width:80px;
		margin: auto;
	}
</style>
<body>


<div id="tb">
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="operateUser('add')">新增</a>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="alert('暂时不能修改');">修改</a>
</div>

   	<table id="users" class="easyui-datagrid" data-options="singleSelect:true">
	   	<thead>
	   		<tr>
	   			<th data-options="checkbox:true"></th>
	   			<th data-options="field:'id',width:100">ID</th>
	   			<th data-options="field:'username',width:100">用户名</th><th data-options="field:'name',width:100">用户姓名</th>
	   			<th data-options="field:'role',width:100">角色</th><th data-options="field:'desc',width:100">用户描述</th>
	   			<th data-options="field:'isEnable',width:100">启用状态</th><th data-options="field:'opt',width:200">操作</th>
	   		</tr>
	   	</thead>
	   	<tbody>
	   		<c:forEach items="${data}" var="user" varStatus="status">
	   			<tr>
	   				<td></td>
		   			<td>${user.id}</td>
		   			<td>${user.userName}</td>
		   			<td>${user.name}</td>
		   			<td>${user.role}</td>
		   			<td>${user.desc}</td>
		   			<td>
		   				<c:if test="${user.isEnable==1}">启用</c:if>
		   				<c:if test="${user.isEnable==0}">禁用</c:if>
		   			</td>
		   			<td>
		   			<div style="text-align: center;">
		   				<span class="icon-tip" style="width:5px">　</span><a id="initpass" onclick="initPassword('init')" title="初始化密码" style="margin-left: 2px">初始化密码</a>
		   				&nbsp;&nbsp;
		   				<span class="icon-delete" style="width:5px">　</span><a title="删除" style="margin-left: 2px" onclick="initPassword('delete')">删除</a>
		   			</div>
		   			</td>
		   			
	   			</tr>
	   		</c:forEach>
	   	</tbody>
   	</table>
   	
   	<div id="infowindow" style="display:none;width:500px;height: 200px;" align="center">
   		<form id="userinfo">
   		<table style="margin: auto;margin-top: 20px">
			<tr>
				<td>用户名</td><td><input type="text" id="musername" name="userName" class="easyui-validatebox" data-options="required:true"></td>
				<td>用户姓名</td><td><input type="text" id="mname" name="name"></td>
			</tr>
			<tr>
				<td>用户角色</td><td><select id="mrole" name="role"><option value="admin">管理员</option><option value="standard">普通用户</option></select></td>
				<td>描述</td><td><input type="text" name="desc" id="mdesc" class="nowrite"><br/></td>
			</tr>
			<tr><td style="height: 20px;"></td></tr>
			<tr>
				<td colspan="4" style="text-align: center;"><input type="button" class="com-btn" value="保存" onclick="saveUserInfo()"/><input type="reset" id="userreset" style="display:none"></td>
			</tr>
		</table>
		</form>
   	</div>
</div>  
</body>
