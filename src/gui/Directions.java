package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Directions extends JFrame implements KeyListener {

    JLabel block;

    public Directions(){
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        addKeyListener(this);
        setLayout(null);
        block = new JLabel();
        block.setBounds(0,0,50,50);
        block.setBackground(Color.red);
        block.setOpaque(true);
        add(block);
    }

    public static void main(String[] args) {
        new Directions().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Zmacknuto: " + e.getKeyChar());
        switch (e.getKeyChar()){
            case 'a':block.setLocation(block.getX()-5, block.getY()); break;
            case 'w':block.setLocation(block.getX(), block.getY()-5); break;
            case 's':block.setLocation(block.getX(), block.getY()+5); break;
            case 'd':block.setLocation(block.getX()+5, block.getY()); break;
            default:
                System.out.println("Neznam :("); break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("Zmacknuto: " + e.getKeyChar());
//        System.out.println("Zmacknuto: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("pusteno: " + e.getKeyChar());
//        System.out.println("pusteno: " + e.getKeyCode());
    }
}
