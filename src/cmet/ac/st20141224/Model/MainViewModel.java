package cmet.ac.st20141224.Model;

import cmet.ac.st20141224.Controller.CheckValidIOController;
import cmet.ac.st20141224.Controller.MainViewController;
import cmet.ac.st20141224.FileIO.*;

import java.util.List;

public class MainViewModel {
    String imgSrc; // String to store image filepath
    String srcSrc; // String to store training dataset filepath
    String lblSrc; // String to store image label filepath
    String kValue; // String to store K value
    List<ImageLabelsIO> labelList; // Access list of labels

    IFileReader labelReader;  // Creating instance of IFileReader *3
    IFileReader imageReader;
    IFileReader sourceReader;

    CheckValidIOController checkValidIO; // IO check access
    MainViewController mainController; // Controller access

    public MainViewModel(CheckValidIOController checkValidIO, MainViewController mainController) {
        this.checkValidIO = checkValidIO; // Instance of CheckValidIO
        this.mainController = mainController; // Instance of mainController
        labelReader = new ImageLabelsIO(); // Instance of IFileReader to read labels
        imageReader = new TestImageIO(); // Instance of IFileReader to read test image
        sourceReader = new TrainingDatasetIO(); // Instance of IFIleReader to read training images
    }

    // Setters & Getters
    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getSrcSrc() {
        return srcSrc;
    }

    public void setSrcSrc(String srcSrc) {
        this.srcSrc = srcSrc;
    }

    public String getLblSrc() {
        return lblSrc;
    }

    public void setLblSrc(String lblSrc) {
        this.lblSrc = lblSrc;
    }

    public Integer getkValue() {
        int kValueInt = Integer.parseInt(kValue);
        return kValueInt;
    }

    public void setkValue(String kValue) {
        this.kValue = kValue;
    }

    public IFileReader getLabelReader() {
        return labelReader;
    }

    public void setLabelReader(IFileReader lLreader) {
        this.labelReader = lLreader;
    }

    public IFileReader getImageReader() {
        return imageReader;
    }

    public void setImageReader(IFileReader iReader) {
        this.imageReader = iReader;
    }

    public IFileReader getSourceReader() {
        return sourceReader;
    }

    public void setSourceReader(IFileReader sReader) {
        this.sourceReader = sReader;
    }

    public List<ImageLabelsIO> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<ImageLabelsIO> labelList) {
        this.labelList = labelList;
    }
}
