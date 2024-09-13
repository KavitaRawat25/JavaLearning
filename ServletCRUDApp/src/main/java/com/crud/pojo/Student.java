package com.crud.pojo;

public class Student {

	private String rollNo;
	private String name;
	private String courseName;
	private String emailId;
	private String address;
	
	public Student() {
	}

	public Student(String rollNo, String name, String courseName, String emailId, String address) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.courseName = courseName;
		this.emailId = emailId;
		this.address = address;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", courseName=" + courseName + ", emailId=" + emailId
				+ ", address=" + address + "]";
	}

}
