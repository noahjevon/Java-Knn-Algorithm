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
import java.util.stream.Stream;


public class TrainingDatasetIO implements IFileReader {
    private String CIFAR; // Delaring variable to store file path

    private FileInputStream imageStream; // Declaring new FileInputStream to read file

    private List<TrainingDatasetModel> imageList; // Declaring new list to store image data
    private List<Integer> redList; // Declaring new list to store red pixel values
    private List<Integer> greenList; // Declaring new list to store green pixel values
    private List<Integer> blueList; // Declaring new list to store blue pixel values
    private List<Integer> greyscaleList; // Declaring new list to store greyscale pixel values


    public TrainingDatasetIO() {
        this.imageList = new ArrayList<TrainingDatasetModel>();
    }


    @Override
    public void read() throws IOException {

        String fileName = CIFAR; // Filepath

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

    // Getters & setters
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
