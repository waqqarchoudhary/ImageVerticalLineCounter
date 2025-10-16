package com.tmmc.assignment.image;


/**
 * Factory class for creating ImageReader instances based on file type.
 */
public class ImageReaderFactory {
    private ImageReaderFactory(){}

    /**
     * Returns an ImageReader for the given file path.
     * @param filePath Path to the image file
     * @return ImageReader instance
     * @throws IllegalArgumentException if the file type is unsupported
     */
    public static ImageReader getReader(String filePath){
        if(filePath.toLowerCase().endsWith(".jpg") || filePath.toLowerCase().endsWith(".jpeg")){
            return new JpgImageReader();
        }
        throw new IllegalArgumentException("Unsupported image format. Only JPG is supported.");
    }
}
