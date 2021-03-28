package cmet.ac.st20141224.Knn;

import cmet.ac.st20141224.Model.*;
import cmet.ac.st20141224.View.ResultsView;

import javax.swing.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


public class Algorithm {

    private ResultsView resultsView;
    private List<TrainingDatasetModel> data; // List to store parameters of training image object
    private List<TestImageModel> unknown; // List to store parameters of test image object
    private List<ImageLabelModel> labels; // List to store labels of images

    private int k; // Integer to store k value
    private String result; // String to store classification result
    private double confidence; // Double to store confidence value

    private String filePath; // Specify the filepath

    private int actualLabel; // Actual label of classified image
    private String labelText; // Actual label of classified image in text format
    private int correctClassification; // Int to store number of correct classifications

    private HashMap<String, Integer> labelHash; // HashMap to store frequency that labels occur during classification
    private List<String> labelList; // List to store test image labels as a string
    private List<Double> distance; // List of doubles to store distance values

    private List<Integer> test; // Lists to store pixel data of test image

    private List<Integer> train; // Lists to store pixel data of train image

    int i = -1; // Starting index for image files at -1 (increases to 0 on first run)

    private int startTime; // Store start time of Knn
    private int endTime; // Store end time of Knn
    private int timeTaken; // Store time taken to run Knn

    List<Integer> greyscale;


    /**
     * Algorithm that accepts parameters used in order to get distances between pixel data, and classify the data
     * to make a prediction as to what the test data may be.
     *
     * @param k       The K value the model will run using
     * @param data    The training data the model will run using
     * @param unknown The test data the model will run with
     */
    public Algorithm(int k, List<TrainingDatasetModel> data, List<TestImageModel> unknown, List<ImageLabelModel> labels) {
        this.k = k; // Set k value
        this.data = data; // Set training image
        this.unknown = unknown; // Set test image value
        this.labels = labels; // Set label value
        this.resultsView = new ResultsView(); // new ResultsView
        computeDistance();
    }


    /**
     * Method to compute the distance between two data points within training and testing images. Contains a
     * SwingWorker thread. Allows the GUI to update dynamically, showing the user an increasing time in ms and a dynamically
     * changing accuracy rating as the classification process runs. Can be seen better when using larger amounts of source
     * and training files. Also allows a progress view to bne displayed to the user with the option to cancel the action,
     * which stops the worker thread from running and proceeds with whatever data was collected during the run time.
     *
     * @return returns null
     */
    public void computeDistance() {
        this.startTime = (int) System.currentTimeMillis(); // Get time at start

        final SwingWorker sw = new SwingWorker<Integer, Integer>() { // New swing worker thread

            protected Integer doInBackground() throws Exception { // Background thread for process to run in
                final ProgressMonitor pm = new ProgressMonitor(resultsView, "",
                        "", 1, unknown.size() - 1); // Progress monitor to display progress to user

                pm.setMillisToDecideToPopup(100); // Time it takes to display progress monitor
                pm.setMillisToPopup(100);

                labelList = new ArrayList<>(); // Arraylist to store labels
                labelHash = new HashMap<String, Integer>(); // Hashmap to store labels and their frequency during classification

                labels.forEach((imageLabels) -> {
                    labelList.add(imageLabels.getLabel()); // add to label list
                });

                unknown.forEach((n) -> { // Lambda - for each item in unknown
                    while (i++ < unknown.size() && !pm.isCanceled()) { // Loop until process finishes or is cancelled by user
                        TestImageModel image = unknown.get(i); // Get image at index i in TestImageModel

                        pm.setProgress(i); // Set the progress of the progress model

                        greyscale = new ArrayList<>(); // New arraylist to store greyscale data
                        filePath = image.getFilePath(); // Get filepath of image
                        test = image.getGreyscale(); // Lists to store pixel data
                        actualLabel = image.getLabel(); // Get label of image

                        pm.setNote(filePath); // Update the progress model with the filepath currently in use

                        greyscale = image.getGreyscale(); // Get greyscale value of image

                        ForkJoinPool fjpool = new ForkJoinPool(); // New ForkJoinPool
                        TrainingDatasetModel[] train = data.toArray(new TrainingDatasetModel[data.size()]); // Convert data to array

                        RecursiveAlgorithm task = new RecursiveAlgorithm(train,
                                greyscale, 0, data.size()); // New task with training data, greyscale data, start point and set size

                        fjpool.invoke(task); // Start the ForkJoinPool

                        classify(); // Classify image
                    }
                });
                return null;
            }
        };
        sw.execute(); // Execute worker thread
    }


