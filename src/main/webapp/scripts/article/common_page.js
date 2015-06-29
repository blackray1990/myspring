// 所有模块都通过 define 来定义
define(function(require, exports, module) {

  // 通过 require 引入依赖
  var $ = require('jquery');
  require('../plugins/jquery/jquery.cookie');
  require('../plugins/easyui-1.3.6/jquery.easyui.min');
  require('../plugins/jHtmlArea/scripts/jquery-ui-1.7.2.custom.min');
  require('../plugins/jHtmlArea/scripts/jHtmlArea-0.8');
  
  var article = "";

  entity = {
		  init:function(object){
			  article = object;
			  this.bundle();
		  },
		  bundle:function(){
			  $("#inputArea").htmlarea();
				if(article.id!=0){		//数据库中已存在时处理
					$("#showtitle").text(article.title);
					$("#content").addClass("content");
					$("#content").html(article.content);
					$("#panel").hide();		//默认隐藏编辑器
					$("#switch").text("编辑");
				}
				
				//发布
				$("#art-submit").click(function(){
					
					var title = $("#title").val();
					var temp = $("#inputArea").htmlarea('html');
					temp = temp.replace(/\"/g,"'");
					var content = encodeURIComponent(temp);	//地址栏参数编码
					if(!confirm("是否确认发布？")){
						return ;
					}
					var curl="";
					var artid = article.id;
					var arttitle = article.title;
					if(artid==0){	//新增
						curl = 'createArticle.do';
					}else{			//修改
						curl = 'editArticle.do?id='+artid;
					}
					$.ajax({
						type : 'POST',   
				        url : curl,  
				        data : "content="+content+"&title="+title,  
				        dataType : 'text',
				        success : function(data){
				        	if(data=="success"){
				        		$.messager.alert('提示','<br/> 保存成功！','info');
				        		window.location.reload();
				        	}
				        }
					});
					
				});
				
				//编辑或隐藏编辑面板
				$("#switch").click(function(){
					var oldcontent = article.content;
					$("#inputArea").htmlarea('html',oldcontent);
					$('#panel').slideToggle('normal');
					if($("#switch").text()=="编辑"){
						$("#switch").text("取消");
					}else{
						$("#switch").text("编辑");
					}
				});
		  }
  }
  // 通过 module.exports 提供整个接口
  module.exports = entity;

});