package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ScreenSaver extends JFrame {
    public ScreenSaver(){
        Canvas panel = new Canvas();
        add(panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public static void main(String[] args) {
        
        new ScreenSaver().setVisible(true);
    }
}

class Canvas extends JPanel {
    final int CANVAS_WIDTH = 1600;
    final int CANVAS_HEIGHT = CANVAS_WIDTH / 16 * 9;
    Image bouncing;
    int x = 0;
    int y = 0;
    int xVelocity = 2;
    int yVelocity = 2;
    
    int xDirection = 1;
    int yDirection = 1;
    int xEnd;
    int yEnd;
    int actualWidth;
    int actualHeight;
    
    Canvas () {
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setBackground(Color.BLACK);
        
        bouncing = new ImageIcon("data/bouncing.png").getImage();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                xEnd = getWidth() - bouncing.getWidth(null) / 2;
                yEnd = getHeight() - bouncing.getHeight(null) / 2;
            }
        });
        
        Timer t = new Timer(50, e -> doBouncing());
        t.start();
     
//        xEnd = (this.getWidth() - bouncing.getWidth(null)) * -1;
//        yEnd = (this.getHeight() - bouncing.getHeight(null)) * -1;
        
        
    }
    
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(bouncing, x,y, bouncing.getHeight(null) / 2, bouncing.getWidth(null) / 2, null);
    }
    
    void doBouncing(){
//        if (xDirection == 1) {
//            x += xVelocity;
//            if (x > xEnd) xDirection = 0;
//        } else {
//            x -= xVelocity;
//            if (x < 1) xDirection = 1;
//        }
        x += xVelocity;
        if (x > xEnd) xVelocity *= -1;
        if (x < 1) xVelocity *= -1;

//        if (yDirection == 1) {
//            y += yVelocity;
//            if (y > yEnd) yDirection = 0;
//        } else {
//            y -= yVelocity;
//            if (y < 1) yDirection = 1;
//        }
        
        y += yVelocity;
        if (y > yEnd) yVelocity *= -1;
        if (y < 1) yVelocity *= -1;
            
            
        
//        y += yVelocity;
//        x += xVelocity;
        
        repaint();        
    }
}
