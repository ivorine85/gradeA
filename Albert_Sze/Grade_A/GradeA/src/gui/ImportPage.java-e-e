package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Import.*;
import entity.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class ImportPage extends ImportCSV {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public static void ShowPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportPage window = new ImportPage();
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
	public ImportPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImportFile = new JLabel("Import File");
		lblImportFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImportFile.setBounds(10, 11, 120, 31);
		frame.getContentPane().add(lblImportFile);
		
		JLabel lblFilePath = new JLabel("File Path:");
		lblFilePath.setBounds(10, 64, 46, 14);
		frame.getContentPane().add(lblFilePath);
		
		textField = new JTextField();
		textField.setBounds(10, 89, 403, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse addCoursePage = new AddCourse();
				addCoursePage.ShowPage();
				frame.dispose();
			}
		});
		btnCancel.setBounds(335, 163, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Path filePath = Paths.get(textField.getText());
				if(Files.notExists(filePath)) {
					JOptionPane.showMessageDialog(null,"File Path Does not exist.");
				}
				else if (filePath.toString().length()<5 || !filePath.toString().substring(filePath.toString().length()-3).equals("csv")) {
					JOptionPane.showMessageDialog(null,"File is not a csv");
				}
				else {
					try {
	                    Course newcourse = Import(filePath.toFile());
	                    //add to profile
	                    Dashboard dashboardPage = new Dashboard();
	                    dashboardPage.ShowPage();
	                    frame.disable();
	                }
	                catch (Exception ex) {
	                    System.out.println("CSV did not upload.");
	                }
				}
			}
		});
		btnImport.setBounds(236, 163, 89, 23);
		frame.getContentPane().add(btnImport);
	}

}
