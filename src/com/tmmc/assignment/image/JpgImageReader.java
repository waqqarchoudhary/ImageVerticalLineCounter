package com.tmmc.assignment.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JpgImageReader implements ImageReader{

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
