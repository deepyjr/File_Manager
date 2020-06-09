package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GroupDirectoriesMenuItem extends JCheckBoxMenuItem implements ItemListener {
    public GroupDirectoriesMenuItem() {
        super("Grouper les répertoires");
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {

    }
}
