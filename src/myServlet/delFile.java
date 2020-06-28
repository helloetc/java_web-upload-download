package myServlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delFile")
public class delFile extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String FileName = req.getParameter("FileName");
		String pathname = "D:\\Tomcat\\apache-tomcat-7.0.100\\webapps\\shiyan6\\download\\";
		pathname = pathname + FileName;
	     String res = toDel(pathname);
	     resp.getWriter().write(res + "<a href='del.jsp'>点击返回</a>");
	     
	}
	
	
	

	private String  toDel(String pathname) {
		File file = new File(pathname);
		if (file.exists()) {
			file.delete();
//			result = true;
			System.out.println("文件已经被成功删除");
			return "文件已经被成功删除";
		}
		return "文件删除失败！";
	}

}
