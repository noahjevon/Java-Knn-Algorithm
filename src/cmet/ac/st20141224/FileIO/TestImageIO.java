package cmet.ac.st20141224.FileIO;


import cmet.ac.st20141224.View.ErrorView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestImageIO implements IFileReader {
    String testImage;
    String labelPath;

    FileInputStream in_stream_images;

    List<String> labelList;
    List<SourceImage> imageList;

    String fileName;
    BufferedImage img;


    public TestImageIO() {
        this.labelList = new ArrayList<>();
    }

    
    @Override
    public void read() throws IOException {
        String image_filename = testImage;

        in_stream_images = new FileInputStream(image_filename);

//      Read list of labels
        labelList.clear();
        Scanner s = new Scanner(new File(labelPath));
        while (s.hasNext()) {
            labelList.add(s.next());
        }
        s.close();

        while(in_stream_images.available() > 0) {

            byte[] red_Data = new byte[1024];
            in_stream_images.read(red_Data);

            byte[] green_Data = new byte[1024];
            in_stream_images.read(green_Data);

            byte[] blue_Data = new byte[1024];
            in_stream_images.read(blue_Data);

            BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
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
                        // Combine individual red, green, blue into one RGB value
                        int rgb = (65536 * red) + (256 * green) + blue;  // Algorithm from StackOverflow user taskinoor
                        // https://stackoverflow.com/questions/4801366/convert-rgb-values-to-integer#comment95858351_4801446

                        // COMBINE ALL RED VALUES, GREEN VALUES, BLUE VALUES ETC. INTO ONE VALUE (GRAYSCALE IMAGE)
                    }
                }
            }
        }
    }

    @Override
    public Object getData() {
        return this.img;
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
