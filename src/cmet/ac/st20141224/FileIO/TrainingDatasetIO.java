package cmet.ac.st20141224.FileIO;

import cmet.ac.st20141224.Model.TrainingDatasetModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TrainingDatasetIO implements IFileReader {
    private String CIFAR;

    private FileInputStream imageStream;

    private List<TrainingDatasetModel> imageList;
    private List<Integer> redList;
    private List<Integer> greenList;
    private List<Integer> blueList;
    private List<Integer> greyscaleList;


    public TrainingDatasetIO() {
        this.imageList = new ArrayList<TrainingDatasetModel>();
    }


    @Override
    public void read() throws IOException {

        String fileName = CIFAR;

        imageStream = new FileInputStream(fileName);

            while(imageStream.available() > 0) {
                int label = imageStream.read();

                byte[] red_Data = new byte[1024];
                imageStream.read(red_Data);

                byte[] green_Data = new byte[1024];
                imageStream.read(green_Data);

                byte[] blue_Data = new byte[1024];
                imageStream.read(blue_Data);

                BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);

                this.redList = new ArrayList<>();
                this.greenList = new ArrayList<>();
                this.blueList = new ArrayList<>();
                this.greyscaleList = new ArrayList<>();

                for(int i=0; i < 32; i++) {
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
                this.imageList.add(new TrainingDatasetModel(label, redList, greenList, blueList, greyscaleList));
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


}
