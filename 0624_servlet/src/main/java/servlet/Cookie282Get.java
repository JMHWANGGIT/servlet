package servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cookie282Get")
public class Cookie282Get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cookie282Get() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookieArr = request.getCookies();
		
		
		for(Cookie coo : cookieArr) {
			System.out.println(coo.getName() + " : " + URLDecoder.decode(coo.getValue(),"utf-8"));
			System.out.println(coo.getMaxAge() + " : " +coo.getDomain());
			System.out.println("=====================================");
			
		}//for
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
