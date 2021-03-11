package cmet.ac.st20141224.View.Panel;

import javax.swing.*;
import java.awt.*;

public class RunPanel extends JPanel{
    private JPanel form;
    JButton runModelBtn;
    JFrame mainWindow;

    private SpringLayout panel;

    public RunPanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;

        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(runModelBtn);
    }

    public JButton getRunModelBtn() {
        return runModelBtn;
    }

    public void setRunModelBtn(JButton runModelBtn) {
        this.runModelBtn = runModelBtn;
    }
}
