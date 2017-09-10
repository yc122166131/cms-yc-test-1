<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test01</title>
</head>
<body>
		<input type="button" value="跨域" onclick="openKuayu();"/>
		<p id="replc">还没修改的数据</p>
	</body>
	
	<script type="text/javascript">
		
			function openKuayu(){
				window.open("kuayu.jsp")
			}
	</script>
</html>