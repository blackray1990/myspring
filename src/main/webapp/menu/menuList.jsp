<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include.jsp" %>

<script>
	$(function(){
		
		$("#emenus").tree({
			onClick:function(node){
				$(".nowrite").attr("disabled",true);	//点击初始化
				$("#dataset").fadeIn("normal");
				$("#mid").val(node.id);
				$("#mtitle").val(node.text);
				$("#mfolder").val(node.isFolder);
				$("#mparent").val(node.parent);
				$("#mparenttext").val(node.parentText);
				alert(node.urltent);
				if(node.url){
					$("#murl").val(node.url);
				}else{
					$("#murl").val(node.urltent);
				}
				$("#mtemplate").val(node.template);
			}
		});
		
		$("#emenus").tree({
			onCheck:function(node,checked){
				if(!checked){	//取消选中
					$("#reset").click();
					$("#dataset").fadeOut("normal");
					return;
				}
				$(".nowrite").attr("disabled",true);	//点击初始化
				$("#dataset").fadeIn("normal");
				$("#mid").val(node.id);
				$("#mtitle").val(node.text);
				$("#mfolder").val(node.isFolder);
				$("#mparent").val(node.parent);
				$("#mparenttext").val(node.parentText);
				alert(node.urltent);
				if(node.url){
					$("#murl").val(node.url);
				}else{
					$("#murl").val(node.urltent);
				}
				
				$("#mtemplate").val(node.template);
			}
		});
		
		//初始化菜单栏
		$('#menupanel').panel({
			  fit:true,    
			  title: '菜单栏',    
			  tools: [
			  {    
			    iconCls:'icon-add',  
			    handler:function(){
			    	//父菜单信息
			    	var parent = $("#mid").val();
			    	var parenttext = $("#mtitle").val();
					//初始化
			    	$("#reset").click();
			    	$(".nowrite").attr("disabled",false);
			    	$("#mparent").val(parent);
			    	$("#mparenttext").val(parenttext);
			    	//操作类型
			    	$("#operation").val("add");
			    }    
			  },{    
			    iconCls:'icon-edit',  
			    handler:function(){
			    	$(".nowrite").attr("disabled",false);
			    	//操作类型
			    	$("#operation").val("edit");
			    }
			  },{
				  iconCls:'icon-remove',    
				    handler:function(){
				    	var mid = $("#mid").val();
				    	var mtext = $("#mtitle").val();
				    	//操作类型
				    	$("#operation").val("delete");
				    	if(confirm("确认删除菜单"+mtext+"?")){
				    		submitForm();	//提交
				    	}
				    }
			  }]    
			}); 
	});
	
	function submitForm(){
		var paramurl = $("#menuform").serialize();	//序列化表单为地址栏参数

		$.ajax({
			url:"menu/operation.do",
			type:"POST",
			data:paramurl+"&operation="+$("#operation").val(),
			success:function(data){
				if(data=="success"){
					$.messager.alert("提示","操作成功");
					var tab = $('#tabs').tabs('getSelected');
					tab.panel('refresh','menu/menuList.jsp');	//刷新面板
				}else{
					$.messager.alert("提示","<br/>错误："+data);
				}
			}
		});
	}
</script>
<style>
	td {
		width: 120px !important;
	}
	.com-btn {
		color: black;
		background: linear-gradient(to bottom, #FFF 0px, #EEE 100%) repeat-x scroll 0% 0% transparent;
		border: 1px solid #BBB;
		border-radius: 0px;
		cursor: pointer;
		height:40px;width:80px;
	}
	
	
</style>
<body>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west',split:true" style="width:250px;">
		<div id="menupanel">
			<ul id="emenus" class="easyui-tree" data-options="url:'menu/loadmenu.do',animate:true,lines:true,dnd:true,checkbox:true"></ul>
		</div>
	</div>   
    <div data-options="region:'center'">
    	<div align="center" style="margin-top: 100px">
    	<fieldset id="dataset" style="width:70%;display:none;">
    		<legend>详情</legend>
    		<br/><br/>
    		<form id="menuform" onsubmit="return false;">
    			<table style="text-align: center;">
    				<tr>
    					<td>名称</td><td><input type="text" id="mtitle" name="text" class="nowrite"></td>
    					<td>是否目录</td><td><select id="mfolder" name="isFolder"  class="nowrite"><option value="0">否</option><option value="1">是</option></select></td>
    					
    				</tr>
    				<tr>
    					<td>上级目录</td><td><input type="hidden" name="parent" id="mparent" class="nowrite"><input type="text" id="mparenttext" disabled="disabled"></td>
    					<td>URL</td><td><input type="text" name="url" id="murl" class="nowrite"></td>
    				</tr>
    				<tr>
    					<td>模板</td><td><input type="text" name="template" id="mtemplate" class="nowrite"><br/></td>
    					<td style="display:none;">id</td><td style="display:none;"><input type="text" name="id" id="mid" value="0"><input type="text" id="operation" name="operation"><br/></td>
    				</tr>
    				<tr height="100px">
    					<td colspan="4">
    						<input class="com-btn nowrite" type="submit" onclick="submitForm()" value="保存">
    						<input class="com-btn" type="reset" id="reset">
    					</td>
    				</tr>
    			</table>
    		</form>
    		</fieldset>
    </div>
</div>
</div>
</body>
