package gui;

import javax.swing.*;
import java.awt.*;

public class GridPane extends JFrame {
    final static int DEFAULT_DIM = 10;

    public GridPane(int dim){
        int dimension = dim; //(4-100)

        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(dimension,dimension));

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
            if ((i+j) % 2 == 1)
                add(new Piece(Color.red));
            else
                add(new Piece(Color.cyan));
            }
        }
    }

    public GridPane(){

        this(DEFAULT_DIM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new GridPane().setVisible(true);
    }
}
class Piece extends JLabel {

    //vlastni label, pamatuje si vsechnu konfiguraci
    public Piece(Color color){
        setText(" ");
        setFont(new Font("Arial", Font.PLAIN, 18));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setOpaque(true);
        setBackground(color);
    }
}