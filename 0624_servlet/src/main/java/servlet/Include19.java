package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Include19")
public class Include19 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Include19() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * RequestDispatcher.include
	 * - 다른 서블릿을 복사해 오는 기술 
	 * - 페이지분리 개발에 사용. 
	 * - 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		RequestDispatcher disp = request.getRequestDispatcher("./Include191");
		disp.include(request, response);
		//Include191의 소스를 복사해 붙여놓고 컴파일을 실행한다. 
		//Include19와 Include191이 하나의 소스가 되어서 컴퍼일 및 실행한다. 
		
		out.print("<h1>success</h1>");
		out.print("</main></div></body></html>");
		out.close();
		
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}
