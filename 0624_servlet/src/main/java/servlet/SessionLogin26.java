package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionLogin26")
public class SessionLogin26 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    LoginService service;
    
    public SessionLogin26() {
        super();
        service = new LoginService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		dto.setMid(request.getParameter("mid"));
		dto.setMpwd(request.getParameter("mpwd"));
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		int result = 0;
		try {
		result = service.loginCheck(dto);
		} catch(SQLException e) {
			e.printStackTrace();
			out.print("<h1>SQL 오류가 발생하였습니다.<br><br>잠시 후 다시 시도해 주세요.</h1>");
			out.close();
			return;
		}
		
		if(result == -1) {//아이디 오류 
			out.print("<h1>ID가 올바르지 않습니다.<br><br>ID를 확인해주세요.</h1>");
		} else if(result == 0) {//패스워드 오류 
			out.print("<h1>비밀번호가 올바르지 않습니다.<br><br>비밀번호를 확인해주세요.</h1>");
		} else if(result == 1) {//로그인 OK(id도 있고, pwd도 정상)
			HttpSession session = request.getSession();
			session.setAttribute("login_id", dto.getMid());
			response.sendRedirect("./LoginOK");
			//out.print("<h1>" + dto.getMid() + "님 환영합니다.</h1>");
		}
		
		out.close();
	}//doPost

}
