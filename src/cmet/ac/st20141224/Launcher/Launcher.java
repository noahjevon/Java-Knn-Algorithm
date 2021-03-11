package cmet.ac.st20141224.Launcher;

import cmet.ac.st20141224.View.MainView;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e) {
            System.err.println("Error");
        }

        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {
                        MainView.getInstance();
                    }
                }
        );
    }
}
