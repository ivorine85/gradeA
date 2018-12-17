package gui;

import dao.AssignmentDAO;
import dao.AssistantDAO;
import dao.CourseDAO;
import entity.Assistant;
import entity.Course;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class CourseInfo {

    private JFrame frame;
    private JTextField textFieldCourseTitle;
    private JTextField textFieldStartTime;
    private JTextField textFieldEndTime;
    private JTextField textFieldTF1Name;
    private JTextField textFieldTF1Email;
    private JTextField textFieldTF2Name;
    private JTextField textFieldTF2Email;
    private JLabel lblCourseInfo;
    private Course pointer;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CourseInfo window = new CourseInfo();
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
    public CourseInfo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
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

        // Label of window
        JLabel lblCourseInfo = new JLabel("COURSE INFO");
        lblCourseInfo.setFont(new Font("Futura", Font.PLAIN, 36));
        lblCourseInfo.setBounds(70, 50, 400, 50);
        frame.getContentPane().add(lblCourseInfo);

        JLabel lblCourseTitle = new JLabel("Course Title");
        lblCourseTitle.setBounds(85, 120, 100, 14);
        frame.getContentPane().add(lblCourseTitle);

        textFieldCourseTitle = new JTextField();
        textFieldCourseTitle.setBounds(85, 145, 200, 20);
        frame.getContentPane().add(textFieldCourseTitle);
        textFieldCourseTitle.setColumns(10);

        JLabel lblDate = new JLabel("Choose Date(s)");
        lblDate.setBounds(85, 180, 100, 14);
        frame.getContentPane().add(lblDate);

        JLabel lblMon = new JLabel("Mon");
        lblMon.setBounds(85, 205, 46, 14);
        frame.getContentPane().add(lblMon);

        JRadioButton radioButtonMon = new JRadioButton("");
        radioButtonMon.setBounds(88, 220, 30, 23);
        frame.getContentPane().add(radioButtonMon);

        JLabel lblTues = new JLabel("Tues");
        lblTues.setBounds(125, 205, 46, 14);
        frame.getContentPane().add(lblTues);

        JRadioButton radioButtonTues = new JRadioButton("");
        radioButtonTues.setBounds(128, 220, 30, 23);
        frame.getContentPane().add(radioButtonTues);

        JLabel lblWed = new JLabel("Wed");
        lblWed.setBounds(165, 205, 46, 14);
        frame.getContentPane().add(lblWed);

        JRadioButton radioButtonWed = new JRadioButton("");
        radioButtonWed.setBounds(168, 220, 30, 23);
        frame.getContentPane().add(radioButtonWed);

        JLabel lblThurs = new JLabel("Thurs");
        lblThurs.setBounds(205, 205, 46, 14);
        frame.getContentPane().add(lblThurs);

        JRadioButton radioButtonThurs = new JRadioButton("");
        radioButtonThurs.setBounds(208, 220, 30, 23);
        frame.getContentPane().add(radioButtonThurs);

        JLabel lblFri = new JLabel("Fri");
        lblFri.setBounds(245, 205, 46, 14);
        frame.getContentPane().add(lblFri);

        JRadioButton radioButtonFri = new JRadioButton("");
        radioButtonFri.setBounds(248, 220, 30, 23);
        frame.getContentPane().add(radioButtonFri);

        JLabel lblStartTime = new JLabel("Start Time (24-hr)");
        lblStartTime.setBounds(85, 255, 120, 14);
        frame.getContentPane().add(lblStartTime);

        textFieldStartTime = new JTextField();
        textFieldStartTime.setBounds(85, 280, 100, 20);
        frame.getContentPane().add(textFieldStartTime);
        textFieldStartTime.setColumns(10);

        JLabel lblEndTime = new JLabel("End Time (24-hr)");
        lblEndTime.setBounds(220, 255, 120, 14);
        frame.getContentPane().add(lblEndTime);

        textFieldEndTime = new JTextField();
        textFieldEndTime.setBounds(220, 280, 100, 20);
        frame.getContentPane().add(textFieldEndTime);
        textFieldEndTime.setColumns(10);

//        JLabel lblPhone = new JLabel("Phone #");
//        lblPhone.setBounds(65, 88, 46, 14);
//        frame.getContentPane().add(lblPhone);
//

        JLabel lblStartDate = new JLabel("Start Date 'DD-MM-YYYY'");
        lblStartDate.setBounds(85, 315, 200, 20);
        frame.getContentPane().add(lblStartDate);

        JTextField textStartDate = new JTextField(20);
        JButton b = new JButton("Choose");
        JPanel pStartDate = new JPanel();
        pStartDate.add(textStartDate);
        pStartDate.add(b);
        pStartDate.setBounds(55, 340, 400, 40);
        pStartDate.setBackground(Color.white);
        frame.getContentPane().add(pStartDate);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textStartDate.setText(new DatePicker(frame).setPickedDate());
            }
        });

        JLabel lblEndDate = new JLabel("End Date 'DD-MM-YYYY'");
        lblEndDate.setBounds(85, 400, 200, 20);
        frame.getContentPane().add(lblEndDate);

        JTextField textEndDate = new JTextField(20);
        JButton btnEndDate = new JButton("Choose");
        JPanel pEndDate = new JPanel();
        pEndDate.add(textEndDate);
        pEndDate.add(btnEndDate);
        pEndDate.setBounds(55, 425, 400, 40);
        pEndDate.setBackground(Color.white);
        frame.getContentPane().add(pEndDate);
        btnEndDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textEndDate.setText(new DatePicker(frame).setPickedDate());
            }
        });

        JLabel lblTF1Name = new JLabel("TF #1 Name");
        lblTF1Name.setBounds(460, 120, 100, 14);
        frame.getContentPane().add(lblTF1Name);

        textFieldTF1Name = new JTextField();
        textFieldTF1Name.setBounds(460, 145, 150, 20);
        frame.getContentPane().add(textFieldTF1Name);
        textFieldTF1Name.setColumns(10);

        JLabel lblTF1Email = new JLabel("TF #1 Email");
        lblTF1Email.setBounds(460, 180, 100, 14);
        frame.getContentPane().add(lblTF1Email);

        textFieldTF1Email = new JTextField();
        textFieldTF1Email.setBounds(460, 205, 150, 20);
        frame.getContentPane().add(textFieldTF1Email);
        textFieldTF1Email.setColumns(10);

        JLabel lblTA2Name = new JLabel("TF #2 Name");
        lblTA2Name.setBounds(460, 240, 100, 14);
        frame.getContentPane().add(lblTA2Name);

        textFieldTF2Name = new JTextField();
        textFieldTF2Name.setBounds(460, 265, 150, 20);
        frame.getContentPane().add(textFieldTF2Name);
        textFieldTF2Name.setColumns(10);

        JLabel lblTA2Email = new JLabel("TF #2 Email");
        lblTA2Email.setBounds(460, 300, 100, 14);
        frame.getContentPane().add(lblTA2Email);

        textFieldTF2Email = new JTextField();
        textFieldTF2Email.setBounds(460, 325, 150, 20);
        frame.getContentPane().add(textFieldTF2Email);
        textFieldTF2Email.setColumns(10);

