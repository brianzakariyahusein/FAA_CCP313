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

    // Input Components
    private JTextField txtUsername;
    private JPasswordField pswPassword;

    // Output (Read-Only) Components
    private JTextField outUsername;
    private JTextField outPassword;

    // Buttons
    private JButton btnApply;
    private JButton btnReset;
    private JButton btnQuit;

    // Constructur
    public SecureLoginApp() {
        // 1. Frame Settings
        setTitle("Secure Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 2. Main Panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Section Title
        JLabel lblTitle = new JLabel("Secure Login", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(lblTitle, gbc);

        // Seperator
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JSeparator sep = new JSeparator();
        sep.setForeground(Color.LIGHT_GRAY);
        mainPanel.add(sep, gbc);

        // Reset gridwidth for the rest
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username Label + Input
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        mainPanel.add(new JLabel("Username: "), gbc);

        txtUsername = new JTextField(20);
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        mainPanel.add(txtUsername, gbc);

        // Password Label + Input
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        mainPanel.add(new JLabel("Password: "), gbc);

        pswPassword = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        mainPanel.add(pswPassword, gbc);

        // Separator
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;

        // Output Section Label
        JLabel lblOutput = new JLabel("Output (Read-Only):", SwingConstants.LEFT);
        lblOutput.setFont(new Font("SansSerif", Font.ITALIC, 12));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(lblOutput, gbc);
        gbc.gridwidth = 1;

        // Output: Username
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.3;
        mainPanel.add(new JLabel("Entered Username: "), gbc);

        outUsername = new JTextField(20);
        outUsername.setEditable(false);
        outUsername.setBackground(new Color(230, 230, 230));
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        mainPanel.add(outUsername, gbc);

        // Output: Password
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.3;
        mainPanel.add(new JLabel("Entered Password: "), gbc);

        outPassword = new JTextField(20);
        outPassword.setEditable(false);
        outPassword.setBackground(new Color(230, 230, 230));
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        mainPanel.add(outPassword, gbc);

        // Separator
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        mainPanel.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;

        // BTN Panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        btnApply = new JButton("Apply");
        btnReset = new JButton("Reset");
        btnQuit = new JButton("Quit");

        // Register ActionListener for three button
        btnApply.addActionListener(this);
        btnReset.addActionListener(this);
        btnQuit.addActionListener(this);

        btnPanel.add(btnApply);
        btnPanel.add(btnReset);
        btnPanel.add(btnQuit);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnPanel, gbc);

        // 3. Add panel to frame, pack, and centre on screen
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // actionPerformed (single listener handles all three button)
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnApply) {
            // APPLY copy username and password text to read-only output fields
            outUsername.setText(txtUsername.getText());
            outPassword.setText(new String(pswPassword.getPassword()));
        } else if (source == btnReset) {
            // RESET Clear ALL input and Output Fields, and back to username
            txtUsername.setText("");
            pswPassword.setText("");
            outUsername.setText("");
            outPassword.setText("");
            txtUsername.requestFocusInWindow();
        } else if (source == btnQuit) {
            // QUIT close the application safely
            dispose();
            System.exit(0);
        }
    }

    // Main (Entry Point)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SecureLoginApp().setVisible(true);
        });
    }
}
