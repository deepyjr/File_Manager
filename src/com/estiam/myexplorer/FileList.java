package com.estiam.myexplorer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.*;
import java.io.File;
import java.util.Arrays;

/**
 * La liste des fichiers.
 *
 * Tout savoir sur les listes: https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
 */
public class FileList extends JList implements ListSelectionListener {
    private PathTextField pathTextField;
    private Object[] listFile;


    public String[] getListFile() {
        return (String[]) listFile;
    }

    public void setListFile(Object[] listFile) {
        this.listFile = listFile;
    }

    public FileList() {
        super();

        setLayoutOrientation(JList.VERTICAL);
        // Si vous voulez un affichage sur plusieurs colonnes, à la manière de l'explorateur Windows 10 liste sans les
        // détails, vous pouvez essayer:
        // setLayoutOrientation(JList.HORIZONTAL_WRAP);
        // Vous pourriez même ajouter un bouton sur la barre d'outils pour passer d'un mode de visualisation à l'autre
        // comme l'explorateur Windows le permet.

        // Dans un fonctionnement plus sophistiqué de l'application, nous pourrions permettre d'autres modes de
        // sélection mais ici on fait au plus simple.
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addListSelectionListener(this);
    }

    public void setData(Object[] files) {
        this.setListData(files);
        this.setListFile(files);
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (getSelectedIndex() != -1) {
            pathTextField.itemSelected((String) this.getSelectedValue());
        }
    }
    
    public void creatingTree(File file, DefaultMutableTreeNode parentNode){
        for(int i = 0; i<file.list().length; i++){
            System.out.println(file.list()[i]);
            parentNode.add(new DefaultMutableTreeNode(file.list()[i]));
            if (file.listFiles()[i].isDirectory()){
                creatingTree(file.listFiles()[i],(DefaultMutableTreeNode) parentNode.getLastChild());
            }
        }
    }
    public DefaultMutableTreeNode setDataTree(){
        File racineFile = new File(this.pathTextField.getText());
        String racineFileString = racineFile.getName();
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode(racineFileString);

        this.creatingTree(racineFile,racine);

        return racine;

    }
 
    /* ---------- Injection de dépendances ---------- */

    public void setPathTextField(PathTextField pathTextField) {
        this.pathTextField = pathTextField;
    }

}

