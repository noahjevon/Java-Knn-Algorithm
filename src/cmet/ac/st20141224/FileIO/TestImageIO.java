package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.ImageLabelModel;
import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.View.ErrorView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestImageIO implements IFileReader {
    String testImage; // Declaring variable to store file path

    private List<TestImageModel> imageList; // Declaring list to store image data
    private List<ImageLabelModel> labelList;

    FileInputStream in_stream_images; // Declaring new FileInputStream

    private Integer label; // Integer to store label of image
    private List<Integer> redList; // List to store red pixel values
    private List<Integer> greenList; // List to store green pixel values
    private List<Integer> blueList; // List to store blue pixel values
    private List<Integer> greyscaleList; // List to store grayscale values

    public TestImageIO() {
        this.imageList = new ArrayList<>();
        this.labelList = new ArrayList<ImageLabelModel>();
    }

    
    @Override
    public void read() throws IOException {
        String fileName = testImage; // Filepath

        in_stream_images = new FileInputStream(fileName); // Declaring new FileInputStream to read file

        File path = new File(getFilename()); // Getting whole path of the specified file
        String name = path.getName(); // Getting just the name of the specified file
        String labelStr = Character.toString(name.charAt(0)); // Getting the character at the first index in the file name
        this.label = Integer.parseInt(labelStr); // Converting this character to integer value

        while(in_stream_images.available() > 0) { // Checking that image data is available

            byte[] red_Data = new byte[1024]; // Reading 1024 bytes of red data
            in_stream_images.read(red_Data);

            byte[] green_Data = new byte[1024]; // Reading 1024 bytes of green data
            in_stream_images.read(green_Data);

            byte[] blue_Data = new byte[1024]; // Reading 1024 bytes of blue data
            in_stream_images.read(blue_Data);

            BufferedImage img = new BufferedImage // New BufferedImage for the image being read
                    (32, 32, BufferedImage.TYPE_INT_ARGB);

            this.redList = new ArrayList<>(); // Initialising list to store red data
            this.greenList = new ArrayList<>(); // Initialising list to store green data
            this.blueList = new ArrayList<>(); // Initialising list to store blue data
            this.greyscaleList = new ArrayList<>(); // Initialising list to store greyscale data

            int image_width = img.getWidth(); // Getting the image width
            int image_height = img.getHeight(); // Getting the image height
            if (image_height > 32 && image_width > 32) { // Checking that image is 32 x 32 or less
                ErrorView.errorMessage("Image cannot be greater than 32x32!", "Image Size Error");
            } else {

                for (int i = 0; i < 32; i++) { // Loop each pixel in the image
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
            }
        }
        this.imageList.add(new TestImageModel // Creating new object containing all image data
                (label, redList, greenList, blueList, greyscaleList));
    }

    // Getters & setters
    @Override
    public Object getData() {
        return this.imageList;
    }

    @Override
    public void setFilename(String filename) {
        this.testImage = filename;
    }

    @Override
    public String getFilename() {
        return this.testImage;
    }

}
