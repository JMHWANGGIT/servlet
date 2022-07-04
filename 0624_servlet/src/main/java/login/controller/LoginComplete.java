package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginComplete")
public class LoginComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("lid");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF8");
		PrintWriter out = response.getWriter();
		
		if(loginID == null || loginID.equals("")) {//로그인 안된사람
			out.print("<h1>로그인 해 주세요.</h1>");
			out.print("<a href='./svl/27login.html'>로그인 바로가기</a>");
		} else {//로그인 된 사람 
			response.addHeader("refresh"
					, "5;url=http://localhost:8080/0624_servlet/svl/13index.html");
			out.print("<h1>"+ loginID +"님 환영합니다. </h1>");
		}
		
		out.close();
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
