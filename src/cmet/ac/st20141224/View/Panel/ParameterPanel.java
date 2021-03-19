package cmet.ac.st20141224.View.Panel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class ParameterPanel extends JPanel {

    private JPanel form;
    JLabel kValueLbl;
    JButton openLabelBtn;
    JLabel labelPathLbl;
    JTextField labelNameTxt;
    JTextField kValueTxt;
    JFrame mainWindow;

    private SpringLayout panel;
    private JFileChooser fileChooser;

    public ParameterPanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;

        this.panel = new SpringLayout();
        setupPanel();
    }
    private void setupPanel() {
        this.add(form);
        this.add(kValueLbl);
        this.add(kValueTxt);
        this.add(openLabelBtn);
        this.add(labelPathLbl);
        this.add(labelNameTxt);
    }

    public File showDirectoryChooserDialog() {
        this.fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");  // File filter
        fileChooser.setFileFilter(filter);  // Apply file filter
        this.fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        this.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int status = this.fileChooser.showOpenDialog(this.mainWindow);
        File selected_path = null;
        if(status == JFileChooser.APPROVE_OPTION) {
            selected_path = this.fileChooser.getSelectedFile();
        }
        return selected_path;
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    public JLabel getkValueLbl() {
        return kValueLbl;
    }

    public void setkValueLbl(JLabel kValueLbl) {
        this.kValueLbl = kValueLbl;
    }

    public JTextField getkValueTxt() {
        return kValueTxt;
    }

    public void setkValueTxt(JTextField kValueTxt) {
        this.kValueTxt = kValueTxt;
    }

    public JButton getOpenLabelBtn() {
        return openLabelBtn;
    }

    public void setOpenLabelBtn(JButton openLabelBtn) {
        this.openLabelBtn = openLabelBtn;
    }

    public JLabel getLabelPathLbl() {
        return labelPathLbl;
    }

    public void setLabelPathLbl(JLabel labelPathLbl) {
        this.labelPathLbl = labelPathLbl;
    }

    public JTextField getLabelNameTxt() {
        return labelNameTxt;
    }

    public void setLabelNameTxt(JTextField labelNameTxt) {
        this.labelNameTxt = labelNameTxt;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
