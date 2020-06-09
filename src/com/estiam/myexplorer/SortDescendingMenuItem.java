package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDescendingMenuItem extends JMenuItem implements ActionListener {
    private FileList fileList;

    public SortDescendingMenuItem() {
        super("descendant");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        List<String> myList = Arrays.asList(this.fileList.getListFile());
        Collections.sort(myList);
        this.fileList.setData(myList.toArray());
    }

    public void setFileList(FileList fileList) {
        this.fileList = fileList;
    }
}
