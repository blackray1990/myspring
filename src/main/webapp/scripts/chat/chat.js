// 所有模块都通过 define 来定义
define(function(require, exports, module) {

  // 通过 require 引入依赖
  var $ = require('jquery');
  require('../../dwr/engine');
  require('../../dwr/util');
  require('../../dwr/interface/ChatService');//由对应java类生成该js

  entity = {
		  init:function(){
			  this.bundle();
		  },
		  bundle:function(){
			  $("#subSend").click(function(){
				  var time = new Date();
				    var content = dwr.util.getValue("content");
				    var name = dwr.util.getValue("userName");
				    var info = encodeURI(encodeURI(name + ":\n" + content+"\n"));
				    var msg = {"id":1,"msg": info, "time": time};
				    dwr.util.setValue("content", "");
				    if (!!content) {
				        ChatService.sendMessage(msg);
				    } else {
				        alert("发送的内容不能为空！");
				    }
			  });
		  }
  }

  // 通过 module.exports 提供整个接口
  module.exports = entity;

});