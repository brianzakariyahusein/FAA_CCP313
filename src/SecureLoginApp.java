/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brian
 */

// Import required libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecureLoginApp extends JFrame implements ActionListener {

    // fields for user input
    private JTextField txtUsername;
    private JPasswordField pswPassword;

    // fields to show result (not editable)
    private JTextField outUsername;
    private JTextField outPassword;

    // buttons
    private JButton btnApply;
    private JButton btnReset;
    private JButton btnQuit;

    // constructor
    public SecureLoginApp() {
        // basic window setup
        setTitle("Secure Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // main container
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // title at the top
        JLabel lblTitle = new JLabel("Secure Login", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitle, gbc);

        // line separator
        gbc.gridy = 1;
        JSeparator sep = new JSeparator();
        mainPanel.add(sep, gbc);

        // reset layout config
        gbc.gridwidth = 1;

        // username input
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Username: "), gbc);

        txtUsername = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(txtUsername, gbc);

        // password input
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Password: "), gbc);

        pswPassword = new JPasswordField(20);
        gbc.gridx = 1;
        mainPanel.add(pswPassword, gbc);

        // another separator
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(new JSeparator(), gbc);

        gbc.gridwidth = 1;

        // label for output section
        JLabel lblOutput = new JLabel("Output (Read-Only):");
        lblOutput.setFont(new Font("SansSerif", Font.ITALIC, 12));

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(lblOutput, gbc);

        gbc.gridwidth = 1;

        // show entered username
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(new JLabel("Entered Username: "), gbc);

        outUsername = new JTextField(20);
        outUsername.setEditable(false);
        outUsername.setBackground(new Color(230, 230, 230));

        gbc.gridx = 1;
        mainPanel.add(outUsername, gbc);

        // show entered password
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(new JLabel("Entered Password: "), gbc);

        outPassword = new JTextField(20);
        outPassword.setEditable(false);
        outPassword.setBackground(new Color(230, 230, 230));

        gbc.gridx = 1;
        mainPanel.add(outPassword, gbc);

        // bottom separator
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        mainPanel.add(new JSeparator(), gbc);

        gbc.gridwidth = 1;

        // buttons area
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        btnApply = new JButton("Apply");
        btnReset = new JButton("Reset");
        btnQuit = new JButton("Quit");

        // attach click events
        btnApply.addActionListener(this);
        btnReset.addActionListener(this);
        btnQuit.addActionListener(this);

        btnPanel.add(btnApply);
        btnPanel.add(btnReset);
        btnPanel.add(btnQuit);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnPanel, gbc);

        // add everything to frame
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnApply) {
            // copy input into output fields
            outUsername.setText(txtUsername.getText());
            outPassword.setText(new String(pswPassword.getPassword()));

        } else if (source == btnReset) {
            // clear all fields
            txtUsername.setText("");
            pswPassword.setText("");
            outUsername.setText("");
            outPassword.setText("");

            // move cursor back to username
            txtUsername.requestFocusInWindow();

        } else if (source == btnQuit) {
            // close the app
            dispose();
            System.exit(0);
        }
    }

    // program entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SecureLoginApp().setVisible(true);
        });
    }
}
