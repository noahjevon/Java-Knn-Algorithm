package cmet.ac.st20141224;

public class Model {

    String inputtext;

    public Model() {}

    public Model(String input) {
        this.inputtext = input;
    }

    /**
     * @return the labeltext
     */
    public String getInputtext() {
        return inputtext;
    }

    /**
     * @param labeltext the labeltext to set
     */
    public void setImagetext(String input) {
        this.inputtext = "Image(s) Selected: " + input;
    }

    public void setSourcetext(String input) {
        this.inputtext = "Input(s) Selected: " + input;
    }



}
