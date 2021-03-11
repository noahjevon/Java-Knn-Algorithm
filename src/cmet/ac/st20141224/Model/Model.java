package cmet.ac.st20141224.Model;

import cmet.ac.st20141224.Controller.Controller;
import cmet.ac.st20141224.FileIO.CheckParams;
import cmet.ac.st20141224.Launcher.Launcher;
import cmet.ac.st20141224.View.*;

public class Model {
    String imgSrc;
    String srcSrc;
    String lblSrc;
    String kValue;

    CheckParams checkParams;

    public Model(CheckParams checkParams) {
        this.checkParams = checkParams;
    }

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
        this.imgSrc = srcSrc;
    }

    public String getLblSrc() {
        return lblSrc;
    }

    public void setLblSrc(String lblSrc) {
        this.imgSrc = lblSrc;
    }

    public String getkValue() {
        return kValue;
    }

    public void setkValue(String kValue) {
        this.kValue = kValue;
    }
}
