package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

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

		/*********************************** Generate frame for Import File Page *******************************/
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.white);

		/*********************************** Import File Title **************************************/
		importFileTitle = new JLabel("IMPORT FILE");
		importFileTitle.setFont(new Font("Futura", Font.PLAIN, 36));
		importFileTitle.setBounds(70, 50, 400, 50);
		frame.getContentPane().add(importFileTitle);

		/*********************************** File path label ***********************************/
		filePathTitle = new JLabel("File Path");
		filePathTitle.setBounds(250, 200, 100, 14);
        filePathTitle.setFont(new Font("Futura", Font.PLAIN, 16));
		frame.getContentPane().add(filePathTitle);

		/*********************************** File path text field ***********************************/
		filePathTextField = new JTextField();
		filePathTextField.setBounds(300, 260, 403, 20);
		frame.getContentPane().add(filePathTextField);
		filePathTextField.setColumns(10);

		/*********************************** Browse files ***********************************/
		//JLabel lblEndDate = new JLabel("Choose a file");
		//lblEndDate.setBounds(10, 135, 100, 14);
		//frame.getContentPane().add(lblEndDate);

		//JTextField textEndDate = new JTextField(20);
		JButton btnBrowse = new JButton("Browse");
		//JPanel pEndDate = new JPanel();
		//pEndDate.add(textEndDate);
		//pEndDate.add(btnBrowse);
		//pEndDate.setBounds(10, 155, 400, 40);
		//frame.getContentPane().add(pEndDate);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				BrowseFiles browseFilesPage = new BrowseFiles();
				browseFilesPage.ShowPage();
				frame.dispose();
			}
		});
		btnBrowse.setBounds(720, 190, 89, 23);
        btnBrowse.setFont(new Font("Futura", Font.PLAIN, 16));
		frame.getContentPane().add(btnBrowse);

		/*********************************** Create Cancel button ************************************/
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse addCoursePage = new AddCourse();
				addCoursePage.ShowPage();
				frame.dispose();
			}
		});
		cancelButton.setBounds(700, 400, 89, 23);
        cancelButton.setFont(new Font("Futura", Font.PLAIN, 16));
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
						Import(filePathTextField.getText());
						JOptionPane.showMessageDialog(null,"CSV file imported.");
						frame.dispose();
						Dashboard dashboardPage = new Dashboard();
						dashboardPage.ShowPage();
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"CSV did not upload.");
					}
				}
			}
		});
		importButton.setBounds(600, 400, 89, 23);
        importButton.setFont(new Font("Futura", Font.PLAIN, 16));
		frame.getContentPane().add(importButton);
		frame.getRootPane().setDefaultButton(importButton);
	}
}
