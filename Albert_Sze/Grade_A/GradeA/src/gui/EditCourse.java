package gui;

import dao.AssignmentDAO;
import dao.AssistantDAO;
import dao.CourseDAO;
import entity.*;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import entity.*;

public class EditCourse {

    private JFrame frame;
    private JTextField textFieldCourseTitle;
    private JTextField textFieldStartTime;
    private JTextField textFieldEndTime;
    private JTextField textFieldTF1Name;
    private JTextField textFieldTF1Email;
    private JTextField textFieldTF2Name;
    private JTextField textFieldTF2Email;
    private JLabel lblCourseInfo;
    private JTable table;
    private static Course curCourse;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditCourse window = new EditCourse(curCourse);
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
    public EditCourse(Course cur) {
        curCourse = cur;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //TODO:Here get all info of current course
        //curCourse is the object of current course
        //assignmentList is all the assignments
        //assistantList is all the TFs
        AssignmentDAO ad = new AssignmentDAO();
        java.util.List<Assignment> assignmentList = ad.findAssignmentByCourse(curCourse.getCourseName());
        AssistantDAO assistantDAO = new AssistantDAO();
        java.util.List<Assistant> assistantList = assistantDAO.findAssistantByCourse(curCourse.getCourseName());
        frame = new JFrame();
        frame.setBounds(100, 100, 1300, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblEditCourse = new JLabel("Edit Course");
        lblEditCourse.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblEditCourse.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(lblEditCourse);

        JLabel lblCourseTitle = new JLabel("Course Title");
        lblCourseTitle.setBounds(40, 85, 100, 14);
        frame.getContentPane().add(lblCourseTitle);

        textFieldCourseTitle = new JTextField();
        textFieldCourseTitle.setBounds(40, 110, 150, 20);
        frame.getContentPane().add(textFieldCourseTitle);
        textFieldCourseTitle.setColumns(10);

        JLabel lblDate = new JLabel("Choose Date");
        lblDate.setBounds(40, 145, 100, 14);
        frame.getContentPane().add(lblDate);

        JLabel lblMon = new JLabel("Mon");
        lblMon.setBounds(40, 170, 46, 14);
        frame.getContentPane().add(lblMon);

        JRadioButton radioButtonMon = new JRadioButton("");
        radioButtonMon.setBounds(43, 185, 109, 23);
        frame.getContentPane().add(radioButtonMon);

        JLabel lblTues = new JLabel("Tues");
        lblTues.setBounds(75, 170, 46, 14);
        frame.getContentPane().add(lblTues);

        JRadioButton radioButtonTues = new JRadioButton("");
        radioButtonTues.setBounds(78, 185, 109, 23);
        frame.getContentPane().add(radioButtonTues);

        JLabel lblWed = new JLabel("Wed");
        lblWed.setBounds(115, 170, 46, 14);
        frame.getContentPane().add(lblWed);

        JRadioButton radioButtonWed = new JRadioButton("");
        radioButtonWed.setBounds(118, 185, 109, 23);
        frame.getContentPane().add(radioButtonWed);

        JLabel lblThurs = new JLabel("Thurs");
        lblThurs.setBounds(150, 170, 46, 14);
        frame.getContentPane().add(lblThurs);

        JRadioButton radioButtonThurs = new JRadioButton("");
        radioButtonThurs.setBounds(153, 185, 109, 23);
        frame.getContentPane().add(radioButtonThurs);

        JLabel lblFri = new JLabel("Fri");
        lblFri.setBounds(200, 170, 46, 14);
        frame.getContentPane().add(lblFri);

        JRadioButton radioButtonFri = new JRadioButton("");
        radioButtonFri.setBounds(200, 185, 109, 23);
        frame.getContentPane().add(radioButtonFri);

        JLabel lblStartTime = new JLabel("Start Time");
        lblStartTime.setBounds(40, 215, 100, 14);
        frame.getContentPane().add(lblStartTime);

        textFieldStartTime = new JTextField();
        textFieldStartTime.setBounds(40, 240, 60, 20);
        frame.getContentPane().add(textFieldStartTime);
        textFieldStartTime.setColumns(10);

        JComboBox<String> comboBoxStart = new JComboBox<String>();
        comboBoxStart.addItem("AM");
        comboBoxStart.addItem("PM");
        comboBoxStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxStart.setBounds(100, 240, 70, 20);
        frame.getContentPane().add(comboBoxStart);

        JLabel lblEndTime = new JLabel("End Time");
        lblEndTime.setBounds(180, 215, 100, 14);
        frame.getContentPane().add(lblEndTime);

        textFieldEndTime = new JTextField();
        textFieldEndTime.setBounds(180, 240, 60, 20);
        frame.getContentPane().add(textFieldEndTime);
        textFieldEndTime.setColumns(10);

        JComboBox<String> comboBoxEnd = new JComboBox<String>();
        comboBoxEnd.addItem("AM");
        comboBoxEnd.addItem("PM");
        comboBoxEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxEnd.setBounds(240, 240, 70, 20);
        frame.getContentPane().add(comboBoxEnd);

//        JLabel lblPhone = new JLabel("Phone #");
//        lblPhone.setBounds(65, 88, 46, 14);
//        frame.getContentPane().add(lblPhone);
//

        JLabel lblStartDate = new JLabel("Start Date");
        lblStartDate.setBounds(40, 270, 100, 14);
        frame.getContentPane().add(lblStartDate);

        JTextField textStartDate = new JTextField(20);
        JButton b = new JButton("Choose");
        JPanel pStartDate = new JPanel();
        pStartDate.add(textStartDate);
        pStartDate.add(b);
        pStartDate.setBounds(15, 290, 400, 40);
        frame.getContentPane().add(pStartDate);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textStartDate.setText(new DatePicker(frame).setPickedDate());
            }
        });

        JLabel lblEndDate = new JLabel("End Date");
        lblEndDate.setBounds(40, 335, 100, 14);
        frame.getContentPane().add(lblEndDate);

        JTextField textEndDate = new JTextField(20);
        JButton btnEndDate = new JButton("Choose");
        JPanel pEndDate = new JPanel();
        pEndDate.add(textEndDate);
        pEndDate.add(btnEndDate);
        pEndDate.setBounds(15, 355, 400, 40);
        frame.getContentPane().add(pEndDate);
        btnEndDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textEndDate.setText(new DatePicker(frame).setPickedDate());
            }
        });

        JLabel lblTF1Name = new JLabel("TF #1 Name");
        lblTF1Name.setBounds(410, 85, 100, 14);
        frame.getContentPane().add(lblTF1Name);

        textFieldTF1Name = new JTextField();
        textFieldTF1Name.setBounds(410, 110, 150, 20);
        frame.getContentPane().add(textFieldTF1Name);
        textFieldTF1Name.setColumns(10);

        JLabel lblTF1Email = new JLabel("TF #1 Email");
        lblTF1Email.setBounds(410, 145, 100, 14);
        frame.getContentPane().add(lblTF1Email);

        textFieldTF1Email = new JTextField();
        textFieldTF1Email.setBounds(410, 170, 150, 20);
        frame.getContentPane().add(textFieldTF1Email);
        textFieldTF1Email.setColumns(10);

        JLabel lblTA2Name = new JLabel("TF #2 Name");
        lblTA2Name.setBounds(410, 205, 100, 14);
        frame.getContentPane().add(lblTA2Name);

        textFieldTF2Name = new JTextField();
        textFieldTF2Name.setBounds(410, 230, 150, 20);
        frame.getContentPane().add(textFieldTF2Name);
        textFieldTF2Name.setColumns(10);

        JLabel lblTA2Email = new JLabel("TF #2 Email");
        lblTA2Email.setBounds(410, 265, 100, 14);
        frame.getContentPane().add(lblTA2Email);

        textFieldTF2Email = new JTextField();
        textFieldTF2Email.setBounds(410, 290, 150, 20);
        frame.getContentPane().add(textFieldTF2Email);
        textFieldTF2Email.setColumns(10);



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

