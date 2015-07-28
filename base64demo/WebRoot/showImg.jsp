<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>html img标签获取base64解码字符串</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 页面代码< img alt="ddd" src="showImg.do"/>提请求到后台，通过读取d:\base64.txt文件（模拟数据库操作），将base64编码通过java 的sun.misc.BASE64Decoder类进行解码并输出到前台，
<hr>
以下是图片显示区
<hr>
<img alt="ddd" src="showImg.do"/>
  </body>
</html>
