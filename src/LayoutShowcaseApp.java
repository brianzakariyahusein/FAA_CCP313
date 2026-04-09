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

    // CardLayout + its container (used to switch panels)
    private CardLayout cardLayout;
    private JPanel cardContainer;

    // Switch buttons
    private JButton btnPanelA;
    private JButton btnPanelB;

    // Panel name constants
    private static final String PANEL_A = "Panel A";
    private static final String PANEL_B = "Panel B";
    
    public LayoutShowcaseApp() {
        // 1. Frame setup
        setTitle("Layout Showcase");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(480, 360));
        setLayout(new BorderLayout());

        // 2. Top navigation bar with two switch buttons
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        navBar.setBackground(new Color(50, 50, 50));

        btnPanelA = new JButton("Switch to Panel A");
        btnPanelB = new JButton("Switch to Panel B");

        btnPanelA.addActionListener(this);
        btnPanelB.addActionListener(this);

        navBar.add(btnPanelA);
        navBar.add(btnPanelB);
        add(navBar, BorderLayout.NORTH);

        // 3. Card container holds Panel A and Panel B
        cardLayout = new CardLayout();
        cardContainer = new JPanel(cardLayout);
        cardContainer.add(buildPanelA(), PANEL_A);
        cardContainer.add(buildPanelB(), PANEL_B);
        add(cardContainer, BorderLayout.CENTER);

        // 4. Status bar at the bottom
        JLabel statusBar = new JLabel("  Currently showing: Panel A  (GridLayout)",
                SwingConstants.LEFT);
        statusBar.setOpaque(true);
        statusBar.setBackground(new Color(220, 220, 220));
        statusBar.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        add(statusBar, BorderLayout.SOUTH);

        // Keep a reference so actionPerformed can update it
        this.statusBar = statusBar;

        // Show Panel A first
        cardLayout.show(cardContainer, PANEL_A);

        pack();
        setLocationRelativeTo(null);
    }

    // stored reference to status bar label
    private JLabel statusBar;
    
    // Panel A
    private JPanel buildPanelA() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // Header
        JLabel header = new JLabel("Panel A GridLayout (3 × 2)", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        wrapper.add(header, BorderLayout.NORTH);

        // Grid panel with 6 components (3 rows, 2 cols, gaps 8px)
        JPanel grid = new JPanel(new GridLayout(3, 2, 8, 8));

        String[] labels = {"Name", "Email", "Phone", "Address", "City", "Country"};
        for (String text : labels) {
            JPanel cell = new JPanel(new BorderLayout(4, 4));
            cell.setBorder(BorderFactory.createTitledBorder(text));
            cell.add(new JTextField(), BorderLayout.CENTER);
            grid.add(cell);
        }

        wrapper.add(grid, BorderLayout.CENTER);
        return wrapper;
    }
    
    // Panel B
    private JPanel buildPanelB() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // Header
        JLabel header = new JLabel("Panel B BorderLayout (5 regions)", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        wrapper.add(header, BorderLayout.NORTH);

        // Inner panel that uses BorderLayout with hgap/vgap
        JPanel border = new JPanel(new BorderLayout(6, 6));

        // NORTH region
        JLabel north = new JLabel("NORTH (Header / Toolbar area)", SwingConstants.CENTER);
        north.setOpaque(true);
        north.setBackground(new Color(173, 216, 230));   // light blue
        north.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        north.setPreferredSize(new Dimension(0, 45));
        border.add(north, BorderLayout.NORTH);

        // SOUTH region
        JLabel south = new JLabel("SOUTH (Footer / Status bar)", SwingConstants.CENTER);
        south.setOpaque(true);
        south.setBackground(new Color(144, 238, 144));   // light green
        south.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        south.setPreferredSize(new Dimension(0, 45));
        border.add(south, BorderLayout.SOUTH);

        // WEST region
        JLabel west = new JLabel("<html><center>WEST<br>Nav</center></html>", SwingConstants.CENTER);
        west.setOpaque(true);
        west.setBackground(new Color(255, 218, 185));    // peach
        west.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        west.setPreferredSize(new Dimension(90, 0));
        border.add(west, BorderLayout.WEST);

        // EAST region
        JLabel east = new JLabel("<html><center>EAST<br>Tools</center></html>", SwingConstants.CENTER);
        east.setOpaque(true);
        east.setBackground(new Color(221, 160, 221));    // plum
        east.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        east.setPreferredSize(new Dimension(90, 0));
        border.add(east, BorderLayout.EAST);

        // CENTER region
        JTextArea center = new JTextArea("CENTER\n\nThis is the main content area.\n"
                + "It expands to fill all remaining space\n"
                + "when the window is resized.");
        center.setEditable(false);
        center.setLineWrap(true);
        center.setWrapStyleWord(true);
        center.setBackground(new Color(255, 255, 204));  // light yellow
        center.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        border.add(new JScrollPane(center), BorderLayout.CENTER);

        wrapper.add(border, BorderLayout.CENTER);
        return wrapper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPanelA) {
            cardLayout.show(cardContainer, PANEL_A);
            statusBar.setText("  Currently showing: Panel A  (GridLayout)");
        } else if (e.getSource() == btnPanelB) {
            cardLayout.show(cardContainer, PANEL_B);
            statusBar.setText("  Currently showing: Panel B  (BorderLayout)");
        }
    }

    // Main (Entry Point)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LayoutShowcaseApp().setVisible(true));
    }
}
