package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpButton extends JButton implements ActionListener {
    private PathTextField pathTextField;

    public UpButton() {
        super();

        java.net.URL iconUrl = UpButton.class.getResource("/toolbarButtonGraphics/navigation/Up16.gif");
        this.setIcon(new ImageIcon(iconUrl));

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /*
         * Je pense qu'il suffit d'appeler une méthode dans le champ texte (1 instruction).
         */
        this.pathTextField.up();
    }

    /* ---------- Injection de dépendances ---------- */

    public void setPathTextField(PathTextField pathTextField) {
        this.pathTextField = pathTextField;
    }
}
