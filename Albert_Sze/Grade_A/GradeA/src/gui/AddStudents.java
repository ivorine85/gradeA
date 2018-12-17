package gui;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.*;
import entity.*;

public class AddStudents {

    private JFrame frame;
    private JTable addStudentsTable;
    private static String prevPage;
    Map<String,Lab> labList = new HashMap<>();
    private static Course curCourse;

    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddStudents window = new AddStudents(prevPage,curCourse);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    // Create connection to sql database
    // Connection connection = null;

    public AddStudents(String prevPage,Course curCourse) {
        this.prevPage = prevPage;
        this.curCourse = curCourse;
        initialize();
    }

    private void initialize() {
        JComboBox<String> labs = new JComboBox<String>();
        JComboBox<String> studentType = new JComboBox<String>();
        JLabel addStudentsTitle;
        JButton cancelButton;
        JButton finishButton;
        JButton addRowButton;
        JScrollPane scrollStudents;
        TableColumn labcolumn;
        TableColumn studentTypecolumn;
        DefaultTableModel model;
        LabDAO labDAO = new LabDAO();

        /*********************************** Generate Frame ***********************************/
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        JButton logoButton;
        Image logoImg;

        /*********************************** Add logo/home button ***********************************/
        logoButton = new JButton("");
        logoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();
            }
        });
        logoImg = new ImageIcon(this.getClass().getResource("gradeA_logo.png")).getImage();
        logoButton.setIcon(new ImageIcon(logoImg));
        logoButton.setBounds(875, 30, 70, 70);
        logoButton.setOpaque(true);
        logoButton.setBackground(Color.white);
        logoButton.setForeground(Color.white);
        logoButton.setBorder(new LineBorder(Color.black));
        this.frame.getContentPane().add(logoButton);

        /*********************************** Add Scroll Panel and Table Student button ************************************/
        scrollStudents = new JScrollPane();
        scrollStudents.setBounds(120, 170, 738, 325);
        frame.getContentPane().add(scrollStudents);

        /*********************************** Generate Student Information tables ***********************************/
        //Create Student
        String [] header = {"Last Name","First Name","Student ID","Email","Year","Lab","Student Type"};
        String [][] data = {{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"}};
        model = new DefaultTableModel(data,header);
        addStudentsTable = new JTable(model);
        scrollStudents.setViewportView(addStudentsTable);
        labcolumn = addStudentsTable.getColumnModel().getColumn(5);
        studentTypecolumn = addStudentsTable.getColumnModel().getColumn(6);
        labcolumn.setCellEditor(new DefaultCellEditor(labs));
        studentTypecolumn.setCellEditor(new DefaultCellEditor(studentType));

        /*********************************** Create Combo box of Lab section ***********************************/
        //Create Combo box for student type and labs
        List<Lab> allLabs = labDAO.findLabOfCourse(curCourse.getCourseName());
        labs.addItem("Select");
        for(Lab l:allLabs){
            labList.put(l.getSection(),l);
            labs.addItem(l.getSection());
        }

        /*********************************** Create Combo box for type of student ********************/
        studentType.addItem("Select");
        studentType.addItem("Undergraduate");
        studentType.addItem("Grad");

        /*********************************** Generate Student Label **********************************/
        addStudentsTitle = new JLabel("ADD STUDENTS");
        addStudentsTitle.setFont(new Font("Futura", Font.PLAIN, 36));
        addStudentsTitle.setBounds(70, 50, 400, 50);
        frame.getContentPane().add(addStudentsTitle);

        /*********************************** Create Cancel button ************************************/
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (prevPage.equals("CoursePage")) {
                    CoursePage changePage = new CoursePage(curCourse);
                    CoursePage.ShowPage();
                    frame.dispose();
                }
                else if(prevPage.equals("LabInfo")){
                    Dashboard dashboardPage = new Dashboard();
                    dashboardPage.ShowPage();
                    frame.dispose();
                }
                frame.dispose();
            }
        });
        cancelButton.setBounds(820, 610, 89, 23);
        cancelButton.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(cancelButton);

        /*********************************** Create Finish button ************************************/
        finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                for (int row = 0; row < addStudentsTable.getRowCount(); row++) {
                    if ((addStudentsTable.getValueAt(row, 0)).toString().isEmpty()) {
                        break;
                    }
                    for (int col = 0; col<addStudentsTable.getColumnCount();col++){
                        if ((addStudentsTable.getValueAt(row, col)).toString().isEmpty() || addStudentsTable.getValueAt(row, col).toString().equals("Select")) {
                            valid = false;
                            JOptionPane.showMessageDialog(null, "Not all information is filled in");
                            break;
                        }
                    }
                    if (valid) {
                        try {
                            Integer.parseInt(addStudentsTable.getValueAt(row, 4).toString());
                        } catch (Exception e1) {
                            valid = false;
                            JOptionPane.showMessageDialog(null, "Make sure all year inputs are numbers");
                        }
                    }
                }

                if (valid) {
                    for (int row = 0; row < addStudentsTable.getRowCount(); row++) {
                        if ((addStudentsTable.getValueAt(row, 0)).toString().isEmpty()) {
                            break;
                        }
                        String name = addStudentsTable.getValueAt(row, 1).toString() + " " + addStudentsTable.getValueAt(row, 0).toString();
                        String sid = addStudentsTable.getValueAt(row,2).toString();
                        String email = addStudentsTable.getValueAt(row, 3).toString();
                        int year = Integer.parseInt(addStudentsTable.getValueAt(row, 4).toString());
                        String labSection = addStudentsTable.getValueAt(row, 5).toString();
                        String studType = addStudentsTable.getValueAt(row, 6).toString();
                        //1.Add student to table
                        Student s = new Student(sid,name,studType,null,email,year);
                        StudentDAO studentDAO = new StudentDAO();
                        studentDAO.insert(s);
                        //2.Assign student to course
                        studentDAO.assignToCourse(s,curCourse.getCourseName());
                        //3.Assign student to lab
                        Lab l = labList.get(labSection);
                        studentDAO.assignToLab(s,l.getSection());
                        //4.Create dum gbd for student
                        AssignmentDAO ad = new AssignmentDAO();
                        List<Assignment> assignments = ad.findAssignmentByCourse(curCourse.getCourseName());
                        GradeBreakDownDAO gradeBreakDownDAO = new GradeBreakDownDAO();
                        for(Assignment a:assignments){
                            float typePer = s.getStudentType().equals("Grad")? a.getGradTypePercentage():a.getUndergradTypePercentage();
                            float per = s.getStudentType().equals("Grad")? a.getGradPercentage():a.getUndergradPercentage();
                            GradeBreakDown gradeBreakDown = new GradeBreakDown(a.getCwname(),curCourse.getCourseName(),typePer,per,a.getType(),a.getWeight(),a.getTotalPts(),0);
                            gradeBreakDownDAO.insert(gradeBreakDown,s);
                        }
                    }
                    // return to proper frame
                    if (prevPage.equals("CoursePage")) {
                        CoursePage changePage = new CoursePage(curCourse);
                        CoursePage.ShowPage();
                        frame.dispose();
                    }
                    else if (prevPage.equals("LabInfo")){
                        Dashboard dashboardPage = new Dashboard();
                        dashboardPage.ShowPage();
                    }
                    frame.dispose();
                }
            }
        });
        finishButton.setBounds(720, 610, 89, 23);
        finishButton.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(finishButton);

        /*********************************** Create Add row button ************************************/
        addRowButton = new JButton("Add Row");
        addRowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] temp = {"","","","","","Select","Select"};
                model.addRow(temp);
            }
        });
        addRowButton.setBounds(70, 610, 120, 23);
        addRowButton.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(addRowButton);
    }
}
