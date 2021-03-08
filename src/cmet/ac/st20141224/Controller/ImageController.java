package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.Model.Model;
import cmet.ac.st20141224.View.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageController {
    ArrayList<String> images = new ArrayList<>();  // Array to store image file names
    ArrayList<String> imagesPath = new ArrayList<>(); // Array to store image paths
    String imagesString = "";

    JFileChooser fileChooser;  // File chooser to allow selection

    Model model;
    Main view;

    public ImageController(Model model, Main view) {
        this.model = model;
        this.view = view;

        initController();
    }

    public void initController() {
        this.view.btnImage.addActionListener((ae) -> selectImage());
    }

    public void selectImage() {
        images.clear();  // Clearing arrays & string
        imagesPath.clear();
        imagesString = "";

        this.model.setImagetext(imagesString);  // Resetting labels
        this.view.jlabImg.setText(this.model.getInputtext());

        // Create a new JFrame container
        JFrame jfrm = new JFrame("Select Image");

        // Filechooser to select images
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
                    JOptionPane.showMessageDialog(jfrm, "Image: " + name + " over 32x32 px. Could not load.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else {  // Image not over-sized. Adding metadata to arrays & string.
                    images.add(name);
                    imagesPath.add(path);
                    imagesString += name + " ";
                }
            }
            if (images.size() > 3) {
                this.model.setImagetext(imagesString);  // Updating labels
                this.view.jlabImgDir.setText("Images Selected: Lots!");
            }
            else {
                this.model.setImagetext(imagesString);  // Updating labels
                this.view.jlabImgDir.setText(this.model.getInputtext());
            }
        }
    }
}
