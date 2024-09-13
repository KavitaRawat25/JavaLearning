package com.crud.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crud.pojo.Student;
import com.crud.service.CreateStudentService;
import com.crud.service.ReadStudentService;


public class CrudHandler {

	public CrudHandler() {
	}

	public int createStudent(HttpServletRequest request, HttpServletResponse response) {
		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String courseName = request.getParameter("courseName");
		String emailId = request.getParameter("emailId");		
		String address = request.getParameter("address");
		
		Student stu = new Student(rollNo, name, courseName, emailId, address);
		
		CreateStudentService createStudentService = new CreateStudentService();		
		int createStatus = createStudentService.createStudent(stu);
		
		return createStatus;
	}
	
	public void readStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ReadStudentService readStudentService = new ReadStudentService();
		List<Student> studentList = readStudentService.readStudentDetails();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Employees List</h1>");

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr> <th>Roll No</th> <th>Name</th> <th>Course Name</th> <th>Email Id</th> <th>Address</th>  <th>Edit</th><th>Delete</th> </tr>");

		for (Student stu : studentList) {
			out.print("<tr><td>" + stu.getRollNo() + "</td><td>" + stu.getName() + "</td><td>"
					+ stu.getCourseName() + "</td><td>" + stu.getEmailId() + "</td><td>" + stu.getAddress()
					+ "</td><td><a href='UpdateServletController?rollNo=" + stu.getRollNo() + "'>Edit</a>"
					+ "</td><td><a href='DeleteServletController?rollNo=" + stu.getRollNo() + "'>Delete</a></td>");
		}
		out.print("</table>");
		out.println("<a href='index.html'>Back</a>");
		out.close();
	}
	
	/*public void readStudentByRollNo(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String rollNo = request.getQueryString();
		ReadStudentService readStudentService = new ReadStudentService();
		Student student = readStudentService.readStudentDetailsByRollNo(rollNo);

	}*/
	
	
		
		

}
