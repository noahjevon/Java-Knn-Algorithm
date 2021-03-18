package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.Model.ProgressViewModel;
import cmet.ac.st20141224.View.ProgressView;

public class ProgressViewController {

    ProgressView progressView;
    ProgressViewModel progressViewModel;
    ProgressViewController progressViewController;

    public ProgressViewController(ProgressView progressView, ProgressViewModel progressViewModel, ProgressViewController progressViewController){
        this.progressView = progressView;
        this.progressViewModel = progressViewModel;
        this.progressViewController = progressViewController;

        initController();
    }

    private void initController() {
        this.progressView.getStop().addActionListener((ae) -> stopAction());
    }

    private void stopAction() {
        //stop activity
    }
}
