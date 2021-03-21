package cmet.ac.st20141224.Knn;

import cmet.ac.st20141224.Model.ImageLabelModel;
import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.Model.TrainingDatasetModel;
import cmet.ac.st20141224.View.ErrorView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;


public class RecursiveAlgorithm extends RecursiveAction implements IAlgorithm<Double, Integer> {

    private static final long serialVersionID = 1l;

    final int threshold = 5000; // how many objects to run with - try with thousands

    TrainingDatasetModel[] data;
    TestImageModel[] unknown;
    static int testSize;
    int start, end;

    public RecursiveAlgorithm(TrainingDatasetModel[] data, TestImageModel[] unknown, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.unknown = unknown;
    }

    @Override
    protected void compute() {
        if((end - start) < threshold) {
            for (int i = start; i < end; i++) {
                int pos = -1; // Position of test image (start at -1)
                for (TestImageModel testImage : unknown) {
                    pos++; // Increase test image position (goes to 0)
                    List<Double> distance = new ArrayList<>();
                    List<Integer> train;
                    List<Integer> test;
                    train = (data[i].getGreyscale());
                    test = (unknown[pos].getGreyscale()); // Use pos to find index of current test image (increases)
                    int length = (train.size());

                    for (int p = 0; p < length; p++) {
                        double s = Math.pow((train.get(p) - test.get(p)), 2);
                        double d = Math.sqrt(s);
                        distance.add(d);
                    }
                    double sum = distance.stream().mapToDouble(a -> a).sum();
                    double finalDistance = sum / distance.size();
                    data[i].setDistance(finalDistance);
                }
            }
        }
        else {
            int middle = (start + end) / 2;
            invokeAll(new RecursiveAlgorithm(data, unknown, start, middle), new RecursiveAlgorithm(data, unknown, middle, end));
        }
    }

    @Override
    public Double normalize(Integer val, Integer min, Integer max) {
        return null;
    }
}
