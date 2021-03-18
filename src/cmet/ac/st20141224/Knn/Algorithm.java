package cmet.ac.st20141224.Knn;

import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.Model.TrainingDatasetModel;

import java.util.*;

public class Algorithm {

    private int k; // Integer to store k value
    private List<TrainingDatasetModel> data; // List to store parameters of training image object
    private List<TestImageModel> unknown; // List to store parameters of test image object
    private String result; // String to store classification result
    private double confidence; // Double to store confidence value
    private List<Double> distance; // List of doubles to store distance vlaues
    private List<Integer> test;
    private List<Integer> test_red;
    private List<Integer> test_green;
    private List<Integer> test_blue;

    private List<Integer> train;
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
    public Algorithm(int k, List<TrainingDatasetModel> data, List<TestImageModel> unknown) {
        this.k = k; // Set k value
        this.data = data; // Set training image
        this.unknown = unknown; // Set test image value
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
        }

        for (TrainingDatasetModel trainImage : data) { // For loop to get training image data
            this.distance = new ArrayList<>(); // Declaring list to store distance

            train = trainImage.getGreyscale(); // Lists to store pixel data
            train_red = trainImage.getRed();
            train_green = trainImage.getGreen();
            train_blue = trainImage.getBlue();

            int length = train_red.size();
            if (length != test_red.size()) { // Check that lists are the same length
                System.out.println("Out of bounds exception!"); // Throw error
            }
            for (int i = 0; i < length; i ++) { // For each pixel in image
                double s = Math.pow((train.get(i) - test.get(i)),2) + // get square root
                        Math.pow((+ train_red.get(i) - test_red.get(i)),2) +
                        Math.pow((+ train_green.get(i) - test_green.get(i)),2) +
                        Math.pow((+ train_blue.get(i) - test_blue.get(i)),2);
                double d = Math.sqrt(s);
                this.distance.add(d); // Add distance to distance list
            }
            double sum = distance.stream().mapToDouble(a -> a).sum(); // Get sum of distances
            double finalDistance = sum / distance.size(); // Get average distance
            trainImage.setDistance(finalDistance); // Set distance of training image
        }
        classify();
    }


    /**
     * Method to classify the distances in order to find out which images are likely to belong to the same class as the
     * test image, allowing an informed decision to be made. Uses K value to take the top 'n' values of the classified
     * data, where 'n' = K.
     */
    public void classify() {
        this.data.sort(Comparator.comparingDouble(TrainingDatasetModel::getDistance));

        List<TrainingDatasetModel> // Creating sublist of images containing the lowest distance from K value
                kList = this.data.subList(0, this.k);
        
        int plane = (int) kList.stream().filter(t -> (t.getLabel() == (0))).count();
        System.out.println("Plane count: " + plane);

        int auto = (int) kList.stream().filter(t -> (t.getLabel() == (1))).count();
        System.out.println("auto count: " + auto);

        int bird = (int) kList.stream().filter(t -> (t.getLabel() == (2))).count();
        System.out.println("bird count: " + bird);

        int cat = (int) kList.stream().filter(t -> (t.getLabel() == (3))).count();
        System.out.println("cat count: " + cat);

        int deer = (int) kList.stream().filter(t -> (t.getLabel() == (4))).count();
        System.out.println("deer count: " + deer);

        int dog = (int) kList.stream().filter(t -> (t.getLabel() == (5))).count();
        System.out.println("dog count: " + dog);

        int frog = (int) kList.stream().filter(t -> (t.getLabel() == (6))).count();
        System.out.println("frog count: " + frog);

        int horse = (int) kList.stream().filter(t -> (t.getLabel() == (7))).count();
        System.out.println("horse count: " + horse);

        int ship = (int) kList.stream().filter(t -> (t.getLabel() == (8))).count();
        System.out.println("ship count: " + ship);

        int truck = (int) kList.stream().filter(t -> (t.getLabel() == (9))).count();
        System.out.println("truck count: " + truck);
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
