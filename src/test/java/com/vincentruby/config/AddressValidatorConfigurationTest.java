package com.vincentruby.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressValidatorConfigurationTest {

    @Test
    public void itShouldReturnTheApiKey() {
        String apiKey = "asdf";
        AddressValidatorConfiguration configuration = new AddressValidatorConfiguration(apiKey);

        assertEquals(apiKey, configuration.getApiKey());
    }
}
