package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.*;

public class MyExplorer {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launcher().launch();
            }
        });
    }
}
