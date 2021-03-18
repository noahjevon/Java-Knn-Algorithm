package cmet.ac.st20141224.View;

import cmet.ac.st20141224.Controller.ProgressViewController;
import cmet.ac.st20141224.Model.ProgressViewModel;

import javax.swing.*;

public class ProgressView {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0, 100);
    JButton stop = new JButton();

    ProgressView progressView;
    ProgressViewModel progressViewModel;
    ProgressViewController progressViewController;

    ProgressView() {
        bar.setValue(0);
        bar.setBounds(0, 0, 100, 50);
        bar.setStringPainted(true);

        frame.add(bar);
        frame.add(stop);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100,100);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    public void fill() {
        int counter = 0;
        while(counter<=100) {
            bar.setValue(counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 1;
        }
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
