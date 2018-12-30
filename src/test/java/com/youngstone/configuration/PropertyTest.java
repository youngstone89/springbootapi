package com.youngstone.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClassUsingProperty.class)
@TestPropertySource
public class PropertyTest {

    @Autowired
    ClassUsingProperty classUsingProperty;

    @Test
    public void givenDefaultTPS_whenVariableRetrieved_thenDefaultFileReturned() {
        String output = classUsingProperty.retrievePropertyOne();

        assertThat(output).isEqualTo("default-value");
    }
}
