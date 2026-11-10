package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseDemo extends JFrame {

    public MouseDemo(){
        setLayout(null);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        //jeden label, velky obdelnik
        JLabel label = new JLabel("");
        label.setBackground(Color.red);
        label.setOpaque(true);

        label.setBounds(213,176,100,120);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setBackground(Color.pink);
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                label.setBackground(Color.cyan);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                label.setBackground(Color.black);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setBackground(Color.red);
            }
        });


        add(label);
    }


    public static void main(String[] args) {
        new MouseDemo().setVisible(true);
    }


}
