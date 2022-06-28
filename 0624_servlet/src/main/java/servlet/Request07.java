package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Request07")
public class Request07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Request07() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>request</title></head><body>");
		out.print("<h1>");
		out.print("getProtocol : "+ request.getProtocol());
		out.print("<br> getMethod : "+ request.getMethod());
		out.print("<hr>");
		out.print("getServerName : "+ request.getServerName());
		out.print("<br>getServerPort : " + request.getServerPort());
		out.print("<hr>");
		out.print("<br>getRemoteAddr : "+ request.getRemoteAddr());
		out.print("<br>getRemotePort : "+ request.getRemotePort());
		out.print("<br>getRemoteHost : "+ request.getRemoteHost());
		out.print("<br>getRemoteUser : "+request.getRemoteUser());
		out.print("<hr>");
		out.print("<br>getRequestURL : "+request.getRequestURL());
		out.print("<br>getRequestURI : "+request.getRequestURI());
		out.print("<br>getServletPath : "+request.getServletPath());
		out.print("<br>getQueryString : "+request.getQueryString());
		
		
		out.print("</h1>");
		out.print("</body></html>");
		out.close();
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
