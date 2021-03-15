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
    String CIFAR;
    String labelPath;

    FileInputStream in_stream_images;

    List<String> labelList;
    List<SourceImage> imageList;

    String fileName;
    BufferedImage img;
    ArrayList<String> images = new ArrayList<>();

    @Override
    public void read() throws IOException {
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
}
