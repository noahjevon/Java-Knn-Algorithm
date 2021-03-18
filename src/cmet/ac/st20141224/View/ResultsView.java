package cmet.ac.st20141224.View;

import cmet.ac.st20141224.View.Panel.ConfidenceRatingPanel;
import cmet.ac.st20141224.View.Panel.ResultsImagePanel;
import cmet.ac.st20141224.View.Panel.ResultsLabelPanel;

import javax.swing.*;

public class ResultsView extends JFrame {
    JFrame mainWindow;  // Main window

    ResultsImagePanel resultsImagePanel;
    ResultsLabelPanel resultsLabelPanel;
    ConfidenceRatingPanel confidenceRatingPanel;

public ResultsView() {
    mainWindow = new JFrame("Results");
    mainWindow.setSize(250,200);  // Setting size of MainWindow
    mainWindow.setLayout(new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS));  // Specifying BoxLayout

    resultsImagePanel = new ResultsImagePanel(mainWindow);  // Adding image selection panel to JFrame
    mainWindow.add(resultsImagePanel);

    resultsLabelPanel = new ResultsLabelPanel(mainWindow);  // Adding image selection panel to JFrame
    mainWindow.add(resultsLabelPanel);

    confidenceRatingPanel = new ConfidenceRatingPanel(mainWindow);  // Adding image selection panel to JFrame
    mainWindow.add(confidenceRatingPanel);

    mainWindow.setVisible(true);  // Setting the MainWindow to visible so panels can be seen
    }

    public ResultsImagePanel getResultsImagePanel() {
        return resultsImagePanel;
    }

    public void setResultsImagePanel(ResultsImagePanel resultsImagePanel) {
        this.resultsImagePanel = resultsImagePanel;
    }

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }

    public ResultsLabelPanel getResultsLabelPanel() {
        return resultsLabelPanel;
    }

    public void setResultsLabelPanel(ResultsLabelPanel resultsLabelPanel) {
        this.resultsLabelPanel = resultsLabelPanel;
    }

    public ConfidenceRatingPanel getConfidenceRatingPanel() {
        return confidenceRatingPanel;
    }

    public void setConfidenceRatingPanel(ConfidenceRatingPanel confidenceRatingPanel) {
        this.confidenceRatingPanel = confidenceRatingPanel;
    }
}
