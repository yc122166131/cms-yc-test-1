<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test01</title>
</head>
<body>
		  <p id="a">A.html main</p>  
		  <p><input type="button" value="调用跨域 子iframe中的 方法()" onclick="exec_iframe()"></p>  
		  
		  <iframe src="http://localhost:8280/cms-yc-test/" name="myframe"
		  	 width="500" height="300" frameborder="no"  style="border: 0px;"></iframe>  
		  <br>
		  <!--<input type="button" id="" value="点击"  onclick="javascript:window.open('execA.html');"/>-->
		  
		<script type="text/javascript">
			function fMain(retStr){  
			    //alert('main function execute success'); 
			    document.getElementById("a").innerText = retStr;
			    window.opener.document.getElementById("replc").innerText = retStr; //window.open的 打开调用者 页面进行赋值 
				window.close();
			}
			
			 function exec_iframe(){  
			    if(typeof(exec_obj)=='undefined'){  
			        exec_obj = document.createElement('iframe');  
			        exec_obj.name = 'tmp_frame';  
			        exec_obj.src = 'http://localhost:8280/cms-yc-test/execB.jsp';  
			        exec_obj.style.display = 'none';  
			        document.body.appendChild(exec_obj);  
			    }else{  
			        exec_obj.src = 'http://localhost:8280/cms-yc-test/execB.jsp?' + Math.random();  
			    }  
			  }  
		</script>
	</body>
</html>