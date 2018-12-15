package gui;

import dao.AssistantDAO;
import dao.LabDAO;
import entity.Assistant;
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

public class EditLab {

    private JFrame frame;
    private JTextField textFieldLabSection;
    private JTextField textFieldStartTime;
    private JTextField textFieldEndTime;
    private JLabel lblEditLab;
    private static Lab currentLab;
    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditLab window = new EditLab(currentLab);
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
    public EditLab(Lab currentLab)  {
        this.currentLab = currentLab;
        try {
            initialize();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws SQLException {
        System.out.println(currentLab.getCourseName());
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblEditLab = new JLabel("Edit Lab");
        lblEditLab.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblEditLab.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(lblEditLab);

        JLabel lblLabSection = new JLabel("Lab Section");
        lblLabSection.setBounds(40, 85, 100, 14);
        frame.getContentPane().add(lblLabSection);

        textFieldLabSection = new JTextField();
        textFieldLabSection.setBounds(40, 110, 50, 20);
        frame.getContentPane().add(textFieldLabSection);
        textFieldLabSection.setColumns(10);
        textFieldLabSection.setText(currentLab.getSection());

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
        String[] days = new String[]{};
        if(currentLab.getWeekday()!=null) days = currentLab.getWeekday();
        for(String str:days){
            if(str.equals("Monday")) radioButtonMon.setSelected(true);
            else if(str.equals("Tuesday")) radioButtonTues.setSelected(true);
            else if(str.equals("Wednesday")) radioButtonWed.setSelected(true);
            else if(str.equals("Thursday")) radioButtonThurs.setSelected(true);
            else if(str.equals("Friday")) radioButtonFri.setSelected(true);
        }
        JLabel lblStartTime = new JLabel("Start Time (24-hr)");
        lblStartTime.setBounds(40, 215, 120, 14);
        frame.getContentPane().add(lblStartTime);

        textFieldStartTime = new JTextField();
        textFieldStartTime.setBounds(40, 240, 60, 20);

        frame.getContentPane().add(textFieldStartTime);
        textFieldStartTime.setColumns(10);
        if(currentLab.getClasstime()[0]!=null) textFieldStartTime.setText(currentLab.getClasstime()[0].toString());
//        JComboBox<String> comboBoxStart = new JComboBox<String>();
//        comboBoxStart.addItem("AM");
//        comboBoxStart.addItem("PM");
//        comboBoxStart.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        comboBoxStart.setBounds(100, 240, 70, 20);
//        frame.getContentPane().add(comboBoxStart);

        JLabel lblEndTime = new JLabel("End Time (24-hr)");
        lblEndTime.setBounds(180, 215, 120, 14);
        frame.getContentPane().add(lblEndTime);

        textFieldEndTime = new JTextField();
        textFieldEndTime.setBounds(180, 240, 60, 20);
        frame.getContentPane().add(textFieldEndTime);
        textFieldEndTime.setColumns(10);
        if(currentLab.getClasstime()[0]!=null) textFieldEndTime.setText(currentLab.getClasstime()[1].toString());
//        JComboBox<String> comboBoxEnd = new JComboBox<String>();
//        comboBoxEnd.addItem("AM");
//        comboBoxEnd.addItem("PM");
//        comboBoxEnd.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        comboBoxEnd.setBounds(240, 240, 70, 20);
//        frame.getContentPane().add(comboBoxEnd);

        JLabel lblAssignTF = new JLabel("Assign TF");
        lblAssignTF.setBounds(40, 270, 100, 14);
        frame.getContentPane().add(lblAssignTF);

        JComboBox<String> comboBoxTF = new JComboBox<String>();
        AssistantDAO ad =  new AssistantDAO();
        java.util.List<Assistant> assistantList = ad.findAssistantByCourse(currentLab.getCourseName());
        for(Assistant a:assistantList) comboBoxTF.addItem(a.getName());
//        comboBoxTF.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
        comboBoxTF.setBounds(40, 300, 200, 20);
        frame.getContentPane().add(comboBoxTF);



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

        btnClear.setBounds(800, 410, 89, 23);
        frame.getContentPane().add(btnClear);


        JButton btnNext = new JButton("Finish");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnNext.setBounds(900, 410, 89, 23);
        frame.getContentPane().add(btnNext);


        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textFieldLabSection.getText().isEmpty()||(textFieldStartTime.getText().isEmpty())||(textFieldEndTime.getText().isEmpty()))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else{
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                    String labname = currentLab.getSection();
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
                    currentLab.setWeekday(day);
                    currentLab.setClasstime(new Time[]{labstart,labend});
                    LabDAO labDAO = new LabDAO();
                    labDAO.update(currentLab);
                    String tfname = comboBoxTF.getSelectedItem().toString();
                    AssistantDAO assistantDAO = new AssistantDAO();
                    assistantDAO.removeFromLab(currentLab);
                    assistantDAO.assignToLab(tfname,currentLab);
                    LabPage returnLabPage = new LabPage(currentLab);
                    returnLabPage.ShowPage();
                    frame.dispose();
                }
                LabPage returnLabPage = new LabPage(currentLab);
                //returnLabPage.ShowPage();
                frame.dispose();


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
//                comboBoxStart.setSelectedItem("Select");


            }
        });

    }
    private Time getTime(String str){
        if(str.length()==8) return Time.valueOf(str);
        str+=":00";
        return Time.valueOf(str);
    }
}
