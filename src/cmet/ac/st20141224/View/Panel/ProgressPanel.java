package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

public class ProgressPanel extends JPanel {
    private JPanel form;
    private JLabel progressLabel;
    JFrame mainWindow;

    private SpringLayout panel;

    public ProgressPanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(progressLabel);
    }

    public JLabel getProgressLabel() {
        return progressLabel;
    }

    public void setProgressLabel(JLabel progressLabel) {
        this.progressLabel = progressLabel;
    }
}
