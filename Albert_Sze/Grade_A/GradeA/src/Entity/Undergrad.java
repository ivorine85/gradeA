package Entity;

import Entity.Student;

public class Undergrad extends Student {
	private String major1;
	private String major2;
	private String minor;
	
	public Undergrad() {
		super();
		this.major1 = "None";
		this.major2 = "None";
		this.minor = "None";
	}
	
	public Undergrad(String name,String sid,String studentType,int year, String email,String labsection, int grade) {
//		super(name,sid,studentType,year,email,grade);
		this.major1 = "None";
		this.major2 = "None";
		this.minor = "None";
	}
	
	public Undergrad(String name,String sid,String studentType,int year, String email,String labsection, int grade,String major1,String major2,String minor) {
//		super(name,sid,studentType,year,email,grade);
		this.major1 = major1;
		this.major2 = major2;
		this.minor = minor;
	}

/*********************************** Getters and Setters ***********************************/	
	public String getMajor1() {
		return major1;
	}
	public void setMajor1(String major1) {
		this.major1 = major1;
	}
	public String getMajor2() {
		return major2;
	}
	public void setMajor2(String major2) {
		this.major2 = major2;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
}
