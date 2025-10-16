package com.tmmc.assignment.image;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Interface for reading images from a file path.
 */
public interface ImageReader {
    /**
     * Reads an image from the specified file path.
     * @param path Path to the image file
     * @return BufferedImage object
     * @throws IOException if the image cannot be read
     */
    BufferedImage readImage(String path) throws IOException;
}
