package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.aq.AQDequeueOptions;


@WebServlet("/SelectEmp11")
public class SelectEmp11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public SelectEmp11() {
        super();
        // TODO Auto-generated constructor stub
    }
    //DAO : data access object : db 접속을 담당하는 java class : servlet 아니어도 된다.
    private SelectEmp11DAO dao;
    public void init() throws ServletException {
    	super.init();
    	dao = new SelectEmp11DAO();
    }//init - 최초의 1번만 수행 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		﻿dao.selectEmp();
		
	}//doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
