package cmet.ac.st20141224.Model;

public class ImageLabelModel { // Handles label object

    private String label; // String to store label models

    public ImageLabelModel(String label) {
        this.label = label;
    }

    @Override
    public String toString() { // Allows label object to be displayed as text
        return "ImageLabelModel{" +
                "label='" + label + '\'' +
                '}';
    }

    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    public String getLabel() {
        return label;
    }
}
