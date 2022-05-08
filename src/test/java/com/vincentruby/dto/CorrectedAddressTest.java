package com.vincentruby.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorrectedAddressTest {

    @Test
    public void itShouldCreateAToStringRepresentationOfTheAddress() {
        String city = "Columbus";
        String postalCode = "43215";
        String streetAddress = "123 e Maine Street";

        InitialAddress address = CorrectedAddress.builder()
                .city(city)
                .postalCode(postalCode)
                .streetAddress(streetAddress)
                .build();

        assertEquals("123 e Maine Street, Columbus, 43215", address.toString());
    }
}