    /**
     * Method to classify the distances in order to find out which images are likely to belong to the same class as the
     * test image, allowing an informed decision to be made. Uses K value to take the top 'n' values of the classified
     * data, where 'n' = K.
     */
    public void classify() {
        DecimalFormat df = new DecimalFormat("#.00"); // DecimalFormat to 2 decimal places

        this.data.sort(Comparator.comparingDouble(TrainingDatasetModel::getDistance)); // Compare values to get distance

        int max = Integer.MIN_VALUE;

        List<TrainingDatasetModel> // Creating sublist of images containing the lowest distance from K value
                kList = this.data.subList(0, this.k);

        // Loop through list to find how many occurrences there are of each label
        int length = labelList.size();
        for (int i = 0; i < length; i++) { // Loop through list
            int finalI = i;
            int lbl = (int) kList.stream().filter(t -> // Get label and frequency at index
                    (t.getLabel() == (finalI))).count();
            this.labelHash.put(this.labelList.get(finalI), lbl); // Add label frequency to hash map
        }

        // Finding highest occurrence of a label in hash map
        Set<Map.Entry<String, Integer>> entries = this.labelHash.entrySet();
        for (Map.Entry<String, Integer> entry : entries) { // Iterate through all values in hash map
            if (entry.getValue() > max) {
                max = entry.getValue(); // Get largest value in hashmap
                this.result = entry.getKey(); // Get key for largest value in hash map
            }
        }

        // Getting the text label of the test image
        labelText = this.labelList.get(actualLabel);

        // Getting the predicted label of the test image
        if (this.result == labelText) { // If result from above loop matches the text label of the test image
            this.correctClassification++; // Increment correctClassification
        } else {
            // Do nothing
        }

        // Find confidence value
        this.confidence = 100 * ((double) max / kList.size());
        String confidenceFormatted = df.format(confidence);


        /**
         * If the number of unknown images exceeds 1, display results needed for one image. If it is greater than 1,
         * display the overall accuracy as well as how many images were successfully classified and how many images
         * there are in total. Also outputs the K value used, how many files were processed and how long it took
         * in milliseconds.
         */
        this.endTime = (int) System.currentTimeMillis(); // Get time at completion
        this.timeTaken = (endTime - startTime); // Calculate time taken

        // Updating the views is in the classify class - this way the results page updates dynamically as the classification
        // runs, acting as a visual guide for the user to see classifications happening in real-time
        if (this.unknown.size() <= 1) {
            // Display results to user
            File f = new File(filePath); // Get file name
            this.resultsView.setTitle(f.getName() + " | " + labelText); // Set title to file name
            this.resultsView.getResultsImagePanel().setImage(filePath);
            this.resultsView.getResultsLabelPanel().getImageLabel().setText("Actual Label: " + labelText + "  "); // Display actual label
            this.resultsView.getResultsLabelPanel().getResultLabel().setText("Classified Label: " + result); // Display classified label
            this.resultsView.getConfidenceRatingPanel().getConfidenceRating().setText("Confidence: " + confidenceFormatted + "%"); // Display confidence
        } else {
            // calculate the average accuracy
            Double accuracy = (double) (this.correctClassification * 100) / (this.unknown.size());
            String accuracyFormatted = df.format(accuracy); // Format accuracy to 2 decimal places
            this.resultsView.setTitle("Multiple Files"); // Set title
            this.resultsView.getResultsLabelPanel().getImageLabel().setText("Correctly Classified: " + this.correctClassification + "  "); // Show correct classifications
            this.resultsView.getResultsLabelPanel().getResultLabel().setText("Total Images: " + (i + 1)); // Show images classified
            this.resultsView.getConfidenceRatingPanel().getConfidenceRating().setText("Accuracy: " + accuracyFormatted + "%"); // Show accuracy
        }
        // Show K value used and the time it took to complete
        this.resultsView.getkValuePanel().getkValueLabel().setText("K value: " + (String.valueOf(this.k)));
        this.resultsView.getTimeTakenPanel().getTimeTakenLabel().setText(("Process took: " + timeTaken + " ms."));
    }
}


