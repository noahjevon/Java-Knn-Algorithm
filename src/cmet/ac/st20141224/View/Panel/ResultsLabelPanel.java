package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

/**
 * This panel allows the true and predicted labels to be displayed on the results JFrame.
 */
public class ResultsLabelPanel extends JPanel {

    private JPanel form;
    private JLabel imageLabel;
    private JLabel resultLabel;
    JFrame mainWindow;

    private SpringLayout panel;

    public ResultsLabelPanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(imageLabel);
        this.add(resultLabel);
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    public JPanel getForm() {
        return form;
    }

    public void setForm(JPanel form) {
        this.form = form;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public void setResultLabel(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }

    public SpringLayout getPanel() {
        return panel;
    }

    public void setPanel(SpringLayout panel) {
        this.panel = panel;
    }
}


