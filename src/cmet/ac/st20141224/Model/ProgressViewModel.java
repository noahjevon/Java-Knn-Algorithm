package cmet.ac.st20141224.Model;

import cmet.ac.st20141224.Controller.ProgressViewController;
import cmet.ac.st20141224.View.ProgressView;

public class ProgressViewModel {
    String barTitle;
    int barProgress;

    ProgressView progressView;
    ProgressViewModel progressViewModel;
    ProgressViewController progressViewController;

    public ProgressViewModel(ProgressView progressView, ProgressViewModel progressViewModel, ProgressViewController progressViewController) {
        this.progressView = progressView;
        this.progressViewModel = progressViewModel;
        this.progressViewController = progressViewController;
    }

    public String getBarTitle() {
        return barTitle;
    }

    public void setBarTitle(String barTitle) {
        this.barTitle = barTitle;
    }

    public int getBarProgress() {
        return barProgress;
    }

    public void setBarProgress(int barProgress) {
        this.barProgress = barProgress;
    }
}
