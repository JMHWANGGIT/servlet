package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SubmitTest12")
public class SubmitTest12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubmitTest12() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("mid1");
		String pwd = request.getParameter("mpwd1");
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		out.print("<h1>" + id + "님 환영합니다." + "</h1>");
		out.close();
		
	}//doPost

}//class
