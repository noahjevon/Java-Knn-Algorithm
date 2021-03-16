package cmet.ac.st20141224.Model;

import java.util.List;

public class SourceModel {

    private int label;
    private String labelText;
    private List<Integer> rgbList;

    public SourceModel(int label, String labelText, List<Integer> rgb) {
        this.label = label;
        this.labelText = labelText;
        this.rgbList = rgbList;
    }

    /**
     * @return the label
     */
    public int getLabel() {
        return label;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "SourceModel{" +
                "label=" + label +
                ", labelText='" + labelText + '\'' +
                ", rgb=" + rgbList +
                '}';
    }
}
