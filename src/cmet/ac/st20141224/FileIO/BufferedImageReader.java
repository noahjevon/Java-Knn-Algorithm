package cmet.ac.st20141224.FileIO;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BufferedImageReader implements IFileReader {
    String fileName;
    BufferedImage img;
    ArrayList<String> images = new ArrayList<>();

    @Override
    public void read() throws IOException {
        System.out.println("filename" + fileName);
        this.img = ImageIO.read(new FileInputStream(this.fileName));
        displayImage();
    }

    @Override
    public Object getData() {
        return this.img;
    }

    @Override
    public void setFilename(String filename) {
        this.fileName = filename;
    }

    @Override
    public String getFilename() {
        return this.fileName;
    }

    @Override
    public void setLabelName(String labelName) {

    }

    // Temporary Function
    public void displayImage() {
        JLabel picLabel = new JLabel(new ImageIcon(img));

        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(img.getWidth(),img.getHeight()));
        frame.add(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
