package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * L'option de menu "A propos de MyExplorer.
 */
public class AboutMenuItem extends JMenuItem implements ActionListener {
    private MainFrame mainFrame;

    public AboutMenuItem() {
        super("A propos de MyExplorer");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // TODO Implémenter un petit dialogue
        // Une instruction peut suffire; vous pouvez utiliser un JOptionPane
        // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
        //default title and icon
        // create a jframe
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");

        // show a joptionpane dialog using showMessageDialog
        JOptionPane.showMessageDialog(frame, "Voila le résumé de mon Application ");
    }
    public static void main(String[] args)
    {


    }

    /* ---------- Injection de dépendances ---------- */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