//        Course newCourse = new Course("CS591");												// Generate new course
//        newCourse.getCourseBreakDown().put("HW", new GradeBreakDown("HW", .5, .5, 0, 0,0, 1));
//        newCourse.getCourseBreakDown().put("Exam", new GradeBreakDown("Exam", .5, .5, 0, 0,0, 1));
//
//        newCourse.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
//        newCourse.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
//        newCourse.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
//        newCourse.getLabSections().get("A1").getStudents().put("undergrad", new ArrayList<Student>(0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").add(new Student("U1","Albert Sze","undergrad","None","yup@gmail",2018));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("HW", 3, 103, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).setGrade(0.98);
//        newCourse.getLabSections().get("A1").getStudents().put("grad", new ArrayList<Student>(0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").add(new Student("U1","Albert Sze","grad","None","yup@gmail",2018));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("HW", 10, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).setGrade(0.97);
/*******************************************************************************************************/
//        frame = new JFrame();
//        frame.getContentPane().setForeground(new Color(0, 0, 0));
//        frame.setBounds(100, 100, 801, 487);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(null);

        //Create header
        ArrayList<String> header = new ArrayList<String>(0);
        ArrayList<ArrayList<String>> allStudentData = new ArrayList<ArrayList<String>>(0);
        ArrayList<String> studentData;
        HashMap<String, Integer> assignCount = new HashMap<String, Integer>(0);
        double sum = 0.0;
        //for this example
        String currentLabSection = "A1";
