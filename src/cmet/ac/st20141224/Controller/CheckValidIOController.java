package cmet.ac.st20141224.Controller;

import cmet.ac.st20141224.FileIO.*;
import cmet.ac.st20141224.Knn.Algorithm;
import cmet.ac.st20141224.Model.ImageLabelModel;
import cmet.ac.st20141224.Model.MainViewModel;
import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.Model.TrainingDatasetModel;
import cmet.ac.st20141224.View.AlertView;
import cmet.ac.st20141224.View.ErrorView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to check if inputs are valid. If validity checks come back positive, the class proceeds to run the model with
 * specified parameters.
 */
public class CheckValidIOController {
    MainViewModel mainViewModel;

    // Declaring Boolean variables. Set to true if an input is valid, false if an input is invalid.
    Boolean img; // Declaring img variable
    Boolean src; // Declaring src variable
    Boolean lbl; // Declaring lbl variable
    Boolean kVal; // Declaring kVal variable


    public CheckValidIOController(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }


    /**
     * Check that test image source is valid. If it is not, it returns an error to the user.
     * Sets boolean value depending on outcome.
     *
     * In-line comments for the next three classes are very similar, so have only been included when there
     * are some differences.
     *
     * @param srcSrc The filepath of the training data
     */
    public void setSrcSrc(String srcSrc) {
        if (srcSrc.equals("")) {  // Check if image source is null
            ErrorView.errorMessage("Training source cannot be null!", "Image Source Error"); // Throw error if invalid
            setImg(false); // Set boolean value to 'false' if input is invalid
        } else {
            setImg(true); // Set boolean value to 'true' if input is valid
        }
    }


    /**
     * Check that test data source is valid. If it is not, it returns an error to the user.
     * Check to see if the test image is over a certain size. If it is, returns an error
     * Sets boolean value depending on outcome.
     *
     * @param imgSrc The filepath of the test data
     */
    public void setImgSrc(String imgSrc) {
        if (imgSrc.equals("")) {
            ErrorView.errorMessage("Image source cannot be null!", "Image Source Error");
            setSrc(false);
        } else {
            this.mainViewModel.setImgSrc(imgSrc);
            setSrc(true);
        }
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File(this.mainViewModel.getImgSrc()));
//        } catch (IOException e) {
//            ErrorView.errorMessage("Cannot read image file!", "Image Read Error");
//            e.printStackTrace();
//        }

//        int image_width = img.getWidth(); // Getting image width and height
//        int image_height = img.getHeight();
//
//        if (image_width > 32 && image_height > 32) { // Checking to see if image is over-sized
//            ErrorView.errorMessage("Image cannot be larger than 32x32!", "Image Size Error");
//        } else {
//            this.mainViewModel.setImgSrc(imgSrc);
//            setSrc(true);
//        }
    }



    /**
     * Check that label source is valid. If it is not, it returns an error to the user.
     * Sets boolean value depending on outcome.
     *
     * @param lblSrc The filepath of the label
     */
    public void setLblSrc(String lblSrc) {
        if (lblSrc.equals("")) {
            ErrorView.errorMessage("Label source cannot be null!", "Label Source Error");
            setLbl(false);
        } else {
            this.mainViewModel.setLblSrc(lblSrc);
            setLbl(true);
        }
    }



    /**
     * Check that the K value is valid. If it is not, it returns an error to the user.
     * Sets boolean value depending on outcome.
     *
     * @param kValue The kValue specified by the user
     */
    public void setkValue(String kValue) {
        try {
            int kValueInt = Integer.parseInt(kValue);
            if (kValue == null) { // Check if K value is null
                ErrorView.errorMessage("K value cannot be null!", "K value Source Error");
                setkVal(false);
            }
            if ((kValueInt < 1) || (kValueInt > 10)) { // Check if K value is between 1 and 10
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


    /**
     * Checks that all boolean values from above are true. If they are, proceed to run the model.
     * Initialises the file readers, reads the data within the try-catch statements.
     * Creates a new instance of the Algorithm class using data required for it to run (test, label and image data)
     */
    public void checkIO() { // Check to see if all boolean values return true
        if ((this.getImg() == true) && (this.getSrc() == true) && (this.getLbl() == true) && (this.getkVal() == true)) {
            AlertView.alertMessage("Running model!", "Alert"); // Inform user model is running. Tests passed

            // Initialising new file readers
            IFileReader readTrainingDataset = new TrainingDatasetIO();
            IFileReader readTestImage = new TestImageIO();
            IFileReader readLabels = new ImageLabelsIO();

            // HERE GOES LOADING SCREEN TO SHOW THAT LABELS ARE BEING READ
            // FIRST THREAD
            try {
                readLabels.setFilename(this.mainViewModel.getLblSrc()); // Getting the filepath of the label file
                readLabels.read(); // Reading the label file
            } catch (IOException e) { // Inform user there was an error reading the label
                ErrorView.errorMessage("Error reading label data", "Label Error");
            }

            // HERE GOES LOADING SCREEN TO SHOW THAT IMAGE IS BEING READ
            // NEW THREAD
            try {
                readTestImage.setFilename(this.mainViewModel.getImgSrc()); // Getting filepath of test image file
                readTestImage.read(); // Reading test image
            } catch (IOException e) { // Inform user there was an error reading the test image
                ErrorView.errorMessage("Error reading image data", "Image Error");
            }

            // HERE GOES LOADING SCREEN TO SHOW THAT TRAINING SET IS BEING READ
            // NEW THREAD
//            File file = new File(this.mainViewModel.getSrcSrc());
//            boolean isDirectory = file.isDirectory();
//
//
            try { // Read specified source
                readTrainingDataset.setFilename(this.mainViewModel.getSrcSrc()); // Getting filepath to training data file
                readTrainingDataset.read(); // Reading training data
            } catch (IOException e) { // Inform user there was an error reading the training data
                ErrorView.errorMessage("Error reading source data", "Source Error");
            }

            // NEW THREAD STARTS (IT WAITS UNTIL PREVIOUS THREE THREADS HAVE FINISHED BEFORE RUNNING)
            // MODEL RUNS HERE
            // HERE GOES LOADING SCREEN TO SHOW THAT MODEL IS RUNNING

            // Declaring ArrayLists for the training dataset and the image data
            ArrayList<ImageLabelModel> labelList = (ArrayList<ImageLabelModel>) readLabels.getData();
            ArrayList<TrainingDatasetModel> trainingSet = (ArrayList<TrainingDatasetModel>) readTrainingDataset.getData();
            ArrayList<TestImageModel> imageList = (ArrayList<TestImageModel>) readTestImage.getData();

            // Creating new instance of 'Algorithm' class with data from IO classes
            Algorithm algorithm = new Algorithm(this.mainViewModel.getkValue(), trainingSet, imageList, labelList);
            algorithm.computeDistance(); // Running the computeDistance method in the Algorithm class
        }
        else { // Let user know the parameters were invalid
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
