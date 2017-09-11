<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test01</title>
</head>
<body>	

		<!--  js 跨域 相关  start -->
			<input type="button" value="javascript跨域" onclick="openKuayu();"/>
			<p id="replc">还没修改的数据 (一会要获取 跨域数据 进行修改 )</p>
		<!-- end  js 跨域 相关   -->
		
		
	</body>
	
	<script type="text/javascript">
			
	
			function openKuayu(){
				window.open("kuayu.jsp")
			}
			
	</script>
</html>