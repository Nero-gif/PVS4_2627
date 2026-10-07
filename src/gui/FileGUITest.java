package gui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileGUITest {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
    
class MainFrame extends JFrame {
    private static JTextField directoryTextField;

    public MainFrame() {
        setTitle("File statistics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 160);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        directoryTextField = new JTextField();

        // Mimo zadání
        directoryTextField.putClientProperty("JTextField.placeholderText", "Vyber soubor nebo složku...");
        directoryTextField.putClientProperty("JComponent.roundRect", true);

        JPanel buttonPanel = createTopPanel();

        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(directoryTextField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private static JPanel createTopPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JButton loadFileButton = new JButton("Load file");
        JButton showStatisticsButton = new JButton("Show statistic");

        loadFileButton.putClientProperty("JButton.buttonType", "roundRect");
        showStatisticsButton.putClientProperty("JButton.buttonType", "roundRect");

        loadFileButton.addActionListener(e -> loadFile());
        showStatisticsButton.addActionListener(e -> showStatistic());

        buttonPanel.add(loadFileButton);
        buttonPanel.add(showStatisticsButton);
        return buttonPanel;
    }

    private static void loadFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int code = chooser.showOpenDialog(null);

        if (code == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            directoryTextField.setText(selectedFile.getAbsolutePath());
        }
    }

    private static void showStatistic() {
        String path = directoryTextField.getText();

        if (path.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nejdříve vyber soubor nebo složku.");
            return;
        }

        File file = new File(path);

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "Soubor nebo složka neexistuje.");
            return;
        }

        new StatisticsWindow(file).setVisible(true);
    }
}

class StatisticsWindow extends JFrame {
    public StatisticsWindow(File file) {
        setTitle("Statistics");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        /*
         * CENTER
         */
        JPanel statisticsPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        addStatistic(statisticsPanel, "Název:", file.getName());
        addStatistic(statisticsPanel, "Typ:", file.isDirectory() ? "Složka" : "Soubor");
        addStatistic(statisticsPanel, "Cesta:", file.getAbsolutePath());

        /*
         * SOUBOR
         */
        if (file.isFile()) {
            addStatistic(statisticsPanel, "Velikost:", formatSize(file.length()));
        }

        /*
         * SLOŽKA
         */
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            int fileCount = 0;
            int directoryCount = 0;
            long totalSize = 0;
            long largestFileSize = 0;
            File largestFile = null;

            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        fileCount++;
                        long size = f.length();
                        totalSize += size;

                        if (size > largestFileSize) {
                            largestFileSize = size;
                            largestFile = f;
                        }
                    } else if (f.isDirectory()) {
                        directoryCount++;
                    }
                }
            }

            addStatistic(statisticsPanel, "Počet souborů:", String.valueOf(fileCount));
            addStatistic(statisticsPanel, "Počet podsložek:", String.valueOf(directoryCount));
            addStatistic(statisticsPanel, "Celková velikost souborů:", formatSize(totalSize));
            addStatistic(statisticsPanel, "Největší soubor:", largestFile != null ? largestFile.getName() : "-");
            addStatistic(statisticsPanel, "Velikost největšího souboru:", largestFile != null ? formatSize(largestFileSize) : "-");
        }


        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(statisticsPanel, BorderLayout.CENTER);
    }

    /*
     * Přidá dvojici:
     *
     * Název statistiky | Hodnota
     */
    private static void addStatistic(JPanel panel, String name, String value) {
        panel.add(createLabel(name, true));
        panel.add(createLabel(value, false));
    }

    /*
     * Styl labelu
     */
    private static JLabel createLabel(String text, boolean bold) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);

        if (bold) {
            label.setFont(label.getFont().deriveFont(Font.BOLD));
        }

        label.setBackground(UIManager.getColor("Panel.background"));

        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(UIManager.getColor("Component.borderColor")),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)));

        return label;
    }

    /*
     * Převod velikosti souboru
     */
    private static String formatSize(long bytes)  {
        if (bytes < 1024) {
            return bytes + " B";
        }

        double kb = bytes / 1024.0;

        if (kb < 1024) {
            return String.format("%.2f kB", kb);
        }

        double mb = kb / 1024.0;

        if (mb < 1024) {
            return String.format("%.2f MB", mb);
        }

        double gb = mb / 1024.0;

        return String.format("%.2f GB", gb);
    }
}