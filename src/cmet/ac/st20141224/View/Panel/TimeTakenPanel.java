package cmet.ac.st20141224.View.Panel;

import javax.swing.*;

public class TimeTakenPanel extends JPanel {
    private JPanel form;
    private JLabel timeTakenLabel;
    JFrame mainWindow;

    private SpringLayout panel;

    public TimeTakenPanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(timeTakenLabel);
    }

    public JPanel getForm() {
        return form;
    }

    public void setForm(JPanel form) {
        this.form = form;
    }


    public JLabel getTimeTakenLabel() {
        return timeTakenLabel;
    }

    public void setTimeTakenLabel(JLabel timeTakenLabel) {
        this.timeTakenLabel = timeTakenLabel;
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


