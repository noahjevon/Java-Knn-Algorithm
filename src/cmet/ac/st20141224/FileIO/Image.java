package cmet.ac.st20141224.FileIO;

import java.awt.image.BufferedImage;

public class Image {
    int label;
    int[] imagedata;
    int image_width;
    int image_height;
    BufferedImage buf_image;

    public Image(int var1, int[] var2, int var3, int var4) {
        this.label = label;
        this.imagedata = imagedata;
        this.image_width = image_width;
        this.image_height = image_height;

        this.generateBufferedImage();
    }

    private void generateBufferedImage() {
        if (this.imagedata.length > 0) {
            this.buf_image = new BufferedImage(this.image_width, this.image_height, 2);
            this.buf_image.setRGB(0, 0, this.image_width, this.image_height, this.imagedata, 0, this.image_width);
        }
    }

    public int getLabel() {
        return this.label;
    }

    public void setLabel(int var1) {
        this.label = var1;
    }

    public int[] getImagedata() {
        return this.imagedata;
    }

    public void setImagedata(int[] var1) {
        this.imagedata = var1;
    }

    public int getImage_width() {
        return this.image_width;
    }

    public void setImage_width(int var1) {
        this.image_width = var1;
    }

    public int getImage_height() {
        return this.image_height;
    }

    public void setImage_height(int var1) {
        this.image_height = var1;
    }

    public java.awt.image.BufferedImage getBuf_image() {
        return this.buf_image;
    }

    public void setBuf_image(java.awt.image.BufferedImage var1) {
        this.buf_image = var1;
    }
}
