package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultCellEditor;
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
import java.awt.Color;
import java.sql.*;
import java.util.Map;

import javax.swing.JComboBox;
import entity.*;

public class AddStudents {

	private JFrame frame;
	private JTable table;
	private static String prevPage;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public static void ShowPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudents window = new AddStudents(prevPage);
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
	public AddStudents(String prevPage) {
		this.prevPage = prevPage;
		//connection = SqlConnection.dbConnector(); 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
/*********************************** for the purpose of this example ***********************************/
		Course newCourse = new Course ("CS591");												// Generate new course
		
		newCourse.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
		newCourse.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
		newCourse.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
/*******************************************************************************************************/
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 801, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Create Student
		String [] header={"Last Name","First Name","Student ID","Email","Year","Lab","Student Type"};
		String [][] data={{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"}};
		DefaultTableModel model = new DefaultTableModel(data,header);
		
		//Create Combo box for student type and labs
		// For the purpose of this example, but this should come from the labs section page
		JComboBox<String> labs = new JComboBox<String>();
		for (Map.Entry<String, Lab> entry : newCourse.getLabSections().entrySet()) {
			labs.addItem(entry.getKey());
		}
		
		JComboBox<String> studentType = new JComboBox<String>();
		studentType.addItem("Undergraduate");
		studentType.addItem("Graduate");
		
		// Label of window
		JLabel lblAddStudents = new JLabel("Add Students");
		lblAddStudents.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblAddStudents.setBounds(10, 11, 212, 44);
		frame.getContentPane().add(lblAddStudents);
		
		//Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prevPage == "CoursePage") {
					CoursePage changePage = new CoursePage(false);
					System.out.println(prevPage);
				}
				frame.dispose();
			}
		});
		btnCancel.setBounds(686, 414, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		//Finish Button
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid = true;
				for (int row = 0; row < table.getRowCount(); row++) {
					if ((table.getValueAt(row, 0)).toString().isEmpty()) {
						break;
					}
					try {
						Integer.parseInt(table.getValueAt(row, 4).toString());
					} catch (Exception e1) {
						valid = false;
						JOptionPane.showMessageDialog(null, "Make sure all year inputs are numbers");
					}
				}
				if (valid) {
					for (int row = 0; row < table.getRowCount(); row++) {
							if ((table.getValueAt(row, 0)).toString().isEmpty()) {
								break;
							}
							String name = table.getValueAt(row, 1).toString() + " " + table.getValueAt(row, 0).toString();
							String sid = table.getValueAt(row,2).toString();
							String email = table.getValueAt(row, 3).toString();
							int year = Integer.parseInt(table.getValueAt(row, 4).toString());
							String labSection = table.getValueAt(row, 5).toString();
							String studType = table.getValueAt(row, 6).toString();
							// bug below//
							if (studType.equals("Undergraduate")){
								newCourse.getLabSections().get(labSection).getStudents().get("undergrad").add(new Student(sid,name,studType,"None",email,year));
							}
							else {
								newCourse.getLabSections().get(labSection).getStudents().get("grad").add(new Student(sid,name,studType,"None",email,year));
							}
			
					}
					// return to proper frame
					if (prevPage == "CoursePage") {
						CoursePage changePage = new CoursePage(false);
						System.out.println(prevPage);
					}
					frame.dispose();
				}
			}
		});
		btnFinish.setBounds(587, 414, 89, 23);
		frame.getContentPane().add(btnFinish);
		
		//Add Student button
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] temp = {"","","","","","Select","Select"};
				model.addRow(temp);
			}
		});
		btnAddStudent.setBounds(457, 414, 120, 23);
		frame.getContentPane().add(btnAddStudent);
		
		//Add ScrollPanel for table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 78, 738, 325);
		frame.getContentPane().add(scrollPane);
				
		table = new JTable(model);
		scrollPane.setViewportView(table);
		TableColumn labcolumn = table.getColumnModel().getColumn(5);
		TableColumn studentTypecolumn = table.getColumnModel().getColumn(6);
		labcolumn.setCellEditor(new DefaultCellEditor(labs));
		studentTypecolumn.setCellEditor(new DefaultCellEditor(studentType));

	}
}
