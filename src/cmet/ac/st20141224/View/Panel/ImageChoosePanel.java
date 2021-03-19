package cmet.ac.st20141224.View.Panel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class ImageChoosePanel extends JPanel {

    JPanel form;
    JButton openImageBtn;
    JLabel imagePathLbl;
    JTextField imageNameTxt;
    JFrame mainWindow;

    private SpringLayout panel;

    private JFileChooser fileChooser;

    public ImageChoosePanel(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.panel = new SpringLayout();
        setupPanel();
    }

    private void setupPanel() {
        this.add(form);
        this.add(openImageBtn);
        this.add(imagePathLbl);
        this.add(imageNameTxt);
    }

    public File showDirectoryChooserDialog() {
        this.fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG file", "png");  // File filter
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
    public JButton getOpenImageBtn() {
        return openImageBtn;
    }

    public void setOpenImageBtn(JButton openImageBtn) {
        this.openImageBtn = openImageBtn;
    }

    public JLabel getImagePathLbl() {
        return imagePathLbl;
    }

    public void setImagePathLbl(JLabel imagePathLbl) {
        this.imagePathLbl = imagePathLbl;
    }

    public JTextField getImageNameTxt() {
        return imageNameTxt;
    }

    public void setImageNameTxt(JTextField imageNameTxt) {
        this.imageNameTxt = imageNameTxt;
    }

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void setData(ImageChoosePanel data) {
    }

    public void getData(ImageChoosePanel data) {
    }

    public boolean isModified(ImageChoosePanel data) {
        return false;
    }
}
