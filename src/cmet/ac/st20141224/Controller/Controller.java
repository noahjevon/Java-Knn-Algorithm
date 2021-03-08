package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.View.Main;
import cmet.ac.st20141224.Model.Model;


public class Controller {

    Model model;
    Main view;

    public Controller(Model model, Main view) {
        this.model = model;
        this.view = view;

        initController();
    }

    public void initController() {
        this.view.btnRun.addActionListener((ae) -> runModel());
    }

    private void runModel() {
        // Make file input streams for data and images - loop through array, start new thread for each
        System.out.println("Ran model.");
    }
}

