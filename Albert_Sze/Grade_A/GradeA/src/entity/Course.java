package entity;


import java.util.HashMap;
import java.util.ArrayList;
import java.sql.*;

public class Course {
	private int courseId;
	private String courseName;
	private Time[] classTime;
	private java.sql.Date[] classDuration;
	private String[] weekDay;
	private ArrayList<Assistant> teachAssist;
	private ArrayList<Assistant> courseAssist;
	private HashMap<String, Lab> labSections;
	private HashMap<String, GradeBreakDown> courseBreakDown;
	private HashMap<String, ArrayList<GradeBreakDown>> assignmentBreakDown;
	private HashMap<String, Double> gradeRanges;

	public Course() {
		this.courseId = 0;
		this.courseName = "None";
		this.classTime = new Time[2];
		this.classDuration = new java.sql.Date[2];
		this.teachAssist = new ArrayList<Assistant>(1);
		this.courseAssist = new ArrayList<Assistant>(1);
		this.labSections = new HashMap();
		this.courseBreakDown = new HashMap();
		this.assignmentBreakDown = new HashMap();
		this.gradeRanges = new HashMap(5);
	}
	
	public Course(String courseName) {
		this.courseId = 0;
		this.courseName = courseName;
		this.classTime = new Time[2];
		this.classDuration = new java.sql.Date[2];
		this.teachAssist = new ArrayList<Assistant>(1);
		this.courseAssist = new ArrayList<Assistant>(1);
		this.labSections = new HashMap(0);
		this.courseBreakDown = new HashMap();
		this.assignmentBreakDown = new HashMap();
		this.gradeRanges = new HashMap(5);
		this.gradeRanges.put("A", .90);
		this.gradeRanges.put("B", .80);
		this.gradeRanges.put("C", .70);
		this.gradeRanges.put("D", .60);
		this.gradeRanges.put("E", .50);
	}

	public Course(String cname, Time startTime, Time endTime, java.sql.Date startDate, java.sql.Date endDate, String[] weekday){
		this.courseName = cname;
		this.classTime = new Time[2];
		this.classTime[0] = startTime;
		this.classTime[1] = endTime;
		this.classDuration = new java.sql.Date[2];
		this.classDuration[0] = startDate;
		this.classDuration[1] = endDate;
		this.weekDay = weekday;
		this.teachAssist = new ArrayList<Assistant>(1);
		this.courseAssist = new ArrayList<Assistant>(1);
		this.labSections = new HashMap(0);
		this.courseBreakDown = new HashMap();
		this.assignmentBreakDown = new HashMap();
		this.gradeRanges = new HashMap(5);
		this.gradeRanges.put("A", .90);
		this.gradeRanges.put("B", .80);
		this.gradeRanges.put("C", .70);
		this.gradeRanges.put("D", .60);
		this.gradeRanges.put("E", .50);
	}


/*********************************** Getters and Setters ***********************************/	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Time[] getClassTime() {
		return classTime;
	}

	public void setClassTime(Time[] classTime) {
		this.classTime = classTime;
	}

	public java.sql.Date[] getClassDuration() {
		return classDuration;
	}

	public void setClassDuration(java.sql.Date[] classDuration) {
		this.classDuration = classDuration;
	}

	public ArrayList<Assistant> getTeachAssist() {
		return teachAssist;
	}

	public void setTeachAssist(ArrayList<Assistant> teachAssist) {
		this.teachAssist = teachAssist;
	}

	public ArrayList<Assistant> getCourseAssist() {
		return courseAssist;
	}

	public void setCourseAssist(ArrayList<Assistant> courseAssist) {
		this.courseAssist = courseAssist;
	}

	public HashMap<String, Lab> getLabSections() {
		return labSections;
	}

	public void setLabSections(HashMap<String, Lab> labSections) {
		this.labSections = labSections;
	}

	public HashMap<String, GradeBreakDown> getCourseBreakDown() {
		return courseBreakDown;
	}

	public void setCourseBreakDown(HashMap<String, GradeBreakDown> courseBreakDown) {
		this.courseBreakDown = courseBreakDown;
	}
	
	public HashMap<String, ArrayList<GradeBreakDown>> getAssignmentBreakDown() {
		return assignmentBreakDown;
	}

	public void setAssignmentBreakDown(HashMap<String, ArrayList<GradeBreakDown>> assignmentBreakDown) {
		this.assignmentBreakDown = assignmentBreakDown;
	}

	public HashMap<String, Double> getGradeRanges() {
		return gradeRanges;
	}

	public void setGradeRanges(HashMap<String, Double> gradeRanges) {
		this.gradeRanges = gradeRanges;
	}
	
	public String[] getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String[] weekDay) {
		this.weekDay = weekDay;
	}
}
