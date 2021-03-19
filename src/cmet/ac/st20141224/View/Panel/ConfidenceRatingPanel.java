package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

public class ConfidenceRatingPanel extends JPanel{
    private JPanel form;
    private JLabel confidenceRating;
    JFrame mainWindow;

    private SpringLayout panel;

    public ConfidenceRatingPanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    /**
     * Adds contents to the panel
     */
    private void setupPanel() {
        this.add(form);
        this.add(confidenceRating);
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    public JLabel getConfidenceRating() {
        return confidenceRating;
    }

    public void setConfidenceRating(JLabel confidenceRating) {
        this.confidenceRating = confidenceRating;
    }
}
