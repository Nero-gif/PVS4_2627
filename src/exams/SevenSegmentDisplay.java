package exams;


import javax.swing.*;
import java.awt.*;

public class SevenSegmentDisplay extends JFrame {
    JTextField input;

    SevenSegmentDisplay() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        input = new JTextField("Value");
        input.setPreferredSize(new Dimension(500, 100));
        input.setFont(new Font("Consolas", Font.BOLD, 32));
        input.setHorizontalAlignment(SwingConstants.CENTER);

        JButton inButton = new JButton("Go");
        inButton.setPreferredSize(new Dimension(100, 100));
        inButton.setFont(new Font("Consolas", Font.BOLD, 32));

        inButton.addActionListener(e -> doStuff());

        this.add(input);
        this.add(inButton);

        this.pack();
    }

    private void doStuff() {
        //TODO:
        // Pokud je vstup kladné číslo {0, 9} -> otevřít okno
        // jinak -> popup okno s varováním
        new Display().setVisible(true);
    }

    public static void main(String[] args) {
        new SevenSegmentDisplay().setVisible(true);
    }
}

class Display extends JFrame {

    // Může se hodit, ale nemusí
    // Viz obrázek: https://www.ic-components.com/upfile/images/10/20251017135826258.jpg
    static boolean[][] segments = {
            //   a      b      c      d      e      f      g
            {true, true, true, true, true, true, false}, // 0
            {false, true, true, false, false, false, false}, // 1
            {true, true, false, true, true, false, true}, // 2
            {true, true, true, true, false, false, true}, // 3
            {false, true, true, false, false, true, true}, // 4
            {true, false, true, true, false, true, true}, // 5
            {true, false, true, true, true, true, true}, // 6
            {true, true, true, false, false, false, false}, // 7
            {true, true, true, true, true, true, true}, // 8
            {true, true, true, true, false, true, true}  // 9
    };



    Display() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // TODO: Logika

        this.pack();
    }


}