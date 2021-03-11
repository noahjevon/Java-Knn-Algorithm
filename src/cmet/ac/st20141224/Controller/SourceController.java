package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.Model.Model;
import cmet.ac.st20141224.View.MainView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;

public class SourceController {
//    ArrayList sources       = new ArrayList();  // Array to store source file names
//    ArrayList sourcesPath   = new ArrayList(); // Array to store source paths
//    String sourcesString    = "";
//
//    JFileChooser fileChooser;  // File chooser to allow selection
//
//    Model   model;
//    MainView view;
//
//    public SourceController(Model model, MainView view) {
//        this.model  = model;
//        this.view   = view;
//
//        initController();
//    }
//
//    public void initController() {
//        this.view.btnSrc.addActionListener((ae) -> selectSource());
//    }
//
//    private void selectSource() {
//        // Create a new JFrame container
//        JFrame jfrm = new JFrame("Select Source");
//
//        // Creating file filter to only show .bin files
//        this.fileChooser = new JFileChooser();
//        fileChooser.setMultiSelectionEnabled(true);  // Allow multiple selection
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("BIN file", "bin");  // File filter
//        fileChooser.setFileFilter(filter);  // Apply file filter
//        int result = fileChooser.showOpenDialog(jfrm);  // Open form
//
//        if (result == JFileChooser.APPROVE_OPTION) {  // If file approved
//            File[] selectedFile = fileChooser.getSelectedFiles();
//
//            for (File file : selectedFile) {
//                String name = file.getName();  // Get source name, append to array + string
//                sources.add(name);
//                sourcesString += name + " ";
//
//                String path = file.getAbsolutePath();  // Get source path, append to array + string
//                sourcesPath.add(path);
//            }
//            this.model.setSourcetext(sourcesString);  // Updating labels
//            this.view.jlabSrc.setText(this.model.getInputtext());
//        }
//    }
}
