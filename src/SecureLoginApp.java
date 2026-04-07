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
        
    }

    // METHOD
    public void actionPerformed(ActionEvent e) {

    }

    // MAIN METHOD
    public static void main(String[] args) {
        new SecureLoginApp();
    }

}
