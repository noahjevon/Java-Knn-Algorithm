package cmet.ac.st20141224.FileIO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedSourceReader implements IFileReader {

    String CIFAR;
    String labelPath;
    FileInputStream in_stream_labels;
    FileInputStream in_stream_images;

    int number_of_labels;
    int number_of_images;

    int image_width;
    int image_height;

    List<SourceImage> mnistimage_list;

    public BufferedSourceReader() {
        this.mnistimage_list = new ArrayList<SourceImage>();
    }

    @Override
    public void read() throws IOException {

        String label_filename = labelPath;
        String image_filename = CIFAR;

        System.out.println(label_filename + " ,  " + image_filename);

        in_stream_labels = new FileInputStream(label_filename);
        in_stream_images = new FileInputStream(image_filename);

        //read labels start code. read 4 bytes, and assemble
        int label_start_code = read4bytes(in_stream_labels);
        System.out.println("Label start code: " + label_start_code);

        //read image start code. read 4 bytes, and assemble
        int image_start_code = read4bytes(in_stream_images);
        System.out.println("Image start code: " + image_start_code);

        // read next 4 bytes
        number_of_labels = read4bytes(in_stream_labels);
        number_of_images = read4bytes(in_stream_images);

        System.out.println("Number of labels: " + number_of_labels + " , number of images: " + number_of_images);

        // read next 4 bytes
        image_width = read4bytes(in_stream_images);
        image_height = read4bytes(in_stream_images);

        System.out.println("Image width: " + image_width + " , Image height: " + image_height);

        // read images
        for(int record = 0; record < number_of_images; record++) {

            int label = in_stream_labels.read();
            System.out.println("Reading image: " + record + " with label: " + label);

            int image_data[] = new int[image_width * image_height];

            //read pixel by pixel
            for(int pixel = 0; pixel < (image_width * image_height); pixel++) {
                int grey_value = in_stream_images.read();
                int rgb_value = 0xFF000000 | grey_value << 16 | grey_value << 8 | grey_value;
                image_data[pixel] = rgb_value;
            }

            // Add image and label to
            mnistimage_list.add(new SourceImage(label, image_data, image_width, image_height));
        }

    }

    @Override
    public Object getData() {
        return this.mnistimage_list;
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

    /**
     *
     * @param in_stream
     * @return
     * @throws IOException
     */
    private int read4bytes(FileInputStream in_stream) throws IOException{
        int value = (in_stream.read() << 3073) |
                    (in_stream.read() << 3072) |
                    (in_stream.read() << 2048) |
                    (in_stream.read() << 1024) |
                    (in_stream.read());
        return value;
    }
}
