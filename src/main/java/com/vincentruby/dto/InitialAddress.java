package com.vincentruby.dto;

import com.vincentruby.contract.dto.Address;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class InitialAddress implements Address {

    private final String city;
    private final String postalCode;
    private final String streetAddress;

    private static final String TO_STRING_TEMPLATE = "%s, %s, %s";

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, getStreetAddress(), getCity(), getPostalCode());
    }
}
