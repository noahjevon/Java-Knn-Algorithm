package cmet.ac.st20141224.View;

import cmet.ac.st20141224.Controller.*;
import cmet.ac.st20141224.Model.Model;

import java.awt.*;
import java.util.concurrent.Flow;
import javax.swing.*;
import javax.swing.border.Border;


public class Main {
    public JButton 	    btnSrc;
    public JLabel       jlabSrc;
    public JLabel       jlabImg;
    public JButton 	    btnImage;
    public JLabel       jlabImgDir;
    public JButton 	    btnImageDir;
    public JButton      btnRun;
    public JTextField	txtK;
    public JLabel 		jlabK;
    public JTextField	txtXLabel;
    public JTextField	txtYLabel;
    public JLabel 		jlabXLabel;
    public JLabel 		jlabYLabel;


    Model model;
    Controller controller;
    ImageController imageController;
    ImageDirectoryController imageDirectoryController;
    SourceController sourceController;


    public Main() {
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("st20141224 kNN Image Classification");

        // Give the frame an initial size.
        jfrm.setSize(500, 500);

        jfrm.setLayout(new GridLayout(0, 2));

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialise components
        this.btnImage 	= new JButton("Select Image Source");  // Image source
        this.jlabImg 	= new JLabel();

        this.btnImageDir 	= new JButton("Select Image Source Directory");  // Image source
        this.jlabImgDir 	= new JLabel();

        this.btnSrc 	= new JButton("Select Input Source");  // Input source
        this.jlabSrc 	= new JLabel();

        this.jlabK 		= new JLabel("K Value", SwingConstants.CENTER);  // K value inputs
        this.txtK 	    = new JTextField(2);

        this.jlabXLabel = new JLabel("X Label", SwingConstants.CENTER);  // Label inputs
        this.txtXLabel 	= new JTextField(10);

        this.jlabYLabel = new JLabel("Y Label", SwingConstants.CENTER);  // Label inputs
        this.txtYLabel 	= new JTextField(10);

        this.btnRun 	= new JButton("Run Model");  // Run model

        jfrm.add(this.btnImage);  // Image and label
        jfrm.add(this.jlabImg);

        jfrm.add(this.btnImageDir);  // Image directory and label
        jfrm.add(this.jlabImgDir);

        jfrm.add(this.btnSrc);  // Source and label
        jfrm.add(this.jlabSrc);

        jfrm.add(this.jlabK);  // K value
        jfrm.add(this.txtK);

        jfrm.add(this.jlabXLabel);  // X Label
        jfrm.add(this.txtXLabel);

        jfrm.add(this.jlabYLabel);  // Y Label
        jfrm.add(this.txtYLabel);

        jfrm.add(this.btnRun);  // Run model

        this.model      = new Model();
        this.controller = new Controller(this.model, this);
        this.imageController = new ImageController(this.model, this);
        this.imageDirectoryController = new ImageDirectoryController(this.model, this);
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
