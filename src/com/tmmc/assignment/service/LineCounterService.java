package com.tmmc.assignment.service;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LineCounterService {

    //don't cache locally, always read from main memory
    private static volatile LineCounterService instance;
    private static final int BLACK_THRESHOLD = 50;

    private LineCounterService(){}

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

    private boolean isBlack(Color c){
        return c.getRed() < BLACK_THRESHOLD && c.getBlue() < BLACK_THRESHOLD && c.getGreen() < BLACK_THRESHOLD;
    }

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
