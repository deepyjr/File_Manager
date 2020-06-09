package com.estiam.myexplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;

/**
 * Le champ texte qui contient le nom du répertoire courant.
 *
 * Tout savoir sur les JTextField: https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
 */
public class PathTextField extends JTextField implements ActionListener {
    private FileList fileList;
    private JFrame mainFrame;

    private File previousPath;
    private File currentPath;

    /**
     * Constructeur.
     * Il initialise la valeur du chemin au répertoire courant (celui dans lequel se trouve votre projet) et câble le
     * gestionnaire d'événements.
     */
    public PathTextField() {
        this.setText(System.getProperty("user.dir"));
        this.addActionListener(this);
    }

    /**
     * Le gestionnaire d'événements associé au champ texte.
     * Cette méthode est appelée lorsque vous changez la valeur du champ texte contenant le chemin courant.
     *
     * @param actionEvent les données associées à l'événement. Comme nous ne les utilisons pas, il est permis de passer
     *                    null.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /*
         * Cette méthode est vraiment au coeur de l'action.
         *
         * Ce qu'il faut faire ici: réclupérer la valeur du champ texte (this) et construire une nouvelle instance
         * de la classe File (https://docs.oracle.com/javase/7/docs/api/java/io/File.html)
         *
         * Il y a une méthode dans cette classe qui renvoie un booléen si le chemin (dossier ou fichier) existe,
         * et une autre pour savoir s'il s'agit d'un répertoire.
         *
         * Conditionnel:
         * - si le chemin existe et que c'est un répertoire, mettez le currentPath dans previousPath; currentPath
         *   devient le chemin que vous avez calculé ci-dessus; mettez dans fileList le contenu du chemin (fichiers et
         *   dossiers). 3 instructions
         * - si le chemin n'existe pas, affichez un dialogue avec un message d'erreur (1 instruction)
         *   https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
         */
        String[] pathnames;
        this.getText();
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");


        // Get the file
        File f = new File(this.getText());

        // Check if the specified file Exists or not
        if (f.exists())
            System.out.println("Exists");
        else
            JOptionPane.showMessageDialog(frame, "Error, this file doesn't exist");

        // Check if the specified file is a directory or not
        if (f.isDirectory()) {
            System.out.println("directory");

            // define paths
            this.previousPath = this.currentPath;
            this.currentPath = f;

            pathnames = f.list();

            this.fileList.setData(pathnames);
        }
        else
            JOptionPane.showMessageDialog(frame, "Error, this is not a directory");
    }

    public void previous() {
        /*
         * 2 instructions:
         * - Mettre dans le champ texte la valeur de previousPath
         * - Appelez actionPerformed en passant null pour rafraîchir la liste
         */
        if (previousPath != null)
            this.setText(previousPath.getAbsolutePath());
        this.actionPerformed(null);

    }

    public void up() {

        try {
            // Create a file object
            File f = this.currentPath;

            // Get the Parent of the given file f
            File Parent = f.getParentFile();

            // Display the file Parent file of the file object
            System.out.println("File Parent : "+ Parent.getPath());

            this.setText(Parent.getPath());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.actionPerformed(null);
    }

    public void itemSelected(String selectedValue) {
        /*
         * Cette méthode sera appelée lorsqu'on sélectionne une valeur dans la liste.
         * Calculez le nouveau chemin en ajoutant la valeur sélectionnée, passée en paramètre, à currentPath
         * (il y a une méthode dans la classe File pour cela, n'utilisez pas de concaténation de chaîne de caractères,
         * vous tomberiez dans le piège des séparateurs, qui dépendent du système).
         * Conditionnel:
         * - si ce "File" existe et est un dossier, mettez dans le champ texte la valeur du chemin que vous avez calculé
         *   et puis appelez actionPerformed en passant null pour rafraîchir la liste.
         * - il n'y a pas d'alternative (si ces conditions ne sont pas remplies, ne faites rien).
         */
        File test = new File(this.currentPath, selectedValue);
        this.setText(String.valueOf(test));
        this.actionPerformed(null);
    }

    /* ---------- Injection de dépendances ---------- */

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setFileList(FileList fileList) {
        this.fileList = fileList;
    }
}
