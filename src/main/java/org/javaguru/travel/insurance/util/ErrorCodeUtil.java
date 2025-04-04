package org.javaguru.travel.insurance.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class ErrorCodeUtil {

    private final Properties props;

    ErrorCodeUtil() throws IOException {
        Resource resource = new ClassPathResource("errorCode.properties");
        props = PropertiesLoaderUtils.loadProperties(resource);
    }

    public String getErrorDesc(String errorCode) {
        return props.getProperty(errorCode);
    }

}
