package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cookie28")
public class Cookie28 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Cookie28() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /*
     * Cookie 
     * - 사용자 웹브라우저에 사용자 관련 정보를 보관하는 방법 
     * - 보안이 취약하다.
     * - 클라이언트에게 쿠키를 내보낸다. : response.addCookie
     * - 
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie c1 = new Cookie("name", "value");
		System.out.println(c1.getMaxAge());//-1 : 브라우저종료시 쿠키삭제. 
		//MaxAge : 쿠키의 유효기간 (생존시간)  
		System.out.println(c1.getDomain());//null 
		c1.setMaxAge(60*60*24);//60초*60분*24시간 == 하루
		c1.setDomain(request.getServerName());
		
		Cookie c2 = new Cookie("cookie_test", "thisiscookietest...");
		Cookie c3 = new Cookie("login_data", URLEncoder.encode("cookie can contain 로그인 data.","UTF-8"));
		response.addCookie(c1); 
		response.addCookie(c2);
		response.addCookie(c3);
		
		
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
