package com.estiam.myexplorer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Cette classe crée les principaux objets de l'application.
 *
 * Elle utilise à plein le principe de l'injection de dépendances en centralisant la création des objets et en injectant
 * dans chaque objet ceux dont il a besoin.
 * Sans utilisation de l'injection de dépendances les applications Swing ont tendance à regrouper toute la machinerie
 * graphique au sein de la même classe et c'est rapidement difficile à gérer.
 */
public class Launcher {
    public void launch() {
        MainFrame mainFrame = new MainFrame();


        FileList fileList = new FileList();
        JScrollPane scrollPane = new JScrollPane(fileList);



        PathTextField pathTextField = new PathTextField();
        pathTextField.setMainFrame(mainFrame);
        pathTextField.setFileList(fileList);

        fileList.setPathTextField(pathTextField);

        PreviousButton previousButton = new PreviousButton();
        previousButton.setPathTextField(pathTextField);

        UpButton upButton = new UpButton();
        upButton.setPathTextField(pathTextField);

        RefreshButton refreshButton = new RefreshButton();
        refreshButton.setPathTextField(pathTextField);

        List<AbstractButton> toolbarButtons = new ArrayList<>();
        toolbarButtons.add(previousButton);
        toolbarButtons.add(upButton);
        toolbarButtons.add(refreshButton);

        // Tout sur les barres de menu: https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
        JMenuBar menuBar = new JMenuBar();
        JMenu sortMenu = new JMenu("Trier par");
        menuBar.add(sortMenu);

        JMenu sortByName = new JMenu("Ordre alphabétique");
        sortMenu.add(sortByName);

        SortAscendingMenuItem sortAscendingMenuItem = new SortAscendingMenuItem();
        sortByName.add(sortAscendingMenuItem);
        // Ajout Montant
        sortAscendingMenuItem.setFileList(fileList);

        SortDescendingMenuItem sortDescendingMenuItem = new SortDescendingMenuItem();
        // Ajout Descendant
        sortDescendingMenuItem.setFileList(fileList);
        sortByName.add(sortDescendingMenuItem);

        sortMenu.addSeparator();

        GroupDirectoriesMenuItem groupDirectoriesMenuItem = new GroupDirectoriesMenuItem();
        sortMenu.add(groupDirectoriesMenuItem);

        JMenu helpMenu = new JMenu("Aide");
        menuBar.add(helpMenu);
        AboutMenuItem aboutMenuItem = new AboutMenuItem();
        aboutMenuItem.setMainFrame(mainFrame);
        helpMenu.add(aboutMenuItem);


        //tree
        TreeBar treeBar = new TreeBar(fileList.setDataTree());

        JScrollPane treeScrollPane = new JScrollPane(treeBar);

        //--------------tree

        pathTextField.actionPerformed(null);
        mainFrame.setTreeBar(treeScrollPane);

        mainFrame.setMenuBar(menuBar);
        mainFrame.setToolbarButtons(toolbarButtons);
        mainFrame.setPathTextField(pathTextField);
        mainFrame.setMainComponent(scrollPane);
        mainFrame.init();



    }
}
