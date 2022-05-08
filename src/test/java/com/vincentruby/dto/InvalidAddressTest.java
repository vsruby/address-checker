package com.vincentruby.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidAddressTest {

    @Test
    public void itShouldThrowErrorIfTryingToCallAnyGetters() {
        InvalidAddress address = new InvalidAddress();

        Assertions.assertThrows(Exception.class, address::getCity, "Not Supported");
        Assertions.assertThrows(Exception.class, address::getPostalCode, "Not Supported");
        Assertions.assertThrows(Exception.class, address::getStreetAddress, "Not Supported");
    }
}
