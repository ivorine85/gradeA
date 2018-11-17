import java.util.ArrayList;
import java.util.*; 

public class Course {
	private String courseName;
	private int[] dates;
	private Time[] classTime;
	private Date[] classDuration;
	private ArrayList<Assistant> teachAssist;
	private ArrayList<Assistant> courseAssist;
	private ArrayList<Lab> labSections;
	private Hashtable<String, GradeBreakDown> underGradCW;
	private Hashtable<String, GradeBreakDown> gradCW;
	private Hashtable<String, Double> gradeRanges;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int[] getDates() {
		return dates;
	}

	public void setDates(int[] dates) {
		this.dates = dates;
	}

	public Time[] getClassTime() {
		return classTime;
	}

	public void setClassTime(Time[] classTime) {
		this.classTime = classTime;
	}

	public Date[] getClassDuration() {
		return classDuration;
	}

	public void setClassDuration(Date[] classDuration) {
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

	public ArrayList<Lab> getLabSections() {
		return labSections;
	}

	public void setLabSections(ArrayList<Lab> labSections) {
		this.labSections = labSections;
	}

	public Hashtable<String, GradeBreakDown> getUnderGradCW() {
		return underGradCW;
	}

	public void setUnderGradCW(Hashtable<String, GradeBreakDown> underGradCW) {
		this.underGradCW = underGradCW;
	}

	public Hashtable<String, GradeBreakDown> getGradCW() {
		return gradCW;
	}

	public void setGradCW(Hashtable<String, GradeBreakDown> gradCW) {
		this.gradCW = gradCW;
	}

	public Hashtable<String, Double> getGradeRanges() {
		return gradeRanges;
	}

	public void setGradeRanges(Hashtable<String, Double> gradeRanges) {
		this.gradeRanges = gradeRanges;
	}

	public Course () {
		this.courseName = "None";
		this.dates = new int[7];
		this.classTime = new Time[2];
		this.classDuration = new Date[2];
		this.teachAssist = new ArrayList<Assistant>(1);
		this.courseAssist = new ArrayList<Assistant>(1);
		this.labSections = new ArrayList<Lab>(1);
		this.underGradCW = new Hashtable();
		this.gradCW = new Hashtable();
		this.gradeRanges = new Hashtable(5);
	}
	
	public Course (String courseName) {
		this.courseName = courseName;
		this.dates = new int[7];
		this.classTime = new Time[2];
		this.classDuration = new Date[2];
		this.teachAssist = new ArrayList<Assistant>(1);
		this.courseAssist = new ArrayList<Assistant>(1);
		this.labSections = new ArrayList<Lab>(1);
		this.underGradCW = new Hashtable();
		this.gradCW = new Hashtable();
		this.gradeRanges = new Hashtable(5);
	}	
}
