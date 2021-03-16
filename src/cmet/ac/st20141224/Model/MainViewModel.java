package cmet.ac.st20141224.Model;

import cmet.ac.st20141224.Controller.CheckValidIOController;
import cmet.ac.st20141224.Controller.MainController;
import cmet.ac.st20141224.FileIO.*;

import java.util.List;

public class MainViewModel {
    String imgSrc;
    String srcSrc;
    String lblSrc;
    String kValue;
    List<ImageLabelsIO> labelList;

    IFileReader labelReader;  // Creating instance of IFileReader *3
    IFileReader imageReader;
    IFileReader sourceReader;

    CheckValidIOController checkParams;
    MainController mainController;

    public MainViewModel(CheckValidIOController checkParams, MainController mainController) {
        this.checkParams = checkParams;
        this.mainController = mainController;
        labelReader = new ImageLabelsIO();
        imageReader = new TestImageIO();
        sourceReader = new TrainingDatasetIO();
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

    public String getkValue() {
        return kValue;
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
