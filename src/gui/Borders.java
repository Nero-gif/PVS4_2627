package gui;

import javax.swing.*;
import java.awt.*;

public class Borders extends BorderLayoutExample {
    public Borders() {
       JPanel blackPanel = new JPanel();
       blackPanel.setPreferredSize(new Dimension(100, 100));
       blackPanel.setBackground(Color.BLACK);
       blackPanel.setLayout(new BorderLayout());

       add(blackPanel, BorderLayout.CENTER);

       JPanel panel1 = new JPanel();
       JPanel panel2 = new JPanel();
       JPanel panel3 = new JPanel();
       JPanel panel4 = new JPanel();

       panel1.setPreferredSize(new Dimension(50, 50));
       panel2.setPreferredSize(new Dimension(50, 50));
       panel3.setPreferredSize(new Dimension(50, 50));
       panel4.setPreferredSize(new Dimension(50, 50));

       panel1.setBackground(Color.LIGHT_GRAY);
       panel2.setBackground(Color.GRAY);
       panel3.setBackground(Color.DARK_GRAY);
       panel4.setBackground(Color.WHITE);

       blackPanel.add(panel1,  BorderLayout.NORTH);
       blackPanel.add(panel2,  BorderLayout.SOUTH);
       blackPanel.add(panel3,  BorderLayout.EAST);
       blackPanel.add(panel4,  BorderLayout.WEST);
    }

    public static void main(String[] args) {
        new  Borders().setVisible(true);
    }
}
