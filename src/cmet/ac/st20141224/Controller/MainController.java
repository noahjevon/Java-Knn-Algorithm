package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.View.MainView;
import cmet.ac.st20141224.Model.MainViewModel;

import java.io.File;

public class MainController {

    MainViewModel mainViewModel;
    MainView mainView;
    CheckValidIOController checkParams;

    public MainController(MainViewModel mainViewModel, MainView mainView, CheckValidIOController checkParams) {
        this.mainViewModel = mainViewModel;
        this.mainView = mainView;
        this.checkParams = checkParams;

        initController();
    }

    private void initController() {  // Action listeners for the various buttons within the MainView and panels
        this.mainView.getImageChoosePanel().getOpenImageBtn().addActionListener((ae) -> imageOpenAction());
        this.mainView.getSourceChoosePanel().getOpenSourceBtn().addActionListener((ae) -> sourceOpenAction());
        this.mainView.getParameterPanel().getOpenLabelBtn().addActionListener((ae) -> paramOpenAction());
        this.mainView.getRunPanel().getRunModelBtn().addActionListener((ae) -> runModelAction());
    }

    private void imageOpenAction() {  // Image selection action
        File selected_path = this.mainView.getImageChoosePanel().showDirectoryChooserDialog();

        System.out.println("Image Folder name: " + selected_path.getAbsolutePath());

        String path = selected_path.getAbsolutePath();

        // Update view with the selected path
        this.mainView.getImageChoosePanel().getImageNameTxt().setText(path);
    }

    private void sourceOpenAction() {  // Training data selection action
        File selected_path = this.mainView.getSourceChoosePanel().showDirectoryChooserDialog();

        System.out.println("Source Folder name: " + selected_path.getAbsolutePath());

        String path = selected_path.getAbsolutePath();

        // Update view with the selected path
        this.mainView.getSourceChoosePanel().getSourceNameTxt().setText(path);
    }

    private void paramOpenAction() {  // Label selection action
        File selected_path = this.mainView.getParameterPanel().showDirectoryChooserDialog();

        System.out.println("Label Folder name: " + selected_path.getAbsolutePath());

        String path = selected_path.getAbsolutePath();

        // Update view with the selected path
        this.mainView.getParameterPanel().getLabelNameTxt().setText(path);
    }

    private void runModelAction() {  // Run model action
        String imgSrc = this.mainView.getImageChoosePanel().getImageNameTxt().getText();
        String srcSrc = this.mainView.getSourceChoosePanel().getSourceNameTxt().getText();
        String lblSrc = this.mainView.getParameterPanel().getLabelNameTxt().getText();
        String kValue = this.mainView.getParameterPanel().getkValueTxt().getText();

        // Update Model class
        this.mainViewModel.setLblSrc(lblSrc);
        this.mainViewModel.setImgSrc(imgSrc);

        // Setting variables in CheckParams class
        this.checkParams.setImgSrc(imgSrc);
        this.checkParams.setSrcSrc(srcSrc);
        this.checkParams.setLblSrc(lblSrc);
        this.checkParams.setkValue(kValue);

        // Run checkParams in CheckParams class to ensure that fields are filled out correctly
        this.checkParams.checkParams();
    }
}


