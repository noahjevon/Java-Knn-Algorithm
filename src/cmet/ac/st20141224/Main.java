package cmet.ac.st20141224;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;


public class Main {
    JButton 	btnSrc;
    JLabel      jlabSrc;
    JLabel      jlabImg;
    JButton 	btnImage;
    JButton     btnRun;
    JTextField	txtK;
    JTextField	txtLabel;
    JLabel 		jlabK;
    JLabel 		jlabLabel;

    Model       model;
    Controller  controller;


    public Main() {

        // Create a new JFrame container.
        JFrame jfrm = new JFrame("st20141224 kNN Image Classification");

        // Give the frame an initial size.
        jfrm.setSize(500, 500);
        jfrm.setLayout(new FlowLayout());

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialise components

        this.btnSrc 	= new JButton("Select Input Source");  // Input source
        this.jlabSrc 	= new JLabel("Input(s) Selected: ");

        this.btnImage 	= new JButton("Select Image Source");  // Image source
        this.jlabImg 	= new JLabel("Image(s) Selected: ");

        this.jlabK 		= new JLabel("K Value");  // K value inputs
        this.txtK 	    = new JTextField(2);

        this.jlabLabel 	= new JLabel("Labels");  // Label inputs
        this.txtLabel 	= new JTextField(15);

        this.btnRun 	= new JButton("Run Model");  // Run model

        // Add the components to the content pane.
        jfrm.add(this.btnSrc);  // Source and label
        jfrm.add(this.jlabSrc);

        jfrm.add(this.btnImage);  // Image and label
        jfrm.add(this.jlabImg);

        jfrm.add(this.btnRun);  // Run model

        jfrm.add(this.jlabK);  // K value
        jfrm.add(this.txtK);

        jfrm.add(this.jlabLabel);  // Label
        jfrm.add(this.txtLabel);

        this.model      = new Model();
        this.controller = new Controller(this.model, this);

        // Display the frame.
        jfrm.setVisible(true);

    }


    public static void main(String args[]) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
