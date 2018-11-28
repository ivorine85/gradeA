package gui;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class CourseInfo {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel lblCourseInfo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
        frame.setBounds(100, 100, 1000, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblCourseInfo = new JLabel("Course Info");
        lblCourseInfo.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblCourseInfo.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(lblCourseInfo);

        JLabel lblCourseTitle = new JLabel("Course Title");
        lblCourseTitle.setBounds(40, 85, 100, 14);
        frame.getContentPane().add(lblCourseTitle);

        textField = new JTextField();
        textField.setBounds(40, 110, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

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

        textField_1 = new JTextField();
        textField_1.setBounds(40, 240, 60, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

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

        textField_2 = new JTextField();
        textField_2.setBounds(180, 240, 60, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

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

        JTextField text = new JTextField(20);
        JButton b = new JButton("Choose");
        JPanel p = new JPanel();
        p.add(text);
        p.add(b);
        p.setBounds(15, 290, 400, 40);
        frame.getContentPane().add(p);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                text.setText(new DatePicker(frame).setPickedDate());
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

        JLabel lblTFName = new JLabel("TF Name");
        lblTFName.setBounds(410, 85, 100, 14);
        frame.getContentPane().add(lblTFName);

        textField = new JTextField();
        textField.setBounds(410, 110, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblTFEmail = new JLabel("TF Email");
        lblTFEmail.setBounds(410, 145, 100, 14);
        frame.getContentPane().add(lblTFEmail);

        textField = new JTextField();
        textField.setBounds(410, 170, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblCAName = new JLabel("CA Name");
        lblCAName.setBounds(410, 205, 100, 14);
        frame.getContentPane().add(lblCAName);

        textField = new JTextField();
        textField.setBounds(410, 230, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblCAEmail = new JLabel("CA Email");
        lblCAEmail.setBounds(410, 265, 100, 14);
        frame.getContentPane().add(lblCAEmail);

        textField = new JTextField();
        textField.setBounds(410, 290, 150, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNumLabs = new JLabel("Number of Labs");
        lblNumLabs.setBounds(610, 85, 100, 14);
        frame.getContentPane().add(lblNumLabs);

        JComboBox<String> comboBoxNumLabs = new JComboBox<String>();
        comboBoxNumLabs.addItem("1");
        comboBoxNumLabs.addItem("2");
        comboBoxNumLabs.addItem("3");
        comboBoxNumLabs.addItem("4");
        comboBoxNumLabs.addItem("5");
        comboBoxNumLabs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxNumLabs.setBounds(610, 112, 70, 20);
        frame.getContentPane().add(comboBoxNumLabs);

        JLabel lblNumAssign = new JLabel("Number of Assignments");
        lblNumAssign.setBounds(610, 145, 155, 14);
        frame.getContentPane().add(lblNumAssign);

        JComboBox<String> comboBoxNumAssign = new JComboBox<String>();
        comboBoxNumAssign.addItem("1");
        comboBoxNumAssign.addItem("2");
        comboBoxNumAssign.addItem("3");
        comboBoxNumAssign.addItem("4");
        comboBoxNumAssign.addItem("5");
        comboBoxNumAssign.addItem("6");
        comboBoxNumAssign.addItem("7");
        comboBoxNumAssign.addItem("8");
        comboBoxNumAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxNumAssign.setBounds(610, 172, 70, 20);
        frame.getContentPane().add(comboBoxNumAssign);

        JLabel lblNumExams = new JLabel("Number of Exams");
        lblNumExams.setBounds(610, 205, 155, 14);
        frame.getContentPane().add(lblNumExams);

        JComboBox<String> comboBoxNumExams = new JComboBox<String>();
        comboBoxNumExams.addItem("1");
        comboBoxNumExams.addItem("2");
        comboBoxNumExams.addItem("3");
        comboBoxNumExams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxNumExams.setBounds(610, 232, 70, 20);
        frame.getContentPane().add(comboBoxNumExams);

        JLabel lblFinal = new JLabel("Will there be a final?");
        lblFinal.setBounds(610, 265, 200, 14);
        frame.getContentPane().add(lblFinal);

        JComboBox<String> comboBoxFinal = new JComboBox<String>();
        comboBoxFinal.addItem("Yes");
        comboBoxFinal.addItem("No");
        comboBoxFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxFinal.setBounds(610, 292, 80, 20);
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

        btnClear.setBounds(800, 410, 89, 23);
        frame.getContentPane().add(btnClear);


        JButton btnCreate = new JButton("Create");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreate.setBounds(900, 410, 89, 23);
        frame.getContentPane().add(btnCreate);


        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||((radioButtonTues.isSelected())&&(radioButtonMon.isSelected()))||(comboBoxStart.getSelectedItem().equals("Select")))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else
                    JOptionPane.showMessageDialog(null, "Data Submitted");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_1.setText(null);
                textField_2.setText(null);
                textField.setText(null);
                radioButtonMon.setSelected(false);
                radioButtonTues.setSelected(false);
                comboBoxStart.setSelectedItem("Select");


            }
        });

    }
}
