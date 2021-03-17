package cmet.ac.st20141224.Knn;

import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.Model.TrainingDatasetModel;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Algorithm {

    private int k;
    private List<TrainingDatasetModel> data;
    private List<TestImageModel> unknown;
    private String result;
    private double confidence;

    public Algorithm(int k, List<TrainingDatasetModel> data, List<TestImageModel> unknown) {
        this.k = k;
        this.data = data;
        this.unknown = unknown;
    }


    public void computeDistance() {
        AtomicInteger image = new AtomicInteger();
        this.data.forEach(item -> {
               System.out.println("Image: " + image.getAndIncrement() + item.getGreyscale());
        });
        //Loop for each image in set
            //Nested loop for each value in image
            //After loop, get average distance
        //Add distance to image object
    }


    public void classify() {

    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

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
