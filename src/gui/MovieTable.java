package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovieTable extends JFrame {
    List<Record> data;

    MovieTable(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(420,640);

        String[] columnNames = {"Name", "Year", "Rating", "Duration"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        loadData("data/Movies.txt");

        add(scrollPane);
        pack();
    }


    void loadData(String filePath){
        try {
            data = Files.lines(Path.of(filePath))
                    .map(line -> line.split(";"))
                    .map(parts -> new Record(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Double.parseDouble(parts[2]),
                            Integer.parseInt(parts[3])
                    )).toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void fillTable(){
        //nejak nacist do String[] radek
    }

    public static void main(String[] args) {
       MovieTable mainWindow =  new MovieTable();
       mainWindow.setVisible(true);
    }


}
class Record {
    String name;
    int yearOfRelease;
    double rating;
    int duration;

    public Record(String name, int yearOfRelease, double rating, int duration) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duration = duration;
    }
}
