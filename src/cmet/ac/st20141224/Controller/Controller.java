package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.FileIO.CheckParams;
import cmet.ac.st20141224.View.MainView;
import cmet.ac.st20141224.Model.Model;

import javax.swing.*;
import java.io.File;

public class Controller {

    Model model;
    MainView mainView;
    CheckParams checkParams;

    public Controller(Model model, MainView mainView, CheckParams checkParams) {
        this.model = model;
        this.mainView = mainView;
        this.checkParams = checkParams;

        initController();
    }

    private void initController() {
        this.mainView.getImageChoosePanel().getOpenImageBtn().addActionListener((ae) -> imageOpenAction());
        this.mainView.getSourceChoosePanel().getOpenSourceBtn().addActionListener((ae) -> sourceOpenAction());
        this.mainView.getParameterPanel().getOpenLabelBtn().addActionListener((ae) -> paramOpenAction());
        this.mainView.getRunPanel().getRunModelBtn().addActionListener((ae) -> runModelAction());
    }

    private void imageOpenAction() {
        File selected_path = this.mainView.getImageChoosePanel().showDirectoryChooserDialog();

        System.out.println("Folder name: " + selected_path.getAbsolutePath());

        String path = selected_path.getAbsolutePath();

        // Update path variable in the Model class

        // Update view with the selected path
        this.mainView.getImageChoosePanel().getImageNameTxt().setText(path);
    }

    private void sourceOpenAction() {
        File selected_path = this.mainView.getSourceChoosePanel().showDirectoryChooserDialog();

        System.out.println("Folder name: " + selected_path.getAbsolutePath());

        String path = selected_path.getAbsolutePath();

        // Update path variable in the Model class

        // Update view with the selected path
        this.mainView.getSourceChoosePanel().getSourceNameTxt().setText(path);
    }

    private void paramOpenAction() {
        File selected_path = this.mainView.getParameterPanel().showDirectoryChooserDialog();

        System.out.println("Folder name: " + selected_path.getAbsolutePath());

        String path = selected_path.getAbsolutePath();

        // Update path variable in the Model class

        // Update view with the selected path
        this.mainView.getParameterPanel().getLabelNameTxt().setText(path);
    }

    private void runModelAction() {
        String imgSrc = this.mainView.getImageChoosePanel().getImageNameTxt().getText();
        String srcSrc = this.mainView.getSourceChoosePanel().getSourceNameTxt().getText();
        String lblSrc = this.mainView.getParameterPanel().getLabelNameTxt().getText();
        String kValue = this.mainView.getParameterPanel().getkValueTxt().getText();

        // Update Model class
        this.model.setImgSrc(imgSrc);
        this.model.setSrcSrc(srcSrc);
        this.model.setLblSrc(lblSrc);
        this.model.setkValue(kValue);

        this.checkParams.checkParams();
    }

}
//    JFrame jfrm = new JFrame("Run Model");
//
//    Model model;
//    MainView view;
//    String error = "";
//
//    public Controller(Model model, MainView view) {
//        this.model = model;
//        this.view = view;
//
//        initController();
//    }
//
//    public void initController() {
//        this.view.btnRun.addActionListener((ae) -> runModel());
//    }
//
//    private void runModel() {
//        // Make file input streams for data and images - loop through array, start new thread for each
//        System.out.println("Ran model.");
//    }


