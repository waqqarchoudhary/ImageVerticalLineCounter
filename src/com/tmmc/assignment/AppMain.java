package com.tmmc.assignment;

import com.tmmc.assignment.exception.ImageProcessingException;
import com.tmmc.assignment.image.ImageReader;
import com.tmmc.assignment.image.ImageReaderFactory;
import com.tmmc.assignment.service.LineCounterService;
import com.tmmc.assignment.util.LoggerUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main application class for the TMMC Coding Assignment.
 * <p>
 * This console application counts the number of vertical black lines in a black and white JPG image.
 * </p>
 *
 * @author Waqqar Choudhary
 */
public class AppMain {

    /**
     * Entry point for the application. Handles user input and coordinates image processing.
     * @param args Command-line arguments (not used)
     */
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        LineCounterService counter = LineCounterService.getInstance();

        LoggerUtil.log("Image Vertical Line Counter Started");
        LoggerUtil.log("Type the full image path or 'Q' to quit.");

        while (true) {
            System.out.print("\nEnter the absolute path of the image file (or Q to quit): ");
            String imagePath = scanner.nextLine().trim();

            // Exit condition
            if (imagePath.equalsIgnoreCase("q")) {
                LoggerUtil.log("Exiting application. Goodbye!");
                break;
            }

            try {
                // Expand '~' for macOS/Linux
                if (imagePath.startsWith("~")) {
                    imagePath = imagePath.replaceFirst("^~", System.getProperty("user.home"));
                }

                // Normalize relative paths
                File file = new File(imagePath);
                if (!file.exists()) {
                    LoggerUtil.log("Error: File not found. Please enter a valid image path.");
                    continue;
                }

                ImageReader reader = ImageReaderFactory.getReader(imagePath);
                BufferedImage image = reader.readImage(imagePath);

                int count = counter.countVerticalLines(image);
                LoggerUtil.log("Number of vertical black lines: " + count);

            } catch (IllegalArgumentException e) {
                LoggerUtil.log("Error: " + e.getMessage());
            } catch (ImageProcessingException e) {
                LoggerUtil.log("Image processing error: " + e.getMessage());
            } catch (Exception e) {
                LoggerUtil.log("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }


}
