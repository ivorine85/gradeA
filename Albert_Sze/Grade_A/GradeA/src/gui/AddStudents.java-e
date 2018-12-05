//package gui;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.DefaultCellEditor;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumn;
//
//import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.Color;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.swing.JComboBox;
//
//import dao.CourseDAO;
//import dao.LabDAO;
//import dao.StudentDAO;
//import entity.*;
//
//public class AddStudents {
//
//    private JFrame frame;
//    private JTable addStudentsTable;
//    private static String prevPage;
//    Map<String,Lab> labList = new HashMap<>();
//    private static String curCourse;
//
//    //public static void main(String[] args) {
//    public static void ShowPage() {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    AddStudents window = new AddStudents(prevPage,curCourse);
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//
//    // Create connection to sql database
//    // Connection connection = null;
//
//    public AddStudents(String prevPage,String cname) {
//        this.prevPage = prevPage;
//        this.curCourse = cname;
//        //connection = SqlConnection.dbConnector();
//        initialize();
//    }
//
//    private void initialize() {
///*********************************** for the purpose of this example ***********************************/
////        Course newCourse = new Course("CS591");												// Generate new course
////
////        newCourse.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
////        newCourse.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
////        newCourse.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
///*******************************************************************************************************/
//    	JComboBox<String> labs = new JComboBox<String>();
//    	JComboBox<String> studentType = new JComboBox<String>();
//    	JLabel addStudentsTitle;
//    	JButton cancelButton;
//    	JButton finishButton;
//    	JButton addStudentButton;
//    	JScrollPane scrollStudents;
//    	TableColumn labcolumn;
//    	TableColumn studentTypecolumn;
//    	DefaultTableModel model;
//    	LabDAO labDAO = new LabDAO();
//
//    	/*********************************** Generate Frame ***********************************/
//        frame = new JFrame();
//        frame.getContentPane().setForeground(new Color(0, 0, 0));
//        frame.setBounds(100, 100, 801, 487);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(null);
//
//        /*********************************** Create Combo box of Lab section ***********************************/
//        //Create Combo box for student type and labs
//        //TODO: find all lab section
//        for(Lab l:labDAO.findLabOfCourse(curCourse)){
//            labList.put(l.getSection(),l);
//            labs.addItem(l.getSection());
//        }
////        for (Map.Entry<String, Lab> entry : newCourse.getLabSections().entrySet()) {
////            labs.addItem(entry.getKey());
////        }
//
//        /*********************************** Create Combo box for type of student ********************/
//        studentType.addItem("Undergraduate");
//        studentType.addItem("Graduate");
//
//        /*********************************** Generate Student Label **********************************/
//        addStudentsTitle = new JLabel("Add Students");
//        addStudentsTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
//        addStudentsTitle.setBounds(10, 11, 212, 44);
//        frame.getContentPane().add(addStudentsTitle);
//
//        /*********************************** Create Cancel button ************************************/
//        cancelButton = new JButton("Cancel");
//        cancelButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (prevPage.equals("CoursePage")) {
//                    CoursePage changePage = new CoursePage();
//                    CoursePage.ShowPage();
//                    frame.dispose();
//                }
//                else if(prevPage.equals("LabInfo")){
//                    Dashboard dashboardPage = new Dashboard();
//                    dashboardPage.ShowPage();
//                    frame.dispose();
//                }
//                frame.dispose();
//            }
//        });
//        cancelButton.setBounds(686, 414, 89, 23);
//        frame.getContentPane().add(cancelButton);
//
//        /*********************************** Create Finish button ************************************/
//        finishButton = new JButton("Finish");
//        finishButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                boolean valid = true;
//                for (int row = 0; row < addStudentsTable.getRowCount(); row++) {
//                    if ((addStudentsTable.getValueAt(row, 0)).toString().isEmpty()) {
//                        break;
//                    }
//                    try {
//                        Integer.parseInt(addStudentsTable.getValueAt(row, 4).toString());
//                    } catch (Exception e1) {
//                        valid = false;
//                        JOptionPane.showMessageDialog(null, "Make sure all year inputs are numbers");
//                    }
//                }
//                if (valid) {
//                    for (int row = 0; row < addStudentsTable.getRowCount(); row++) {
//                        if ((addStudentsTable.getValueAt(row, 0)).toString().isEmpty()) {
//                            break;
//                        }
//                        String name = addStudentsTable.getValueAt(row, 1).toString() + " " + addStudentsTable.getValueAt(row, 0).toString();
//                        String sid = addStudentsTable.getValueAt(row,2).toString();
//                        String email = addStudentsTable.getValueAt(row, 3).toString();
//                        int year = Integer.parseInt(addStudentsTable.getValueAt(row, 4).toString());
//                        String labSection = addStudentsTable.getValueAt(row, 5).toString();
//                        String studType = addStudentsTable.getValueAt(row, 6).toString();
//                        //TODO:1.Add student to table
//                        Student s = new Student(sid,name,studType,null,email,year);
//                        StudentDAO studentDAO = new StudentDAO();
//                        studentDAO.insert(s);
//                        //TODO:2.Assign student to course
//                        studentDAO.assignToCourse(s,curCourse);
//                        //TODO:3.Assign student to lab
//                        Lab l = labList.get(labSection);
//                        studentDAO.assignToLab(s,l);
//
//                        // bug below//
//
//                    }
//                    // return to proper frame
//                    if (prevPage.equals("CoursePage")) {
//                        CoursePage changePage = new CoursePage();
//                        CoursePage.ShowPage();
//                        frame.dispose();
//                    }
//                    else if (prevPage.equals("LabInfo")){
//                        Dashboard dashboardPage = new Dashboard();
//                        dashboardPage.ShowPage();
//                    }
//                    frame.dispose();
//                }
//            }
//        });
//        finishButton.setBounds(587, 414, 89, 23);
//        frame.getContentPane().add(finishButton);
//
//        /*********************************** Create Add Student button ************************************/
//        addStudentButton = new JButton("Add Student");
//        addStudentButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String[] temp = {"","","","","","Select","Select"};
//                model.addRow(temp);
//            }
//        });
//        addStudentButton.setBounds(457, 414, 120, 23);
//        frame.getContentPane().add(addStudentButton);
//
//        /*********************************** Add Scroll Panel and Table Student button ************************************/
//        scrollStudents = new JScrollPane();
//        scrollStudents.setBounds(25, 78, 738, 325);
//        frame.getContentPane().add(scrollStudents);
//
//        /*********************************** Generate Student Information tables ***********************************/
//        //Create Student
//        String [] header = {"Last Name","First Name","Student ID","Email","Year","Lab","Student Type"};
//        String [][] data = {{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"}};
//        model = new DefaultTableModel(data,header);
//        addStudentsTable = new JTable(model);
//        scrollStudents.setViewportView(addStudentsTable);
//        labcolumn = addStudentsTable.getColumnModel().getColumn(5);
//        studentTypecolumn = addStudentsTable.getColumnModel().getColumn(6);
//        labcolumn.setCellEditor(new DefaultCellEditor(labs));
//        studentTypecolumn.setCellEditor(new DefaultCellEditor(studentType));
//
//    }
//}
