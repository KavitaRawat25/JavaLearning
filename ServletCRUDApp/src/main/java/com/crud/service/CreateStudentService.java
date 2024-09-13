package com.crud.service;


import com.crud.dao.StudentDAO;
import com.crud.pojo.Student;

public class CreateStudentService {

	public CreateStudentService() {
	}
	

	public int createStudent(Student stu) {
		
		StudentDAO studentDao = new StudentDAO();
		int createStatus = studentDao.addStudent(stu);
		
		return createStatus;
	}
	
}
