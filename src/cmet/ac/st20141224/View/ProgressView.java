package cmet.ac.st20141224.View;

import cmet.ac.st20141224.Controller.ProgressViewController;
import cmet.ac.st20141224.Model.ProgressViewModel;

import javax.swing.*;

public class ProgressView {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0, 100);
    JButton stop = new JButton("stop");
    int percentage;

    ProgressView progressView;
    ProgressViewModel progressViewModel;
    ProgressViewController progressViewController;

    public ProgressView() {
        bar.setValue(0);
        bar.setBounds(0, 0, 100, 50);
        bar.setStringPainted(true);

        frame.add(bar);
        frame.add(stop);
        frame.setSize(100,100);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void fill() {
        int counter = 0;
        while(counter<=100) {
            bar.setValue(counter);
            counter += percentage;
        }
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
        System.out.println(percentage);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JProgressBar getBar() {
        return bar;
    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }

    public JButton getStop() {
        return stop;
    }

    public void setStop(JButton stop) {
        this.stop = stop;
    }

    public ProgressView getProgressView() {
        return progressView;
    }

    public void setProgressView(ProgressView progressView) {
        this.progressView = progressView;
    }

    public ProgressViewModel getProgressViewModel() {
        return progressViewModel;
    }

    public void setProgressViewModel(ProgressViewModel progressViewModel) {
        this.progressViewModel = progressViewModel;
    }

    public ProgressViewController getProgressViewController() {
        return progressViewController;
    }

    public void setProgressViewController(ProgressViewController progressViewController) {
        this.progressViewController = progressViewController;
    }
}
