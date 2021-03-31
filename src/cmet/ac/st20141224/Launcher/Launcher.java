package cmet.ac.st20141224.Launcher;

import cmet.ac.st20141224.View.MainView;

import javax.swing.*;

/**
 * Launcher class to launch the main view. Ensures that only one instance is live at a time
 */
public class Launcher {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e) {
            System.err.println("Application Launch Error"); // Display error if launch fails
        }

        javax.swing.SwingUtilities.invokeLater(
                MainView::getInstance // Creating a new instance of the MainView
        );
    }
}
