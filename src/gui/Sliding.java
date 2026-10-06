package gui;

import javax.swing.*;
import java.awt.*;

public class Sliding extends JFrame {

    public Sliding() {
        setSize(420, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel label = new JLabel();
        JSlider slider = new JSlider(-100, 100, 21);

        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);

        label.setText("°C = " + slider.getValue());
        label.setFont(new Font("Roboto", Font.BOLD, 21));


        slider.setForeground(Color.blue);
        slider.setBackground(Color.green);

        slider.addChangeListener(e -> {
            label.setText("°C = " + slider.getValue());
        });

        slider.setOrientation(SwingConstants.VERTICAL);

        panel.add(slider);
        panel.add(label);
        add(panel);
    }

    public static void main(String[] args) {
        new Sliding().setVisible(true);
    }

}
