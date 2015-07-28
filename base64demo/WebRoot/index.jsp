<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>base64Demo</title>
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
		<script language="javascript">
function init() {
    var foo = null;
    try {
        // 此处注意不是"HelloActiveX.CFoo"
        // 具体参考Resource Files->Foo.rgs文件
        foo = new ActiveXObject("CaptureScreen.Foo.1");
    } catch (e) {
        window.alert("new ActiveXObject failed.");
        return;
    }	
		document.getElementById('result1').value =  getScreenPicInfo();
  }
window.onload=function(){
}
//模拟使用框架 Ext.lt.ifmis.activex.getScreenPicInfo()方法，该方法在loadOcx.js中，正式使用时会添加检测以及提示等功能。
getScreenPicInfo=function(){	
	//var capture = new ActiveXObject("CaptureScreen.Foo");
	var capture = cap;
	var base64code = "";
	if(capture == null){
     return "";
	}else{
		base64code = capture.PicValue();
		return base64code.replace(/(\s*$)/g,""); 
	}
	
}
</script>
<OBJECT   ID= "cap" name="cap"  CLASSID= "CLSID:D4A55BDB-B9FF-4CF2-AB5C-F073492D46DF"   CODEBASE= "CaptureScreen.cab#version=1,0,0,1" ></OBJECT> 
		<input type="button" value="点击截图" onclick="init();" />
		<input type="button" value="点击上传"
			onclick="document.forms['queryform2'].submit()" />
		<form action="service.do" id="queryform2" method="post">
			<input id="result1" name="code" type="hidden" />
		</form>
		<hr>
		点击"点击截图",JS调用方法（模拟框架提供截屏接口），截取当前屏幕，并返回base64编码字符串。<br>
		点击"点击上传",提交表单，将编码字符串提交到后台servlet，通过java方法将该字符串存入d:\base64.txt（模拟存入数据库，同时解码该字符串并生成图片文件d:\base64.jpg，可以查看效果）。
		<br>
	</body>
</html>
