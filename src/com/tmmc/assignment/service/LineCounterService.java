package com.tmmc.assignment.service;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Service class for counting vertical black lines in a black and white image.
 * Implements a thread-safe singleton pattern.
 */
public class LineCounterService {

    //don't cache locally, always read from main memory
    private static volatile LineCounterService instance;
    private static final int BLACK_THRESHOLD = 50;

    private LineCounterService(){}

    /**
     * Returns the singleton instance of LineCounterService.
     * @return LineCounterService instance
     */
    public static LineCounterService getInstance(){
        if (instance == null) {
            synchronized (LineCounterService.class) {
                if(instance == null) {
                    instance = new LineCounterService();
                }
            }
        }
        return instance;
    }

    /**
     * Determines if a color is considered black based on a threshold.
     * @param c Color to check
     * @return true if the color is black, false otherwise
     */
    private boolean isBlack(Color c){
        return c.getRed() < BLACK_THRESHOLD && c.getBlue() < BLACK_THRESHOLD && c.getGreen() < BLACK_THRESHOLD;
    }

    /**
     * Counts the number of vertical black lines in the given image.
     * @param image BufferedImage to process
     * @return Number of vertical black lines
     */
    public int countVerticalLines(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
        int count = 0;
        boolean inLine = false;

        for(int x = 0; x< width; x++){
            boolean hasBlack = false;

            for(int y = 0; y < height; y++){
                Color c = new Color(image.getRGB(x,y));
                if(isBlack(c)){
                    hasBlack = true;
                    break;
                }
            }
            if(hasBlack && !inLine){
                count++;
                inLine = true;
            } else if (!hasBlack) {
                inLine = false;
            }
        }
        return count;
    }

}
