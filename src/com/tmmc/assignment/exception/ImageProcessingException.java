package com.tmmc.assignment.exception;


/**
 * Custom exception for image processing errors.
 */
public class ImageProcessingException extends RuntimeException{

    /**
     * Constructs a new ImageProcessingException with the specified detail message.
     * @param message the detail message
     */
    public ImageProcessingException (String message) {
        super(message);
    }

    /**
     * Constructs a new ImageProcessingException with the specified detail message and cause.
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public ImageProcessingException (String message, Throwable cause) {
        super(message, cause);
    }
}
