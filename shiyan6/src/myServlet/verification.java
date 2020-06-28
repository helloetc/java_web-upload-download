package myServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verification")
public class verification extends HttpServlet {
	
	String str;
	String  userName= "123456";
	String  userPass= "123456";

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {
		 str = verifi();
		resp.getWriter().write(str);
		
	};
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		 String userId = req.getParameter("userId");
		 String userPassWord = req.getParameter("userPassWord");
		 String verifi = req.getParameter("verifi");
		if(!(userId.equals(userName) && userPassWord.equals(userPass) && verifi.equals(str)) ){
			
			resp.getWriter().write("输入账号或者在验证码错误");
		}else{
			resp.getWriter().write("");
		}
    		
	}
	
	
	

	public String verifi() {

		Object[] StrArr = new Object[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
				'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Z', };
		int i;
		String str = "";
		for (int j = 0; j < 4; j++) {
			i = (int) (Math.random() * 52);
			str += StrArr[i];
		}
		System.out.println(str);
		return str;
	}

}
