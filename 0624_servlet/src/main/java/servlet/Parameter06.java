package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Parameter06")
public class Parameter06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Parameter06() {
        super();
    }

    /*
     * parameter 1개를 받을 때 : request.getParameter : 반드시 알아야 함
     * parameter 여러개를 받을 때 : request.getParameterValues : 반드시 알아야 함
     * parameter 여러개의 이름만 받을 때 : request.getParameterNames : 알아도 되고 몰라도 됨
     * parameter를 Map으로 받을 때 : request.getParameterMap : 몰라도 됨
     * getParameter의 소괄호() 내부에는 html input type의 name 속성이 온다,
     * 예) <input type="text" name="txt"> ---> request.getParameter("txt");
     * getParameterNames : html input type의 name 속성들만 모아 놓는 메소드
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("name : " + request.getParameter("txt"));//text, password
		System.out.println("hidden : " + request.getParameter("hid"));//hidden
		System.out.println("season : " + request.getParameter("season"));//radio
		System.out.println("nation : " + request.getParameter("nation"));//단건 선택 select
		System.out.println("area : " + request.getParameter("area"));//textarea
		//System.out.println("fruit : " + request.getParameter("fruit"));
		//System.out.println("sports : " + request.getParameter("sports"));
		String [] fruits = request.getParameterValues("fruit");//checkbox
		String [] sports = request.getParameterValues("sports");//다건 선택 select
		System.out.println( Arrays.toString(fruits) );
		System.out.println( Arrays.toString(sports) );
		//Enumeration : data searching이 가능한 형태의 자료구조
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String tmp = names.nextElement();
			System.out.print(tmp + " : ");
			System.out.println(request.getParameter(tmp));
		}//while
		Map<String, String[]> map = request.getParameterMap();
		Set<String> set = map.keySet();//ketSet 메소드 : Map에서 name만 가지고 오는 메소드. 
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String tmp = iter.next();
			System.out.print(tmp + " : map : ");
			System.out.println( Arrays.toString( map.get(tmp) ));
		}
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}//class
