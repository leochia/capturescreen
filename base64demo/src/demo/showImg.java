
package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

public class showImg extends HttpServlet {
    /**
     * @Fields serialVersionUID : 
     */
    
    private static final long serialVersionUID = 1456008878224274765L;

    /**
     * .
     * <p>
     * Title: service
     * </p>
     * <p>
     * Description:
     * </p>
     * @param arg0
     * @param arg1
     * @throws ServletException
     * @throws IOException
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected void service(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("image/jpeg"); // 设置返回的文件类型
        OutputStream sout = null;
        try {
            sout = resp.getOutputStream();

            imageToPage(sout);
        } catch (Exception e) {

        }
        sout.close();
    }

    /**
     * 取出编码字符串进行解码并输出到前台.
     * @param sout 文件流
     * @throws ServletException servlet异常
     */
    public void imageToPage(OutputStream sout) throws ServletException {
        String imgStr = null;
        File ini = null;
        BufferedReader br = null;
        String content = null;
        StringBuffer sb = new StringBuffer(307200);
        try {
            ini = new File("d://base64.txt");
            br = new BufferedReader(new FileReader(ini));
            content = br.readLine().trim();
            while (content != null) {
                sb.append(content);
                content = br.readLine();
            }
            br.close();
        } catch (Exception e) {

        }
        imgStr = sb.toString(); //取出base64编码
        if (imgStr == null) {
            return;
        }
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            sout.write(b);
            sout.flush();
            sout.close();
        } catch (Exception e) {
        } finally {
        }

    }

}
