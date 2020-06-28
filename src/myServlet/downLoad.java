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
        //��ȡ�ļ���
        String filename = request.getParameter("filename");
        //�ļ����ڵ��ļ���
        String folder="/download/";
        //֪ͨ����������صķ�ʽ��
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename="+filename);
        //ͨ���ļ���������ȡ�ļ�
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
//	            //list()�����Ƿ���ĳ��Ŀ¼�µ������ļ���Ŀ¼���ļ��������ص���String����
//
//	            //listFiles()�����Ƿ���ĳ��Ŀ¼�������ļ���Ŀ¼�ľ���·�������ص���File����
//	            File[] files = file.listFiles();
//	            for (File file2 : files) {
//	                if (file2.isDirectory()) {
//	                    System.out.println("�ļ���:" + file2.getAbsolutePath());
//	                    list.add(file2);
//	                    foldeNum++;
//	                } else {
//	                    System.out.println("�ļ�:" + file2.getAbsolutePath());
//	                    fileNum++;
//	                }
//	            }
//	        }
//		}
}
