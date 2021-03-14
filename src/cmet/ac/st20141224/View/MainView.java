package cmet.ac.st20141224.View;

import cmet.ac.st20141224.Controller.*;
import cmet.ac.st20141224.FileIO.CheckParams;
import cmet.ac.st20141224.Model.Model;
import cmet.ac.st20141224.View.Panel.*;

import javax.swing.*;
import java.awt.*;

public class MainView {

    JFrame mainWindow;
    ImageChoosePanel imageChoosePanel;
    SourceChoosePanel sourceChoosePanel;
    ParameterPanel parameterPanel;
    ImagePanel imagePanel;
    RunPanel runPanel;

    Model model;
    CheckParams checkParams;
    Controller controller;

    private static MainView instance;

    private MainView() {
        mainWindow = new JFrame("st20141224 Knn Image Classification");
        mainWindow.setSize(500,250);
        mainWindow.setLayout(new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS));

        imageChoosePanel = new ImageChoosePanel(mainWindow);
        mainWindow.add(imageChoosePanel);

        sourceChoosePanel = new SourceChoosePanel(mainWindow);
        mainWindow.add(sourceChoosePanel);

        parameterPanel = new ParameterPanel(mainWindow);
        mainWindow.add(parameterPanel);

        imagePanel = new ImagePanel(mainWindow);
        mainWindow.add(imagePanel);

        runPanel = new RunPanel(mainWindow);
        mainWindow.add(runPanel);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);

        model = new Model(checkParams);
        checkParams = new CheckParams(model);
        controller = new Controller(model, this, checkParams);
    }

    public static MainView getInstance() {
        if(instance == null)
            instance = new MainView();
        return instance;
    }

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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
