package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Board15")
public class Board15 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	FreeBoardDAO dao;
    public Board15() {
        super();
        dao = new FreeBoardDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		if(cmd.equals("list")) {
			ArrayList<FreeBoardDTO> list = dao.selectList();
			
			response.setCharacterEncoding("euc-kr");
			PrintWriter out = response.getWriter();
			out.print("<table border=1><tbody>");
			for(int i = 0; i < list.size(); i++) {
				out.print("<tr>");
				FreeBoardDTO tmpDTO = list.get(i);
				out.print("<td>" + tmpDTO.getBno() + "</td>");
				out.print("<td>" + tmpDTO.getBtitle() + "</td>");
				out.print("<td>" + tmpDTO.getBwriter() + "</td>");
				out.print("<td>" + tmpDTO.getBcnts() + "</td>");
				out.print("<td>" + tmpDTO.getBdate() + "</td>");
				out.print("</tr>");
			}//for
			out.print("</tbody></table>");
			out.close();
		} else if(cmd.equals("detail")) {
			
		}//if
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		if(cmd.equals("reg")) {
			FreeBoardDTO dto = new FreeBoardDTO();
			dto.setBtitle(request.getParameter("title"));
			dto.setBwriter(request.getParameter("writer"));
			dto.setBcnts(request.getParameter("cnts"));
			
			int successCount = dao.insertFreeBoard(dto);
			
			response.setCharacterEncoding("euc-kr");
			PrintWriter out = response.getWriter();
			successCount = 0;//에러테스트를 위한 것 
			if(successCount > 0) {
				//out.print("<h1>등록 완료</h1>");
				response.sendRedirect("./Board15?cmd=list");
			} else {
				//out.print("<h1>등록 실패 - 서버로그를 확인해주세요</h1>");
				response.sendRedirect("./Redirect16ErrorPage");
			}
			out.close();
		}//자유게시판 등록 업무 
	}//doPost

}//class
