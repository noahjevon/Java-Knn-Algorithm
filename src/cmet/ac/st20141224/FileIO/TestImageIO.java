package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.ImageLabelModel;
import cmet.ac.st20141224.Model.TestImageModel;
import cmet.ac.st20141224.View.ErrorView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TestImageIO implements IFileReader {
    String testImage; // Declaring variable to store file path

    private List<TestImageModel> imageList; // Declaring list to store image data
    private List<ImageLabelModel> labelList; // List of labels
    public List<String> filePath; // List to store individual paths of files in the directory

    private Integer label; // Integer to store label of image
    private List<Integer> greyscaleList; // List to store grayscale values
    private String fileName;

    public TestImageIO() {
        this.imageList = new ArrayList<>();
        this.labelList = new ArrayList<ImageLabelModel>();
        this.filePath = new ArrayList<>();
    }


    @Override
    public void read() throws IOException {
        File file = new File(testImage); // Path of directory or file

        boolean isDirectory = file.isDirectory(); // Boolean to see if directory or file
        if (isDirectory == true) { // If a directory,
            String folder = testImage; // Specify folder
            Path dir = Paths.get(folder); // Specify paths
            Files.walk(dir).forEach(path -> showFile(path.toFile())); // Run toFile to add paths to array
            filePath.remove(0); // Remove first index (It's the directory itself)

            filePath.forEach( (path) -> { // Start reading each file
                try {
                    readData(path); // Run readData function with path as argument
                } catch (IOException e) {
                    e.printStackTrace(); // Throw exception
                }
            });

        } else { // If not a directory, read single file
            readData(testImage);
        }
    }

    public void showFile(File file) {
        this.filePath.add(file.getAbsolutePath());
    }

    public void readData(String path) throws IOException {
        try {
            FileInputStream imageStream; // Declaring new FileInputStream to read file
            this.fileName = path; // Filepath

            File path2 = new File(fileName); // Getting whole path of the specified file
            String name = path2.getName(); // Getting just the name of the specified file
            String labelStr = Character.toString(name.charAt(0)); // Getting the character at the first index in the file name
            this.label = Integer.parseInt(labelStr); // Converting this character to integer value

            imageStream = new FileInputStream(fileName); // Declaring new FileInputStream to read file
            while(imageStream.available() > 0) { // Checking that image data is available

                byte[] red_Data = new byte[1024]; // Reading 1024 bytes of red data
                imageStream.read(red_Data);

                byte[] green_Data = new byte[1024]; // Reading 1024 bytes of green data
                imageStream.read(green_Data);

                byte[] blue_Data = new byte[1024]; // Reading 1024 bytes of blue data
                imageStream.read(blue_Data);

                BufferedImage img = new BufferedImage // New BufferedImage for the image being read
                        (32, 32, BufferedImage.TYPE_INT_ARGB);

                int image_width = img.getWidth(); // Getting the image width
                int image_height = img.getHeight(); // Getting the image height
                if (image_height > 32 && image_width > 32) { // Checking that image is 32 x 32 or less
                    ErrorView.errorMessage("Image: " + fileName + " is greater than 32x32.", "Image Size Error");
                } else {
                    this.greyscaleList = new ArrayList<>(); // Initialising list to store greyscale data

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

                            this.greyscaleList.add(greyscale); // Adding greyscale pixel data to greyscale list
                        }
                    }
                }
            }
            this.imageList.add(new TestImageModel // Creating new object containing all image data
                    (fileName, label, greyscaleList));
        } catch (NumberFormatException e) {
            ErrorView.errorMessage("Error reading image: " + fileName + ".", "Image Read Error");
        }
    }

    /**
     * Getters & setters
     */
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