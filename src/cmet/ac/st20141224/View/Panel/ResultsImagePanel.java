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


    /**
     * Adds contents to the panel
     */
    private void setupPanel() {
        this.add(form);
    }


    /**
     * Updates image value (Had to do this - had bug where image always returned null as it was being called before
     * it was assigned from the Algorithm class)
     */
    private void updateImage() {
        this.imageView = new JLabel(new ImageIcon(image));
        this.add(imageView);
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    public SpringLayout getPanel() { return panel; }

    public void setPanel(SpringLayout panel) {
        this.panel = panel;
    }

    public String getImage() { return this.image; }

    public void setImage(String image) { this.image = image;
    updateImage();}
}
