package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.View.ResultsView;

public class ResultsViewController {
    ResultsView resultsView;
    Boolean isCancelled = false;

    public ResultsViewController(ResultsView resultsView){
        this.resultsView = resultsView;
        initController();
    }

    private void initController() {
        this.resultsView.getStopPanel().getStopButton().addActionListener((ae) -> stopClassification());
    }

    private void stopClassification() {
        setCancelled(!isCancelled);
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }
}
