import java.util.ArrayList;

public class Profile {
	private String username;
	private String password;
	private ArrayList<Course> courses;
	private String[] securityAnswers;
	private String[] securityQuestions;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public String[] getSecurityAnswers() {
		return securityAnswers;
	}

	public void setSecurityAnswers(String[] securityAnswers) {
		this.securityAnswers = securityAnswers;
	}

	public String[] getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(String[] securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public Profile() {
		this.username = "None";
		this.password = "None";
		
		this.securityAnswers = new String[3];
		this.securityQuestions = new String[3];
	}
	
	public Profile(String username, String password, String[] answers, String[] questions) {
		this.username = username;
		this.password = password;
		
		this.securityAnswers = answers;
		this.securityQuestions = questions;
	}
}
