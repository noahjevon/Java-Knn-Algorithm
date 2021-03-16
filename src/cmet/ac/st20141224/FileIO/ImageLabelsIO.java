package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Controller.Controller;
import cmet.ac.st20141224.Model.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImageLabelsIO implements IFileReader {
    String filePath;
    List<String> labelList;

    public ImageLabelsIO() {
        this.labelList = new ArrayList<String>();
    }

    @Override
    public void read() throws IOException {
//        labelList.clear();
//        Scanner s = new Scanner(new File(filePath));
//        while (s.hasNext()) {
//            labelList.add(s.next());
//        }
//        s.close();
//        System.out.println(labelList);
    }


    @Override
    public Object getData() {
        return this.labelList;
    }

    @Override
    public void setFilename(String filename) {
        this.filePath = filename;
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public void setLabelName(String labelName) {

    }
}
