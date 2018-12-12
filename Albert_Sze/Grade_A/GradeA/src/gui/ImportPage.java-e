package gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Font;

import Import.*;
import entity.*;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class ImportPage extends ImportCSV {

	private JFrame frame;
	private JTextField filePathTextField;

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


	public ImportPage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		JLabel importFileTitle;
		JLabel filePathTitle;
		JButton cancelButton;
		JButton importButton;

		/*********************************** Generate frame for Import File Page *******************************/
		frame.setBounds(100, 100, 450, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/*********************************** Import File Title **************************************/
		importFileTitle = new JLabel("Import File");
		importFileTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		importFileTitle.setBounds(10, 11, 120, 31);
		frame.getContentPane().add(importFileTitle);

		/*********************************** File path label ***********************************/
		filePathTitle = new JLabel("File Path:");
		filePathTitle.setBounds(10, 64, 65, 14);
		frame.getContentPane().add(filePathTitle);

		/*********************************** File path text field ***********************************/
		filePathTextField = new JTextField();
		filePathTextField.setBounds(10, 89, 403, 20);
		frame.getContentPane().add(filePathTextField);
		filePathTextField.setColumns(10);


		/*********************************** Browse files ***********************************/
		JLabel lblEndDate = new JLabel("Choose a file");
		lblEndDate.setBounds(10, 135, 100, 14);
		frame.getContentPane().add(lblEndDate);

		JTextField textEndDate = new JTextField(20);
		JButton btnEndDate = new JButton("Browse");
		JPanel pEndDate = new JPanel();
		pEndDate.add(textEndDate);
		pEndDate.add(btnEndDate);
		pEndDate.setBounds(10, 155, 400, 40);
		frame.getContentPane().add(pEndDate);
		btnEndDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				BrowseFiles browseFilesPage = new BrowseFiles();
				browseFilesPage.ShowPage();
				frame.dispose();
			}
		});

		BrowseFiles browse = new BrowseFiles();
		frame.getContentPane().add(browse);

		/*********************************** Create Cancel button ************************************/
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse addCoursePage = new AddCourse();
				addCoursePage.ShowPage();
				frame.dispose();
			}
		});
		cancelButton.setBounds(335, 163, 89, 23);
		frame.getContentPane().add(cancelButton);

		/*********************************** Create Import button ************************************/
		importButton = new JButton("Import");
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Path filePath = Paths.get(filePathTextField.getText());
				if(Files.notExists(filePath)) {
					JOptionPane.showMessageDialog(null,"File Path Does not exist.");
				}
				else if (filePath.toString().length()<5 || !filePath.toString().substring(filePath.toString().length()-3).equals("csv")) {
					JOptionPane.showMessageDialog(null,"File is not a csv");
				}
				else {
					try {
	                    //Course newcourse = Import(filePath.toFile());
	                    //add to profile
	                    Dashboard dashboardPage = new Dashboard();
	                    //dashboardPage.ShowPage();
	                    frame.disable();
	                }
	                catch (Exception ex) {
	                    System.out.println("CSV did not upload.");
	                }
				}
			}
		});
		importButton.setBounds(236, 163, 89, 23);
		frame.getContentPane().add(importButton);
	}
}
