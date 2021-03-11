package cmet.ac.st20141224.View;

import javax.swing.*;

public class ErrorView {

    public static void errorMessage(String error, String title) {
        JFrame errorFrame = new JFrame("Error");
        JOptionPane.showMessageDialog(errorFrame, error,
                title, JOptionPane.ERROR_MESSAGE);
    }
}
