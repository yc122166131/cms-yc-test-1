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
	<input   type="button"   value="测试jsonp"  onclick="testJsonP1();"/>
	<br/><br/>
	<input   type="button"   value="测试activeMQ"  onclick="testActiveMQ();"/>
	<br/><br/>
	<input type="button" id="btn1" value="测试下 responseBody(json)"  onclick="javascript:testRespJson();" />

	
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		
	
			$(function(){
			});
			
			
			// 本地为 正常请求 
			// 跨域时 我们用的 是 jsonp 的请求 (多加了个 callback 参数 )
			function  testJsonP1(){
				//正常 请求 和 跨域 jsonp 请求
				
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
			}
			
			
			//测试 responseBody 返回的 json 格式数据 (主要测试的是 返回的 String 类型 )
			function testRespJson(){
				
				   	$.ajax({
				   		type:"post",
				   		url:"${pageContext.request.contextPath}/testRequestMapping/testResponseBody1.action",
				   		data:{name:"nice"},
				   		/* dataType:"json",     */
				   		success:function(data){
				   			data = JSON.parse(data);		
				   			//data = JSON.stringify(data);
				   			console.log("===   " + data);
				   			//data = eval("("+data+")");
				   			alert(Object.prototype.toString.call(data));
				   			console.log(data.liushuihao);
				   		},
				   		error:function(msg){
				   			alert("error@！");
				   		}
				   		
				   	});
				
			}
			
			
			// 使用ActiveMq
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