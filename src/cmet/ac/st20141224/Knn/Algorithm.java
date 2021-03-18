package cmet.ac.st20141224.Knn;

import cmet.ac.st20141224.Model.*;
import cmet.ac.st20141224.View.ResultsView;

import java.util.*;

public class Algorithm {

    private MainViewModel mainViewModelModel;
    private ResultsView resultsView;
    private List<TrainingDatasetModel> data; // List to store parameters of training image object
    private List<TestImageModel> unknown; // List to store parameters of test image object
    private List<ImageLabelModel> labels; // List to store labels of images

    private int k; // Integer to store k value
    private String result; // String to store classification result
    private double confidence; // Double to store confidence value
    private int label; // Actual label of classified image
    private String labelText;

    private List<String> labelList;
    private HashMap<String, Integer> labelHash;

    private List<Double> distance; // List of doubles to store distance values

    private List<Integer> test; // Lists to store pixel data of test image
    private List<Integer> test_red;
    private List<Integer> test_green;
    private List<Integer> test_blue;

    private List<Integer> train; // Lists to store pixel data of train image
    private List<Integer> train_red;
    private List<Integer> train_green;
    private List<Integer> train_blue;


    /**
     * Algorithm that accepts parameters used in order to get distances between pixel data, and classify the data
     * to make a prediction as to what the test data may be.
     *
     * @param k The K value the model will run using
     * @param data The training data the model will run using
     * @param unknown The test data the model will run with
     */
    public Algorithm(int k, List<TrainingDatasetModel> data, List<TestImageModel> unknown, List<ImageLabelModel> labels) {
        this.resultsView = new ResultsView();

        this.k = k; // Set k value
        this.data = data; // Set training image
        this.unknown = unknown; // Set test image value
        this.labels = labels;
    }


    /**
     * Method to compute the distance between two data points within training and testing images.
     */
    public void computeDistance() {
        for (TestImageModel testImage : unknown) { // For loop to get test image data
            test = testImage.getGreyscale(); // Lists to store pixel data
            test_red = testImage.getRed();
            test_green = testImage.getGreen();
            test_blue = testImage.getBlue();
            label = testImage.getLabel();
        }

        for (TrainingDatasetModel trainImage : data) { // For loop to get training image data
            this.distance = new ArrayList<>(); // List to store distance

            train = trainImage.getGreyscale(); // Lists to store pixel data
            train_red = trainImage.getRed();
            train_green = trainImage.getGreen();
            train_blue = trainImage.getBlue();

            int length = train.size(); // Set length to list of greyscale data list (Should be 1024)
            if (length != test.size()) { // Check that lists are the same length
                System.out.println("Out of bounds exception!"); // Throw error if lists don't match
            }
            for (int i = 0; i < length; i ++) { // For each pixel in image
                double s = Math.pow((train.get(i) - test.get(i)),2) + // get square sum
                        Math.pow((+ train_red.get(i) - test_red.get(i)),2) +
                        Math.pow((+ train_green.get(i) - test_green.get(i)),2) +
                        Math.pow((+ train_blue.get(i) - test_blue.get(i)),2);
                double d = Math.sqrt(s);
                this.distance.add(d); // Add distance to distance list
            }
            double sum = distance.stream().mapToDouble(a -> a).sum(); // Get sum of distances
            double finalDistance = sum / distance.size(); // Get average distance (divide sum number of distances)
            trainImage.setDistance(finalDistance); // Set distance of training image
        }
        classify(); // Begin classification
    }


    /**
     * Method to classify the distances in order to find out which images are likely to belong to the same class as the
     * test image, allowing an informed decision to be made. Uses K value to take the top 'n' values of the classified
     * data, where 'n' = K.
     */
    public void classify() {
        this.data.sort(Comparator.comparingDouble(TrainingDatasetModel::getDistance));

        this.labelList = new ArrayList<>();
        this.labelHash = new HashMap<String, Integer>();

        int max = Integer.MIN_VALUE;

        List<TrainingDatasetModel> // Creating sublist of images containing the lowest distance from K value
                kList = this.data.subList(0, this.k);

        for (ImageLabelModel imageLabels : labels) { // For each item in label object,
            this.labelList.add(imageLabels.getLabel()); // add to label list
        }

        // Loop through list to find how many occurrences there are of each label
        int length = 10; // Length of list (0-9)
        for (int i = 0; i < length; i ++) { // Loop through list
            int finalI = i;
            int lbl = (int) kList.stream().filter(t -> // Get label at list
                    (t.getLabel() == (finalI))).count();
            this.labelHash.put(this.labelList.get(finalI), lbl); // Add label frequency to hash map
        }

        // Finding highest occurrence of a label in hash map
        Set<Map.Entry<String,Integer>> entries=this.labelHash.entrySet();
        for(Map.Entry<String,Integer> entry:entries) { // Iterate through all values in hash map
            if (entry.getValue() > max) {
                max = entry.getValue(); // Get largest value in hashmap
                this.result = entry.getKey(); // Get key for largest value in hash map
            }
        }

        // Getting the text label of the test image
        labelText = this.labelList.get(label);

        // Find confidence value
        this.confidence = 100 * ((double) max / kList.size()); // Confidence formula
        System.out.println("Result: " + this.result + " | " + "Confidence: " + this.confidence);

        // Display results to user
        this.resultsView.getResultsLabelPanel().getImageLabel().setText("Actual Label: " + labelText);
        this.resultsView.getResultsLabelPanel().getResultLabel().setText("Classified Label: " + result);
        this.resultsView.getConfidenceRatingPanel().getConfidenceRating().setText("Confidence: " + confidence);
    }

    // Getters & setters
    public int getK() {
        return k;
    }

    public void setK(int k) { this.k = k; }

    public List<TrainingDatasetModel> getData() {
        return data;
    }

    public void setData(List<TrainingDatasetModel> data) {
        this.data = data;
    }

    public List<TestImageModel> getUnknown() {
        return unknown;
    }

    public void setUnknown(List<TestImageModel> unknown) {
        this.unknown = unknown;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
