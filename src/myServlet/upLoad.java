package myServlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
/**
 * Created by lc on 2018/8/24.
 */
@WebServlet(name = "UploadServlet",urlPatterns = "/UploadServlet")
public class upLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setContentType("text/html;charset=utf-8");
//            ����DiskFileItemFactory��������
            DiskFileItemFactory factory=new DiskFileItemFactory();
//            �����ļ�����Ŀ¼��������ļ��в������򴴽�һ��
            File f=new File("\\TempFolder");
            System.out.println(f);
            if (!f.exists()){
                f.mkdirs();
            }
            factory.setRepository(f);
//            ����ServletFileUpload����
            ServletFileUpload fileUpload=new ServletFileUpload(factory);
//            �����ַ�����
            fileUpload.setHeaderEncoding("utf-8");
//            ����request����form���ĸ����ֶη�װΪFileItem����
            List<FileItem> fileItems = fileUpload.parseRequest(request);
//            ��ȡ�ַ���
            PrintWriter writer=response.getWriter();
//            ����List����
            for (FileItem fileItem:fileItems) {
//            �ж��Ƿ�Ϊ��ͨ�ֶ�
                if (fileItem.isFormField()){
//                    ��ȡ�ֶ�����
                    String name = fileItem.getFieldName();
                    if(name.equals("name")){
//                        ����ֶ�ֵ��Ϊ��
                        if (!fileItem.getString().equals("")){
                            String value=fileItem.getString("utf-8");
                            writer.print("�ϴ��ߣ�"+value+"<br />");
                        }
                    }
                }
                else {
                    //��ȡ�ϴ����ļ���
                    String filename=fileItem.getName();
//                    �����ϴ��ļ�
                    if(filename!=null&&filename!=""){
                        writer.print("�ϴ����ļ������ǣ�"+filename+"<br />");
//                        �����ļ���Ψһ
                        filename= UUID.randomUUID().toString()+"_"+filename;
                        String webpath="/download/";
//                        �����ļ�·��
                        String filepath=getServletContext().getRealPath(webpath+filename);
                        //����File����
                        File file=new File(filepath);
                        //�����ļ���
                        file.getParentFile().mkdirs();
                        //�����ļ�
                        file.createNewFile();
                        //��ȡ�ϴ��ļ���
                        InputStream in=fileItem.getInputStream();
//                        ʹ�� FileOutputStream�򿪷������˵��ϴ��ļ�
                        FileOutputStream out=new FileOutputStream(file);
//                        ���ĶԿ�
                        byte[] bytes=new byte[1024];//ÿ�ζ�ȡһ���ֽ�
                        int len;
//                        ��ʼ��ȡ�ϴ��ļ����ֽڣ�������������������˵��ϴ��ļ��������
                        while ((len=in.read(bytes))>0)
                            out.write(bytes,0,len);
                        in.close();
                        out.close();
                        fileItem.delete();
                        writer.print("�ļ��ϴ��ɹ���");
                    }
                }
 
 
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
  
}

