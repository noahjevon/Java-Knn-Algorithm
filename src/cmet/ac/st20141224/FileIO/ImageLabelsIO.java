package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.ImageLabelModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImageLabelsIO implements IFileReader {

    String filePath; // String variable for the file path of the image labels
    List<ImageLabelModel> labelList; // List to store the labels

    public ImageLabelsIO() {
        this.labelList = new ArrayList<ImageLabelModel>();
    }

    @Override
    public void read() throws IOException {
        String line = "";
        if(this.filePath != null); // Checking to see if location is null
            try(BufferedReader br = new BufferedReader(new FileReader(this.filePath))) { // Buffered reader to read file
                while((line = br.readLine()) != null) { // While the line in the file is not null, read the file
                    String label = line; // Assigning line in file to String
                    this.labelList.add(new ImageLabelModel(label)); // Adding String to list that stores labels
                }
            }
    }

    // Getters & setters
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

}
