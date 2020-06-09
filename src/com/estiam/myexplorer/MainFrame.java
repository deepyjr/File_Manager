package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private List<AbstractButton> toolbarButtons;
    private PathTextField pathTextField;
    private JComponent mainComponent;
    private JMenuBar menuBar;
    private JComponent treeComponant;

    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));

        // MenuBar
        this.setJMenuBar(menuBar);

        // ToolBar
        JToolBar toolBar = new JToolBar();
        for (AbstractButton button: toolbarButtons) {
            toolBar.add(button);
        }
        add(toolBar, BorderLayout.PAGE_START);

        JPanel mainPanel = new JPanel();

        // Tout savoir sur le GridBagLayout: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel path = new JLabel("Path: ");
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(path, c);

        c.gridx = 1;
        c.weightx = 1;
        mainPanel.add(pathTextField, c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.add(mainComponent, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=1;
        c.gridheight=1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.add(treeComponant,c);

        add(mainPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
        setState(Frame.NORMAL);
    }

    /* ---------- Injection de dépendances ---------- */

    public void setToolbarButtons(List<AbstractButton> toolbarButtons) {
        this.toolbarButtons = toolbarButtons;
    }

    public void setPathTextField(PathTextField pathTextField) {
        this.pathTextField = pathTextField;
    }

    public void setMainComponent(JComponent mainComponent) {
        this.mainComponent = mainComponent;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setTreeBar(JComponent treeComponant){ this.treeComponant = treeComponant;}
}
