package exams;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Warehouse extends JFrame {

    ArrayList<Product> data;
    DefaultTableModel model;

    JRadioButton allButton;
    JRadioButton lowStockButton;
    JRadioButton inStockButton;

    JTextField limitField;


    Warehouse() {

        setTitle("Warehouse");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

    }


    void loadData(String filePath) {

    }


    void fillTable(ArrayList<Product> products) {

    }



    public static void main(String[] args) {

        Warehouse window = new Warehouse();
        window.setVisible(true);
    }
}


class Product {

    String name;
    String category;

    int pieces;

    double price;


    public Product(String name,
                   String category,
                   int pieces,
                   double price) {

        this.name = name;
        this.category = category;
        this.pieces = pieces;
        this.price = price;
    }


    public int getPieces() {
        return pieces;
    }


    public double getValue() {
        return 0;
    }


    public String[] getAsTableRow() {

        return new String[]{
                name,
                category,
                String.valueOf(pieces),
                String.format("%.2f", price),
                String.format("%.2f", getValue())
        };
    }
}