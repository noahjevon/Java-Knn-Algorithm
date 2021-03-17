package cmet.ac.st20141224.View;

import cmet.ac.st20141224.Controller.*;
import cmet.ac.st20141224.Controller.CheckValidIOController;
import cmet.ac.st20141224.Knn.Algorithm;
import cmet.ac.st20141224.Model.MainViewModel;
import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.Model.TrainingDatasetModel;
import cmet.ac.st20141224.View.Panel.*;

import javax.swing.*;

public class MainView {


    // Initialise JFrame and panels required to build the view
    JFrame mainWindow;  // Main window
    ImageChoosePanel imageChoosePanel;  // Panel for image selection
    SourceChoosePanel sourceChoosePanel;  // Panel for training set selection
    ParameterPanel parameterPanel;  // Panel for K value and label source selection
    ImagePanel imagePanel;  // Panel to display the image selected
    RunPanel runPanel;  // Panel to display the run button

    MainViewModel mainViewModel;
    CheckValidIOController checkValidIOController;
    MainController mainController;

    private static MainView instance;


    /**
     *  The main view of the application. Creates a main JFrame, which has panels added on found in the 'panel' folder
     *  within the 'view' package.
     */
    private MainView() {
        mainWindow = new JFrame("st20141224 Knn Image Classification");
        mainWindow.setSize(500,250);  // Setting size of MainWindow
        mainWindow.setLayout(new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS));  // Specifying BoxLayout

        imageChoosePanel = new ImageChoosePanel(mainWindow);  // Adding image selection panel to JFrame
        mainWindow.add(imageChoosePanel);

        sourceChoosePanel = new SourceChoosePanel(mainWindow);  // Adding training set selection panel to JFrame
        mainWindow.add(sourceChoosePanel);

        parameterPanel = new ParameterPanel(mainWindow);  // Adding parameter selection panel to JFrame
        mainWindow.add(parameterPanel);

        imagePanel = new ImagePanel(mainWindow);  // Adding image display panel to JFrame
        mainWindow.add(imagePanel);

        runPanel = new RunPanel(mainWindow);  // Adding run button panel to JFrame
        mainWindow.add(runPanel);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Setting program to close when GUI is exited
        mainWindow.setVisible(true);  // Setting the MainWindow to visible so panels cal be seen

        mainViewModel = new MainViewModel(checkValidIOController, mainController);
        checkValidIOController = new CheckValidIOController(mainViewModel);
        mainController = new MainController(mainViewModel, this, checkValidIOController);
    }


    /**
     * Singleton class to emsure that only one instance of mainview is running at a time
     *
     * @return returns an instance of mainview
     */
    public static MainView getInstance() {  // Creating a new instance of MainView so only one can run at once
        if(instance == null)
            instance = new MainView();
        return instance;
    }


    // Setters & Getters
    public ImageChoosePanel getImageChoosePanel() {
        return imageChoosePanel;
    }

    public void setImageChoosePanel(ImageChoosePanel imageChoosePanel) {
        this.imageChoosePanel = imageChoosePanel;
    }

    public SourceChoosePanel getSourceChoosePanel() {
        return sourceChoosePanel;
    }

    public void setSourceChoosePanel(SourceChoosePanel sourceChoosePanel) {
        this.sourceChoosePanel = sourceChoosePanel;
    }

    public ParameterPanel getParameterPanel() {
        return parameterPanel;
    }

    public void setParameterPanel(ParameterPanel parameterPanel) {
        this.parameterPanel = parameterPanel;
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    public void setImagePanel(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    public RunPanel getRunPanel() {
        return runPanel;
    }

    public void setRunPanel(RunPanel runPanel) {
        this.runPanel = runPanel;
    }

    public MainViewModel getModel() {
        return mainViewModel;
    }

    public void setModel(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    public MainController getController() {
        return mainController;
    }

    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
}
