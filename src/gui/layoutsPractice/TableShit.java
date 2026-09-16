package gui.layoutsPractice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TableShit extends JFrame {
    final static int WIDTH = 1500;
    final static int HEIGHT = 800;
    
    final static int tilesCount = 110;
    
    public TableShit() {
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
//        topPanel.setBackground(Color.RED);
        topPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT/15));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.add(new JLabel("Query: "));
        topPanel.add(new JTextField(20));
        topPanel.add(new JButton("Go"));
        
        int paddingSize = HEIGHT/80;
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border padding = BorderFactory.createEmptyBorder(paddingSize, paddingSize, paddingSize, 0);
        topPanel.setBorder(BorderFactory.createCompoundBorder(blackBorder, padding));

        JPanel leftPanel = new JPanel();
//        leftPanel.setBackground(Color.GREEN);
        leftPanel.setPreferredSize(new Dimension(WIDTH/5, HEIGHT));
        leftPanel.setLayout(new GridLayout(5, 1));

        JRadioButton optionA = new JRadioButton("Option A");
        JRadioButton optionB = new JRadioButton("Option B");
        JRadioButton optionC = new JRadioButton("Option C");
        JRadioButton optionD = new JRadioButton("Option D");
        JRadioButton optionE = new JRadioButton("Option E");
        
        ButtonGroup options = new ButtonGroup();
        options.add(optionA);
        options.add(optionB);
        options.add(optionC);
        options.add(optionD);
        options.add(optionE);
        
        leftPanel.add(optionA);
        leftPanel.add(optionB);
        leftPanel.add(optionC);
        leftPanel.add(optionD);
        leftPanel.add(optionE);
        
        
        JPanel tablePanel = new JPanel();
//        tablePanel.setBackground(Color.BLUE);
        tablePanel.setLayout(new GridLayout(tilesCount /11, tilesCount /10));
        for (int i = 1; i <= tilesCount; i++) {
            tablePanel.add(new Tile("Tile " + String.valueOf(i)));
        }
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT/35));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(new JLabel(String.valueOf(tilesCount) + " results"));
        


        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        TableShit tableShit = new TableShit();
        tableShit.setVisible(true);
    }
}

class Tile extends JLabel {
    public Tile(String text) {
        setText(text);
        setBackground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        
        int paddingSize = 2;
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border padding = BorderFactory.createEmptyBorder(paddingSize, paddingSize, paddingSize, 0);
        setBorder(BorderFactory.createCompoundBorder(padding, blackBorder));

        setOpaque(true);
    
    }
}
