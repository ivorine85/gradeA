package entity;


import java.sql.Time;
import java.util.HashMap;
import java.util.ArrayList;

public class Lab {
	private String section;
	private int[] dates;
	private Time[] classtime;
	private Assistant teachAssist;
	private Assistant courseAssist;
	private String courseName;
	String[] weekday;
	private HashMap<String, ArrayList<Student>> students;
	
	public Lab() {
		this.section = "None";
		this.dates = new int[7];
		this.classtime = new Time[2];
		this.teachAssist = new Assistant();
		this.courseAssist = new Assistant();
		this.students = new HashMap();
		students.put("undergrad", new ArrayList<Student>(0));
		students.put("grad", new ArrayList<Student>(0));	
	}
	public Lab(String section) {
		this.section = section;
		this.dates = new int[7];
		this.classtime = new Time[2];
		this.teachAssist = new Assistant();
		this.courseAssist = new Assistant();
		this.students = new HashMap();
		students.put("undergrad", new ArrayList<Student>(0));
		students.put("grad", new ArrayList<Student>(0));	
	}

	public Lab(String cname, Time startTime, Time endTime, String[] weekday){
		this.section = cname;
		this.classtime = new Time[2];
		this.classtime[0] = startTime;
		this.classtime[1] = endTime;
		this.weekday = weekday;
	}

	public String[] getWeekday() {
		return weekday;
	}

	public void setWeekday(String[] weekday) {
		this.weekday = weekday;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/*********************************** Getters and Setters ***********************************/

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
	public HashMap<String, ArrayList<Student>> getStudents() {
		return students;
	}
	public void setStudents(HashMap<String, ArrayList<Student>> students) {
		this.students = students;
	}
}
