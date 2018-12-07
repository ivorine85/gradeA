package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import dao.AssignmentDAO;
import dao.CourseDAO;
import dao.GradeBreakDownDAO;
import entity.*;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;


public class CoursePage {

	private JFrame frame;
	private JTable tableGradeBreakDown;
	private JTable tableStats;
	private static Course currentCourse;


	public static void ShowPage() {
	//public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//CoursePage window = new CoursePage(currentCourse);
					CoursePage window = new CoursePage(currentCourse);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private boolean CalcSum (JTable table) {
		for (int i = 0; i < table.getRowCount();i++) {
			double sum  = 0.0;
			for (int j = 1; j < table.getColumnCount(); j++) {
				sum += Double.parseDouble((String) table.getModel().getValueAt(i, j));
			}
			if (sum != 100.00) {
				return false;
			}
		}
		return true;
	}

	private String[][] doubleALtoA(ArrayList<ArrayList<String>> doubleArrayList){
		String[][] array = new String[doubleArrayList.size()][];
		for (int i = 0; i < doubleArrayList.size(); i++) {
		    ArrayList<String> row = doubleArrayList.get(i);
		    array[i] = row.toArray(new String[row.size()]);
		}
		return array;
	}

	public CoursePage(Course c) {
		currentCourse = c;
		initialize();

	}

	private void initialize() {
		////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
		//Load course information here
		//Course courseProfile = profile.getCourses().get(0);
		//////////////////////////////////////////////////////////////////////////////////////////////////
		ArrayList<String> header = new ArrayList<String>(0);
		ArrayList<String> arrayList1 = new ArrayList<String>(0);
		ArrayList<String> arrayList2 = new ArrayList<String>(0);
		ArrayList<ArrayList<String>> doubleArrayList = new ArrayList<ArrayList<String>>(0);
		DefaultTableModel model;
		DefaultTableModel assignStats;
		JLabel courseTitle;
		JScrollPane scrollGradeBreakDown;
		JScrollPane scrollAssignStat;
		JButton homeButton;
		JButton deleteButton;
		JButton editCourseButton;
		JButton addStudentButton;
		JButton addCourseworkButton;
		JButton addLabButton;
		JButton saveButton;
		Image homeImg;
		JLabel gradeBreakdownTitle;
		JLabel assignmentStatisticsTitle;
        Map<String,Double> getAvg = new HashMap<>();
        GradeBreakDownDAO gd = new GradeBreakDownDAO();
        //The getAvg score of each assignment
		//key : the name of assignment , value: the avgPoint;
        Map<String,Double[]> avgScore = gd.getPerformance(currentCourse.getCourseName());
        for(String key:avgScore.keySet()){
        	Double[] points = avgScore.get(key);
        	getAvg.put(key,points[0]/points[1]*100);

		}


		AssignmentDAO assignmentDAO = new AssignmentDAO();
		//The percentage of each hw1
		//key : the name of assignment
		//value: Float[] arr ,  arr[0] is the percent in gradPer , arr[1] is the percent in undergrad
		Map<String,Float[]> getPercentage = assignmentDAO.getPercentage(currentCourse.getCourseName());
		Map<String,Float[]> typePercentage = assignmentDAO.getTypePercentage(currentCourse.getCourseName());
		/*********************************** Generate Type Percentage tables ***********************************/
		header.add("");
		arrayList1.add("Undergraduate");
		arrayList2.add("Graduate");

		doubleArrayList.add(arrayList1);
		doubleArrayList.add(arrayList2);

		model = new DefaultTableModel (doubleALtoA(doubleArrayList),header.toArray()) {
			public boolean isCellEditable(int row, int col)
			{
			    //If you didn't want the first column to be editable
			    if(col == 0) {
			    	return false;
			    }
			    else {
			    	return true;
			    }
			}
		};

		/*********************************** Generate Assignment Average tables ***********************************/
		header = new ArrayList<String>(0);
		arrayList2 = new ArrayList<String>(0);
		doubleArrayList = new ArrayList<ArrayList<String>>(0);
		header.add("");
		arrayList2.add("Averages");

		//////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
//		for (Map.Entry<String, ArrayList<GradeBreakDown>> entry: courseProfile.getAssignmentBreakDown().entrySet()) {
//			for (int i = 0; i < entry.getValue().size(); i++) {
//				// Add individual assignment to header ex. HW1 HW2 Quiz1 Project1
//				header.add(entry.getKey() + Integer.toString(i+1));
//				// Add individual assignment averages ex. HW1 average HW2 average etc.
//				arrayList2.add(Double.toString(Math.round(entry.getValue().get(i).getAverage()*10000)/100));
//			}
//		}
		//////////////////////////////////////////////////////////////////////////////////////////////////
		doubleArrayList.add(arrayList2);

		assignStats = new DefaultTableModel (doubleALtoA(doubleArrayList),header.toArray()) {
			public boolean isCellEditable(int row, int col)
			{
			    return false;
			}
		};

		/*********************************** Generate Frame  ***********************************/
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 801, 487);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		/*********************************** Add Course Title ***********************************/
		//////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
		// Change courseProfile.getCourseName() to the current course name
		courseTitle = new JLabel( " Grades");
		//////////////////////////////////////////////////////////////////////////////////////////////////
		//lblCourseTitle.setText(courseProfile.getCourseName() + " Grades");
		courseTitle.setFont(new Font("Tahoma", Font.PLAIN, 34));
		courseTitle.setBounds(10, 11, 349, 47);
		this.frame.getContentPane().add(courseTitle);

		/*********************************** Add Scroll Panel ***********************************/
		scrollGradeBreakDown = new JScrollPane();
		scrollGradeBreakDown.setBounds(125, 270, 543, 55);
		this.frame.getContentPane().add(scrollGradeBreakDown);

		tableGradeBreakDown = new JTable(model);
		scrollGradeBreakDown.setViewportView(tableGradeBreakDown);

		/*********************************** Add home button ***********************************/
		homeButton = new JButton("");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (CalcSum(tableGradeBreakDown)) {
					Dashboard dashboardPage = new Dashboard();
					//dashboardPage.ShowPage(currentCourse.getCourseName());
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Percentages do not add up to 100%, please try again.");;
				}
			}
		});
		homeImg = new ImageIcon(this.getClass().getResource("home_icon.png")).getImage();
		homeButton.setIcon(new ImageIcon(homeImg));
		homeButton.setBounds(10, 383, 55, 54);
		this.frame.getContentPane().add(homeButton);

		/*********************************** Add delete button ***********************************/
		deleteButton = new JButton("");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				//////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
				// change courseProfile.getCourseName() to current cousrse name
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this " + currentCourse.getCourseName() + "?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					// Need to add deleting of course here
					System.out.println("delete course");
					CourseDAO cd = new CourseDAO();
					cd.deleteCourse(currentCourse.getCourseName());
					Dashboard dashboardPage = new Dashboard();
					//dashboardPage.ShowPage();
					frame.dispose();
				}
				//////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		Image trashImg = new ImageIcon(this.getClass().getResource("trash_icon.png")).getImage();
		deleteButton.setIcon(new ImageIcon(trashImg));
		deleteButton.setBounds(71, 383, 55, 54);
		this.frame.getContentPane().add(deleteButton);

		/*********************************** Add edit button ***********************************/
		editCourseButton = new JButton("Edit Course");
		editCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CalcSum(tableGradeBreakDown)) {
					//EditCourse editCoursePage = new EditCourse();
					//editCoursePage.ShowPage();
					//frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Percentages do not add up to 100%, please try again.");;
				}
			}
		});
		editCourseButton.setBounds(672, 414, 103, 23);
		this.frame.getContentPane().add(editCourseButton);

		/*********************************** Add edit button ***********************************/
		addStudentButton = new JButton("Add Student");
		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CalcSum(tableGradeBreakDown)) {
					//////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
					// change currentCourse.getCourseName()-represents the current course's name you are looking at
					// DON'T CHANGE "CoursePage" this allows for AddStudent to know the previous page
					AddStudents addStudentsPage = new AddStudents("CoursePage",currentCourse);
					//////////////////////////////////////////////////////////////////////////////////////////////////
					addStudentsPage.ShowPage();
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Percentages do not add up to 100%, please try again.");;
				}
			}
		});
		addStudentButton.setBounds(424, 414, 103, 23);
		this.frame.getContentPane().add(addStudentButton);

		/*********************************** Add Coursework button ***********************************/
		addCourseworkButton = new JButton("Add Coursework");
		addCourseworkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CalcSum(tableGradeBreakDown)) {
					//AddCoursework addCourseWorkPage = new AddCoursework(currentCourse);
					//addCourseWorkPage.ShowPage();
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Percentages do not add up to 100%, please try again.");;
				}
			}
		});
		addCourseworkButton.setBounds(531, 414, 137, 23);
		this.frame.getContentPane().add(addCourseworkButton);

		/*********************************** Add Lab button ***********************************/
		addLabButton = new JButton("Add Lab");
