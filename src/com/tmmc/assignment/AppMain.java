package com.tmmc.assignment;

import com.tmmc.assignment.exception.ImageProcessingException;
import com.tmmc.assignment.image.ImageReader;
import com.tmmc.assignment.image.ImageReaderFactory;
import com.tmmc.assignment.service.LineCounterService;
import com.tmmc.assignment.util.LoggerUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

/**
 * Main application class for the TMMC Coding Assignment.
 *
 * This console application counts the number of vertical black lines in
 * a black and white JPG image. It supports one command-line argument
 * (image path), or prompts the user interactively if none is provided.
 *
 * The program enforces that exactly one path is entered at a time,
 * handles errors gracefully, and continues until the user enters 'Q' or 'q'.
 *
 * Author: Waqqar Choudhary
 */
public class AppMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LineCounterService counter = LineCounterService.getInstance();

        LoggerUtil.log("Image Vertical Line Counter Started");
        LoggerUtil.log("Tip: Sample test images are located in the 'images' directory of this project.");
        LoggerUtil.log("Provide one image path at a time, or type 'Q' to quit.");

        String imagePath = null;

        // --- Handle command-line arguments ---
        if (args.length == 1) {
            imagePath = args[0].trim();
        } else if (args.length > 1) {
            LoggerUtil.error("Invalid number of arguments. Please provide exactly one image path.");
        }

        // --- Main program loop ---
        while (true) {
            try {
                // If no valid argument, prompt user
                if (imagePath == null || imagePath.isEmpty()) {
                    System.out.print("Enter the absolute path of the image file (or Q to quit): ");
                    String inputLine = scanner.nextLine().trim();

                    // Exit condition
                    if (inputLine.equalsIgnoreCase("q")) {
                        LoggerUtil.log("Exiting application. Goodbye!");
                        break;
                    }

                    // Split by whitespace to check for multiple paths
                    String[] parts = inputLine.split("\\s+");
                    if (parts.length != 1) {
                        LoggerUtil.error("Please provide exactly one image path at a time.");
                        continue; // reprompt the user
                    }

                    imagePath = parts[0];
                }

                // Expand '~' for macOS/Linux
                if (imagePath.startsWith("~")) {
                    imagePath = imagePath.replaceFirst("^~", System.getProperty("user.home"));
                }

                // Validate file existence
                File file = new File(imagePath);
                if (!file.exists()) {
                    LoggerUtil.error("File not found. Please enter a valid image path.");
                    imagePath = null; // re-prompt
                    continue;
                }

                // Process image
                ImageReader reader = ImageReaderFactory.getReader(imagePath);
                BufferedImage image = reader.readImage(imagePath);
                int count = counter.countVerticalLines(image);

                LoggerUtil.log("File processed: " + imagePath + " | Number of vertical black lines: " + count);

            } catch (IllegalArgumentException e) {
                LoggerUtil.error("Illegal or inappropriate argument error: " + e.getMessage());
            } catch (ImageProcessingException e) {
                LoggerUtil.error("Image processing error: " + e.getMessage());
            } catch (Exception e) {
                LoggerUtil.error("Unexpected error: " + e.getMessage());
            }

            // Reset path for next prompt
            imagePath = null;
        }

        scanner.close();
    }
}