//        JLabel lblNumLabs = new JLabel("Number of Labs");
//        lblNumLabs.setBounds(610, 85, 100, 14);
//        frame.getContentPane().add(lblNumLabs);
//
//        JComboBox<String> comboBoxNumLabs = new JComboBox<String>();
//        comboBoxNumLabs.addItem("0");
//        comboBoxNumLabs.addItem("1");
//        comboBoxNumLabs.addItem("2");
//        comboBoxNumLabs.addItem("3");
//        comboBoxNumLabs.addItem("4");
//        comboBoxNumLabs.addItem("5");
//        comboBoxNumLabs.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        comboBoxNumLabs.setBounds(610, 112, 70, 20);
//        frame.getContentPane().add(comboBoxNumLabs);

        JLabel lblNumHW = new JLabel("Number of HWs");
        lblNumHW.setBounds(670, 120, 155, 14);
        frame.getContentPane().add(lblNumHW);

        JComboBox<String> comboBoxNumHW = new JComboBox<String>();
        comboBoxNumHW.addItem("0");
        comboBoxNumHW.addItem("1");
        comboBoxNumHW.addItem("2");
        comboBoxNumHW.addItem("3");
        comboBoxNumHW.addItem("4");
        comboBoxNumHW.addItem("5");
        comboBoxNumHW.addItem("6");
        comboBoxNumHW.addItem("7");
        comboBoxNumHW.addItem("8");
        comboBoxNumHW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxNumHW.setBounds(670, 145, 70, 20);
        frame.getContentPane().add(comboBoxNumHW);

        JLabel lblNumQuiz = new JLabel("Number of Quizzes");
        lblNumQuiz.setBounds(670, 180, 155, 14);
        frame.getContentPane().add(lblNumQuiz);

        JComboBox<String> comboBoxNumQuiz = new JComboBox<String>();
        comboBoxNumQuiz.addItem("0");
        comboBoxNumQuiz.addItem("1");
        comboBoxNumQuiz.addItem("2");
        comboBoxNumQuiz.addItem("3");
        comboBoxNumQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxNumQuiz.setBounds(670, 205, 70, 20);
        frame.getContentPane().add(comboBoxNumQuiz);

        JLabel lblNumMidterm = new JLabel("Number of Midterms");
        lblNumMidterm.setBounds(670, 240, 155, 14);
        frame.getContentPane().add(lblNumMidterm);

        JComboBox<String> comboBoxNumMidterm = new JComboBox<String>();
        comboBoxNumMidterm.addItem("0");
        comboBoxNumMidterm.addItem("1");
        comboBoxNumMidterm.addItem("2");
        comboBoxNumMidterm.addItem("3");
        comboBoxNumMidterm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxNumMidterm.setBounds(670, 265, 70, 20);
        frame.getContentPane().add(comboBoxNumMidterm);

        JLabel lblNumProject = new JLabel("Number of Projects");
        lblNumProject.setBounds(670, 300, 155, 14);
        frame.getContentPane().add(lblNumProject);

        JComboBox<String> comboBoxNumProject = new JComboBox<String>();
        comboBoxNumProject.addItem("0");
        comboBoxNumProject.addItem("1");
        comboBoxNumProject.addItem("2");
        comboBoxNumProject.addItem("3");
        comboBoxNumProject.addItem("4");
        comboBoxNumProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxNumProject.setBounds(670, 325, 70, 20);
        frame.getContentPane().add(comboBoxNumProject);

        JLabel lblFinal = new JLabel("Will there be a final?");
        lblFinal.setBounds(670, 355, 200, 14);
        frame.getContentPane().add(lblFinal);

        JComboBox<String> comboBoxFinal = new JComboBox<String>();
        comboBoxFinal.addItem("Yes");
        comboBoxFinal.addItem("No");
        comboBoxFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxFinal.setBounds(670, 380, 80, 20);
        frame.getContentPane().add(comboBoxFinal);

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



        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(720, 610, 89, 23);
        btnClear.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnClear);


        JButton btnCreate = new JButton("Create");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreate.setBounds(820, 610, 89, 23);
        btnCreate.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnCreate);


        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textFieldCourseTitle.getText().isEmpty()||(textFieldStartTime.getText().isEmpty())||(textFieldEndTime.getText().isEmpty())||((radioButtonTues.isSelected())&&(radioButtonMon.isSelected())))
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
                    pointer = c;
                    CourseDAO cd = new CourseDAO();
                    cd.insert(c);
                    AssistantDAO assistantDAO = new AssistantDAO();
                    String tfName2 = textFieldTF2Name.getText();
                    String tfEmail2 = textFieldTF2Email.getText();
                    String tfName1 = textFieldTF1Name.getText();
                    String tfEmail1 = textFieldTF1Email.getText();
                    int hwCount = Integer.valueOf(comboBoxNumHW.getSelectedItem().toString());
                    int qzCount = Integer.valueOf(comboBoxNumQuiz.getSelectedItem().toString());
                    int midCount = Integer.valueOf(comboBoxNumMidterm.getSelectedItem().toString());
                    int proCount = Integer.valueOf(comboBoxNumProject.getSelectedItem().toString());
                    int finalCount = comboBoxFinal.getSelectedItem().toString().equals("Yes")?1:0;
                    int totalType = 0;
                    if(hwCount > 0) totalType++;
                    if(qzCount > 0) totalType++;
                    if(midCount > 0) totalType++;
                    if(proCount > 0) totalType++;
                    if(finalCount > 0) totalType++;
                    AssignmentDAO assignmentDAO = new AssignmentDAO();
                    float typePer = (float)100/totalType;
                    for(int i = 0;i<hwCount;i++){
                        assignmentDAO.addAssignmentWithPer("hw",c.getCourseName(),0,typePer,(float)100/hwCount);
                    }
                    for(int i = 0;i<qzCount;i++){
                        assignmentDAO.addAssignmentWithPer("quiz",c.getCourseName(),0,typePer,(float)100/qzCount);
                    }
                    for(int i = 0;i<midCount;i++){
                        assignmentDAO.addAssignmentWithPer("midterm",c.getCourseName(),0,typePer,(float)100/midCount);
                    }
                    for(int i = 0;i<proCount;i++){
                        assignmentDAO.addAssignmentWithPer("project",c.getCourseName(),0,typePer,(float)100/proCount);
                    }
                    for(int i = 0;i<finalCount;i++){
                        assignmentDAO.addAssignmentWithPer("final",c.getCourseName(),0,typePer,100f);
                    }
                    try {
                        Assistant a1 = new Assistant(tfName1,tfEmail1);
                        if(!assistantDAO.checkExist(tfEmail1)) assistantDAO.insert(a1);
                        Assistant a2 = new Assistant(tfName2,tfEmail2);
                        if(!assistantDAO.checkExist(tfEmail2)) assistantDAO.insert(a2);
                        assistantDAO.assign(a1,cname);
                        assistantDAO.assign(a2,cname);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                    LabInfo labInfoPage = null;
                    labInfoPage = new LabInfo("LabInfo",pointer);
                    labInfoPage.ShowPage();

                    frame.dispose();
                }
            }
        });

        //Back Button
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddCourse addCoursePage = new AddCourse();
                addCoursePage.ShowPage();
                frame.dispose();
            }
        });
        btnBack.setBounds(70, 610, 89, 23);
        btnBack.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnBack);

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
