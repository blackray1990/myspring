<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script>

</script>
<body>

	<!-- 文章发布固定引用jsp param.url是链接的真正地址 -->
	<iframe scrolling="auto" style="height: 99%;width: 100%;border: none;" src="${param.url }?title=${param.title }"></iframe>
	
</body>
</html>