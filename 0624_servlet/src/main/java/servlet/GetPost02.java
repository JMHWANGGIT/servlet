package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPost02
 */
@WebServlet("/GetPost02")
public class GetPost02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPost02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet : 화면에서 method=get으로 전송했을 때, 호출되는 메서드 
		System.out.println("=== GetPost02 : doGet ===");
		System.out.println("mid : " + request.getParameter("mid"));
		System.out.println("mpwd : " + request.getParameter("mpwd"));
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost : 화면에서 method = post로 전송했을 때, 호출되는 메소드 
		System.out.println("=== GetPost02 : doPost ===");
		System.out.println("mid : " + request.getParameter("mid"));
		System.out.println("mpwd : " + request.getParameter("mpwd"));
	}//doPost

}//class
