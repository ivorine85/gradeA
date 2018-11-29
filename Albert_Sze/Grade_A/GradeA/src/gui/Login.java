package gui;

import dao.UserDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JButton loginButton;
    private JPanel panelMain;
    private JPasswordField input_pass;
    private JLabel lbl_uname;
    private JLabel lbl_password;
    private JTextField input_uname;
    private JFrame message;
    private static JFrame frame;

    public Login() {
        message = new JFrame();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "hello, world.");
                String password = String.valueOf(input_pass.getPassword());
                String username = input_uname.getText();
                UserDAO userDAO = new UserDAO();
                String psw = userDAO.getPsw(username);
                if(psw.equals("No such user!")){
                    System.out.println("can't find this username!");
                    JOptionPane.showMessageDialog(message, "User does not exist.");
                }
                else if(psw.equals(password)){
                    System.out.println("Match!");
                    Dashboard dashboardPage = new Dashboard();
                    dashboardPage.ShowPage();
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(message, "Username or Password incorrect");
                    System.out.println("Wrong!");
                }
                /*
                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();
                */
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Login");
        frame.setContentPane(new Login().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
