package com.crud.service;

import java.util.List;

import com.crud.dao.StudentDAO;
import com.crud.pojo.Student;

public class ReadStudentService {

	public ReadStudentService() {
	}
	
	public List<Student> readStudentDetails() {
		
		StudentDAO studentDAO = new StudentDAO();
		List<Student> studentList = studentDAO.readStudent();
		
		return studentList;
	}
}
