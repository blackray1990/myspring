<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
	.content {
		overflow: auto;
		background-color: #fafafa;
		margin-left: 20px;
		margin-right: 20px;
		border: 1px gray solid;
		min-height: 200px;
	}
</style>

 
<script type="text/javascript" src="../plugins/jquery.min.js"></script> 

<link rel="stylesheet" type="text/css" href="../plugins/easyui-1.3.6/themes/gray/easyui.css">   
<link rel="stylesheet" type="text/css" href="../plugins/easyui-1.3.6/themes/icon.css">   
<script type="text/javascript" src="../plugins/easyui-1.3.6/jquery.easyui.min.js"></script> 

<script type="text/javascript" src="../plugins/jHtmlArea/scripts/jquery-ui-1.7.2.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="../plugins/jHtmlArea/style/jqueryui/ui-lightness/jquery-ui-1.7.2.custom.css" />
<script type="text/javascript" src="../plugins/jHtmlArea/scripts/jHtmlArea-0.8.js"></script>
<link rel="stylesheet" type="text/css" href="../plugins/jHtmlArea/style/jHtmlArea.css" />

<script type="text/javascript">
	$(function(){
		$("#inputArea").htmlarea();
		
		if("${article.id}"!=0){		//数据库中已存在时处理
			$("#showtitle").text("${article.title}");
			$("#content").addClass("content");
			$("#content").html("${article.content}");
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
			var artid = "${article.id}";
			var arttitle = "${article.title}";
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
			var oldcontent = "${article.content}";
			$("#inputArea").htmlarea('html',oldcontent);
			$('#panel').slideToggle('normal');
			if($("#switch").text()=="编辑"){
				$("#switch").text("取消");
			}else{
				$("#switch").text("编辑");
			}
		});
		
	}); 
</script>
<style>
	.above {
		background:#F5F5F5;float:right;
    	position:fixed !important; top:10px;
    	position:absolute; z-index:300; top:expression(offsetParent.scrollTop+100);right:30px;
    	}
	.onoff{
		text-align:center; 
		background-color: #eaeaea;
		border: 1px solid black;
		cursor: pointer;
		width:40px;
	}
</style>
<body>
	<div align="center" style="font-weight: bold;font-size: large;"><div id="showtitle"></div></div><br/>
	<div id="switch" class="above onoff">取消</div>
	<div id="content" style="height:100%;"></div>
	

	<div style="margin-left: 20px;margin-top: 10px;" id="panel">
	标题：<input type="text" id="title" value="${article.title}" readonly="readonly"/>
		<textarea id="inputArea"  style="height:180px;width: 600px;" ></textarea>
		<a id="art-submit" href="#" class="easyui-linkbutton" data-options="size:'small'" style="width:70px;position: relative;top:-25px;left:65%">发布</a>
	</div>
		
	
</body>
</html>