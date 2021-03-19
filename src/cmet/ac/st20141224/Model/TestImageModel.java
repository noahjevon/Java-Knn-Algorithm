package cmet.ac.st20141224.Model;

import java.util.List;

public class TestImageModel {

    String filePath;
    private int label; // Int to store label data
    private List<Integer> red; // List to store red pixel data
    private List<Integer> green; // List to store green pixel data
    private List<Integer> blue; // List to store blue pixel data
    private List<Integer> greyscale; // List to store greyscale pixel data

    // New object - test image
    public TestImageModel(String filePath, int label, List<Integer> red, List<Integer> green, List<Integer> blue, List<Integer> greyscale) {
        this.filePath = filePath;
        this.label = label;
        this.red = red;
        this.green = green;
        this.blue = blue;
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

    public List<Integer> getRed() {
        return red;
    }

    public void setRed(List<Integer> red) {
        this.red = red;
    }

    public List<Integer> getGreen() {
        return green;
    }

    public void setGreen(List<Integer> green) {
        this.green = green;
    }

    public List<Integer> getBlue() {
        return blue;
    }

    public void setBlue(List<Integer> blue) {
        this.blue = blue;
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
                ", red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", greyscale=" + greyscale +
                '}';
    }
}
