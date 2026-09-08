package gui;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {
    public  BorderLayoutExample() {
        // Settings
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        JPanel redPanel = new JPanel();
        redPanel.setPreferredSize(new Dimension(100, 100));
        redPanel.setBackground(Color.RED);

        JPanel bluePanel = new JPanel();
        bluePanel.setPreferredSize(new Dimension(100, 100));
        bluePanel.setBackground(Color.BLUE);

        JPanel greenPanel = new JPanel();
        greenPanel.setPreferredSize(new Dimension(100, 100));
        greenPanel.setBackground(Color.GREEN);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setPreferredSize(new Dimension(100, 100));
        yellowPanel.setBackground(Color.YELLOW);

        add(redPanel, BorderLayout.NORTH);
        add(bluePanel, BorderLayout.SOUTH);
        add(greenPanel, BorderLayout.WEST);
        add(yellowPanel, BorderLayout.EAST);
    }


    public static void main(String[] args) {
        new BorderLayoutExample().setVisible(true);
    }
}
