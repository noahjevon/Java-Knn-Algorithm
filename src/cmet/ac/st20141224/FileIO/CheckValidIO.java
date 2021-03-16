package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.MainViewModel;
import cmet.ac.st20141224.Model.SourceModel;
import cmet.ac.st20141224.View.AlertView;
import cmet.ac.st20141224.View.ErrorView;
import cmet.ac.st20141224.View.MainView;
import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class CheckValidIO {
    MainViewModel mainViewModel;

    Boolean img;
    Boolean src;
    Boolean lbl;
    Boolean kVal;


    public CheckValidIO(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }


    public void setImgSrc(String imgSrc) {
        if (imgSrc.equals("")) {  // Check if image source is null
            ErrorView.errorMessage("Image source cannot be null!", "Image Source Error");
            setImg(false);
        } else {
            setImg(true);
        }
    }


    public void setSrcSrc(String srcSrc) {
        if (srcSrc.equals("")) {  // Check if training source is null
            ErrorView.errorMessage("Training source cannot be null!", "Training Source Error");
            setSrc(false);
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(this.mainViewModel.getImgSrc()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int image_width = img.getWidth();  // Getting image width and height
        int image_height = img.getHeight();

        if (image_width > 32 && image_height > 32) {  // Checking to see if image is over-sized
            ErrorView.errorMessage("Image cannot be larger than 32x32!", "Image Size Error");
        } else {
            this.mainViewModel.setSrcSrc(srcSrc);
            setSrc(true);
        }
    }


    public void setLblSrc(String lblSrc) {
        if (lblSrc.equals("")) {  // Check if training source is null
            ErrorView.errorMessage("Label source cannot be null!", "Label Source Error");
            setLbl(false);
        } else {
            this.mainViewModel.setLblSrc(lblSrc);
            System.out.println(this.mainViewModel.getLblSrc());
            setLbl(true);
        }
    }


    public void setkValue(String kValue) {
        try {
            int kValueInt = Integer.parseInt(kValue);
            if (kValue == null) {  // Check if K value is null
                ErrorView.errorMessage("K value cannot be null!", "K value Source Error");
                setkVal(false);
            }
            if ((kValueInt < 1) || (kValueInt > 10)) {  // Check if K value is between 1 and 10
                ErrorView.errorMessage("K value must be between 1 and 10!", "K value Error");
                setkVal(false);
            }
            else {
                this.mainViewModel.setkValue(kValue);
                setkVal(true);
            }
        } catch (NumberFormatException e) {  // Check K value is a number
            ErrorView.errorMessage("K value must be a number!", "K value Error");
        }
    }


    public void checkParams() {  // Check to see if all boolean values return true
        if ((this.getImg() == true) && (this.getSrc() == true) && (this.getLbl() == true) && (this.getkVal() == true)) {
            AlertView.alertMessage("Running model!", "Alert");  // Inform user model is running. Tests passed

            // HERE GOES LOADING SCREEN TO SHOW THAT LABELS ARE BEING READ
            // FIRST THREAD
            try {  // Read specified label
                this.mainViewModel.getLabelReader().setFilename(this.mainViewModel.getLblSrc());
                this.mainViewModel.getLabelReader().read();
            } catch (IOException e) {  // Inform user there was an error reading the label
                ErrorView.errorMessage("Error reading label data", "Label Error");
            }

            // HERE GOES LOADING SCREEN TO SHOW THAT IMAGE IS BEING READ
            // NEW THREAD
            try {  // Read specified image
                this.mainViewModel.getImageReader().setFilename(this.mainViewModel.getImgSrc());
                this.mainViewModel.getImageReader().setLabelName(this.mainViewModel.getLblSrc());
                this.mainViewModel.getImageReader().read();
            } catch (IOException e) {  // Inform user there was an error reading the source
                ErrorView.errorMessage("Error reading image data", "Image Error");
            }

            // HERE GOES LOADING SCREEN TO SHOW THAT TRAINING SET IS BEING READ
            // NEW THREAD
            try {  // Read specified source
                this.mainViewModel.getSourceReader().setFilename(this.mainViewModel.getSrcSrc());
                this.mainViewModel.getSourceReader().setLabelName(this.mainViewModel.getLblSrc());
                this.mainViewModel.getSourceReader().read();
            } catch (IOException e) {  // Inform user there was an error reading the source
                ErrorView.errorMessage("Error reading source data", "Source Error");
            }

            // NEW THREAD STARTS (IT WAITS UNTIL PREVIOUS THREE THREADS HAVE FINISHED BEFORE RUNNING)
            // MODEL RUNS HERE
//            ArrayList<SourceModel> imageList = (ArrayList<SourceModel>) this.mainViewModel.getSourceReader().getData();
//
//            imageList.forEach (t -> System.out.println(t));
            // HERE GOES LOADING SCREEN TO SHOW THAT MODEL IS RUNNING
        }
        else {  // Let user know the parameters were invalid
            ErrorView.errorMessage("Please check parameters and try again.", "Run Error");
        }
    }

    // Setters & Getters
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
}
