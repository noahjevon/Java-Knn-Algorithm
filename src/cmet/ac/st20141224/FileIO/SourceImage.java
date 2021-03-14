package cmet.ac.st20141224.FileIO;

import java.awt.image.BufferedImage;

public class SourceImage {
    int label;
    int[] imagedata;
    int image_width;
    int image_height;
    BufferedImage buf_image;

    public SourceImage(int label, int[] image_data, int image_width, int image_height) {
        this.label = label;
        this.imagedata = image_data;
        this.image_width = image_width;
        this.image_height = image_height;

        generateBufferedImage();
    }


    private void generateBufferedImage() {
        if(imagedata.length > 0) {
            buf_image = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_ARGB);
            buf_image.setRGB(0, 0, image_width, image_height, imagedata, 0, image_width);
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
        return buf_image;
    }


    /**
     * @param buf_image the buf_image to set
     */
    public void setBuf_image(BufferedImage buf_image) {
        this.buf_image = buf_image;
    }

}
