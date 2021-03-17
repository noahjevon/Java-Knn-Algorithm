package cmet.ac.st20141224.View;

import javax.swing.*;

public class AlertView {

    /**
     * Displays an alert message to the user. Accepts parameters to specify what the alert is for.
     *
     * @param alert Main body of the alert message to inform user. e.g 'successfully ran model!'
     * @param title Title of the alert window to inform user. e.g 'success!'
     */
    public static void alertMessage(String alert, String title) {
        JFrame alertFrame = new JFrame("Alert");
        JOptionPane.showMessageDialog(alertFrame, alert,
                title, JOptionPane.PLAIN_MESSAGE);
    }
}
