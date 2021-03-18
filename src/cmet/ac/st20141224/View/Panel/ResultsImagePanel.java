package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

public class ResultsImagePanel extends JPanel {

    private JPanel form;
    private String image;
    private JLabel imageView;
    JFrame mainWindow;

    private SpringLayout panel;

    public ResultsImagePanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        System.out.println(image);
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(imageView);
    }

    // Getters & setters
    public SpringLayout getPanel() { return panel; }

    public void setPanel(SpringLayout panel) {
        this.panel = panel;
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }
}
