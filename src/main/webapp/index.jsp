<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>xiangwozheyang deren !</h1>
	<input   type="button"   value="测试activeMQ"  onclick="testActiveMQ();"/>

	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		
	
			$(function(){
				
					var _token = "bysf201712";
				
					$.ajax({
						type:"get",
						url:"${pageContext.request.contextPath}/testRequestMapping/getT/"+_token,
						data:{},
						dataType:"json",
						success:function(data){
							console.log(data);
							console.log(Object.prototype.toString.call(data));
						},
						error:function(msg){
							console.log(msg);	
						}
						
					});
				
			});
			
			function testActiveMQ(){
				 $.ajax({
					 url:"${pageContext.request.contextPath}/testRequestMapping/testActiveMq.do",
					 type:"post",
					 success:function(data){
						 console.log(data);
					 },
					 error:function(){
						 alert("报错了!");
					 }
					 
				 })
			}
		
		
	
	</script>
</body>
</html>