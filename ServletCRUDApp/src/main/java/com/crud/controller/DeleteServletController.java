package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.StudentDAO;
import com.crud.util.DBConnection;

//import com.crud.handler.CrudHandler;

/**
 * Servlet implementation class DeleteServletController
 */
public class DeleteServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter();
		String rollNo = request.getParameter("rollNo");   
        int status = StudentDAO.delete(rollNo); 
        
        if(status>0) {
        	RequestDispatcher rs=request.getRequestDispatcher("ReadServletController");
        	out.print("<p>Record deleted successfully !</p>");
        	rs.include(request, response);
        } else {
        	RequestDispatcher rs=request.getRequestDispatcher("ReadServletController");
        	out.print("<p>Record not deleted !</p>");
        	rs.include(request, response);
        }
        out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//CrudHandler crudHandler = new CrudHandler();
		//crudHandler.deleteStudent(request,response);
	}

}
