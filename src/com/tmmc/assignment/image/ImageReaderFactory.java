package com.tmmc.assignment.image;

public class ImageReaderFactory {
    private ImageReaderFactory(){}

    public static ImageReader getReader(String filePath){
        if(filePath.toLowerCase().endsWith(".jpg") || filePath.toLowerCase().endsWith(".jpeg")){
            return new JpgImageReader();
        }
        throw new IllegalArgumentException("Unsupported image format. Only JPG is supported.");
    }
}
