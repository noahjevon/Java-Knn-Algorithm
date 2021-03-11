package cmet.ac.st20141224.View;

import javax.swing.*;

public class AlertView {

    public static void alertMessage(String alert, String title) {
        JFrame alertFrame = new JFrame("Alert");
        JOptionPane.showMessageDialog(alertFrame, alert,
                title, JOptionPane.PLAIN_MESSAGE);
    }
}
