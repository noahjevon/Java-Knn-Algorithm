package cmet.ac.st20141224.Model;

import java.util.List;


/**
 * TestImageModel. Handles data surrounding the test image file(s).
 */
public class TestImageModel {

    String filePath;
    private int label; // Int to store label data
    private List<Integer> greyscale; // List to store greyscale pixel data

    // New object - test image
    public TestImageModel(String filePath, int label, List<Integer> greyscale) {
        this.filePath = filePath;
        this.label = label;
        this.greyscale = greyscale;
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public List<Integer> getGreyscale() {
        return greyscale;
    }

    public void setGreyscale(List<Integer> greyscale) {
        this.greyscale = greyscale;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() { // Allows test image object to be displayed as text
        return "TestImageModel{" +
                "label=" + label +
                ", greyscale=" + greyscale +
                '}';
    }
}
