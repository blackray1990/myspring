<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String contextPath = request.getContextPath();
%>

<script src="<%=contextPath%>/plugins/sea-modules/seajs/seajs/2.2.0/sea.js"></script>
<script type="text/javascript">
//seajs基本路径配置
 seajs.config({
	  base: "<%=contextPath%>/plugins/sea-modules/",
	  alias: {
	    "jquery": "jquery/jquery/1.10.1/jquery.js"
	  }
	});
</script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/plugins/easyui-1.3.6/themes/gray/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/plugins/easyui-1.3.6/themes/icon.css">   
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/plugins/jHtmlArea/style/jqueryui/ui-lightness/jquery-ui-1.7.2.custom.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/plugins/jHtmlArea/style/jHtmlArea.css" />


<body>
</body>
