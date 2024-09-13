package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crud.dao.StudentDAO;
import com.crud.pojo.Student;

/**
 * Servlet implementation class UpdateServletController
 */
public class UpdateServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String rollNo = request.getParameter("rollNo");
		Student stu = StudentDAO.readStudentByRollNo(rollNo);
		out.print("<form action='UpdateServletController' method='post'>");
		out.print("<table>");
		out.print(
				"<tr><td>Roll No : </td><td><input type='text' name='rollNo' value='" + stu.getRollNo() + "'/></td></tr>");
		out.print("<tr><td>Name : </td><td><input type='text' name='name' value='" + stu.getName() + "'/></td></tr>");
		out.print("<tr><td>Course Name : </td><td><input type='text' name='courseName' value='" + stu.getCourseName()
				+ "'/>  </td></tr>");
		out.print("<tr><td>Email Id :</td><td><input type='email' name='emailId' value='" + stu.getEmailId()
				+ "'/></td></tr>");
		out.print("<tr><td>Address : </td><td><input type='text' name='address' value='" + stu.getAddress()
				+ "'/></td></tr>");
		out.print("<tr><td ><input type='submit' value='Save'/></td> <td><a href='ReadServletController'>Back</a></td> </tr>");
		out.print("</table>");
		out.print("</form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String rolNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String courseName = request.getParameter("courseName");
		String emailId = request.getParameter("emailId");
		String address = request.getParameter("address");
		Student stu = new Student();

		stu.setRollNo(rolNo);
		stu.setName(name);
		stu.setCourseName(courseName);
		stu.setEmailId(emailId);
		stu.setAddress(address);
		int updateStatus = StudentDAO.updateStudent(stu);
		
		if (updateStatus > 0) {
			RequestDispatcher rs=request.getRequestDispatcher("ReadServletController");
        	out.print("<p>Record updated successfully !</p>");
        	rs.include(request, response);
		} else {
			RequestDispatcher rs=request.getRequestDispatcher("ReadServletController");
			out.print("<p>Record not updated !</p>");
        	rs.include(request, response);
		}
		
		out.close();
	}
}
		
	


