package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

public class StopPanel extends JPanel{
    private JButton stopButton;
    private JPanel form;
    JFrame mainWindow;

    private SpringLayout panel;

    public StopPanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(stopButton);
    }
}
