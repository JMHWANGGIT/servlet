package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RE04")//프로그램 id : 클라이언트는 프로그램 id를 서버에 전송해서 서블릿 프로그램을 실행시킨다. 
//@ : annotation, @WebServlet : 프로그램 id를 등록하는 표현 
public class RE04 extends HttpServlet {
	/* 서블릿 프로그램은 반드시 extends HttpServlet를 해야 한다. 
	 * extends HttpServlet : http 통신을 하는 자바 객체.
	 * http 통신의 역할1 : 클라이언트의 정보를 받는 역할 
	 * http 통신의 역할2 : 클라이언트에게 html 문서를 전달 
	 * 
	 * HttpServletRequest : 톰캣이 받은 클라이언트 정보를 담은 객체. 
	 * HttpServletResponse : 톰캣이 클라이언트에게 보낼 html 문서를 담은 객체 
	 * 
	 * 우리가 필요한 정보는 HttpServletRequest에서 꺼낸다. 
	 * 클라이언트에게 보낼 정보는 HttpServletResponse 넣는다. 
	 * 
	*/
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RE04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<h1><font color=pink>hello mr.hwnag</font></h1>");
		out.close();
		
		
		}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}//dopost

}//class

/*
 * 서블릿 프로그램 하나마다 프로그램 id가 있어야 한다. 
 * 프로그램 id를 만드는 방법.
 * 1. @WebServlet("프로그램id") : annotation 
 * 2. Web.xml에 프로그램 아이디를 등록하는 방법   
 * 
 * @WebServlet("프로그램id") : annotation
 *  - 프로그램과 프로그램 id를 함께 관리. 
 *  - 장점 : 직관적, 생성/수정/삭제가 쉬움.
 *  - 단점 : 프로그램 id를 목록으로 관리하기 어려움 
 *  
 *  Web.xml에 프로그램 아이디를 등록하는 방법
 *  - 프로그램과 프로그램 id를 따로 관리 
 *  - 장점 : 프로그램 id를 목록으로 관리하기 쉽다. 
 *  - 단점 : 생성/수정/삭제가 어려움. 사용하지 않는 프로그램을 찾아내기가 어렵다. 
 *  
 *  
 */
