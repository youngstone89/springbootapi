package com.youngstone.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClassUsingProperty {

    @Value("${property.one}")
    private String propertyOne;

    public String retrievePropertyOne(){
        return propertyOne;
    }
}
