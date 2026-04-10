/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brian
 */
// import libraries

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LayoutShowcaseApp extends JFrame implements ActionListener {

    // used to switch between panels
    private CardLayout cardLayout;
    private JPanel cardContainer;

    // buttons for navigation
    private JButton btnPanelA;
    private JButton btnPanelB;

    // panel identifiers
    private static final String PANEL_A = "Panel A";
    private static final String PANEL_B = "Panel B";

    public LayoutShowcaseApp() {
        // basic frame setup
        setTitle("Layout Showcase");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(480, 360));
        setLayout(new BorderLayout());

        // top bar with buttons
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        navBar.setBackground(new Color(50, 50, 50));

        btnPanelA = new JButton("Switch to Panel A");
        btnPanelB = new JButton("Switch to Panel B");

        btnPanelA.addActionListener(this);
        btnPanelB.addActionListener(this);

        navBar.add(btnPanelA);
        navBar.add(btnPanelB);
        add(navBar, BorderLayout.NORTH);

        // area that holds both panels
        cardLayout = new CardLayout();
        cardContainer = new JPanel(cardLayout);

        cardContainer.add(buildPanelA(), PANEL_A);
        cardContainer.add(buildPanelB(), PANEL_B);

        add(cardContainer, BorderLayout.CENTER);

        // simple status text at the bottom
        JLabel statusBar = new JLabel("  Currently showing: Panel A  (GridLayout)",
                SwingConstants.LEFT);

        statusBar.setOpaque(true);
        statusBar.setBackground(new Color(220, 220, 220));
        statusBar.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));

        add(statusBar, BorderLayout.SOUTH);

        // save reference for later update
        this.statusBar = statusBar;

        // show first panel
        cardLayout.show(cardContainer, PANEL_A);

        pack();
        setLocationRelativeTo(null);
    }

    // keep reference to status label
    private JLabel statusBar;

    // create Panel A (grid layout)
    private JPanel buildPanelA() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // title
        JLabel header = new JLabel("Panel A GridLayout (3 × 2)", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        wrapper.add(header, BorderLayout.NORTH);

        // grid with 6 input fields
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

    // create Panel B (border layout)
    private JPanel buildPanelB() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // title
        JLabel header = new JLabel("Panel B BorderLayout (5 regions)", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        wrapper.add(header, BorderLayout.NORTH);

        // inner layout
        JPanel border = new JPanel(new BorderLayout(6, 6));

        // top section
        JLabel north = new JLabel("NORTH (Header / Toolbar area)", SwingConstants.CENTER);
        north.setOpaque(true);
        north.setBackground(new Color(173, 216, 230));
        north.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        north.setPreferredSize(new Dimension(0, 45));
        border.add(north, BorderLayout.NORTH);

        // bottom section
        JLabel south = new JLabel("SOUTH (Footer / Status bar)", SwingConstants.CENTER);
        south.setOpaque(true);
        south.setBackground(new Color(144, 238, 144));
        south.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        south.setPreferredSize(new Dimension(0, 45));
        border.add(south, BorderLayout.SOUTH);

        // left side
        JLabel west = new JLabel("<html><center>WEST<br>Nav</center></html>", SwingConstants.CENTER);
        west.setOpaque(true);
        west.setBackground(new Color(255, 218, 185));
        west.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        west.setPreferredSize(new Dimension(90, 0));
        border.add(west, BorderLayout.WEST);

        // right side
        JLabel east = new JLabel("<html><center>EAST<br>Tools</center></html>", SwingConstants.CENTER);
        east.setOpaque(true);
        east.setBackground(new Color(221, 160, 221));
        east.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        east.setPreferredSize(new Dimension(90, 0));
        border.add(east, BorderLayout.EAST);

        // center content
        JTextArea center = new JTextArea("CENTER\n\nThis is the main content area.\n"
                + "It expands to fill all remaining space\n"
                + "when the window is resized.");

        center.setEditable(false);
        center.setLineWrap(true);
        center.setWrapStyleWord(true);
        center.setBackground(new Color(255, 255, 204));
        center.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        border.add(new JScrollPane(center), BorderLayout.CENTER);

        wrapper.add(border, BorderLayout.CENTER);
        return wrapper;
    }

    // handle button clicks
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

    // main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LayoutShowcaseApp().setVisible(true));
    }
}
