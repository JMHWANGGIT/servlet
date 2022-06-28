package servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RE09")
public class RE09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RE09() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getParameter("html input의 name 속성");
//		request.getParameter로는 다건 value를 받을 수 없다. 		
//		request.getParameterValues("html input의 name 속성");
//		request.getParameterValues로 다건 value를 받을 수 있다. 		
//		request.getParameterNames();
		String id = request.getParameter("mid"); //value가 단건 
		String pwd = request.getParameter("mpwd"); //value가 단건 
		String fruit = request.getParameter("fruit"); //value가 다건 
		System.out.println(id + " : " + pwd + " : " + fruit);
		
		String[] fruitArr = request.getParameterValues("fruit");
		System.out.println( Arrays.toString(fruitArr));
		
		Enumeration<String> fruitsEnum = request.getParameterNames();
		while(fruitsEnum.hasMoreElements()) {
			String tmp = fruitsEnum.nextElement();
			System.out.println(tmp + " : ");
			System.out.println(request.getParameter(tmp));
		}//while
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
