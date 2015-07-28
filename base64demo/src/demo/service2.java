/**
 * @Title: service.java
 * @Copyright (C) 2012 龙图软件
 * @Description:
 * @Revision History:
 * @Revision 1.0 2012-8-14  贾志宇
 */

package demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

/**
 * @ClassName: service
 * @Description:
 * @author <a href="mailto:jiazhiyu@szlongtu.com">贾志宇</a> 于 2012-8-14 下午08:29:18
 */

public class service2 extends HttpServlet {

    /**
     * @Fields serialVersionUID :
     */

    private static final long serialVersionUID = 6533716825557540734L;

    /**
     * .
     * <p>
     * Title: doGet
     * </p>
     * <p>
     * Description:
     * </p>
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dd = req.getParameter("code");
        String path = "showImg.jsp";
        resp.sendRedirect(path);
        generateImage(dd);  //此处实际开发中应将该编码串存入数据库中.demo中用文件存取替代了.
    }

    /**
     * 对Base64解码并在本地生成图片.
     * @param imgStr 编码字符串.
     */
    public void generateImage(String imgStr) {
        if (imgStr == null)// 图像数据为空
            return;

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            String imgFilePath = "d://base64.txt";// 存放base64编码
            File file = new File(imgFilePath);
            if (file.isFile()) {
                file.delete();
            }
            OutputStream out1 = new FileOutputStream(imgFilePath);
            out1.write(imgStr.getBytes());
            out1.flush();
            out1.close();
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            String imgFilePath2 = "d://base64.jpg";
            File file2 = new File(imgFilePath2);
            if (file2.isFile()) {
                file2.delete();
            }
            OutputStream out = new FileOutputStream(imgFilePath2);
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
        }
    }
}
