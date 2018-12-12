package gui;

import dao.AssignmentDAO;
import dao.GradeBreakDownDAO;
import dao.StudentDAO;
import entity.Assignment;
import entity.Course;
import entity.GradeBreakDown;
import entity.Student;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class AddCoursework {

    private JFrame frame;
    private JTextField textFieldTotalPoints;
    private JLabel lblCourseInfo;
    private static Course currentCourse;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCoursework window = new AddCoursework(currentCourse);
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
    public AddCoursework(Course course) {
        currentCourse = course;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblLabInfo = new JLabel("Add Coursework");
        lblLabInfo.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblLabInfo.setBounds(30, 20, 300, 44);
        frame.getContentPane().add(lblLabInfo);

        JLabel lblStartType = new JLabel("Type");
        lblStartType.setBounds(150, 150, 100, 14);
        frame.getContentPane().add(lblStartType);

        JComboBox<String> comboBoxType = new JComboBox<String>();
        comboBoxType.addItem("Homework");
        comboBoxType.addItem("Quiz");
        comboBoxType.addItem("Project");
        comboBoxType.addItem("Midterm");
        comboBoxType.addItem("Final");
        comboBoxType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxType.setBounds(150, 180, 175, 20);
        frame.getContentPane().add(comboBoxType);


        JLabel lblTotalPoints = new JLabel("Total Points");
        lblTotalPoints.setBounds(375, 150, 100, 14);
        frame.getContentPane().add(lblTotalPoints);

        textFieldTotalPoints = new JTextField();
        textFieldTotalPoints.setBounds(375, 180, 50, 20);
        frame.getContentPane().add(textFieldTotalPoints);
        textFieldTotalPoints.setColumns(10);

//        JLabel lblPhone = new JLabel("Phone #");
//        lblPhone.setBounds(65, 88, 46, 14);
//        frame.getContentPane().add(lblPhone);
//
//        textField_1 = new JTextField();
//        textField_1.setBounds(128, 85, 86, 20);
//        frame.getContentPane().add(textField_1);
//        textField_1.setColumns(10);
//
//        JLabel lblEmailId = new JLabel("Email Id");
//        lblEmailId.setBounds(65, 135, 46, 14);
//        frame.getContentPane().add(lblEmailId);
//
//        textField_2 = new JTextField();
//        textField_2.setBounds(128, 132, 247, 17);
//        frame.getContentPane().add(textField_2);
//        textField_2.setColumns(10);
//
//        JLabel lblAddress = new JLabel("Address");
//        lblAddress.setBounds(65, 182, 46, 14);
//        frame.getContentPane().add(lblAddress);
//
//        JTextArea textArea_1 = new JTextArea();
//        textArea_1.setBounds(126, 177, 212, 40);
//        frame.getContentPane().add(textArea_1);


        JButton btnCancel = new JButton("Cancel");

        btnCancel.setBounds(800, 410, 89, 23);
        frame.getContentPane().add(btnCancel);


        JButton btnAdd = new JButton("Add");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnAdd.setBounds(900, 410, 89, 23);
        frame.getContentPane().add(btnAdd);


        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textFieldTotalPoints.getText().isEmpty()||(comboBoxType.getSelectedItem().equals("Select")))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else{
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                    int total = Integer.valueOf(textFieldTotalPoints.getText());
                    String type = comboBoxType.getSelectedItem().toString();
                    if (type == "Homework"){
                        type = "hw";
                    }
                    else{
                        type = type.toLowerCase();
                    }
                    AssignmentDAO assignmentDAO = new AssignmentDAO();
                    String cwname = assignmentDAO.addAssignmentToCourse(type,currentCourse.getCourseName(),total);
                    CoursePage changePage = new CoursePage(currentCourse);
                    StudentDAO studentDAO = new StudentDAO();
                    java.util.List<Student> allStudents = studentDAO.findStudentByCourse(currentCourse.getCourseName());
                    GradeBreakDownDAO gradeBreakDownDAO = new GradeBreakDownDAO();
                    for(Student s:allStudents){
                        GradeBreakDown newGrade = new GradeBreakDown(cwname,currentCourse.getCourseName(),0,0,type,0,0,0);
                        gradeBreakDownDAO.insert(newGrade,s);
                    }
                    changePage.ShowPage();
                    frame.dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxType.setSelectedItem("Select");
                CoursePage changePage = new CoursePage(currentCourse);
                CoursePage.ShowPage();
                frame.dispose();


            }
        });

    }
}
