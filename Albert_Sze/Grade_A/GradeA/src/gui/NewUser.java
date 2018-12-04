//package gui;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.Font;
//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class NewUser {
//
//	private JFrame frame;
//	private JTextField textFieldUsername;
//	private JTextField textFieldPassword;
//	private JTextField textFieldReenter;
//	private JLabel lblQuestion1;
//	private JTextField textFieldA1;
//	private JTextField textFieldA2;
//	private JTextField textFieldA3;
//
//	/**
//	 * Launch the application.
//	 */
//	//public static void main(String[] args) {
//	public static void ShowPage() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewUser window = new NewUser();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public NewUser() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 639);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//
//		JLabel lblNewUser = new JLabel("New User");
//		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblNewUser.setBounds(10, 11, 101, 25);
//		frame.getContentPane().add(lblNewUser);
//
//		JLabel lblUsername = new JLabel("Username");
//		lblUsername.setBounds(10, 47, 62, 14);
//		frame.getContentPane().add(lblUsername);
//
//		textFieldUsername = new JTextField();
//		textFieldUsername.setBounds(10, 72, 86, 20);
//		frame.getContentPane().add(textFieldUsername);
//		textFieldUsername.setColumns(10);
//
//		JLabel lblPassword = new JLabel("Password");
//		lblPassword.setBounds(10, 103, 62, 14);
//		frame.getContentPane().add(lblPassword);
//
//		textFieldPassword = new JTextField();
//		textFieldPassword.setBounds(10, 128, 86, 20);
//		frame.getContentPane().add(textFieldPassword);
//		textFieldPassword.setColumns(10);
//
//		JLabel lblNewLabel = new JLabel("Reenter Password");
//		lblNewLabel.setBounds(10, 159, 115, 14);
//		frame.getContentPane().add(lblNewLabel);
//
//		textFieldReenter = new JTextField();
//		textFieldReenter.setBounds(10, 184, 86, 20);
//		frame.getContentPane().add(textFieldReenter);
//		textFieldReenter.setColumns(10);
//
//		lblQuestion1 = new JLabel("Question 1:");
//		lblQuestion1.setBounds(10, 215, 86, 14);
//		frame.getContentPane().add(lblQuestion1);
//
//		JComboBox comboBoxQ1 = new JComboBox();
//		comboBoxQ1.addItem("Question1 choice A");
//		comboBoxQ1.addItem("Question1 choice B");
//		comboBoxQ1.addItem("Question1 choice C");
//		comboBoxQ1.setBounds(10, 240, 396, 20);
//		frame.getContentPane().add(comboBoxQ1);
//
//		JLabel lblAnswer1 = new JLabel("Answer:");
//		lblAnswer1.setBounds(10, 271, 71, 14);
//		frame.getContentPane().add(lblAnswer1);
//
//		textFieldA1 = new JTextField();
//		textFieldA1.setBounds(10, 296, 396, 20);
//		frame.getContentPane().add(textFieldA1);
//		textFieldA1.setColumns(10);
//
//		JLabel lblQuestion2 = new JLabel("Question 2:");
//		lblQuestion2.setBounds(10, 330, 101, 14);
//		frame.getContentPane().add(lblQuestion2);
//
//		JComboBox comboBoxQ2 = new JComboBox();
//		comboBoxQ2.addItem("Question2 choice A");
//		comboBoxQ2.addItem("Question2 choice B");
//		comboBoxQ2.addItem("Question2 choice C");
//		comboBoxQ2.setBounds(10, 355, 396, 20);
//		frame.getContentPane().add(comboBoxQ2);
//
//		JLabel lblAnswer2 = new JLabel("Answer:");
//		lblAnswer2.setBounds(10, 386, 80, 14);
//		frame.getContentPane().add(lblAnswer2);
//
//		textFieldA2 = new JTextField();
//		textFieldA2.setBounds(10, 405, 396, 20);
//		frame.getContentPane().add(textFieldA2);
//		textFieldA2.setColumns(10);
//
//		JLabel lblQuestion3 = new JLabel("Question 3:");
//		lblQuestion3.setBounds(10, 440, 62, 14);
//		frame.getContentPane().add(lblQuestion3);
//
//		JComboBox comboBoxQ3 = new JComboBox();
//		comboBoxQ3.addItem("Question3 choice A");
//		comboBoxQ3.addItem("Question3 choice B");
//		comboBoxQ3.addItem("Question3 choice C");
//		comboBoxQ3.setBounds(10, 465, 396, 20);
//		frame.getContentPane().add(comboBoxQ3);
//
//		JLabel lblAnswer3 = new JLabel("Answer:");
//		lblAnswer3.setBounds(10, 496, 101, 14);
//		frame.getContentPane().add(lblAnswer3);
//
//		textFieldA3 = new JTextField();
//		textFieldA3.setBounds(10, 521, 396, 20);
//		frame.getContentPane().add(textFieldA3);
//		textFieldA3.setColumns(10);
//
//		JButton btnCancel = new JButton("Cancel");
//		btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Login.main(new String[0]);
//				frame.dispose();
//			}
//		});
//		btnCancel.setBounds(317, 567, 89, 23);
//		frame.getContentPane().add(btnCancel);
//		JButton btnFinish = new JButton("Finish");
//		btnFinish.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (textFieldUsername.getText().isEmpty() || textFieldPassword.getText().isEmpty() || textFieldReenter.getText().isEmpty() || textFieldA1.getText().isEmpty() || textFieldA2.getText().isEmpty() || textFieldA3.getText().isEmpty() || !textFieldPassword.getText().equals(textFieldReenter.getText()) ) {
//					JOptionPane.showMessageDialog(null, "Not all components are filled in.");
//				}
//				else {
//					Dashboard dashboardPage = new Dashboard();
//					dashboardPage.ShowPage();
//					frame.dispose();
//				}
//			}
//		});
//
//		btnFinish.setBounds(218, 567, 89, 23);
//		frame.getContentPane().add(btnFinish);
//	}
//	private static class __Tmp {
//		private static void __tmp() {
//			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
//		}
//	}
//}
