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
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

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
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblCourseInfo = new JLabel("Course Info");
        lblCourseInfo.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblCourseInfo.setBounds(10, 11, 212, 44);
        frame.getContentPane().add(lblCourseInfo);

        textField = new JTextField();
        textField.setBounds(128, 48, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblCourseTitle = new JLabel("Course Title");
        lblCourseTitle.setBounds(65, 51, 46, 14);
        frame.getContentPane().add(lblCourseTitle);

        JLabel lblDate = new JLabel("Choose Date");
        lblDate.setBounds(65, 248, 46, 14);
        frame.getContentPane().add(lblDate);

        JLabel lblMon = new JLabel("Mon");
        lblMon.setBounds(128, 248, 46, 14);
        frame.getContentPane().add(lblMon);

        JLabel lblTues = new JLabel("Tues");
        lblTues.setBounds(292, 248, 46, 14);
        frame.getContentPane().add(lblTues);

        JRadioButton radioButton = new JRadioButton("");
        radioButton.setBounds(337, 244, 109, 23);
        frame.getContentPane().add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("");
        radioButton_1.setBounds(162, 244, 109, 23);
        frame.getContentPane().add(radioButton_1);

        JLabel lblStartTime = new JLabel("Start Time");
        lblStartTime.setBounds(65, 308, 67, 14);
        frame.getContentPane().add(lblStartTime);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("AM");
        comboBox.addItem("PM");
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox.setBounds(180, 305, 91, 20);
        frame.getContentPane().add(comboBox);

        JLabel lblPhone = new JLabel("Phone #");
        lblPhone.setBounds(65, 88, 46, 14);
        frame.getContentPane().add(lblPhone);

        textField_1 = new JTextField();
        textField_1.setBounds(128, 85, 86, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblEmailId = new JLabel("Email Id");
        lblEmailId.setBounds(65, 135, 46, 14);
        frame.getContentPane().add(lblEmailId);

        textField_2 = new JTextField();
        textField_2.setBounds(128, 132, 247, 17);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(65, 182, 46, 14);
        frame.getContentPane().add(lblAddress);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(126, 177, 212, 40);
        frame.getContentPane().add(textArea_1);



        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 407, 89, 23);
        frame.getContentPane().add(btnClear);


        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        frame.getContentPane().add(btnSubmit);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||((radioButton_1.isSelected())&&(radioButton.isSelected()))||(comboBox.getSelectedItem().equals("Select")))
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
                textArea_1.setText(null);
                radioButton.setSelected(false);
                radioButton_1.setSelected(false);
                comboBox.setSelectedItem("Select");


            }
        });

    }
}
