package myServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
/**
 * Created by lc on 2018/8/24.
 */
@WebServlet("/Download")
public class downLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取文件名
        String filename = request.getParameter("filename");
        //文件所在的文件夹
        String folder="/download/";
        //通知浏览器以下载的方式打开
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename="+filename);
        //通过文件输入流读取文件
        InputStream in=getServletContext().getResourceAsStream(folder+filename);
        System.out.println("------------------");
        System.out.println(folder+filename);
        System.out.println("------------------");
        OutputStream out=response.getOutputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
    }
    
//	public void test1(){
//	  	  String path = "F:\\";
//	        int fileNum = 0;
//	        int folderNum = 0;
//	        int foldeNum = 0;
//	        
//	        
//	        
//	        File file = new File(path);
//	    
//	        if (file.exists()) {
//	            LinkedList<File> list = new LinkedList<File>();
//
//	            //list()方法是返回某个目录下的所有文件和目录的文件名，返回的是String数组
//
//	            //listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组
//	            File[] files = file.listFiles();
//	            for (File file2 : files) {
//	                if (file2.isDirectory()) {
//	                    System.out.println("文件夹:" + file2.getAbsolutePath());
//	                    list.add(file2);
//	                    foldeNum++;
//	                } else {
//	                    System.out.println("文件:" + file2.getAbsolutePath());
//	                    fileNum++;
//	                }
//	            }
//	        }
//		}
}
