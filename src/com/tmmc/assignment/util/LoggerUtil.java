package com.tmmc.assignment.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Utility class for logging messages with timestamps.
 */
public class LoggerUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LoggerUtil(){}

    public static void log(String message) {
        log("INFO", message);
    }

    public static void error(String message) {
        log("ERROR", message);
    }

    public static void warn(String message) {
        log("WARN", message);
    }
    /**
     * Logs a message to the console with a timestamp.
     * @param message Message to log
     */
    private static void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.println("[" + timestamp + "][" + level + "] " + message);
    }
}
