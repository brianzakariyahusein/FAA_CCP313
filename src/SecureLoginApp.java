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

    // Input Field
    JTextField usernameField;
    JPasswordField passwordField;

    // BTN
    JButton applyButton;
    JButton resetButton;
    JButton quitButton;

    // Output Field (only read)
    JTextField outputUsername;
    JTextField outputPassword;

    // CONSTRUCTUR
    public SecureLoginApp() {
        // Setup frame
        setTitle("Secure Login");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Create Component
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        applyButton = new JButton("Apply");
        resetButton = new JButton("Reset");
        quitButton = new JButton("Quit");
        outputUsername = new JTextField();
        outputPassword = new JTextField();

        // lock the output field, edit disable
        outputUsername.setEditable(false);
        outputPassword.setEditable(false);

        // add the btn to listener
        applyButton.addActionListener(this);
        resetButton.addActionListener(this);
        quitButton.addActionListener(this);

        // add all of the component to the frame
        add(new JLabel("Username: "));
        add(usernameField);
        add(new JLabel("Passord: "));
        add(passwordField);
        add(new JLabel(""));
        add(new JLabel(""));
        add(applyButton);
        add(resetButton);
        add(quitButton);
        add(new JLabel(""));
        add(new JLabel("Output Username: "));
        add(outputUsername);
        add(new JLabel("Output Password: "));
        add(outputPassword);

        setVisible(true);
    }

    // METHOD
    public void actionPerformed(ActionEvent e) {

    }

    // MAIN METHOD
    public static void main(String[] args) {
        new SecureLoginApp();
    }

}
