package cmet.ac.st20141224.Knn;

import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.Model.TrainingDatasetModel;

import java.lang.reflect.Field;
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
    private int label;


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
        for (TestImageModel val2 : unknown) {
            test = val2.getGreyscale();
            test_red = val2.getRed();
            test_green = val2.getGreen();
            test_blue = val2.getBlue();
        }

        for (TrainingDatasetModel val : data) {
            this.distance = new ArrayList<>(); // Declaring list to store distance

            train = val.getGreyscale();
            train_red = val.getRed();
            train_green = val.getGreen();
            train_blue = val.getBlue();

            int length = train_red.size();
            if (length != test_red.size()) {
                System.out.println("Out of bounds exception!");
            }
            for (int i = 0; i < length; i ++) {
                double s = Math.pow((train.get(i) - test.get(i)),2) +
                        Math.pow((+ train_red.get(i) - test_red.get(i)),2) +
                        Math.pow((+ train_green.get(i) - test_green.get(i)),2) +
                        Math.pow((+ train_blue.get(i) - test_blue.get(i)),2);
                double d = Math.sqrt(s);
                this.distance.add(d);
            }
            double sum = distance.stream().mapToDouble(a -> a).sum();
            double finalDistance = sum / 1024;
            val.setDistance(finalDistance);
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

    //    Knn has NO training phase. Takes test image, performs algorithm on all training images available and try to come up with a classification.
//    If it’s a datastream, go through regression path. Not building a model using training dataset,
//    instead takes whole training dataset and uses testing image or testing data on the whole dataset
//    to come up with classification – this Is why it’s a lazy algorithm
//    Try to identify neighbours of each image, the similar image next to the image we are trying to classify
//    K is a user defined constant. How does the value of K change how the algorithm reacts?
//    An unlabeled image is going to be given the label that is most frequent among it's nearest neighbours
//
//    If 'K' = 3   ,   look at the 3 closest neighbours for the object
//    If the MAJORITY of an unknown object has X label, it is assumed that the unknown object also belongs to that
//    majority.
//
//    If 'K' = 5   ,   the same thing applies. Look at the 5 closest neighbors
//
//    Use odd numbers when experimenting to avoid issues where there is 1 square and 1 circle, for example
//
//    Measure the distance from the unknown object to the known objects. Different distances are available. See "Distance Measures"
//    in moodle for additional support. Use Euclidean Distance for the example.
//
//    If 'k' = 1   ,   the nearest class is assigned the unknown feature vector. Lots of noise, not a good approach.
//    Selecting 'K' is a heuristic approach. Need to experiment to decide on the best 'K' value.
//
//    Issues with Knn algorithm - there are more sophisticated and accurate models available. If dataset is biased
//    towards a particular class, the distribution is skewed. Classification will be biased towards this. If there are 6
//    squares but only 1 circle, the unknown class will always be a square even if it is a circle. Does not apply to
//    CIFAR-10 as it is a very balanced dataset.
//
//    get dataset, normalise if i have to, compute the distances, sort the dataset, extract k values, find majority
//    classification, assign unknown object to said majority classification
//
//    We deal with 2D data. How to compare distance between images? take 1 pixel from 1 image (unknown), take another pixel
//    from a second image (test), and use these values as (P1-q1)2, do this for the next pixel (P2-Q2)2, continue this
//    until the very last image is indentified (Pn - Qn)2 and add them all together to find the distance
//    when reading CIFAR dataset, combine RGB values into coloured object for all the images I read. Once this is done,
//    trying to extract one pixel will give the individual RGB value into 1 value so we don't need to deal with separate
//    RGB channels. Will make things easier. Unless we create buffered structure, we have to treat RGB values individually.
//    If they are combined together into one colour value in buffered image structure we do not have to do this.
//
//    Write a for loop going from top end of each image, get each pixel one at a time, get distance, square it, add it
//    together, do this for every pixel in image, square root it to get the distance. Add array for each image to the
//    array to get all the distances, sort that list, apply K value, print suggested label.
//
//    Read CIFAR-10 dataset and construct the pixel sorting.
}
