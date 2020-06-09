package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SortAscendingMenuItem extends JMenuItem implements ActionListener {
    private FileList fileList;
    public SortAscendingMenuItem() {
        super("ascendant");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        List<String> myList = Arrays.asList(this.fileList.getListFile());
        Collections.sort(myList);
        Collections.reverse(myList);
        this.fileList.setData(myList.toArray());
    }
    public void setFileList(FileList fileList) {
        this.fileList = fileList;
    }
}
