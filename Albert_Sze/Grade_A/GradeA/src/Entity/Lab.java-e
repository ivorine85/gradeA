package Entity;

import Entity.Assistant;
import Entity.Student;


import java.sql.Time;
import java.util.ArrayList;

public class Lab {
	private String section;
	private int[] dates;
	private Time[] classtime;
	private Assistant teachAssist;
	private Assistant courseAssist;
	private ArrayList<Student> students;

	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int[] getDates() {
		return dates;
	}
	public void setDates(int[] dates) {
		this.dates = dates;
	}
	public Time[] getClasstime() {
		return classtime;
	}
	public void setClasstime(Time[] classtime) {
		this.classtime = classtime;
	}
	public Assistant getTeachAssist() {
		return teachAssist;
	}
	public void setTeachAssist(Assistant teachAssist) {
		this.teachAssist = teachAssist;
	}
	public Assistant getCourseAssist() {
		return courseAssist;
	}
	public void setCourseAssist(Assistant courseAssist) {
		this.courseAssist = courseAssist;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public Lab() {
		this.section = "None";
		this.dates = new int[7];
		this.classtime = new Time[2];
		this.teachAssist = new Assistant();
		this.courseAssist = new Assistant();
		this.students = new ArrayList<Student>(1);
	}
	public Lab(String section) {
		this.section = section;
		this.dates = new int[7];
		this.classtime = new Time[2];
		this.teachAssist = new Assistant();
		this.courseAssist = new Assistant();
		this.students = new ArrayList<Student>(1);
	}	
}
