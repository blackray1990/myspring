// 所有模块都通过 define 来定义
define(function(require, exports, module) {

  // 通过 require 引入依赖
  var $ = require('jquery');
  require('../plugins/jquery/jquery.cookie');
  require('../plugins/easyui-1.3.6/jquery.easyui.min');

  entity = {
		  init:function(){
			  this.bundle();
		  },
		  bundle:function(){
			  	//是否免登录
			  /*var username = $.cookie("userName");
				var password = $.cookie("password");
				if(username&&password){
					$("#userName").val(username);
					$("#password").val(password);
					$("#remdiv").append("<input type='hidden' name='auto' value='1'/>");
					$("#logon").submit();
				}*/
				
				//登录提示信息
				var msg = $("#msg").val();
				if(msg=="failure"){
					$.messager.alert('提示','<br/> 登陆失败，用户名或密码错误！','info');    
				}
				//刷新验证码
				$(".kaptcha").click(function(){
					$(this).attr("src","kaptcha.jpg?"+Math.floor(Math.random()*100));
				});
				
				//登录
				$("#submitData").click(function(){
					if($("#rempass").is(":checked")){
						$.cookie("userName","hejinsheng",{expires:7});	//保存7天
						$.cookie("password","123456",{expires:7});
					}else{
						$.cookie("userName","");
						$.cookie("password","");
					}
					$("#logon").submit();
				});
		  }
  }

  // 通过 module.exports 提供整个接口
  module.exports = entity;

});