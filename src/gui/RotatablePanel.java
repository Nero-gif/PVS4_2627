package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RotatablePanel extends JPanel {
    private boolean isRotated = false;

    public RotatablePanel() {
        super();
    }

    public void setRotated(boolean rotated) {
        this.isRotated = rotated;
        repaint();
    }

    public boolean isRotated() {
        return isRotated;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isRotated) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Ulož původní transformaci
            AffineTransform originalTransform = g2d.getTransform();

            // Střed panelu
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Otočení o 180 stupňů
            g2d.rotate(Math.PI, centerX, centerY);

            // Překresli obsah s rotací
            paintChildren(g2d);

            // Obnoví originální transformaci
            g2d.setTransform(originalTransform);
        }
    }
}

