package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Start01
 */
@WebServlet("/end")//program id : 유저는 프로그램 아이디를 서버로 전송해서 서브릿 프로그램을 실행 시킨다. 
//하나의 서블릿 프로그램에는 하나의 program id가 필요하다. 
//@ : annotation : 어노테이션 
public class Start01 extends HttpServlet {
	//서블릿 프로그램은 유저에게 전송할 웹페이지를 만든다.
	//서블릿 프로그램은 extends HttpServlet을 해야한다. 
	/*
	 * ★ 필수암기!!
	 * HttpServlet : http 통신을 하는 servlet 객체 
	 * - 톰캣으로부터 유저 정보와 유저가 보낸 기타 정보를 받는다. 
	 * - 톰캣에게 유저에게 전송할 html 문서를 준다. 
	 * - HttpServletRequest : 유저 정보와 유저가 보낸 기타 정보를 담은 객체 
	 * - HttpServletResponse : 유저에게 전송할 html 문서를 담는 객체 
	 * - 유저 관련 정보는 HttpServletRequest에서 꺼내서 사용. 
	 * - 유저에게 보낼 데이터는 HttpServletResponse에 넣는다. 
	 */
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== get method ===");
		PrintWriter out = response.getWriter();
		out.print("<h1>hwang jae myoung</h1>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
/*
 * 프로그램 id를 만들과 관리하는 두가지 방법 
 * 1. @WebServlet(program id) 사용
 * - 장점 : 손쉽게 사용 가능 (id 생성/수정 쉽다.)
 * - 단점 : 프로그램 id 목록 작성 및 관리가 어려움 
 * 
 * 2. web.xml에 program id를 등록해서 사용하는 방법 
 * - 장점 : 프로그램 id 목록의 역할까지 가능. 
 * - 단점 : 프로그램 id를 생성과 수정에 일일이 손이 간다. 
 * 사용되지 않는 id 정보(쓰레기정보)가 삭제되지 않는다. 
 */
