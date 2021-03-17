package cmet.ac.st20141224.Model;

import java.util.List;

public class TrainingDatasetModel {

    private int label;
    private List<Integer> red;
    private List<Integer> green;
    private List<Integer> blue;
    private List<Integer> greyscale;
    private Double distance;

    public TrainingDatasetModel(int label, List<Integer> red, List<Integer> green, List<Integer> blue, List<Integer> greyscale) {
        this.label = label;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.greyscale = greyscale;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

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

    @Override
    public String toString() {
        return "TrainingDatasetModel{" +
                "label=" + label +
                ", red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", greyscale=" + greyscale +
                '}';
    }
}
