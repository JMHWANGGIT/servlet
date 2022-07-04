package login.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dao.Login2DAO;
import login.dto.Member2DTO;


@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Login2DAO dao;
    public Login2() {
        super();
        dao = new Login2DAO();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member2DTO dto = new Member2DTO();
		dto.setMid(request.getParameter("mid"));
		dto.setMpwd(request.getParameter("mpwd"));
		
		int loginYN = 0;
		RequestDispatcher disp = request.getRequestDispatcher("./ErrMsg2");
		
		try {
			loginYN = dao.loginCheck(dto);//id, pwd가 모두 올바르면 로그인 YN은 1이 된다.
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error_message", "DBMS오류<br><br>잠시후 다시시작해요!");
			disp.forward(request, response);
			return;
		}
		
		if(loginYN == 0) {//login이 불가능 
			request.setAttribute("error_message", "로그인 실패<br><br>아이디 패스워드 확인");
			disp.forward(request, response);
			
			
		} else if(loginYN == 1) {//login 가능 
			//로그인 성공 표시를 session에 남긴다. 
			HttpSession session = request.getSession();
			session.setAttribute("lid", dto.getMid());
			response.sendRedirect("./LoginComplete2");
		}
	}//doPost

}
