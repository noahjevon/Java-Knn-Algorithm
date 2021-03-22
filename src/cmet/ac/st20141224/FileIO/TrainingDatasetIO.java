package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.TrainingDatasetModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TrainingDatasetIO implements IFileReader {
    private String CIFAR; // Delaring variable to store file path
    public List<String> filePath; // List to store individual paths of files in the directory

    private List<TrainingDatasetModel> imageList; // Declaring new list to store image data
    private List<Integer> redList; // Declaring new list to store red pixel values
    private List<Integer> greenList; // Declaring new list to store green pixel values
    private List<Integer> blueList; // Declaring new list to store blue pixel values
    private List<Integer> greyscaleList; // Declaring new list to store greyscale pixel values


    public TrainingDatasetIO() {
        this.imageList = new ArrayList<TrainingDatasetModel>(); // Arraylist to store object data
        this.filePath = new ArrayList<>(); // Arraylist to store file paths
    }


    /**
     * Reads the files in the dataset. Boolean value determines if the given path is a file or directory. If it is
     * a directory, it repeats the read process for every file in the directory.
     *
     * @throws IOException Throws error if there is mistake reading the files
     */
    @Override
    public void read() throws IOException {
        File file = new File(CIFAR); // Path of directory or file

        boolean isDirectory = file.isDirectory(); // Boolean to see if directory or file

            if (isDirectory == true) { // If a directory,
                String folder = CIFAR; // Specify folder
                Path dir = Paths.get(folder); // Specify paths
                Files.walk(dir).forEach(path -> showFile(path.toFile())); // Run toFile to add paths to array
                filePath.remove(0); // Remove first index (It's the directory itself)

                for (String path : filePath) { // Start reading each file within directory
                    readData(path);
                }

            } else { // If not a directory, read single file
                    readData(CIFAR);
            }
        }


    /**
     * Adds the paths of each file within the directory to filePath array. For use later to read each file
     * individually.
     *
     * @param file The directory containing the files to be read
     */
    public void showFile(File file) {
        this.filePath.add(file.getAbsolutePath()); // Add absolute path of each file to filePath array
    }


    /**
     * Reads fine data. Accesses first byte to get label, then three batches of 1024 bytes to read red, green and
     * blue data. Repeats process for each pixel in the image (1024) for each image in the binary file.
     *
     * @param path The individual path of each file being read
     * @throws IOException Exception if there is an error in reading the image data
     */
    public void readData(String path) throws IOException {
        FileInputStream imageStream; // Declaring new FileInputStream to read file
        String fileName = path; // Filepath

        imageStream = new FileInputStream(fileName); // Declaring new FileInputStream to read file
        while(imageStream.available() > 0) { // Checking that image data is available
            int label = imageStream.read(); // Reading first byte to get label value

            byte[] red_Data = new byte[1024]; // Reading 1024 bytes of red data
            imageStream.read(red_Data);

            byte[] green_Data = new byte[1024]; // Reading 1024 bytes of green data
            imageStream.read(green_Data);

            byte[] blue_Data = new byte[1024]; // Reading 1024 bytes of blue data
            imageStream.read(blue_Data);

            BufferedImage img = new BufferedImage // New BufferedImage for the image being read
                    (32, 32, BufferedImage.TYPE_INT_ARGB);

            this.redList = new ArrayList<>(); // Initialising list to store red data
            this.greenList = new ArrayList<>(); // Initialising list to store green data
            this.blueList = new ArrayList<>(); // Initialising list to store blue data
            this.greyscaleList = new ArrayList<>(); // Initialising list to store greyscale data

            for(int i=0; i < 32; i++) { // Loop each pixel in the image
                for (int j = 0; j < 32; j++) {
                    Color color = new Color(
                            red_Data[i * 32 + j] & 0xFF, // Get red data from pixel
                            green_Data[i * 32 + j] & 0xFF, // get green data from pixel
                            blue_Data[i * 32 + j] & 0xFF); // Get blue data from pixel
                    img.setRGB(i, j, color.getRGB()); // Getting the RGB value of the pixel

                    int red = red_Data[i * 32 + j] & 0xFF; // Storing red data as int
                    int green = green_Data[i * 32 + j] & 0xFF; // Storing green data as int
                    int blue = blue_Data[i * 32 + j] & 0xFF; // Storing blue data as int

                    int greyscale = (int) ((0.3 * red) + // Formula to calculate greyscale value of the pixel
                            (0.59 * green) + (0.11 * blue));

                    this.redList.add(red); // Adding red pixel data to red list
                    this.greenList.add(green); // Adding green pixel data to green list
                    this.blueList.add(blue); // Adding blue pixel data to blue list
                    this.greyscaleList.add(greyscale); // Adding greyscale pixel data to greyscale list
                }
            }
            this.imageList.add(new TrainingDatasetModel // Creating new object containing all image data
                    (label, redList, greenList, blueList, greyscaleList));
        }
    }


    /**
     * Getters & setters
     *
     * @return Returns the current value assigned to variable
     */
    @Override
    public Object getData() {
        return this.imageList;
    }

    @Override
    public void setFilename(String filename) {
        this.CIFAR = filename;
    }

    @Override
    public String getFilename() {
        return this.CIFAR;
    }
}
