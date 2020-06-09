package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefreshButton extends JButton implements ActionListener {
    private PathTextField pathTextField;

    public RefreshButton() {
        super();

        java.net.URL iconUrl = RefreshButton.class.getResource("/toolbarButtonGraphics/general/Refresh16.gif");
        this.setIcon(new ImageIcon(iconUrl));

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /*
         * Je pense qu'il suffit d'appeler la bonne méthode dans le champ texte (1 instruction).
         */
        this.pathTextField.actionPerformed(null);
    }

    /* ---------- Injection de dépendances ---------- */

    public void setPathTextField(PathTextField pathTextField) {
        this.pathTextField = pathTextField;
    }
}
