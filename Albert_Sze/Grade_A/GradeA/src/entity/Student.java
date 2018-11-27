package entity;

import java.util.ArrayList;

public class Student {
	private String name; // new
	private String sid;
	private String studentType;
	private String pohtoPath;
	private int year;
	private String email;
	private double grade;
	private ArrayList<Assignment> courseWork;
	
	public Student() {
		this.name = "None";
		this.sid = "None";
		this.studentType = "None";
		this.year = 0;
		this.email =  "None";
		this.grade = 0.0;
		this.courseWork = new ArrayList<Assignment>(1);
	}

	public Student(String sid,String name,String studentType,String photoPath,String email,int year) {
		this.name = name;
		this.sid = sid;
		this.studentType = studentType;
		this.year = year;
		this.email =  email;
		this.courseWork = new ArrayList<Assignment>(1);
		this.pohtoPath = photoPath;
	}

/*********************************** Getters and Setters ***********************************/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPohtoPath() {
		return pohtoPath;
	}

	public void setPohtoPath(String pohtoPath) {
		this.pohtoPath = pohtoPath;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<Assignment> getCourseWork() {
		return courseWork;
	}

	public void setCourseWork(ArrayList<Assignment> courseWork) {
		this.courseWork = courseWork;
	}
	
}
