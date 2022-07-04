package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context232Get
 */
@WebServlet("/Context232Get")
public class Context232Get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Context232Get() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>" + ctx.getAttribute("hello")+ "</h1>");
		
		FreeBoardDTO dto = (FreeBoardDTO)ctx.getAttribute("free");
		out.print("<h1>" + dto.getBtitle() + "</h1>");
		
		ArrayList<String> list = (ArrayList<String>) ctx.getAttribute("arr");

//		for(int i = 0; i<list.size();i++) {
//			String tmp = list.get(i);
//		}
		
		for(String tmp : list) {
			out.print("<h1>" + tmp + "</h1>");
		}
		
		out.close();
		
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}
