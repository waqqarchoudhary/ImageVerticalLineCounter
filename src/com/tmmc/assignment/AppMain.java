package com.tmmc.assignment;

import com.tmmc.assignment.exception.ImageProcessingException;
import com.tmmc.assignment.image.ImageReader;
import com.tmmc.assignment.image.ImageReaderFactory;
import com.tmmc.assignment.service.LineCounterService;
import com.tmmc.assignment.util.LoggerUtil;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

/**
 * TMMC Coding Assignment
 * Author: Waqqar Choudhary
 *
 * AppMain
 * Description: Console app that counts the number of vertical black lines in a black and white JPG image.
 */
public class AppMain {

    public static void main (String[] args) {

        String imagePath;

        if (args.length == 0) {
            System.out.print("Enter the absolute path of the image file: ");
            Scanner scanner = new Scanner(System.in);
            imagePath = scanner.nextLine().trim();
            scanner.close();
        }else {
            imagePath = args[0];
        }

        try{
            ImageReader reader = ImageReaderFactory.getReader(imagePath);
            BufferedImage image = reader.readImage(imagePath);

            LineCounterService counter = LineCounterService.getInstance();
            int count = counter.countVerticalLines(image);

            LoggerUtil.log("Number of vertical black lines: " + count);

        } catch (IllegalArgumentException e) {
           LoggerUtil.log("Error: " + e.getMessage());
        } catch (Exception e) {
            throw new ImageProcessingException("Unexpected error while processing image", e);
        }
    }
}
