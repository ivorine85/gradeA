package gui;

import dao.AssistantDAO;
import dao.LabDAO;
import entity.Assistant;
import entity.Course;
import entity.Lab;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class LabInfo {

    private JFrame frame;
    private JTextField textFieldLabSection;
    private JTextField textFieldStartTime;
    private JTextField textFieldEndTime;
    private JLabel lblCourseInfo;
    private static String prevPage;
    private static Course curCourse;
    private static String chosedName;
    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LabInfo window = new LabInfo(prevPage,curCourse);
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
    public LabInfo(String prevPage,Course courseName) {
        this.prevPage = prevPage;
        this.curCourse = courseName;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(){
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblLabInfo = new JLabel("Lab Info");
        lblLabInfo.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblLabInfo.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(lblLabInfo);

        JLabel lblLabSection = new JLabel("Lab Section");
        lblLabSection.setBounds(40, 85, 100, 14);
        frame.getContentPane().add(lblLabSection);

        textFieldLabSection = new JTextField();
        textFieldLabSection.setBounds(40, 110, 50, 20);
        frame.getContentPane().add(textFieldLabSection);
        textFieldLabSection.setColumns(10);

        JLabel lblDate = new JLabel("Choose Date");
        lblDate.setBounds(40, 145, 100, 14);
        frame.getContentPane().add(lblDate);

        JLabel lblMon = new JLabel("Mon");
        lblMon.setBounds(40, 170, 46, 14);
        frame.getContentPane().add(lblMon);

        JRadioButton radioButtonMon = new JRadioButton("");
        radioButtonMon.setBounds(43, 185, 30, 23);
        frame.getContentPane().add(radioButtonMon);

        JLabel lblTues = new JLabel("Tues");
        lblTues.setBounds(75, 170, 46, 14);
        frame.getContentPane().add(lblTues);

        JRadioButton radioButtonTues = new JRadioButton("");
        radioButtonTues.setBounds(78, 185, 30, 23);
        frame.getContentPane().add(radioButtonTues);

        JLabel lblWed = new JLabel("Wed");
        lblWed.setBounds(115, 170, 46, 14);
        frame.getContentPane().add(lblWed);

        JRadioButton radioButtonWed = new JRadioButton("");
        radioButtonWed.setBounds(118, 185, 30, 23);
        frame.getContentPane().add(radioButtonWed);

        JLabel lblThurs = new JLabel("Thurs");
        lblThurs.setBounds(150, 170, 46, 14);
        frame.getContentPane().add(lblThurs);

        JRadioButton radioButtonThurs = new JRadioButton("");
        radioButtonThurs.setBounds(153, 185, 30, 23);
        frame.getContentPane().add(radioButtonThurs);

        JLabel lblFri = new JLabel("Fri");
        lblFri.setBounds(200, 170, 46, 14);
        frame.getContentPane().add(lblFri);

        JRadioButton radioButtonFri = new JRadioButton("");
        radioButtonFri.setBounds(200, 185, 30, 23);
        frame.getContentPane().add(radioButtonFri);
//
//        JLabel lblStartTime = new JLabel("Start Time");
//        lblStartTime.setBounds(40, 215, 100, 14);
//        frame.getContentPane().add(lblStartTime);
//
//        textFieldStartTime = new JTextField();
//        textFieldStartTime.setBounds(40, 240, 60, 20);
//        frame.getContentPane().add(textFieldStartTime);
//        textFieldStartTime.setColumns(10);
//
//        JComboBox<String> comboBoxStart = new JComboBox<String>();
//        comboBoxStart.addItem("AM");
//        comboBoxStart.addItem("PM");
//        comboBoxStart.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        comboBoxStart.setBounds(100, 240, 70, 20);
//        frame.getContentPane().add(comboBoxStart);
//
//        JLabel lblEndTime = new JLabel("End Time");
//        lblEndTime.setBounds(180, 215, 100, 14);
//        frame.getContentPane().add(lblEndTime);
//
//        textFieldEndTime = new JTextField();
//        textFieldEndTime.setBounds(180, 240, 60, 20);
//        frame.getContentPane().add(textFieldEndTime);
//        textFieldEndTime.setColumns(10);
//
//        JComboBox<String> comboBoxEnd = new JComboBox<String>();
//        comboBoxEnd.addItem("AM");
//        comboBoxEnd.addItem("PM");
//        comboBoxEnd.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        comboBoxEnd.setBounds(240, 240, 70, 20);
//        frame.getContentPane().add(comboBoxEnd);

        JLabel lblStartTime = new JLabel("Start Time (24-hr)");
        lblStartTime.setBounds(40, 215, 120, 14);
        frame.getContentPane().add(lblStartTime);

        textFieldStartTime = new JTextField();
        textFieldStartTime.setBounds(40, 240, 100, 20);
        frame.getContentPane().add(textFieldStartTime);
        textFieldStartTime.setColumns(10);

        JLabel lblEndTime = new JLabel("End Time (24-hr)");
        lblEndTime.setBounds(180, 215, 120, 14);
        frame.getContentPane().add(lblEndTime);

        textFieldEndTime = new JTextField();
        textFieldEndTime.setBounds(180, 240, 100, 20);
        frame.getContentPane().add(textFieldEndTime);
        textFieldEndTime.setColumns(10);

        JLabel lblAssignTF = new JLabel("Assign TF");
        lblAssignTF.setBounds(40, 270, 100, 14);
        frame.getContentPane().add(lblAssignTF);

        JComboBox<String> comboBoxTF = new JComboBox<String>();
        AssistantDAO ad =  new AssistantDAO();
        java.util.List<Assistant> assistantList = ad.findAssistantByCourse(curCourse.getCourseName());
        for(Assistant a:assistantList) comboBoxTF.addItem(a.getName());
//        comboBoxTF.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//
//            }
//        });
        comboBoxTF.setBounds(40, 300, 200, 20);
        frame.getContentPane().add(comboBoxTF);


        /*********************************** Create Cancel button ************************************/
        JButton cancelButton = new JButton("Cancel");
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
        cancelButton.setBounds(700, 410, 89, 23);
        frame.getContentPane().add(cancelButton);


        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(800, 410, 89, 23);
        frame.getContentPane().add(btnClear);


        JButton btnNext = new JButton("Next");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnNext.setBounds(900, 410, 89, 23);
        frame.getContentPane().add(btnNext);


        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textFieldLabSection.getText().isEmpty()||(textFieldStartTime.getText().isEmpty())||(textFieldEndTime.getText().isEmpty())||((radioButtonTues.isSelected())&&(radioButtonMon.isSelected())))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else{
                    String labname = textFieldLabSection.getText();
                    String startTime = textFieldStartTime.getText();
                    Time labstart = getTime(startTime);
                    String endTime = textFieldEndTime.getText();
                    Time labend = getTime(endTime);
                    java.util.List<String> days = new ArrayList<>();
                    if(radioButtonMon.isSelected()) days.add("Monday");
                    if(radioButtonTues.isSelected()) days.add("Tuesday");
                    if(radioButtonWed.isSelected()) days.add("Wednesday");
                    if(radioButtonThurs.isSelected()) days.add("Thursday");
                    if(radioButtonFri.isSelected()) days.add("Friday");
                    String[] day = new String[days.size()];
                    for(int i = 0;i<day.length;i++) day[i] = days.get(i);
                    Lab newlab = new Lab(labname,labstart,labend,day);
                    newlab.setCourseName(curCourse.getCourseName());
                    LabDAO ld = new LabDAO();
                    ld.insert(newlab);
                    String tfname = comboBoxTF.getSelectedItem().toString();
                    AssistantDAO assistantDAO = new AssistantDAO();
                    assistantDAO.assignToLab(tfname,newlab);
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                    AddStudents addStudentsPage = new AddStudents(prevPage,curCourse);
                    addStudentsPage.ShowPage();
                    frame.dispose();
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldStartTime.setText(null);
                textFieldEndTime.setText(null);
                textFieldLabSection.setText(null);
                radioButtonMon.setSelected(false);
                radioButtonTues.setSelected(false);
                radioButtonWed.setSelected(false);
                radioButtonThurs.setSelected(false);
                radioButtonFri.setSelected(false);


            }
        });

    }
    private Time getTime(String str){
        str+=":00";
        return Time.valueOf(str);
    }
}
