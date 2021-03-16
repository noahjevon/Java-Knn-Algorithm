package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.SourceModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TrainingDatasetIO implements IFileReader {
    String CIFAR;
    String labelPath;

    FileInputStream in_stream_images;

    List<String> labelList;
    List<SourceModel> imageList;
    List<Integer> rgbList;


    public TrainingDatasetIO() {
        this.labelList = new ArrayList<>();
        this.imageList = new ArrayList<SourceModel>();
    }


    @Override
    public void read() throws IOException {

        String image_filename = CIFAR;

        in_stream_images = new FileInputStream(image_filename);

        // Read list of labels
        labelList.clear();
        Scanner s = new Scanner(new File(labelPath));
        while (s.hasNext()) {
            labelList.add(s.next());
        }
        s.close();

            while(in_stream_images.available() > 0) {
                int label = in_stream_images.read();
                String labelText = labelList.get(label).toString();
                System.out.println("Label: " + label + "Text label: " + labelList.get(label));

                byte[] red_Data = new byte[1024];
                in_stream_images.read(red_Data);

                byte[] green_Data = new byte[1024];
                in_stream_images.read(green_Data);

                byte[] blue_Data = new byte[1024];
                in_stream_images.read(blue_Data);

                BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
                this.rgbList = new ArrayList<>();

                for(int i=0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        Color color = new Color(
                                red_Data[i * 32 + j] & 0xFF,
                                green_Data[i * 32 + j] & 0xFF,
                                blue_Data[i * 32 + j] & 0xFF);
                        img.setRGB(i, j, color.getRGB());
                    }
                }
            }
        }


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

    @Override
    public void setLabelName(String labelName) {
        this.labelPath = labelName;
    }

}
