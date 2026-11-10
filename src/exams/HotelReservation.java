package exams;


import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class HotelReservation extends JFrame {
    public HotelReservation() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 640);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Hotel Reservation");
        JPanel all = new JPanel();
        
        all.setLayout(new GridLayout(6, 2));
        
        JLabel label1 = new JLabel("Guest Name");
        JLabel label2 = new JLabel("Room type");
        JLabel label3 = new JLabel("Days");
        JLabel label4 = new JLabel("Room number");
        JLabel label5 = new JLabel("Extra bed");
        
        
        TextField tf = new TextField();
        JRadioButton r1 = new JRadioButton("Single");
        JRadioButton r2 = new JRadioButton("Double");
        JRadioButton r3 = new JRadioButton("Apartment");
        ButtonGroup bg = new ButtonGroup();
        JPanel radio = new JPanel();
        JSlider slider = new JSlider();
        TextField tf2 = new TextField();
        JCheckBox chb = new JCheckBox();
        
        
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        r1.setSelected(true);
        slider.setMinimum(0);
        slider.setMaximum(80);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        
        JButton reserve = new JButton("Reserve");
        JButton clear = new JButton("Clear");


        
        radio.add(r1);
        radio.add(r2);
        radio.add(r3);
        
        all.add(label1);
        all.add(tf);
        all.add(label2);
        all.add(radio);
        all.add(label3);
        all.add(slider);
        all.add(label4);
        all.add(tf2);
        all.add(label5);
        all.add(chb);
        all.add(reserve);
        all.add(clear);

        add(label);
        add(all);
        
        List reservation = new List();
        List errors = new List();
        AtomicBoolean err = new AtomicBoolean(false);
        
        
        reserve.addActionListener(e ->{
            if (tf.getText().length() > 5) {
                reservation.add("Name: " + tf.getText());
            }
            else {
                errors.add("Invalid guest name");
                err.set(true);
                
            }
            
            if (r1.isSelected()) reservation.add("Room type: Single");
            else if (r2.isSelected()) reservation.add("Room type: Double");
            else if (r3.isSelected()) reservation.add("Room type: Apartment");
            
                        
            if (r3.isSelected()) {
                if (slider.getValue() > 19) reservation.add(String.valueOf(slider.getValue()));
                else {
                    err.set(true);
                    errors.add("For apartment must be reserved 20 or more days.");
                }
            }
            else if (slider.getValue() > 0) reservation.add(String.valueOf(slider.getValue()));
            else {
                err.set(true);
                errors.add("You must set 1+ days");
            }
            
            if (Integer.parseInt(tf2.getText()) > 99  && Integer.parseInt(tf2.getText()) < 800){
                reservation.add("Room number: " + tf2.getText());
            }
            else {
                err.set(true);
                errors.add("Number must be in range 100 to 799");
            }
            
            if (chb.isSelected()) {
                if (r1.isSelected()) {
                    err.set(true);
                    errors.add("Extra bed is not allowed for single rooms");
                }
                else reservation.add("Extra bed");
            }
            else reservation.add("no extra bed");
            
            if (err.get()) JOptionPane.showMessageDialog(null, errors, "user error", JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(null, reservation, "reservation", JOptionPane.INFORMATION_MESSAGE);
        });
        
        clear.addActionListener(e -> {
            tf.setText("");
            r1.setSelected(true);
            slider.setValue(1);
            tf2.setText("");
            chb.setSelected(false);
        });
        
    }
    
    
    public static void main(String[] args) {
        new HotelReservation().setVisible(true);
    }
}
