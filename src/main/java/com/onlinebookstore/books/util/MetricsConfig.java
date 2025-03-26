package com.onlinebookstore.books.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// Utility class for measuring and logging the execution time of various operations.

public class MetricsConfig {

    // Logger instance for recording performance metrics and operation details
    private static final Logger log = LoggerFactory.getLogger(MetricsConfig.class);

    // Name of the operation being tracked
    private final String operationName;
    // Time stamp when the operation started
    private final long startTime;

  //Constructor that initializes the operation name and records the start time.

    public MetricsConfig(String operationName) {
        this.operationName = operationName;
        this.startTime = System.currentTimeMillis();  // Record start time
        log.info("Starting operation: {}", operationName);
    }

  
    // Stops the tracking process and logs the total execution time of the operation.
    public void stop() {
        long endTime = System.currentTimeMillis();  // Capture end time
        long duration = endTime - startTime;        // Compute the elapsed
        log.info("Operation '{}' completed in {} ms", operationName, duration);
        log.info("***********************************************************\n");
    }
}