//		btnAddLab.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (CalcSum(tableGradeBreakDown)) {
//					LabInfo labInfoPage = null;
//					try {
//						labInfoPage = new LabInfo("CoursePage",newCourse.getCourseName());
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//					}
//					labInfoPage.ShowPage();
//					frame.dispose();
//				}
//				else {
//					JOptionPane.showMessageDialog(frame, "Percentages do not add up to 100%, please try again.");;
//				}
//			}
//		});
		addLabButton.setBounds(332, 414, 89, 23);
		this.frame.getContentPane().add(addLabButton);
		
		/***********************************  Update button ***********************************/
		saveButton = new JButton("Save");
		saveButton.setEnabled(false);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
				// update data base with information
				saveButton.setEnabled(false);
				//////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		saveButton.setBounds(238, 414, 89, 23);
		frame.getContentPane().add(saveButton);
		
		/*********************************** Grade Breakdown Label ***********************************/
		gradeBreakdownTitle = new JLabel("Grade Breakdown %");
		gradeBreakdownTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		gradeBreakdownTitle.setBounds(270, 230, 252, 29);
		this.frame.getContentPane().add(gradeBreakdownTitle);

		/*********************************** Assignments Statistics Label ***********************************/
		assignmentStatisticsTitle = new JLabel("Assignment Statistics");
		assignmentStatisticsTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		assignmentStatisticsTitle.setBounds(270, 109, 252, 29);
		this.frame.getContentPane().add(assignmentStatisticsTitle);

		/*********************************** Add scroll panel for assignment stats table ***********************************/
		scrollAssignStat = new JScrollPane();
		scrollAssignStat.setBounds(125, 139, 549, 39);
		this.frame.getContentPane().add(scrollAssignStat);

		tableStats = new JTable(assignStats);
		scrollAssignStat.setViewportView(tableStats);
		
		/************************************ Detects when value is changed in tableGrades ****************************************/
		tableGradeBreakDown.getModel().addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e){
				try{
					int row = e.getFirstRow();
					int col = e.getColumn();
					int edit = Integer.parseInt((String)tableGradeBreakDown.getValueAt(row, col));
					if (CalcSum(tableGradeBreakDown)) {
						saveButton.setEnabled(true);
					}
				} catch (NumberFormatException nfe) {
					saveButton.setEnabled(false);
					//JOptionPane.showMessageDialog(null,"not valid edit");
				}
			}
		});
	}
}
