package gui;

import javax.swing.*;

public class Options {
    public static void main(String[] args) {
        String vstup = JOptionPane.showInputDialog("Zadej něco.");
        System.out.println(vstup);

        int answer = JOptionPane.showConfirmDialog(null,
                "Uzavrena otazka",
                "Titulek",
                JOptionPane.YES_NO_OPTION);

        JOptionPane.showMessageDialog(null,
                "Uzavrena otazka: " + answer,
                "Titulek",
                JOptionPane.QUESTION_MESSAGE);

        JFileChooser chooser = new JFileChooser();
        int code = chooser.showOpenDialog(null);
        System.out.println(code);
        System.out.println(chooser.getSelectedFile().getAbsolutePath());
    }
}
