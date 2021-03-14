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
        int label_start_code = read4bytes(in_stream_images);
        System.out.println("Label start code: " + label_start_code);

        //read image start code. read 4 bytes, and assemble
        int image_start_code = read4bytes(in_stream_images);
        System.out.println("Image start code: " + image_start_code);

        // read next 4 bytes
        number_of_labels = read4bytes(in_stream_images);
        number_of_images = read4bytes(in_stream_images);

        System.out.println("Number of labels: " + number_of_labels + " , number of images: " + number_of_images);

        // read next 4 bytes
        image_width = read4bytes(in_stream_images);
        image_height = read4bytes(in_stream_images);

        System.out.println("Image width: " + image_width + " , Image height: " + image_height);
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
        int value =
                    (in_stream.read() << 32) |
                    (in_stream.read() << 24) |
                    (in_stream.read() << 16) |
                    (in_stream.read());
        return value;
    }
}
