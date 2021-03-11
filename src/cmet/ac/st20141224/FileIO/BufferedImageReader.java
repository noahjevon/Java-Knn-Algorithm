package cmet.ac.st20141224.FileIO;


import java.awt.image.BufferedImage;
import java.io.IOException;


public class BufferedImageReader {
    int label;
    int[] imagedata;
    int image_width;
    int image_height;
    BufferedImage img;


    public BufferedImageReader(int label, int[] image_data, int image_width, int image_height) {
        this.label = label;
        this.imagedata = image_data;
        this.image_width = image_width;
        this.image_height = image_height;
        this.generateBufferedImage();
    }


    private void generateBufferedImage() {
        if(imagedata.length > 0) {
            this.img = new BufferedImage(this.image_width, this.image_height, 2);
            this.img.setRGB(0, 0, this.image_width, this.image_height, this.imagedata, 0, this.image_width);
        }
    }


    /**
     * @return the label
     */
    public int getLabel() {
        return label;
    }


    /**
     * @param label the label to set
     */
    public void setLabel(int label) {
        this.label = label;
    }


    /**
     * @return the imagedata
     */
    public int[] getImagedata() {
        return imagedata;
    }


    /**
     * @param imagedata the imagedata to set
     */
    public void setImagedata(int[] imagedata) {
        this.imagedata = imagedata;
    }


    /**
     * @return the image_width
     */
    public int getImage_width() {
        return image_width;
    }


    /**
     * @param image_width the image_width to set
     */
    public void setImage_width(int image_width) {
        this.image_width = image_width;
    }


    /**
     * @return the image_height
     */
    public int getImage_height() {
        return image_height;
    }


    /**
     * @param image_height the image_height to set
     */
    public void setImage_height(int image_height) {
        this.image_height = image_height;
    }


    /**
     * @return the buf_image
     */
    public BufferedImage getBuf_image() {
        return img;
    }


    /**
     * @param buf_image the buf_image to set
     */
    public void setBuf_image(BufferedImage buf_image) {
        this.img = buf_image;
    }
}
