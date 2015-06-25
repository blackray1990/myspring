<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Chat</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <script type="text/javascript" src="${pageContext.request.contextPath }/dwr/engine.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/dwr/util.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/dwr/interface/ChatService.js"></script>
    <script type="text/javascript">
        function sendMsg(){
        	alert("测试");
/*             var time = new Date();
            var content = dwr.util.getValue("content");
            var name = dwr.util.getValue("userName");
            var info = encodeURI(encodeURI(name + " say:\n" + content));
            var msg = {"msg": info, "time": time};
            dwr.util.setValue("content", "");
            if (!!content) {
                ChatService.sendMessage(msg);
            } else {
                alert("发送的内容不能为空！");
            } */
        }
 
/*         function showMessage(data) {
            var message = decodeURI(decodeURI(data.msg));
            var text = dwr.util.getValue("info");
            if (!!text) {  
                dwr.util.setValue("info", text + "\n" + data.time + "  " + message);
            } else {
                dwr.util.setValue("info", data.time + "  " + message);
            }
        } */
    </script>
  </head>
  
  <body><!--  onload="dwr.engine.setActiveReverseAjax(true);" -->
  <div style="margin: 10px 10px 10px 100px;">
      <textarea rows="30" cols="60" id="info" readonly="readonly"></textarea>
      <hr/>
      <div>
      	昵称：<input type="text" id="userName"/><br/>
      </div>
      <div style="margin-top: 10px">
      	消息：<textarea rows="5" cols="30" id="content"></textarea>
      	<input type="button" value=" Send " onclick="sendMsg()" style="height: 25px; width: 85px;"/>
      </div>
  </div>    
  </body>
</html>