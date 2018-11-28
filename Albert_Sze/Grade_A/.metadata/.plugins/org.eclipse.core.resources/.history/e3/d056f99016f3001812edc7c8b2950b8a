package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoursePage {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoursePage window = new CoursePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoursePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 801, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCourseTitle = new JLabel("Course Title");
		lblCourseTitle.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblCourseTitle.setBounds(10, 11, 349, 47);
		frame.getContentPane().add(lblCourseTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 261, 543, 97);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHome.setBounds(10, 383, 55, 54);
		frame.getContentPane().add(btnHome);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(71, 383, 55, 54);
		frame.getContentPane().add(btnDelete);
		
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditCourse.setBounds(686, 414, 89, 23);
		frame.getContentPane().add(btnEditCourse);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddStudent.setBounds(474, 414, 93, 23);
		frame.getContentPane().add(btnAddStudent);
		
		JButton btnAddCoursework = new JButton("Add Coursework");
		btnAddCoursework.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCoursework.setBounds(570, 414, 111, 23);
		frame.getContentPane().add(btnAddCoursework);
		
		JButton btnAddLab = new JButton("Add Lab");
		btnAddLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddLab.setBounds(380, 414, 89, 23);
		frame.getContentPane().add(btnAddLab);
		
		JLabel lblGradeBreakdown = new JLabel("Grade Breakdown %");
		lblGradeBreakdown.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGradeBreakdown.setBounds(289, 221, 252, 29);
		frame.getContentPane().add(lblGradeBreakdown);
	}
}
