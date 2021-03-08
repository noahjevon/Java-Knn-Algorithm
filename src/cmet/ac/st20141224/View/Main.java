package cmet.ac.st20141224.View;

import cmet.ac.st20141224.Controller.*;
import cmet.ac.st20141224.Model.Model;

import java.awt.*;
import javax.swing.*;
import javax.xml.transform.Source;


public class Main {
    public JButton 	    btnSrc;
    public JLabel       jlabSrc;
    public JLabel       jlabImg;
    public JButton 	    btnImage;
    public JButton      btnRun;
    public JTextField	txtK;
    public JTextField	txtLabel;
    public JLabel 		jlabK;
    public JLabel 		jlabLabel;

    Model model;
    Controller controller;
    ImageController imageController;
    SourceController sourceController;


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
        this.imageController = new ImageController(this.model, this);
        this.sourceController = new SourceController(this.model, this);

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
