package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.View.AlertView;
import cmet.ac.st20141224.View.ErrorView;

public class CheckParams {
    Boolean img;
    Boolean src;
    Boolean lbl;
    Boolean kVal;

    public CheckParams() {

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
        }
        else {
            ErrorView.errorMessage("Please check parameters and try again.", "Run Error");
        }
    }
}
