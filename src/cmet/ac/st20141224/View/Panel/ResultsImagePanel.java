package cmet.ac.st20141224.View.Panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResultsImagePanel extends JPanel {

    private JPanel form;
    private String image;
    private JLabel imageView;
    JFrame mainWindow;

    private SpringLayout panel;

    public ResultsImagePanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
    }

    private void updateImage() {
        System.out.println(image);
        this.imageView = new JLabel(new ImageIcon(image));
        this.add(imageView);
    }

    // Getters & setters
    public SpringLayout getPanel() { return panel; }

    public void setPanel(SpringLayout panel) {
        this.panel = panel;
    }

    public String getImage() { return this.image; }

    public void setImage(String image) { this.image = image;
    updateImage();}
}
