package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.View.MainView;
import cmet.ac.st20141224.Model.MainViewModel;

import java.io.File;

public class MainViewController {

    MainViewModel mainViewModel; // Declaring the MainViewModel
    MainView mainView; // Declaring the MainView
    CheckValidIOController checkValidIO; // Declaring the IO check controller

    public MainViewController(MainViewModel mainViewModel, MainView mainView, CheckValidIOController checkValidIO) {
        this.mainViewModel = mainViewModel;
        this.mainView = mainView;
        this.checkValidIO = checkValidIO;

        initController(); // Run the controller
    }

    private void initController() { // Action listeners for the various buttons within the MainView and panels
        this.mainView.getImageChoosePanel().getOpenImageBtn().addActionListener((ae) -> imageOpenAction());
        this.mainView.getSourceChoosePanel().getOpenSourceBtn().addActionListener((ae) -> sourceOpenAction());
        this.mainView.getParameterPanel().getOpenLabelBtn().addActionListener((ae) -> paramOpenAction());
        this.mainView.getRunPanel().getRunModelBtn().addActionListener((ae) -> runModelAction());
    }

    private void imageOpenAction() { // Image selection action
        File selected_path = this.mainView.getImageChoosePanel().showDirectoryChooserDialog(); // Show directory chooser
        String path = selected_path.getAbsolutePath(); // Get path
        this.mainView.getImageChoosePanel().getImageNameTxt().setText(path); // Update view with the selected path
        this.mainViewModel.setImgSrc(this.mainView.getImageChoosePanel().getImageNameTxt().getText()); // Update model
    }

    private void sourceOpenAction() {
        File selected_path = this.mainView.getSourceChoosePanel().showDirectoryChooserDialog();
        String path = selected_path.getAbsolutePath();
        this.mainView.getSourceChoosePanel().getSourceNameTxt().setText(path);
        this.mainViewModel.setSrcSrc(this.mainView.getSourceChoosePanel().getSourceNameTxt().getText());
    }

    private void paramOpenAction() {
        File selected_path = this.mainView.getParameterPanel().showDirectoryChooserDialog();
        String path = selected_path.getAbsolutePath();
        this.mainView.getParameterPanel().getLabelNameTxt().setText(path);
        this.mainViewModel.setLblSrc(this.mainView.getParameterPanel().getLabelNameTxt().getText());
    }

    private void runModelAction() {  // Run model action
        // Setting variables in CheckParams class
        this.checkValidIO.setImgSrc(this.mainView.getImageChoosePanel().getImageNameTxt().getText());
        this.checkValidIO.setSrcSrc(this.mainView.getSourceChoosePanel().getSourceNameTxt().getText());
        this.checkValidIO.setLblSrc(this.mainView.getParameterPanel().getLabelNameTxt().getText());
        this.checkValidIO.setkValue(this.mainView.getParameterPanel().getkValueTxt().getText());

        // Run checkIO in CheckValidIO class to ensure that fields are filled out correctly
        this.checkValidIO.checkIO();
    }
}


