package com.tmmc.assignment.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Utility class for logging messages with timestamps.
 */
public class LoggerUtil {
    private LoggerUtil(){}

    /**
     * Logs a message to the console with a timestamp.
     * @param message Message to log
     */
    public static void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        System.out.println("[" + time + "] " + message);
    }
}
