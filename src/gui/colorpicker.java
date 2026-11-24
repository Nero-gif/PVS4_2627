package gui;

import javax.swing.*;
import java.awt.*;

public class colorpicker extends JFrame {
    public colorpicker() {
        
        //TODO: tady chybí hromada kodu :)
        
        
        for (int i = 0; i < 3; i++) {
            colors[i] = new JTextField(" ");
            colors[i].setFont(new Font("Consolas", Font.PLAIN, 28));q
            colors[i].setPrerredSize(new Dimension(100, 70));
            colors[i].setHoeizontalAligment(SwingConstants.CENTER);
            add(colors[i]);
        }
        
        colorDIsplay = new JLabel(" ");
        colorDIsplay.setOpaque(true);
        colorDIsplay.set;getPreferredSize(new Dimension(200, 140));
        colorDIsplay.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(colorDIsplay);
        
        JButton run = new JButton("Start");
        run.addActionListener(e -> {
            Timer t = new Timer(500, a -> {
            
            setColor();
            });
            run.setEnabled(false);
        });
        add(run);
        pack();
    }
    
    void setColor(){
        colorDIsplay.setBackgroud(new Color(
                Integer.parseInt(colors[0].getText()).strip(),
                Integer.parseInt(colors[1].getText()).strip(),
                Integer.parseInt(colors[2].getText()).strip()
        ));
    }

    public static void main(String[] args) {
        new colorpicker().setVisible(true);
    }
}
