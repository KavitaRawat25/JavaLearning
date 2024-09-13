package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.handler.CrudHandler;

/**
 * Servlet implementation class CreateServletController
 */
public class CreateServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		CrudHandler crudHandler = new CrudHandler();
		int  createStatus=crudHandler.createStudent(request, response);
		PrintWriter out =response.getWriter();
		
		if(createStatus>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			out.print("<p>Record save successfully</p>");
			rd.include(request, response);
			
		}
		else
		{
			out.print("<html><body>");
			out.print("<p>Record could not saved !</p>");
			out.print("</body></html>");
		}	
		out.close();
	}

}
