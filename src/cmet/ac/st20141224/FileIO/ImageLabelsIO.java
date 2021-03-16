package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.ImageLabelModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImageLabelsIO implements IFileReader {
    String filePath;
    List<ImageLabelModel> labelList;

    public ImageLabelsIO() {
        this.labelList = new ArrayList<ImageLabelModel>();
    }

    @Override
    public void read() throws IOException {
        String line = "";
        if(this.filePath != null);
            try(BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
                while((line = br.readLine()) != null) {
                    String label = line;
                    this.labelList.add(new ImageLabelModel(label));
                }
            }
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
