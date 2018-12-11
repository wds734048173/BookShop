package org.lanqiao.control;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //为基于磁盘的文件项创建工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //配置存储库（以确保使用安全的临时位置）
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        //创建一个新的文件上传处理程序
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        //解析请求
        try {
            List<FileItem> items = upload.parseRequest(req);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    //处理常规元素
                    String name = item.getFieldName();
                    String value = item.getString();
                } else {
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    boolean isInMemory = item.isInMemory();
                    long sizeInBytes = item.getSize();

                    //保护文件的安全性，给上传的文件重新命名
                    String uuidName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));

                    //给上传的文件，按照日期进行分类存储
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    File filePath = new File("D://upload/" + sdf.format(new Date()));
                    //如果文件名不存在，就创建，存在就不用创建
                    if(!filePath.exists()){
                        filePath.mkdirs();
                    }

                    //需要保存数据库的信息有：fileName(文件原名)，uuidName(文件生成的uuid名称),filePath(文件路径)
                    File uploadedFile = new File(filePath,uuidName);
                    item.write(uploadedFile);
                    HttpSession session = req.getSession();
                    session.setAttribute("picUrl",uploadedFile);
                    Cookie cookie = new Cookie("JSESSIONID",session.getId());
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    resp.addCookie(cookie);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
