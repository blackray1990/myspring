<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include.jsp" %>

<style>
	td {
		width: 80px;
		text-align: left;
	}
	.input_td {
		width: 200px;
	}
	.com-btn {
		color: black;
		background: linear-gradient(to bottom, #FFF 0px, #EEE 100%) repeat-x scroll 0% 0% transparent;
		border: 1px solid #BBB;
		border-radius: 0px;
		cursor: pointer;
		height:40px;width:80px;
	}
	
	
</style>
<body>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west',split:true" style="width:250px;">
		<div id="menupanel">
			<ul id="emenus" class="easyui-tree" data-options="url:'menu/loadmenu.do',animate:true,lines:true,dnd:true,checkbox:true"></ul>
		</div>
	</div>   
    <div data-options="region:'center'">
    	<div align="center" style="margin-top: 100px">
    	<fieldset id="dataset" style="width:70%;display:none;">
    		<legend>详情</legend>
    		<br/><br/>
    		<form id="menuform" onsubmit="return false;">
    			<table style="text-align: center;">
    				<tr>
    					<td>名称</td><td class="input_td"><input type="text" id="mtitle" name="text" class="nowrite"></td>
    					<td>是否目录</td><td class="input_td"><select id="mfolder" name="isFolder"  class="nowrite"><option value="0">否</option><option value="1">是</option></select></td>
    					
    				</tr>
    				<tr>
    					<td>上级目录</td><td class="input_td"><input type="hidden" name="parent" id="mparent" class="nowrite"><input type="text" id="mparenttext" disabled="disabled"></td>
    					<td>URL</td>
    					<td class="input_td">
    						<input type="text" name="url" id="murl" class="nowrite">&nbsp;&nbsp;<a id="aritcle_tpl" href="javascript:void(0)">文章</a>
    					</td>
    				</tr>
    				<tr>
    					<td>模板</td><td class="input_td"><input type="text" name="template" id="mtemplate" class="nowrite"><br/></td>
    					<td style="display:none;">id</td><td style="display:none;"><input type="text" name="id" id="mid" value="0"><input type="text" id="operation" name="operation"><br/></td>
    					<td>打开方式</td>
    					<td>
    						<select name="openType">
    							<option value="1">tab打开</option>
    							<option value="2">新标签页打开</option>
    						</select>
    					</td>
    				</tr>
    				<tr height="100px">
    					<td colspan="4">
    						<input class="com-btn nowrite" type="submit" id="subIndex" value="保存">
    						<input class="com-btn" type="reset" id="reset">
    					</td>
    				</tr>
    			</table>
    		</form>
    		</fieldset>
    </div>
</div>
</div>
<script>
	seajs.use("<%=contextPath%>/scripts/menu/menuList",function(page){
		page.init();
	});
</script>
</body>
