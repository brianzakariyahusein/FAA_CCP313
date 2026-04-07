/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brian
 */
//Import Library
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecureLoginApp extends JFrame implements ActionListener {

    // Color Theme
    Color bgDark = new Color(0x16213e);
    Color bgDeep = new Color(0x0f0f23);
    Color borderPurple = new Color(0x2d2b55);
    Color accentPurple = new Color(0x534AB7);
    Color textLight = new Color(0xAFA9EC);
    Color textDim = new Color(0x7F77DD);
    Color red = new Color(0xE24B4A);

    // Input Component
    JTextField usernameField;
    JPasswordField passwordField;

    // Button
    JButton applyButton;
    JButton resetButton;
    JButton quitButton;

    // Component Output (read-only)
    JTextField outputUsername;
    JTextField outputPassword;

    public SecureLoginApp() {

        // setup frame
        setTitle("Secure Login");
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // background color for the frame
        getContentPane().setBackground(bgDark);

        // Username Label
        JLabel labelUsername = new JLabel("USERNAME");
        labelUsername.setBounds(60, 40, 180, 20);
        labelUsername.setForeground(textLight);
        labelUsername.setFont(new Font("SansSerif", Font.PLAIN, 11));

        // Input Username
        usernameField = new JTextField();
        usernameField.setBounds(60, 62, 380, 34);
        usernameField.setBackground(bgDeep);
        usernameField.setForeground(textDim);
        usernameField.setCaretColor(textLight);
        usernameField.setBorder(BorderFactory.createLineBorder(borderPurple, 1));
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Password Label
        JLabel labelPassword = new JLabel("PASSWORD");
        labelPassword.setBounds(60, 106, 180, 20);
        labelPassword.setForeground(textLight);
        labelPassword.setFont(new Font("SansSerif", Font.PLAIN, 11));

        // Input Password
        passwordField = new JPasswordField();
        passwordField.setBounds(60, 128, 380, 34);
        passwordField.setBackground(bgDeep);
        passwordField.setForeground(textDim);
        passwordField.setCaretColor(textLight);
        passwordField.setBorder(BorderFactory.createLineBorder(borderPurple, 1));
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Apply Button
        applyButton = new JButton("Apply");
        applyButton.setBounds(60, 178, 110, 32);
        applyButton.setBackground(new Color(0x26215C));
        applyButton.setForeground(new Color(0xCECBF6));
        applyButton.setBorder(BorderFactory.createLineBorder(accentPurple, 1));
        applyButton.setFocusPainted(false);
        applyButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
        applyButton.addActionListener(this);

        // Reset Button
        resetButton = new JButton("Reset");
        resetButton.setBounds(185, 178, 110, 32);
        resetButton.setBackground(bgDark);
        resetButton.setForeground(textLight);
        resetButton.setBorder(BorderFactory.createLineBorder(borderPurple, 1));
        resetButton.setFocusPainted(false);
        resetButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
        resetButton.addActionListener(this);

        // Quit Button
        quitButton = new JButton("Quit");
        quitButton.setBounds(310, 178, 130, 32);
        quitButton.setBackground(bgDark);
        quitButton.setForeground(red);
        quitButton.setBorder(BorderFactory.createLineBorder(new Color(0x3d1f1f), 1));
        quitButton.setFocusPainted(false);
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
        quitButton.addActionListener(this);

        // dividing between input and output
        JSeparator separator = new JSeparator();
        separator.setBounds(60, 224, 380, 1);
        separator.setForeground(borderPurple);

        // Label for username output
        JLabel labelOutUser = new JLabel("Output Username");
        labelOutUser.setBounds(60, 234, 180, 18);
        labelOutUser.setForeground(textLight);
        labelOutUser.setFont(new Font("SansSerif", Font.PLAIN, 11));

        // Output for username (read only)
        outputUsername = new JTextField();
        outputUsername.setBounds(60, 254, 180, 30);
        outputUsername.setBackground(bgDeep);
        outputUsername.setForeground(textDim);
        outputUsername.setBorder(BorderFactory.createLineBorder(new Color(0x1e1e38), 1));
        outputUsername.setEditable(false);
        outputUsername.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Label for password
        JLabel labelOutPass = new JLabel("Output Password");
        labelOutPass.setBounds(260, 234, 180, 18);
        labelOutPass.setForeground(textLight);
        labelOutPass.setFont(new Font("SansSerif", Font.PLAIN, 11));

        // Output for password (Read Only)
        outputPassword = new JTextField();
        outputPassword.setBounds(260, 254, 180, 30);
        outputPassword.setBackground(bgDeep);
        outputPassword.setForeground(textDim);
        outputPassword.setBorder(BorderFactory.createLineBorder(new Color(0x1e1e38), 1));
        outputPassword.setEditable(false);
        outputPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Add to the frame
        add(labelUsername);
        add(usernameField);
        add(labelPassword);
        add(passwordField);
        add(applyButton);
        add(resetButton);
        add(quitButton);
        add(separator);
        add(labelOutUser);
        add(outputUsername);
        add(labelOutPass);
        add(outputPassword);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == applyButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            outputUsername.setText(username);
            outputPassword.setText(password);

        } else if (e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
            outputUsername.setText("");
            outputPassword.setText("");
            usernameField.requestFocus();

        } else if (e.getSource() == quitButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new SecureLoginApp();
    }
}
