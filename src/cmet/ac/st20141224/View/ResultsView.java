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
    ProgressPanel progressPanel;
    StopPanel stopPanel;

    public String title;

public ResultsView() {
    mainWindow = new JFrame();
    mainWindow.setSize(325,250);  // Setting size of MainWindow
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

    progressPanel = new ProgressPanel(mainWindow);
    mainWindow.add(progressPanel);

    stopPanel = new StopPanel(mainWindow);
    mainWindow.add(stopPanel);

    mainWindow.setVisible(true);  // Setting the MainWindow to visible so panels can be seen
    }

    public void removeProgress() {
    mainWindow.remove(progressPanel);
    mainWindow.remove(stopPanel);
    }

    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        mainWindow.setTitle(title);
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

    public ProgressPanel getProgressPanel() {
        return progressPanel;
    }

    public void setProgressPanel(ProgressPanel progressPanel) {
        this.progressPanel = progressPanel;
    }

    public StopPanel getStopPanel() {
        return stopPanel;
    }

    public void setStopPanel(StopPanel stopPanel) {
        this.stopPanel = stopPanel;
    }
}
