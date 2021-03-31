package cmet.ac.st20141224.Knn;

import cmet.ac.st20141224.Model.TrainingDatasetModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;


public class RecursiveAlgorithm extends RecursiveAction implements IAlgorithm<Double, Integer> {

    private static final long serialVersionID = 1l;

    final int threshold = 2500; // how many objects to run with

    List<Double> distance;
    List<Integer> train;
    TrainingDatasetModel[] data;
    List<Integer> greyscale;
    int start, end;

    public RecursiveAlgorithm(TrainingDatasetModel[] data, List<Integer> greyscale, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.greyscale = greyscale;
    }

    /**
     * Compute class. Decides how much data should be split up within the ForkJoin pool. Performs the actions
     * normally done by the Algorithm class to speed up the process (About 6x increase in speed)
     */
    @Override
    protected void compute() {
        if((end - start) < threshold) {
                for (int i = start; i < end; i++) {
                        distance = new ArrayList<>(); // List to store distance
                        train = (data[i].getGreyscale()); // Lists to store pixel data

                        int length = train.size(); // Set length to list of greyscale data list (Should be 1024)

                        for (int p = 0; p < length; p++) { // For each pixel in image
                            double s = Math.pow((train.get(p) - greyscale.get(p)), 2); // get square sum
                            double d = Math.sqrt(s);
                            this.distance.add(d); // Add distance to distance list
                        }
                        double sum = distance.stream().mapToDouble(a -> a).sum(); // Get sum of distances
                        double finalDistance = sum / distance.size(); // Get average distance (divide sum number of distances)
                        data[i].setDistance(finalDistance);
                    }
                }
        else {
            int middle = (start + end) / 2;
            invokeAll(new RecursiveAlgorithm(data, greyscale, start, middle), new RecursiveAlgorithm(data, greyscale, middle, end));
        }
    }


    @Override
    public Double distance(Integer val, Integer min, Integer max) {
        return null;
    }
}
