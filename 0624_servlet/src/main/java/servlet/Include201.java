package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Include201")
public class Include201 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Include201() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//disp.include는 request와 response를 공유한다. 
		System.out.println("=== start 201 ===");
		System.out.println("mid : " + request.getParameter("mid"));
		System.out.println("mpwd : " + request.getParameter("mpwd"));
		System.out.println("hid : " + request.getParameter("hid"));
		
		PrintWriter out = response.getWriter();
		RequestDispatcher disp = request.getRequestDispatcher("./Include202");
		disp.include(request, response);
		
		out.print("<h1>This is message form 201</h1>");
		//수행되지 않는다. 
		//수행되지 않는 이유는 202에서 out.close();를 수행했기 때문이다. 
		
		System.out.println("=== end 201 ===");
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}
