import java.util.ArrayList;

public class Student {
	//private String fname;
	//private String lname;
	private String name; // new
	private String sid;
	//private String major;
	private String studentType;
	private int year;
	private String email;
	//private String labSection;
	private int grade;
	private ArrayList<Assignment> courseWork;
	
	public Student() {
		//this.fname = "None";
		//this.lname = "None";
		this.name = "None";
		this.sid = "None";
		//this.major = "None";
		this.studentType = "None";
		this.year = 0;
		this.email =  "None";
		//this.labSection =  "None";
		this.grade = 0;
		this.courseWork = new ArrayList<Assignment>(1);
	}
	
	public Student(String name,String sid,String major,String studentType, int year,String email,int grade) {
		//this.fname = fname;
		//this.lname = lname;
		this.name = name;
		this.sid = sid;
		//this.major = major;
		this.studentType = studentType;
		this.year = year;
		this.email =  email;
		//this.labSection =  labSection;
		this.grade = grade;
		this.courseWork = new ArrayList<Assignment>(1);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//public String getMajor() {
	//	return major;
	//}

	//public void setMajor(String major) {
	//	this.major = major;
	//}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//public String getLabSection() {
	//	return labSection;
	//}

	//public void setLabSection(String labSection) {
	//	this.labSection = labSection;
	//}

	//public String getFname() {
	//	return fname;
	//}

	//public void setFname(String fname) {
	//	this.fname = fname;
	//}

	//public String getLname() {
	//	return lname;
	//}

	//public void setLname(String lname) {
	//	this.lname = lname;
	//}

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
