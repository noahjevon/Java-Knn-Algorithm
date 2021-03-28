package cmet.ac.st20141224.Model;

import java.util.List;

public class TrainingDatasetModel {

    private int label; // Int to store label data
    private List<Integer> greyscale; // List to store greyscale pixel data
    private Double distance; // Double to store distance value

    // New object - training image
    public TrainingDatasetModel(int label, List<Integer> greyscale) {
        this.label = label;
        this.greyscale = greyscale;
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    public Double getDistance() { return distance; }

    public void setDistance(Double distance) { this.distance = distance; }

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

    @Override
    public String toString() { // Allows training image object to be displayed as text
        return "TrainingDatasetModel{" +
                "label=" + label +
                ", greyscale=" + greyscale +
                '}';
    }
}
