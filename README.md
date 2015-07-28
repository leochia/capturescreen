# capturescreen
  an ActiveX object which can be used when you need to capture the screen of the IE

CaptureScreen.cab:
  这是2012年，开发的一个基于IE浏览器ActiveX标准开发的浏览器插件。
  实现功能： 
  1.截取当前屏幕为jpeg图片并在内存中将图片按照标准进行BASE64编码
  2.对外发布接口，可以通过javascript调用。  
  
CaptureScreen
   控件实现源码，Visual Studio工程。
   实现：
    截屏控件使用的是VC++ ATL库中的标准base64编码API对图片进行编码

base64demo
   MyEclipse9.0工程，控件使用示例  功能：a.JSP页面模拟提供接口，截取当前屏幕为jpeg图片，并对该图片进行编码，获取编码字符串，提交表单。如果本地客户端没有安装该控件，则提示安装。
         b.后台servlet获取该字符串，并将该字符串存入磁盘txt文件中（模拟存入数据库），同时调用sun.misc.BASE64Decoder 类的解码方法将该字符串进行解码并通过文件流在本地磁盘上生成jpeg图片。
         c.页面跳转到展示页面，通过html的img标签向后台发送请求，后台servlet读取存放字符串的文本文件，并进行解码输出。页面中可以展示刚才截取的屏幕。

