<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test01</title>
</head>
<body onload="onLoad();">
				
		<script type="text/javascript">  
		
			function oo(st){
				parent.parent.fMain(st); // execute main function 
			}
	        
	        
	        //js 中获取 地址栏参数
	        function getUrlParam(name) {  
			   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象  
			   var r = window.location.search.substr(1).match(reg);  //匹配目标参数  
			   if (r != null) {
			       return unescape(r[2]);  //返回参数值 
			   } else {
			       return null; 
			   }
			}
			
			function onLoad() {
			    var p = getUrlParam("p");
			    console.info("p=" + p);
			    oo(p);
			}
	        
	    </script>  
	</body>
</html>