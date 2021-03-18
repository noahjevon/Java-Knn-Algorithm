package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

public class ResultsImagePanel extends JPanel {

    private JPanel form;
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
        this.add(imageView);
    }

    public JLabel getImageView() {
        return imageView;
    }

    public void setImageView(JLabel imageView) {
        this.imageView = imageView;
    }

    public SpringLayout getPanel() {
        return panel;
    }

    public void setPanel(SpringLayout panel) {
        this.panel = panel;
    }
}
