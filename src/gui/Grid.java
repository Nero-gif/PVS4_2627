package gui;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {

    public Grid(){
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5,5));

        for (int i = 0; i < 25; i++) {
            add(new JButton(String.valueOf(i+1)));
        }
//            add(new JButton("Test"), 2, 2);
    }


    public static void main(String[] args) {
        new Grid().setVisible(true);
    }
}
