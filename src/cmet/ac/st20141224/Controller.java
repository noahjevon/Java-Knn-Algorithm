package cmet.ac.st20141224;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;


public class Controller {
    ArrayList images = new ArrayList();  // Array to store image file names
    String imagesString = "";

    ArrayList sources = new ArrayList();  // Array to store source file names
    String sourcesString = "";

    JFileChooser fileChooser;  // File chooser to allow selection

    Model model;
    Main view;

    public Controller(Model model, Main view) {
        this.model = model;
        this.view = view;

        initController();
    }

    private void initController() {
        this.view.btnImage.addActionListener((ae) -> selectImage());
        this.view.btnSrc.addActionListener((ae) -> selectSource());
        this.view.btnRun.addActionListener((ae) -> runModel());
    }

    private void selectImage() {
        // Create a new JFrame container
        JFrame jfrm = new JFrame("Select Image");

        this.fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);  // Allow multiple selection
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG file", "png");  // File filter
        fileChooser.setFileFilter(filter);  // Apply file filter
        int result = fileChooser.showOpenDialog(jfrm);  // Open form

        if (result == JFileChooser.APPROVE_OPTION) {  // If file is approved
            File[] selectedFile = fileChooser.getSelectedFiles();

            for (File file : selectedFile) {
                String path = file.getName();
                System.out.println(("Selected file: " + path));
                images.add(path);
                imagesString += path + " ";
            }
            System.out.println(imagesString);
            this.model.setImagetext(imagesString);
            this.view.jlabImg.setText(this.model.getInputtext());
        }
    }

    private void selectSource() {
        // Create a new JFrame container
        JFrame jfrm = new JFrame("Select Source");

        this.fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);  // Allow multiple selection
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BIN file", "bin");  // File filter
        fileChooser.setFileFilter(filter);  // Appyl file filter
        int result = fileChooser.showOpenDialog(jfrm);  // Open form

        if (result == JFileChooser.APPROVE_OPTION) {  // If file approved
            File[] selectedFile = fileChooser.getSelectedFiles();

            for (File file : selectedFile) {
                String path = file.getName();
                System.out.println(("Selected file: " + path));
                sources.add(path);
                sourcesString += path + " ";
            }
            System.out.println(sourcesString);
            this.model.setSourcetext(sourcesString);
            this.view.jlabSrc.setText(this.model.getInputtext());
        }
    }

    private void runModel() {
        System.out.println("Ran model.");
    }



}
