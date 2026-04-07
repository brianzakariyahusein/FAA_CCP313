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

public class LayoutShowcaseApp extends JFrame implements ActionListener {

    // CardLayout and its container
    CardLayout cardLayout;
    JPanel cardPanel;

    // Two main panels
    JPanel panelA;
    JPanel panelB;

    // Switch buttons
    JButton btnSwitchA;
    JButton btnSwitchB;

    public LayoutShowcaseApp() {

        // Configure main frame
        setTitle("Layout Showcase");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize CardLayout and its container
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create Panel A and Panel B
        panelA = buildPanelA();
        panelB = buildPanelB();

        // Add panels to CardLayout container
        cardPanel.add(panelA, "A");
        cardPanel.add(panelB, "B");

        // Create button panel at the bottom (SOUTH region)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnSwitchA = new JButton("Switch to Panel A");
        btnSwitchB = new JButton("Switch to Panel B");

        // Register action listeners
        btnSwitchA.addActionListener(this);
        btnSwitchB.addActionListener(this);

        buttonPanel.add(btnSwitchA);
        buttonPanel.add(btnSwitchB);

        // Add components to the frame
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Panel A using BorderLayout
    private JPanel buildPanelA() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(new Color(0x16213e));

        // NORTH - Title section
        JLabel title = new JLabel("Panel A  —  BorderLayout", SwingConstants.CENTER);
        title.setForeground(new Color(0xCECBF6));
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        title.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));

        // WEST - Left section
        JLabel west = new JLabel("  WEST  ", SwingConstants.CENTER);
        west.setOpaque(true);
        west.setBackground(new Color(0x26215C));
        west.setForeground(new Color(0xAFA9EC));
        west.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // CENTER - Main content area
        JLabel center = new JLabel("CENTER — Main Area", SwingConstants.CENTER);
        center.setOpaque(true);
        center.setBackground(new Color(0x0f0f23));
        center.setForeground(new Color(0x7F77DD));
        center.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // EAST - Right section
        JLabel east = new JLabel("  EAST  ", SwingConstants.CENTER);
        east.setOpaque(true);
        east.setBackground(new Color(0x26215C));
        east.setForeground(new Color(0xAFA9EC));
        east.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // SOUTH - Status bar
        JLabel south = new JLabel("SOUTH — Status Bar", SwingConstants.CENTER);
        south.setOpaque(true);
        south.setBackground(new Color(0x1e1a4a));
        south.setForeground(new Color(0xAFA9EC));
        south.setFont(new Font("SansSerif", Font.PLAIN, 11));
        south.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));

        panel.add(title, BorderLayout.NORTH);
        panel.add(west, BorderLayout.WEST);
        panel.add(center, BorderLayout.CENTER);
        panel.add(east, BorderLayout.EAST);
        panel.add(south, BorderLayout.SOUTH);

        return panel;
    }

    // Panel B using GridLayout
    private JPanel buildPanelB() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0x16213e));

        // Title section
        JLabel title = new JLabel("Panel B  —  GridLayout", SwingConstants.CENTER);
        title.setForeground(new Color(0xCECBF6));
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        title.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));

        // Grid container (3 rows x 2 columns)
        JPanel grid = new JPanel(new GridLayout(3, 2, 8, 8));
        grid.setBackground(new Color(0x16213e));
        grid.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        String[] labels = {"Name", "Email", "City"};

        for (String labelText : labels) {
            // Label component
            JLabel lbl = new JLabel(labelText);
            lbl.setForeground(new Color(0xAFA9EC));
            lbl.setFont(new Font("SansSerif", Font.PLAIN, 13));

            // Input field component
            JTextField field = new JTextField();
            field.setBackground(new Color(0x0f0f23));
            field.setForeground(new Color(0x7F77DD));
            field.setCaretColor(new Color(0xAFA9EC));
            field.setBorder(BorderFactory.createLineBorder(new Color(0x2d2b55), 1));

            grid.add(lbl);
            grid.add(field);
        }

        panel.add(title, BorderLayout.NORTH);
        panel.add(grid, BorderLayout.CENTER);

        return panel;
    }

    // Handle button click events
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSwitchA) {
            cardLayout.show(cardPanel, "A"); // Show Panel A
        } else if (e.getSource() == btnSwitchB) {
            cardLayout.show(cardPanel, "B"); // Show Panel B
        }
    }

    public static void main(String[] args) {
        new LayoutShowcaseApp();
    }
}