//        ArrayList<Student> allStudents = newCourse.getLabSections().get(currentLabSection).getStudents().get("undergrad");
//        allStudents.addAll(newCourse.getLabSections().get(currentLabSection).getStudents().get("grad"));
//
//        header.add("Item");
//        for (Map.Entry<String, GradeBreakDown> entry : newCourse.getCourseBreakDown().entrySet()) {
//            assignCount.put(entry.getKey(),entry.getValue().getNumAssign()-1);
//        }


        header.add("Final");
        studentData = new ArrayList<String>(0);
        studentData.add("Total Points");
        for (int i = 1; i < header.size(); i++) {
            sum = 0.0;
            for (int j = 0; j < allStudentData.size(); j ++ ) {
                sum = j;
            }
            studentData.add(Double.toString((double)Math.round(sum*100)/100));
        }
        allStudentData.add(studentData);


        String[][] array = new String[allStudentData.size()][];
        for (int i = 0; i < allStudentData.size(); i++) {
            ArrayList<String> row = allStudentData.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }

        String [][] data={{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"}};
        DefaultTableModel model = new DefaultTableModel (array,header.toArray()) {
            public boolean isCellEditable(int row, int col)
            {
                //If you didn't want the first column to be editable
                if(col%2 == 0 || row == allStudentData.size()-1 || col == header.size()-1) {
                    return false;
                }
                else {
                    return true;
                }
            }
        };

        //Cancel Button
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoursePage changePage = new CoursePage(curCourse);
                changePage.ShowPage();
                frame.dispose();
            }
        });
        btnCancel.setBounds(686, 614, 89, 23);
        frame.getContentPane().add(btnCancel);

        //Finish Button
        JButton btnFinish = new JButton("Finish");
        btnFinish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /* need to fix perform check that percentage are correct
                if (CalcSum(tableGradeBreakDown)) {
                    //need to add save edits
                    CoursePage changePage = new CoursePage();
                    changePage.ShowPage();
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Percentages do not add up to 100%, please try again.");;
                }
                */
                CoursePage changePage = new CoursePage(curCourse);
                changePage.ShowPage();
                frame.dispose();
            }
        });
        btnFinish.setBounds(580, 614, 89, 23);
        frame.getContentPane().add(btnFinish);

        //Add ScrollPanel for table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 400, 738, 150);
        frame.getContentPane().add(scrollPane);

        table = new JTable(model);
        scrollPane.setViewportView(table);

        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(800, 614, 89, 23);
        frame.getContentPane().add(btnClear);


        /*JButton btnCreate = new JButton("Create");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreate.setBounds(900, 614, 89, 23);
        frame.getContentPane().add(btnCreate);


        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textFieldCourseTitle.getText().isEmpty()||(textFieldStartTime.getText().isEmpty())||(textFieldEndTime.getText().isEmpty())||((radioButtonTues.isSelected())&&(radioButtonMon.isSelected()))||(comboBoxStart.getSelectedItem().equals("Select")))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else{
                    String cname = textFieldCourseTitle.getText();
                    Date startDate = getDate(textStartDate.getText());
                    Date endDate = getDate(textEndDate.getText());
                    Time startTime = getTime(textFieldStartTime.getText());
                    Time endTime = getTime(textFieldEndTime.getText());
                    java.util.List<String> days = new ArrayList<>();
                    if(radioButtonMon.isSelected()) days.add("Monday");
                    if(radioButtonTues.isSelected()) days.add("Tuesday");
                    if(radioButtonWed.isSelected()) days.add("Wednesday");
                    if(radioButtonThurs.isSelected()) days.add("Thursday");
                    if(radioButtonFri.isSelected()) days.add("Friday");
                    String[] day = new String[days.size()];
                    for(int i = 0;i<day.length;i++) day[i] = days.get(i);
                    Course c = new Course(cname,startTime,endTime,startDate,endDate,day);
                    CourseDAO cd = new CourseDAO();
                    cd.insert(c);
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                }
            }
        });
*/
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldStartTime.setText(null);
                textFieldEndTime.setText(null);
                textFieldCourseTitle.setText(null);
                textFieldTF1Name.setText(null);
                textFieldTF2Name.setText(null);
                textFieldTF1Email.setText(null);
                textFieldTF2Email.setText(null);
                textStartDate.setText(null);
                textEndDate.setText(null);
                radioButtonMon.setSelected(false);
                radioButtonTues.setSelected(false);
                radioButtonWed.setSelected(false);
                radioButtonThurs.setSelected(false);
                radioButtonFri.setSelected(false);
                comboBoxStart.setSelectedItem("Select");


            }
        });

    }

    private Date getDate(String start){
        String[] a = start.split("-");
        start = a[2]+"-"+a[1]+"-"+a[0];
        Date startDate = Date.valueOf(start);
        return startDate;
    }

    private Time getTime(String str){
        str+=":00";
        return Time.valueOf(str);
    }


}
