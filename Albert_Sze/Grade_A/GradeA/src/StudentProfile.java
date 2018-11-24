import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import Entity.*;

public class StudentProfile extends Adjustments {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentProfile window = new StudentProfile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// Create connection to sql database
	// Connection connection = null;
	/**
	 * Create the application.
	 */
	public StudentProfile() {
		//connection = SqlConnection.dbConnector(); 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
/*********************************** for the purpose of this example ***********************************/
		Course newCourse = new Course ("CS591");												// Generate new course
		newCourse.getCourseBreakDown().put("HW", new GradeBreakDown("HW", .5, .5, 0, 0,0.0, 1));
		newCourse.getCourseBreakDown().put("Exam", new GradeBreakDown("Exam", .5, .5, 0, 0,0.0, 1));
		newCourse.getAssignmentBreakDown().put("hw", new ArrayList<GradeBreakDown>(0));
		newCourse.getAssignmentBreakDown().put("exam", new ArrayList<GradeBreakDown>(0));
		newCourse.getAssignmentBreakDown().get("hw").add(new GradeBreakDown("HW", 1.0, 1.0, 0, 103,0.54, 1));
		newCourse.getAssignmentBreakDown().get("exam").add(new GradeBreakDown("Exam", 1, 1, 0, 100,0.80, 1));
		
		newCourse.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
		newCourse.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
		newCourse.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
		newCourse.getLabSections().get("A1").getStudents().put("undergrad", new ArrayList<Student>(0));
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").add(new Student("U1","Albert Sze","undergrad","None","yup@gmail",2018));
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("HW", 3, 103, 0));
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).setGrade(.955);
		newCourse.getLabSections().get("A2").getStudents().put("grad", new ArrayList<Student>(0));
		newCourse.getLabSections().get("A2").getStudents().get("grad").add(new Student("U1","Albert Sze","grad","None","yup@gmail",2018));
		newCourse.getLabSections().get("A2").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("HW", 10, 103, 0));
		newCourse.getLabSections().get("A2").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
		newCourse.getLabSections().get("A2").getStudents().get("grad").get(0).setGrade(.80);
		Lab labSection =newCourse.getLabSections().get("A2");
		Student studentProfile = labSection.getStudents().get("grad").get(0);
/*******************************************************************************************************/
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 801, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Create header
		ArrayList<ArrayList<String>> allAssignData = new ArrayList<ArrayList<String>>(0);
		HashMap<String, Integer> assignCount = new HashMap<String, Integer>(0);
		double sum = 0.0;
		//for this example
		ArrayList<String> assignments;
		
		
		String[] header = {"Assignment","Points Lost","Total Points Available","Percentage","Class Average"};
		for (Map.Entry<String, GradeBreakDown> entry : newCourse.getCourseBreakDown().entrySet()) {
			assignCount.put(entry.getKey(),entry.getValue().getNumAssign()-1);
		}
		
				
		for (int i = 0; i < studentProfile.getCourseWork().size();i++) {
			assignments = new ArrayList<String>(0);
			int j = newCourse.getCourseBreakDown().get(studentProfile.getCourseWork().get(i).getType()).getNumAssign()-assignCount.get(studentProfile.getCourseWork().get(i).getType());
			assignCount.put(studentProfile.getCourseWork().get(i).getType(), assignCount.get(studentProfile.getCourseWork().get(i).getType())-1);
			assignments.add(studentProfile.getCourseWork().get(i).getType() + " " + Integer.toString(j));
			assignments.add(Integer.toString(studentProfile.getCourseWork().get(i).getPtsLost()));
			//assignments.add("");
			//System.out.println(newCourse.getAssignmentBreakDown().get(studentProfile.getCourseWork().get(i).getType().toLowerCase()));
			assignments.add(Integer.toString(newCourse.getAssignmentBreakDown().get(studentProfile.getCourseWork().get(i).getType().toLowerCase()).get(j-1).getTotalPoints()));
			assignments.add(Double.toString((double)Math.round(studentProfile.getCourseWork().get(i).getPercent()*10000)/100));
			//assignments.add("");
			assignments.add(Double.toString((double)Math.round(newCourse.getAssignmentBreakDown().get(studentProfile.getCourseWork().get(i).getType().toLowerCase()).get(j-1).getAverage()*10000)/100));
			allAssignData.add(assignments);
		}
		
		String[][] array = new String[allAssignData.size()][];
		for (int i = 0; i < allAssignData.size(); i++) {
		    ArrayList<String> row = allAssignData.get(i);
		    array[i] = row.toArray(new String[row.size()]);
		}
		
		String [][] data={{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"}};
		DefaultTableModel model = new DefaultTableModel (array,header) {
			public boolean isCellEditable(int row, int col)
			{
			    //If you didn't want the first column to be editable
			    if(col == 1) {
			    	return false;
			    }
			    else {
			    	return true;
			    }
			}
		};
		
		// Label of window
		JLabel lblStudentName = new JLabel("Student's Name");
		lblStudentName.setText(studentProfile.getName());
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblStudentName.setBounds(188, 11, 338, 44);
		frame.getContentPane().add(lblStudentName);
		
		//Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JLabel lblGrade = new JLabel("grade");
		lblGrade.setText(Double.toString((double)Math.round(studentProfile.getGrade()*10000)/100) + "%");
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGrade.setBounds(188, 68, 152, 35);
		frame.getContentPane().add(lblGrade);
		
		JLabel lblGraduatingYear = new JLabel("Graduating Year");
		lblGraduatingYear.setText("Graduating Year: " + Integer.toString(studentProfile.getYear()));
		lblGraduatingYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGraduatingYear.setBounds(25, 125, 160, 19);
		frame.getContentPane().add(lblGraduatingYear);
		
		JLabel lblLab = new JLabel("Lab: ");
		lblLab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLab.setBounds(25, 155, 46, 14);
		frame.getContentPane().add(lblLab);
		btnCancel.setBounds(686, 414, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		//Finish Button
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// return to proper frame
				frame.dispose();
			}
		});
		btnFinish.setBounds(587, 414, 89, 23);
		frame.getContentPane().add(btnFinish);
		
		//Add ScrollPanel for table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 180, 738, 206);
		frame.getContentPane().add(scrollPane);
				
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		for (Map.Entry<String, Lab> entry : newCourse.getLabSections().entrySet()) {
			comboBox.addItem(entry.getKey());
			comboBox.setSelectedItem(labSection.getSection());
		}
		comboBox.setBounds(60, 155, 74, 23);
		frame.getContentPane().add(comboBox);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeleteStudent.setBounds(657, 11, 118, 23);
		frame.getContentPane().add(btnDeleteStudent);
		
		JLabel lblProfileImg = new JLabel("");
		Image profileImg = new ImageIcon(this.getClass().getResource("/default_profile.png")).getImage();
		lblProfileImg.setIcon(new ImageIcon(profileImg));
		lblProfileImg.setBounds(25, 11, 109, 113);
		frame.getContentPane().add(lblProfileImg);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Image homeImg = new ImageIcon(this.getClass().getResource("/home_icon.png")).getImage();
		btnHome.setIcon(new ImageIcon(homeImg));
		btnHome.setBounds(10, 391, 55, 54);
		frame.getContentPane().add(btnHome);

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
