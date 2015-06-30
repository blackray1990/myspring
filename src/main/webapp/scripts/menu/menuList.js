// 所有模块都通过 define 来定义
define(function(require, exports, module) {

  // 通过 require 引入依赖
  var $ = require('jquery');
  require('../../plugins/jquery/jquery.cookie');
  require('../../plugins/easyui-1.3.6/jquery.easyui.min');
  require('../../plugins/jHtmlArea/scripts/jquery-ui-1.7.2.custom.min');
  require('../../plugins/jHtmlArea/scripts/jHtmlArea-0.8');

  entity = {
		  init:function(){
			  this.bundle();
		  },
		  bundle:function(){
			  $("#emenus").tree({
					onClick:function(node){
						$(".nowrite").attr("disabled",true);	//点击初始化
						$("#dataset").fadeIn("normal");
						$("#mid").val(node.id);
						$("#mtitle").val(node.text);
						$("#mfolder").val(node.isFolder);
						$("#mparent").val(node.parent);
						$("#mparenttext").val(node.parentText);
						$("#murl").val(node.url);
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
						$("#murl").val(node.url);
						
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
				
				$("#aritcle_tpl").click(function(){
					var tpl_url = "article/common.do";	//链接地址
					var tpl_frame = "views/article/iframe.jsp";	//使用模版文件
					$("#murl").val(tpl_url);
					$("#mtemplate").val(tpl_frame);
				});
				//保存
				$("#subIndex").click(function(){
					var paramurl = $("#menuform").serialize();	//序列化表单为地址栏参数
					$.ajax({
						url:"menu/operation.do",
						type:"POST",
						data:paramurl+"&operation="+$("#operation").val(),
						success:function(data){
							if(data=="success"){
								$.messager.alert("提示","操作成功");
								var tab = $('#tabs').tabs('getSelected');
								tab.panel('refresh','menu/manager.do');	//刷新面板
							}else{
								$.messager.alert("提示","<br/>错误："+data);
							}
						}
					});
					
				});
		  }
  }

  // 通过 module.exports 提供整个接口
  module.exports = entity;

});