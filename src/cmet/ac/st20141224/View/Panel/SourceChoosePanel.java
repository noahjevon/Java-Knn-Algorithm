package cmet.ac.st20141224.View.Panel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


/**
 * This panel allows the training dataset files to be selected on the main JFrame.
 */
public class SourceChoosePanel extends JPanel {
    JPanel form;
    JButton openSourceBtn;
    JTextField sourceNameTxt;
    JLabel sourceNameLbl;
    JFrame mainWindow;

    private SpringLayout panel;
    private JFileChooser fileChooser;

    public SourceChoosePanel(JFrame mainWindow) {

        this.mainWindow = mainWindow;
        this.sourceNameTxt.setEnabled(false);

        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(openSourceBtn);
        this.add(sourceNameLbl);
        this.add(sourceNameTxt);
    }

    public File showDirectoryChooserDialog() {
        this.fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BIN files", "bin");  // File filter
        fileChooser.setFileFilter(filter);  // Apply file filter
        this.fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        this.fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

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
    public JButton getOpenSourceBtn() {
        return openSourceBtn;
    }

    public void setOpenSourceBtn(JButton openSourceBtn) {
        this.openSourceBtn = openSourceBtn;
    }

    public JTextField getSourceNameTxt() {
        return sourceNameTxt;
    }

    public void setSourceNameTxt(JTextField sourceNameTxt) {
        this.sourceNameTxt = sourceNameTxt;
    }

    public JLabel getSourceNameLbl() {
        return sourceNameLbl;
    }

    public void setSourceNameLbl(JLabel sourceNameLbl) {
        this.sourceNameLbl = sourceNameLbl;
    }
}
