// 所有模块都通过 define 来定义
define(function(require, exports, module) {

  // 通过 require 引入依赖
  var $ = require('jquery');
  require('../plugins/jquery/jquery.cookie');
  require('../plugins/easyui-1.3.6/jquery.easyui.min');
  require('../plugins/jHtmlArea/scripts/jquery-ui-1.7.2.custom.min');
  require('../plugins/jHtmlArea/scripts/jHtmlArea-0.8');

  entity = {
		  init:function(){
			  this.bundle();
		  },
		  bundle:function(){
			  $("#tt").tree({
					onClick:function(node){
						var flag = $('#tabs').tabs('exists',node.text);
						if(flag==true){		//选项卡存在，则聚焦到该选项卡
							$('#tabs').tabs('select',node.text);
							return ;
						}
						var isFolder = node.isFolder;
						if(isFolder){	//目录不处理事件
							return;
						}else{
							// 创建一个新的tab    
							var title = encodeURIComponent(node.text);
							var url = node.url;
							if(node.template==""){	//不使用iframe
								if(node.openType=="1"){
									url = url+"?title="+title;
								}else{
									window.open(url);
									return;
								}
								
							}else{		//使用iframe 共同的模板node.url
								url = node.template+"?title="+title+"&menuId="+node.id+"&url="+encodeURIComponent(url);
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
				//退出登录
				$("#logout").click(function(){
					if(confirm("确认退出系统吗?")){
						$.cookie("password","");	//清除自动登录信息
						document.location.href="${sessionScope.contextPaths}/logout.do";	
					}
				});
		  }
  }
  // 通过 module.exports 提供整个接口
  module.exports = entity;

});