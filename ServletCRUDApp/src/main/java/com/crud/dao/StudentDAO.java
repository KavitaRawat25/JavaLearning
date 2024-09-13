package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.pojo.Student;
import com.crud.util.DBConnection;

public class StudentDAO {

	public StudentDAO() {

	}

	public int addStudent(Student stu) {
		int createStatus = 0;
		Connection con = DBConnection.getDBConnect();
		if (con != null) {
			try {
				String rollNo = stu.getRollNo(); 
				String name = stu.getName(); 
				String courseName = stu.getCourseName(); 
				String emailId = stu.getEmailId(); 
				String address = stu.getAddress();
				
				
				
				PreparedStatement preparedStatement = con.prepareStatement("insert into student values(?, ?, ?, ?, ?)");
				preparedStatement.setString(1, rollNo);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, courseName);
				preparedStatement.setString(4, emailId);
				preparedStatement.setString(5, address);

				createStatus = preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return createStatus;
	}
	
	public List<Student> readStudent() {
		List<Student> studentList = new ArrayList<Student>();
		Connection con = DBConnection.getDBConnect();
		if (con != null) {
			try {
				
				PreparedStatement preparedStatement = con.prepareStatement("select * from student");
				ResultSet result = preparedStatement.executeQuery();
				
				while(result.next()) {
					String rollNo = result.getString(1);
					String name = result.getString(2);
					String courseName = result.getString(3);
					String emailId = result.getString(4);
					String address =  result.getString(5);
					
					Student stu = new Student(rollNo, name, courseName, emailId, address);
					studentList.add(stu);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return studentList;
	}

	public static Student readStudentByRollNo(String rollNo) {
		Student stu = new Student();
		Connection con = DBConnection.getDBConnect();
		if (con != null) {
			try {

				PreparedStatement preparedStatement = con.prepareStatement("select * from student where rollno = ?");
				preparedStatement.setString(1, rollNo);

				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					stu.setRollNo(result.getString(1));
					stu.setName(result.getString(2));
					stu.setCourseName(result.getString(3));
					stu.setEmailId(result.getString(4));
					stu.setAddress(result.getString(5));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return stu;
	}

	public static int updateStudent(Student stu) {
		int updateStatus = 0;
		Connection con = DBConnection.getDBConnect();
		if (con != null) {
			try {
				
				PreparedStatement preparedStatement = con.prepareStatement("update student set name = ?, courseName = ?, emailId = ?, address = ? where rollno = ?");
				preparedStatement.setString(1, stu.getName());
				preparedStatement.setString(2, stu.getCourseName());
				preparedStatement.setString(3, stu.getEmailId());
				preparedStatement.setString(4, stu.getAddress());
				preparedStatement.setString(5, stu.getRollNo());

				updateStatus = preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		return updateStatus;
	}
	
	public static int delete(String rollNo){  
        int status=0; 
        try{  
        	Connection con = DBConnection.getDBConnect();
            PreparedStatement ps=con.prepareStatement("delete from student where rollno = ?");  
            ps.setString(1, rollNo);  
            status = ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){
        	e.printStackTrace();
        }  
          
        return status;  
	
	}
}
