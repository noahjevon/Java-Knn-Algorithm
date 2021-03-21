package cmet.ac.st20141224.View;

import cmet.ac.st20141224.View.Panel.*;

import javax.swing.*;

public class ResultsView extends JFrame {
    JFrame mainWindow;  // Main window

    KValuePanel kValuePanel;
    ResultsImagePanel resultsImagePanel;
    ResultsLabelPanel resultsLabelPanel;
    ConfidenceRatingPanel confidenceRatingPanel;
    TimeTakenPanel timeTakenPanel;

public ResultsView() {
    mainWindow = new JFrame("Results");
    mainWindow.setSize(200,250);  // Setting size of MainWindow
    mainWindow.setLayout(new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS));  // Specifying BoxLayout

    resultsImagePanel = new ResultsImagePanel(mainWindow);  // Adding image selection panel to JFrame
    mainWindow.add(resultsImagePanel);

    kValuePanel = new KValuePanel(mainWindow);
    mainWindow.add(kValuePanel);

    resultsLabelPanel = new ResultsLabelPanel(mainWindow);  // Adding image selection panel to JFrame
    mainWindow.add(resultsLabelPanel);

    confidenceRatingPanel = new ConfidenceRatingPanel(mainWindow);  // Adding image selection panel to JFrame
    mainWindow.add(confidenceRatingPanel);

    timeTakenPanel = new TimeTakenPanel(mainWindow);
    mainWindow.add(timeTakenPanel);

    mainWindow.setVisible(true);  // Setting the MainWindow to visible so panels can be seen
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
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

    public TimeTakenPanel getTimeTakenPanel() {
        return timeTakenPanel;
    }

    public void setTimeTakenPanel(TimeTakenPanel timeTakenPanel) {
        this.timeTakenPanel = timeTakenPanel;
    }

    public KValuePanel getkValuePanel() {
        return kValuePanel;
    }

    public void setkValuePanel(KValuePanel kValuePanel) {
        this.kValuePanel = kValuePanel;
    }
}
