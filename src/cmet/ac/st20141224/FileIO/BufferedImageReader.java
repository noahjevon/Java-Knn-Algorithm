package cmet.ac.st20141224.FileIO;


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


public class BufferedImageReader implements IFileReader {
    String testImage;
    String labelPath;

    FileInputStream in_stream_images;

    List<String> labelList;
    List<SourceImage> imageList;

    String fileName;
    BufferedImage img;

    public BufferedImageReader() {
        this.labelList = new ArrayList<>();
    }

    @Override
    public void read() throws IOException {
        String image_filename = testImage;

        in_stream_images = new FileInputStream(image_filename);

        // Read list of labels
//        labelList.clear();
//        Scanner s = new Scanner(new File(labelPath));
//        while (s.hasNext()) {
//            labelList.add(s.next());
//        }
//        s.close();

        while(in_stream_images.available() > 0) {

            byte[] red_Data = new byte[1024];
            in_stream_images.read(red_Data);

            byte[] green_Data = new byte[1024];
            in_stream_images.read(green_Data);

            byte[] blue_Data = new byte[1024];
            in_stream_images.read(blue_Data);

            BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);

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
                    System.out.println(color);
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
