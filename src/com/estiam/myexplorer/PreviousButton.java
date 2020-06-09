package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Le bouton "Marche arrière" dans la barre d'icônes.
 */
public class PreviousButton extends JButton implements ActionListener {
    private PathTextField pathTextField;

    public PreviousButton() {
        super();

        java.net.URL iconUrl = PreviousButton.class.getResource("/toolbarButtonGraphics/navigation/Back16.gif");
        this.setIcon(new ImageIcon(iconUrl));

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /*
         * Je pense qu'il suffit d'appeler une méthode dans le champ texte (1 instruction).
         */
        this.pathTextField.previous();
    }

    /* ---------- Injection de dépendances ---------- */

    public void setPathTextField(PathTextField pathTextField) {
        this.pathTextField = pathTextField;
    }
}
