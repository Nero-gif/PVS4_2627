package exams;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

public class tableProductsExam extends JFrame {
    ArrayList<Record> data;
    DefaultTableModel model;

    tableProductsExam(){


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(420,640);
        setLayout(new BorderLayout());

        JPanel upperPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());

        JRadioButton allButton = new JRadioButton("All");
        JRadioButton lowSButton = new JRadioButton("Low stock");
        JRadioButton inSButton = new JRadioButton("In stock");


        ButtonGroup group = new ButtonGroup();
        group.add(allButton);
        group.add(lowSButton);
        group.add(inSButton);


        allButton.setFocusable(false);
        lowSButton.setFocusable(false);
        inSButton.setFocusable(false);

        allButton.setSelected(true); //nejaky jeden defaultni
        
        JLabel label = new JLabel("Low stock below: ");
        JTextField lowField = new JTextField(5);
        lowField.setText("0");
        
        JButton applyButton = createApplyButton(allButton, lowSButton, inSButton, lowField);
        applyButton.setFocusable(false);

        upperPanel.add(allButton);
        upperPanel.add(lowSButton);
        upperPanel.add(inSButton);
        upperPanel.add(label);
        upperPanel.add(lowField);
        
        upperPanel.add(applyButton);

        String[] columnNames = {"Product", "Category", "Pieces", "Price", "Value"};
        model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        loadData("data/Products.txt", bottomPanel);
        fillTable();
        
        


        add(upperPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        pack();
    }

    private JButton createApplyButton(JRadioButton allButton, JRadioButton lowSButton, JRadioButton inSButton, JTextField lowField) {
        JButton applyButton = new JButton("Apply");
        //TODO: funkce aply
        applyButton.addActionListener(e -> {
            int lowFieldInt = Integer.parseInt(lowField.getText());
            ArrayList<Record> filtered = data;
            if (allButton.isSelected()){
            }
            if (lowSButton.isSelected()){
                filtered = new ArrayList<>(data.stream()
                        .filter(record -> record.getPieces() < lowFieldInt)
                        .toList());
            }
            if (inSButton.isSelected()){
                filtered = new ArrayList<>(data.stream()
                        .filter(record -> record.getPieces() > 0)
                        .toList());
            }
            System.out.println(filtered);
            refreshData(filtered);
        });
        return applyButton;
    }
    
    
    JPanel loadData(String filePath, JPanel bottomPanel){
        //TODO: repair
        try {
            data = new ArrayList<>(Files.lines(Path.of(filePath))
                    .map(line -> line.split(";"))
                    .map(parts -> new Record(
                            parts[0],
                            parts[1],
                            Integer.parseInt(parts[2]),
                            Double.parseDouble(parts[3]),
                            Double.parseDouble(parts[3])*Integer.parseInt(parts[2])
                    )).toList() );

            JLabel productsCount = new JLabel("Products count: " + data.size());
            JLabel totalValue = new JLabel("Total value: " + 0);
            bottomPanel.add(productsCount);
            bottomPanel.add(totalValue);
            return bottomPanel;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void refreshData(ArrayList<Record> data){
        model.setRowCount(0);
        for (Record record : data){
            model.addRow(record.getAsTableRow());
        }
    }

    void fillTable(){
        for (Record record : data){
            model.addRow(record.getAsTableRow());
        }
    }

    public static void main(String[] args) {
        tableProductsExam mainWindow =  new tableProductsExam();
        mainWindow.setVisible(true);
    }


}
class Record {
    String product;
    String category;
    int pieces;
    Double price;
    Double value;


    public Record(String product, String category, int pieces, Double price, Double value) {
        this.product = product;
        this.category = category;
        this.pieces = pieces;
        this.price = price;
        this.value = value;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Record{" +
                "product='" + product + '\'' +
                ", category='" + category + '\'' +
                ", pieces=" + pieces +
                ", price=" + price +
                ", value=" + value +
                '}';
    }

    public String[] getAsTableRow(){
        return new String[]{product, category, String.valueOf(pieces), String.valueOf(price), String.valueOf(value)};
    }
}
