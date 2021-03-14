package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.Model;
import cmet.ac.st20141224.View.AlertView;
import cmet.ac.st20141224.View.ErrorView;

import java.io.IOException;

public class CheckParams {
    Model model;

    Boolean img;
    Boolean src;
    Boolean lbl;
    Boolean kVal;

    String lblSrc;


    public CheckParams(Model model) {
        this.model = model;

    }

    public void setImgSrc(String imgSrc) {
        if (imgSrc.equals("")) {
            ErrorView.errorMessage("Image source cannot be null!", "Image Source Error");
            setImg(false);
        } else {
            setImg(true);
        }
    }

    public void setSrcSrc(String srcSrc) {
        if (srcSrc.equals("")) {
            ErrorView.errorMessage("Model source cannot be null!", "Model Source Error");
            setSrc(false);
        } else {
            this.model.setSrcSrc(srcSrc);
            setSrc(true);
        }
    }

    public void setLblSrc(String lblSrc) {
        if (lblSrc.equals("")) {
            ErrorView.errorMessage("Label source cannot be null!", "Label Source Error");
            setLbl(false);
        } else {
            setLbl(true);
        }
    }

    public void setkValue(String kValue) {
        try {
            int kValueInt = Integer.parseInt(kValue);
            if (kValue == null) {
                ErrorView.errorMessage("K value cannot be null!", "K value Source Error");
                setkVal(false);
            }
            if ((kValueInt < 1) || (kValueInt > 10)) {
                ErrorView.errorMessage("K value must be between 1 and 10!", "K value Error");
                setkVal(false);
            }
            else {
                this.model.setkValue(kValue);
                setkVal(true);
            }
        } catch (NumberFormatException e) {
            ErrorView.errorMessage("K value must be a number!", "K value Error");
        }
    }

    public Boolean getImg() {
        return img;
    }

    public void setImg(Boolean img) {
        this.img = img;
    }

    public Boolean getSrc() {
        return src;
    }

    public void setSrc(Boolean src) {
        this.src = src;
    }

    public Boolean getLbl() {
        return lbl;
    }

    public void setLbl(Boolean lbl) {
        this.lbl = lbl;
    }

    public Boolean getkVal() {
        return kVal;
    }

    public void setkVal(Boolean kVal) {
        this.kVal = kVal;
    }

    public void checkParams() {
        if ((this.getImg() == true) && (this.getSrc() == true) && (this.getLbl() == true) && (this.getkVal() == true)) {
            AlertView.alertMessage("Running model!", "Alert");

            try {  // Label reader
                this.model.getLabelReader().setFilename(this.model.getLblSrc());
                this.model.getLabelReader().read();
            } catch (IOException e) {
                ErrorView.errorMessage("Error reading label data", "Label Error");
            }

            try {  // Source reader
                this.model.getImageReader().setFilename(this.model.getImgSrc());
                this.model.getImageReader().read();
            } catch (IOException e) {
                ErrorView.errorMessage("Error reading image data", "Image Error");
            }

            try {  // Image reader
                this.model.getSourceReader().setFilename(this.model.getSrcSrc());
                this.model.getSourceReader().setLabelName(this.model.getLblSrc());
                this.model.getSourceReader().read();
            } catch (IOException e) {
                ErrorView.errorMessage("Error reading image data", "Image Error");
            }

        }
        else {
            ErrorView.errorMessage("Please check parameters and try again.", "Run Error");
        }
    }
}
