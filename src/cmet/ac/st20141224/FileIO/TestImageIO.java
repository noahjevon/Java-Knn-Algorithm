package cmet.ac.st20141224.FileIO;

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
    String testImage;
    String labelPath;

    private List<TestImageModel> imageList;

    FileInputStream in_stream_images;
    BufferedImage img;

    private List<Integer> redList;
    private List<Integer> greenList;
    private List<Integer> blueList;
    private List<Integer> greyscaleList;

    public TestImageIO() {
        this.imageList = new ArrayList<TestImageModel>();
    }

    
    @Override
    public void read() throws IOException {
        String image_filename = testImage;

        in_stream_images = new FileInputStream(image_filename);
        // Long process, probably a better way to do this. Getting first index in file name and converting to int for label
        File path = new File(getFilename());
        String name = path.getName();
        String labelStr = Character.toString(name.charAt(0));
        int label = Integer.parseInt(labelStr);

        while(in_stream_images.available() > 0) {

            byte[] red_Data = new byte[1024];
            in_stream_images.read(red_Data);

            byte[] green_Data = new byte[1024];
            in_stream_images.read(green_Data);

            byte[] blue_Data = new byte[1024];
            in_stream_images.read(blue_Data);

            BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);

            this.redList = new ArrayList<>();
            this.greenList = new ArrayList<>();
            this.blueList = new ArrayList<>();
            this.greyscaleList = new ArrayList<>();

            int image_width = img.getWidth();
            int image_height = img.getHeight();
            if (image_height > 32 && image_width > 32) {  // Error message just in case image is not shrunk to 32x32
                ErrorView.errorMessage("Image cannot be greater than 32x32!", "Image Size Error");
            } else {

                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        Color color = new Color(
                                red_Data[i * 32 + j] & 0xFF,
                                green_Data[i * 32 + j] & 0xFF,
                                blue_Data[i * 32 + j] & 0xFF);
                        img.setRGB(i, j, color.getRGB());

                        int red = red_Data[i * 32 + j] & 0xFF;
                        int green = green_Data[i * 32 + j] & 0xFF;
                        int blue = blue_Data[i * 32 + j] & 0xFF;
                        int greyscale = (int) ((0.3 * red) + (0.59 * green) + (0.11 * blue));

                        this.redList.add(red);
                        this.greenList.add(green);
                        this.blueList.add(blue);
                        this.greyscaleList.add(greyscale);
                    }
                }
            }
        }
        this.imageList.add(new TestImageModel(label, redList, greenList, blueList, greyscaleList));
    }

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

    @Override
    public void setLabelName(String labelName) {
        this.labelPath = labelName;
    }
}
