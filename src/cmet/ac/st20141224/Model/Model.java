package cmet.ac.st20141224.Model;

import cmet.ac.st20141224.FileIO.*;

import java.util.List;

public class Model {
    String imgSrc;
    String srcSrc;
    String lblSrc;
    String kValue;
    List<String> labelList;

    IFileReader labelReader;  // Creating instance of IFileReader *3
    IFileReader imageReader;
    IFileReader sourceReader;

    CheckParams checkParams;

    public Model(CheckParams checkParams) {
        this.checkParams = checkParams;
        labelReader = new BufferedLabelReader();
        imageReader = new BufferedImageReader();
        sourceReader = new BufferedSourceReader();
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

    public List getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
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
}
