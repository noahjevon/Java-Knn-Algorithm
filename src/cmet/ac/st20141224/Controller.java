package cmet.ac.st20141224;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileFilter.*;

public class Controller {
    ArrayList<String> images = new ArrayList<>();  // Array to store image file names
    ArrayList<String> imagesPath = new ArrayList<>(); // Array to store image paths
    String imagesString = "";

    ArrayList sources = new ArrayList();  // Array to store source file names
    ArrayList sourcesPath = new ArrayList(); // Array to store source paths
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
        images.clear();  // Clearing arrays & string
        imagesPath.clear();
        imagesString = "";

        this.model.setImagetext(imagesString);  // Resetting labels
        this.view.jlabImg.setText(this.model.getInputtext());

        // Create a new JFrame container
        JFrame jfrm = new JFrame("Select Image");

        // Creating file filter to only show .png images
        this.fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);  // Allow multiple selection
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG file", "png");  // File filter
        fileChooser.setFileFilter(filter);  // Apply file filter
        int result = fileChooser.showOpenDialog(jfrm);  // Open form

        if (result == JFileChooser.APPROVE_OPTION) {  // If file is approved
            File[] selectedFile = fileChooser.getSelectedFiles();

            for (File file : selectedFile) {
                String name = file.getName();  // Get image name
                String path = file.getAbsolutePath();  // Get image path

                // Loading image
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                int image_width = img.getWidth();  // Getting image width and height
                int image_height = img.getHeight();

                if (image_width > 32 && image_height > 32) {  // Checking to see if image is over-sized
                    System.out.println("Image " + path + " " + name + " greater than 32x32.");  // Informing user
                }
                else {  // Image not over-sized. Adding metadata to arrays & string.
                    images.add(name);
                    imagesPath.add(path);
                    imagesString += name + " ";
                }
            }
            this.model.setImagetext(imagesString);  // Updating labels
            this.view.jlabImg.setText(this.model.getInputtext());
        }
    }

    private void selectSource() {
        // Create a new JFrame container
        JFrame jfrm = new JFrame("Select Source");

        // Creating file filter to only show .bin files
        this.fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);  // Allow multiple selection
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BIN file", "bin");  // File filter
        fileChooser.setFileFilter(filter);  // Apply file filter
        int result = fileChooser.showOpenDialog(jfrm);  // Open form

        if (result == JFileChooser.APPROVE_OPTION) {  // If file approved
            File[] selectedFile = fileChooser.getSelectedFiles();

            for (File file : selectedFile) {
                String name = file.getName();  // Get source name, append to array + string
                sources.add(name);
                sourcesString += name + " ";

                String path = file.getAbsolutePath();  // Get source path, append to array + string
                sourcesPath.add(path);
            }
            this.model.setSourcetext(sourcesString);  // Updating labels
            this.view.jlabSrc.setText(this.model.getInputtext());
        }
    }

    private void runModel() {
        // Make file input streams for data and images - loop through array, start new thread for each
        System.out.println("Ran model.");
    }
}

