package cmet.ac.st20141224.Model;

public class ImageLabelModel {

    private String label;

    public ImageLabelModel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ImageLabelModel{" +
                "label='" + label + '\'' +
                '}';
    }

    public String getLabel() {
        return label;
    }
}
