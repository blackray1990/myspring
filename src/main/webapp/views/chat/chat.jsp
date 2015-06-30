<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>聊天室</title>
</head>
<%@ include file="../include.jsp" %>

<script type="text/javascript">
	//dwz回调方法使用seajs管理
    function showMessage(data) {
	    var message = decodeURI(decodeURI(data.msg));
	    var text = dwr.util.getValue("info");
	    if (!!text) {  
	        dwr.util.setValue("info", text + "\n" + data.time + "  " + message);
	    } else {
	        dwr.util.setValue("info", data.time + "  " + message);
	    }
	}
</script>
<!-- dwr 必须设定为反向ajax，否则不会自动触发showMessage事件 -->
<body onload="dwr.engine.setActiveReverseAjax(true);">   
<div style="margin-left: 20px;">
      <textarea rows="30" cols="60" id="info" readonly="readonly" style="background-color: azure;">
      			   查看历史记录
      </textarea>
      <hr/>
      <div>
      	昵称：<input type="text" id="userName" value="${sessionScope.USER.name }" readonly="readonly"/><br/>
      </div>
      <div style="margin-top: 10px">
      	消息：<textarea rows="5" cols="30" id="content"></textarea>
      	<input type="button" value=" 发送 " id="subSend" style="height: 25px; width: 85px;"/>
      </div>
  </div>  
</body> 
<script>
//加载入口模块
	seajs.use("<%=contextPath%>/scripts/chat/chat",function(page){
		page.init();
	});
</script>
</html>