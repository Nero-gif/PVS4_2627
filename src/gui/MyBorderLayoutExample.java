package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class MyBorderLayoutExample extends JFrame {
    private final RotatingPanel rotatingPanel;
    
    public MyBorderLayoutExample() {
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Vytvoř custom rotating panel
        rotatingPanel = new RotatingPanel();
        rotatingPanel.setLayout(new BorderLayout());
        setContentPane(rotatingPanel);
        
        JPanel panelWest = new JPanel();
        panelWest.setBackground(Color.GREEN);
        panelWest.setPreferredSize(new Dimension(100, 100));
        
        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.BLUE);
        panelNorth.setPreferredSize(new Dimension(100, 100));
        
        JPanel panelEast = new JPanel();
        panelEast.setBackground(Color.ORANGE);
        panelEast.setPreferredSize(new Dimension(100, 100));

        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.RED);
        panelSouth.setPreferredSize(new Dimension(100, 100));

        rotatingPanel.add(panelWest, BorderLayout.WEST);
        rotatingPanel.add(panelNorth, BorderLayout.NORTH);
        rotatingPanel.add(panelEast, BorderLayout.EAST);
        rotatingPanel.add(panelSouth, BorderLayout.SOUTH);
        
        JButton rotateColors = new JButton("RotateColors");
        rotatingPanel.add(rotateColors, BorderLayout.CENTER);
        rotateColors.addActionListener(e -> rotatingPanel.rotateBy90());
        
    }
    
    // Vnitřní třída pro rotate-able panel s Graphics2D transformací
    private class RotatingPanel extends JPanel {
        private double rotationAngle = 0; // Úhel rotace v radiánech
        
        public void rotateBy90() {
            // Přidej 90 stupňů (Math.PI / 2 radiánů)
            rotationAngle += Math.PI / 2;
            // Resetuj na 0 po 360 stupních
            if (rotationAngle >= 2 * Math.PI) {
                rotationAngle = 0;
            }
            repaint();
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
        
        @Override
        protected void paintChildren(Graphics g) {
            if (rotationAngle != 0) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Ulož původní transformaci
                AffineTransform originalTransform = g2d.getTransform();
                
                // Střed panelu
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                
                // Otočení o aktuální úhel
                g2d.rotate(rotationAngle, centerX, centerY);
                
                // Překresli obsah s rotací
                super.paintChildren(g2d);
                
                // Obnoví originální transformaci
                g2d.setTransform(originalTransform);
            } else {
                super.paintChildren(g);
            }
        }
    }

    public static void main(String[] args) {
        new MyBorderLayoutExample().setVisible(true);
    }
}
