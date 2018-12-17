package gui;

// import com.sun.tools.internal.ws.wsdl.document.Import;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.SwingUtilities;
import Import.*;

/*
 * BrowseFiles.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class BrowseFiles extends JPanel
        implements ActionListener {
    static private final String newline = "\n";
    private static JFrame frame = new JFrame("Browse Files");
    JButton openButton, importButton;
    JTextArea log;
    JFileChooser fc;


    public BrowseFiles() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Open a File");
                //createImageIcon("images/Open16.gif"));
        openButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        importButton = new JButton("Import File");
                //createImageIcon("images/Save16.gif"));
        importButton.addActionListener(this);

        //Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImportPage importPagePage = new ImportPage();
                importPagePage.ShowPage();
                frame.dispose();
            }
        });

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(importButton);
        buttonPanel.add(backButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public String getPath(){
        int returnVal = fc.showOpenDialog(BrowseFiles.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(BrowseFiles.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                log.append("File Path: "+ file.getAbsolutePath());
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        } else if (e.getSource() == importButton) {
            File file = fc.getSelectedFile();
            String filePath = file.getAbsolutePath();
            if(Files.notExists(Paths.get(filePath))) {
                JOptionPane.showMessageDialog(null,"File Path Does not exist.");
            }
            else if (filePath.length()<5 || !filePath.substring(filePath.length()-3).equals("csv")) {
                JOptionPane.showMessageDialog(null,"File is not a csv");
            }
            else {
                try {
                    //Course newcourse = Import(filePath.toFile());
                    //add to profile
                    Path path = Paths.get(filePath);
                    ImportCSV csv = new ImportCSV();
                    csv.Import(filePath);
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
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new BrowseFiles());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void ShowPage() {
    //public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
