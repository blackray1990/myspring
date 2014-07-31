<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Spring MVC</title>
</head>
<%@ include file="../include.jsp" %>

<script>
	$(function(){
		$("#tt").tree({
			onClick:function(node){
				var flag = $('#tabs').tabs('exists',node.text);
				if(flag==true){		//选项卡存在，则聚焦到该选项卡
					$('#tabs').tabs('select',node.text);
					return ;
				}
				if(node.children==null||node.children==""){	//如果不是目录，打开tab
					// 创建一个新的tab    
					var title = encodeURIComponent(node.text);
					var url = "";
					if(node.template==""){	//不使用iframe
						url = node.url+"?title="+title;
					}else{		//使用iframe 共同的模板node.url
						url = node.template+"?title="+title+"&url="+encodeURIComponent(node.url);
					}
					$('#tabs').tabs('add',{    
						id:"tab1",
					    title:node.text,    
					    href: url,
					    closable:true, 
					    tools:[{    
					        iconCls:'icon-mini-refresh',    
					        handler:function(){    
					        	// 调用 'refresh' 方法更新选项卡面板的内容
					        	var ctab = $('#tabs').tabs('getSelected');  // 获取选择的面板
					        	ctab.panel('refresh', url);    
					        }    
					    }],
					    onSelect:function(){}
					});
				}
			}
		});
		
		$("#tabs").tabs({
					onSelect:function(){
						
					}
					});
		
	})
</script>
<body class="easyui-layout">   
    <div id="north" data-options="region:'north'" style="overflow: hidden;height:120px;border-top: none;background-repeat: no-repeat;">
    	<div style="margin-top: 30px;margin-left: 30px;width:75px;font-family: 黑体"><!-- background-image: url('images/header2.jpg'); -->
    		<img src="images/cook_java.jpg" style="height: 60px;"><br/>
    		<center>COOK JAVA</center>
    	</div>
    </div>   
    <div data-options="region:'south'" style="height:auto;"><div align="center">BlackRay版权所有</div></div>      
    <div data-options="region:'west',title:'菜单项',split:false" style="width:200px;">
    	<ul id="tt" class="easyui-tree" data-options="url:'menu/loadmenu.do'"></ul>  
    </div>   
    <div data-options="region:'center'" style="padding:0px;background:#eee;">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true">   
		    <div id="tab0" title="主页" style="padding:20px;text-align: center;background-image: url('images/lizhi.jpg');background-position: center;background-repeat: no-repeat;">   
		        	欢迎来到Spring的世界！ 
		    </div>  
		</div> 
    </div>   
</body> 
</html>