package cmet.ac.st20141224.FileIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedSourceReader implements IFileReader {
    String filepath;
    FileInputStream in_stream_labels;
    FileInputStream in_stream_images;
    int number_of_labels;
    int number_of_images;
    int image_width;
    int image_height;

    @Override
    public void read() throws IOException {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public void setFilename(String filename) {

    }

    @Override
    public String getFilename() {
        return null;
    }
}
