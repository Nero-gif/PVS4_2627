package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttoning extends JFrame {

    public Buttoning() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 640);
        setLocationRelativeTo(null);

        JButton hideButton = new JButton("Hide");

        hideButton.setFont(new Font("Consolas", Font.BOLD, 24));
        hideButton.setFocusable(false);
        hideButton.setBackground(Color.cyan);
        hideButton.setForeground(new Color(54, 24, 101));
//        button.setForeground(new Color(0x00ff00));

        JButton showButton = new JButton("Show;");
        showButton.setFont(new Font("Consolas", Font.BOLD, 24));
        showButton.setFocusable(false);
        showButton.setBackground(Color.cyan);
        showButton.setForeground(new Color(54, 24, 101));

        //odted musim pouzivat 2D XY system
        setLayout(null);
        JLabel label = new JLabel("neajyk text");

        hideButton.setBounds(200, 0, 240, 100);
        showButton.setBounds(200, 105, 240, 100);
        label.setBounds(200, 300, 240, 100);
        //nejake hrani s labelem
        label.setFont(new Font("Consolas", Font.PLAIN, 24));
        label.setBackground(Color.white);
        label.setForeground(Color.black);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //aby tlacitka neco delala
        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
                label.setBackground(Color.black);
                showButton.setEnabled(true);
                hideButton.setEnabled(false);
            }
        });

        //napsano lambda-formatem
        showButton.addActionListener(a -> {
            label.setBackground(Color.white);

            showButton.setEnabled(false);
            hideButton.setEnabled(true);
        });

        //nelze nyni kliknout
        showButton.setEnabled(false);

        add(label);
        add(hideButton);
        add(showButton);
    }

    public static void main(String[] args) {
        new Buttoning().setVisible(true);
    }
}
