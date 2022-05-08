package com.vincentruby.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvalidAddressTest {

    @Test
    public void itShouldThrowErrorIfTryingToCallAnyGetters() {
        InvalidAddress address = new InvalidAddress();

        assertThrows(Exception.class, address::getCity, "Not Supported");
        assertThrows(Exception.class, address::getPostalCode, "Not Supported");
        assertThrows(Exception.class, address::getStreetAddress, "Not Supported");
    }
}
