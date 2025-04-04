package org.javaguru.travel.insurance.rest.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TravelCalculatePremiumLogger {

    private final Logger logger = LoggerFactory.getLogger("RESPONSE_REQUEST_Logger");

    public void log(Object typeObject, String type){
        if(typeObject instanceof TravelCalculatePremiumResponse || typeObject instanceof TravelCalculatePremiumRequest){
            try{
                ObjectMapper mapper = getMapper();
                logger.info("{}: {}",type,mapper.writeValueAsString(typeObject));
            }catch (JsonProcessingException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private ObjectMapper getMapper(){
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

}
