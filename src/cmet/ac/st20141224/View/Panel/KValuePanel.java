package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

/**
 * This panel allows the K Value to be displayed on the results JFrame.
 */
public class KValuePanel extends JPanel {
    private JPanel form;
    private JLabel kValueLabel;
    JFrame mainWindow;

    private SpringLayout panel;

    public KValuePanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(kValueLabel);
    }

    public JPanel getForm() {
        return form;
    }

    public void setForm(JPanel form) {
        this.form = form;
    }

    public JLabel getkValueLabel() {
        return kValueLabel;
    }

    public void setkValueLabel(JLabel kValueLabel) {
        this.kValueLabel = kValueLabel;
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
