package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.View.Main;
import cmet.ac.st20141224.Model.Model;

import javax.swing.*;


public class Controller {
    JFrame jfrm = new JFrame("Run Model");

    Model model;
    Main view;
    String error = "";

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
        error = "aaaaaaaa";
        errorMessage(error);

    }

    // MAKE ERROR FOR EACH EMPTY FIELD

    private void getImage() {

    }

    private void getSource() {

    }

    private void getKValue() {

    }

    private void getXLabel() {

    }

    private void getYLabel() {

    }

    private void errorMessage(String error) {
        JOptionPane.showMessageDialog(jfrm, error,
                "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}

