package gui;

import dao.UserDAO;
import entity.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewUser {

	private JFrame frame;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField reenterTextField;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField answer3;

	//public static void main(String[] args) {
	public static void ShowPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser window = new NewUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewUser() {
		initialize();
	}

	private void initialize() {
		JLabel NewUserLabel;
		JLabel usernameLabel;
		JLabel passwordLabel;
		JLabel reenterLabel;
		JLabel question1Label;
		JLabel question2Label;
		JLabel question3Label;
		JLabel answer1Label;
		JLabel answer2Label;
		JLabel answer3Label;
		JComboBox question1Options;
		JComboBox question2Options;
		JComboBox question3Options;
		JButton cancelButton;
		JButton finishButton;

		/*********************************** Generate frame for New User page ***************************************/
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/*********************************** New User Title **************************************/
		NewUserLabel = new JLabel("New User");
		NewUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NewUserLabel.setBounds(10, 11, 101, 25);
		frame.getContentPane().add(NewUserLabel);

		/*********************************** Username label **************************************/
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 47, 62, 14);
		frame.getContentPane().add(usernameLabel);

		/*********************************** Username textfield **************************************/
		usernameTextField = new JTextField();
		usernameTextField.setBounds(10, 72, 86, 20);
		frame.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);

		/*********************************** Password label **************************************/
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 103, 62, 14);
		frame.getContentPane().add(passwordLabel);

		/*********************************** Password textfield **************************************/
		passwordTextField = new JTextField();
		passwordTextField.setBounds(10, 128, 86, 20);
		frame.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);

		/*********************************** Reenter Password label **************************************/
		reenterLabel = new JLabel("Reenter Password");
		reenterLabel.setBounds(10, 159, 115, 14);
		frame.getContentPane().add(reenterLabel);

		/*********************************** Reenter Password textfield **************************************/
		reenterTextField = new JTextField();
		reenterTextField.setBounds(10, 184, 86, 20);
		frame.getContentPane().add(reenterTextField);
		reenterTextField.setColumns(10);

		/*********************************** Question1 label **************************************/
		question1Label = new JLabel("Question 1:");
		question1Label.setBounds(10, 215, 86, 14);
		frame.getContentPane().add(question1Label);

		/*********************************** Question1 Combobox **************************************/
		question1Options = new JComboBox();
		question1Options.addItem("What is the name of the road you grew up on?");
		question1Options.addItem("What was the first company that you worked for?");
		question1Options.addItem("What city were you born in?");
		question1Options.setBounds(10, 240, 396, 20);
		frame.getContentPane().add(question1Options);

		/*********************************** Answer1 label **************************************/
		answer1Label = new JLabel("Answer:");
		answer1Label.setBounds(10, 271, 71, 14);
		frame.getContentPane().add(answer1Label);

		/*********************************** Answer1 textfield **************************************/
		answer1 = new JTextField();
		answer1.setBounds(10, 296, 396, 20);
		frame.getContentPane().add(answer1);
		answer1.setColumns(10);

		/*********************************** Question2 label **************************************/
		question2Label = new JLabel("Question 2:");
		question2Label.setBounds(10, 330, 101, 14);
		frame.getContentPane().add(question2Label);

		/*********************************** Question2 Combobox **************************************/
		question2Options = new JComboBox();
		question2Options.addItem("Where did you go to high school/college?");
		question2Options.addItem("What was the name of your first/current/favorite pet?");
		question2Options.addItem("What Is your favorite book?");
		question2Options.setBounds(10, 355, 396, 20);
		frame.getContentPane().add(question2Options);

		/*********************************** Answer2 label **************************************/
		answer2Label = new JLabel("Answer:");
		answer2Label.setBounds(10, 386, 80, 14);
		frame.getContentPane().add(answer2Label);

		/*********************************** Answer2 textfield **************************************/
		answer2 = new JTextField();
		answer2.setBounds(10, 405, 396, 20);
		frame.getContentPane().add(answer2);
		answer2.setColumns(10);

		/*********************************** Question3 label **************************************/
		question3Label = new JLabel("Question 3:");
		question3Label.setBounds(10, 440, 101, 14);
		frame.getContentPane().add(question3Label);

		/*********************************** Question3 combobox **************************************/
		question3Options = new JComboBox();
		question3Options.addItem("What was your high school mascot?");
		question3Options.addItem("What is the name of your first grade teacher?");
		question3Options.addItem("What was the make of your first car?");
		question3Options.setBounds(10, 465, 396, 20);
		frame.getContentPane().add(question3Options);

		/*********************************** Answer3 label **************************************/
		answer3Label = new JLabel("Answer:");
		answer3Label.setBounds(10, 496, 101, 14);
		frame.getContentPane().add(answer3Label);

		/*********************************** Answer3 textfield **************************************/
		answer3 = new JTextField();
		answer3.setBounds(10, 521, 396, 20);
		frame.getContentPane().add(answer3);
		answer3.setColumns(10);

		/*********************************** Cancel Button **************************************/
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(new String[0]);
				frame.dispose();
			}
		});
		cancelButton.setBounds(317, 567, 89, 23);
		frame.getContentPane().add(cancelButton);

		/*********************************** Finish Button **************************************/
		finishButton = new JButton("Finish");
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || reenterTextField.getText().isEmpty() || answer1.getText().isEmpty() || answer2.getText().isEmpty() || answer3.getText().isEmpty() || !passwordTextField.getText().equals(reenterTextField.getText()) ) {
					JOptionPane.showMessageDialog(null, "Not all components are filled in.");
				}
				else {
					String q1 = question1Options.getSelectedItem().toString();
					String q2 = question2Options.getSelectedItem().toString();
					String q3 = question3Options.getSelectedItem().toString();
					String a1 = answer1.getText();
					String a2 = answer2.getText();
					String a3 = answer3.getText();
					String uname = usernameTextField.getText();
					String psw = passwordTextField.getText();
					UserDAO ud = new UserDAO();
					ud.insert(uname,psw,new String[]{q1,q2,q3},new String[]{a1,a2,a3});
					Dashboard dashboardPage = new Dashboard();
					dashboardPage.ShowPage();
					frame.dispose();
				}
			}
		});

		finishButton.setBounds(218, 567, 89, 23);
		frame.getContentPane().add(finishButton);
	}
	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
