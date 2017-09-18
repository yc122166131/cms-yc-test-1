package com.test1.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 只是作为 demo 进行测试 cross Domain
 */
public class CrossDomainDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrossDomainDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String flag = request.getParameter("cDflag");
			System.out.println(flag);
		
		
	}

}
