package com.tmmc.assignment.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * ImageReader implementation for JPG images.
 */
public class JpgImageReader implements ImageReader{

    /**
     * Reads a JPG image from the specified file path.
     * @param path Path to the JPG image file
     * @return BufferedImage object
     * @throws IOException if the image cannot be read or is invalid
     */
    @Override
    public BufferedImage readImage(String path) throws IOException {
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        if(image == null) {
            throw new IOException("Invalid or unsupported JPG file: " + path);
        }
        return image;
    }
}
