package cmet.ac.st20141224.View;

import javax.swing.*;

public class ErrorView {

    /**
     * Displays an error message to the user. Accepts parameters to specify what the error is for.
     *
     * @param error Main body of the error message to inform user. e.g 'could not read image!'
     * @param title Title of the error window to inform user. e.g 'read error!'
     */
    public static void errorMessage(String error, String title) {
        JFrame errorFrame = new JFrame("Error");
        JOptionPane.showMessageDialog(errorFrame, error,
                title, JOptionPane.ERROR_MESSAGE);
    }
}
