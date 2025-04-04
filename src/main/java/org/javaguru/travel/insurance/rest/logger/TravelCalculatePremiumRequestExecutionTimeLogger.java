package org.javaguru.travel.insurance.rest.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TravelCalculatePremiumRequestExecutionTimeLogger {
    private final Logger logger = LoggerFactory.getLogger(
            TravelCalculatePremiumRequestExecutionTimeLogger.class);
    public void log(long startTime, long endTime){
        logger.info("Request processing time (ms): {}",endTime-startTime);
    }
}
