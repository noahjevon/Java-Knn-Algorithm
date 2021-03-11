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
        if (imgSrc.equals("")) {
            ErrorView.errorMessage("Image source cannot be null!", "Image Source Error");
            checkParams.setImg(false);
        }
        else {
            this.imgSrc = imgSrc;
            this.checkParams.setImg(true);
        }
    }

    public String getSrcSrc() {
        return srcSrc;
    }

    public void setSrcSrc(String srcSrc) {
        if (srcSrc.equals("")) {
            ErrorView.errorMessage("Model source cannot be null!", "Model Source Error");
            this.checkParams.setSrc(false);
        }
        else {
            this.imgSrc = srcSrc;
            this.checkParams.setSrc(true);
        }
    }

    public String getLblSrc() {
        return lblSrc;
    }

    public void setLblSrc(String lblSrc) {
        if (lblSrc.equals("")) {
            ErrorView.errorMessage("Label source cannot be null!", "Label Source Error");
            this.checkParams.setLbl(false);
        }
        else {
            this.imgSrc = lblSrc;
            this.checkParams.setLbl(true);
        }
    }

    public String getkValue() {
        return kValue;
    }

    public void setkValue(String kValue) {
        if (kValue.equals("")) {
            ErrorView.errorMessage("K value cannot be null!", "K value Source Error");
            this.checkParams.setkVal(false);
        }
        int kValueInt = Integer.parseInt(kValue);
        if ((kValueInt < 1) || (kValueInt > 10)) {
            ErrorView.errorMessage("K value must be between 1 and 10!", "K value Error");
            this.checkParams.setkVal(false);
        }
        else {
            this.kValue = kValue;
            this.checkParams.setkVal(true);
        }
    }
}
