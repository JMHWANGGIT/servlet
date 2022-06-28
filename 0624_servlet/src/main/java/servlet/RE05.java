package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RE05")
public class RE05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RE05() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== RE05 : doGet ===");
		
		String id = request.getParameter("mid");
		String password = request.getParameter("mpwd");
		String hidden1 = request.getParameter("h1");
		
		System.out.println(id);
		System.out.println(password);
		System.out.println(hidden1);
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out2 = response.getWriter();
		out2.print("<h1>클라이언트가 입력한 id를 서버에서 받아서 다시 클라이언트로 보냄 :" + id + "</h1>");
		out2.close();
		
		/*
		 * doGet 메소드를 호출해 주는 객체 : 톰캣
		 *  - 클라이언트가 프로그램id를 톰캣에 전달 
		 *  	-> 톰캣이 프로그램id를 실행 
		 *  		+ 클라이언트가 보낸 정보를 request객체로 생성해서 전달. 
		 *   		+ 클라이언트에게 보낼 html 문서를 넣는 객체 HttpServletResponse객체도 생성해서 프로그램에 전달. 
		 *   
		 */
	
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== RE05 : doPost ===");
		String id2 = request.getParameter("mid");
		String password2 = request.getParameter("mpwd");
		String h12 = request.getParameter("h1");
		
		System.out.println(id2);
		System.out.println(password2);
		System.out.println(h12);
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out3 = response.getWriter();
		out3.print("유저가 전송한 id, password, hidden data가 서버에 잘 도착하였습니다."); 
		out3.close();
		
	}//doPost

}
