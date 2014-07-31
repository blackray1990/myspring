<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>系统登陆</title>
</head>
<link rel="stylesheet" type="text/css" href="plugins/easyui-1.3.6/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="plugins/easyui-1.3.6/themes/icon.css">   
<script type="text/javascript" src="plugins/easyui-1.3.6/jquery.min.js"></script>   
<script type="text/javascript" src="plugins/easyui-1.3.6/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="plugins/jquery.json-2.2.min.js"></script> 
<script>

jQuery.prototype.serializeObject=function(){ 	//将表单序列化成对象
    var obj=new Object(); 
    $.each(this.serializeArray(),function(index,param){ 
        if(!(param.name in obj)){ 
            obj[param.name]=param.value; 
        } 
    }); 
    return obj; 
};
jQuery.prototype.serializeUrlParams=function(obj){ 	//将序列化后的对象进行地址栏参数组装
	var urlparam="";
	for(obj.name in obj){
		var attrname=obj.name;
		urlparam=urlparam+obj.name+"="+obj[attrname]+"&";
	}
	return urlparam;
};

	$(document).ready(function(){
		
		$("#submit-btn").click(function(){
			var temp = $("#logon").serializeObject();	//序列化成对象
			//var jsonInfo = $.toJSON(temp);	//将对象转为json字符串  类似：{"userName":"ss","password":"af"}
			var param = $().serializeUrlParams(temp);
			$.ajax({
				type : 'POST',   
		        url : 'logonsys.do',  
		        data : param,  
		        dataType : 'text',
		        success : function(data){
		        	if(data=="success"){
		        		alert("sdf");
		        		document.location.href="index.jsp";
		        	}
		        }
			});
		});
	});
</script>

<body>
<div align="center" style="margin-top: 200px;">
	<input type="hidden" id="msg" value="init"/>
	<form id="logon" method="post">
	<div id="p" class="easyui-panel" style="width:300px;padding:10px;"  title="系统登陆" data-options="collapsible:false" align="center">   
		<div>   
	        <label for="name">用户名:</label>   
	        <input class="easyui-validatebox" type="text" name="userName" data-options="required:false" />   
	    </div><br/>
	    <div>   
	        <label for="email">密&nbsp;&nbsp;码:</label>   
	        <input class="easyui-validatebox" type="password" name="password" data-options="required:false" />   
	    </div><br/>
	    <a id="submit-btn" href="#" class="easyui-linkbutton" data-options="size:'large'" style="width:100px;">提交</a>    
	</div> 
	</form>  
</div>
</body>
</html>