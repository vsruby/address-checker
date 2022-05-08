package com.vincentruby.dto;

import com.vincentruby.contract.dto.Address;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@SuperBuilder
public class InitialAddress implements Address {

    protected final String city;
    protected final String postalCode;
    protected final String streetAddress;

    private static final String TO_STRING_TEMPLATE = "%s, %s, %s";

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, getStreetAddress(), getCity(), getPostalCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InitialAddress that = (InitialAddress) o;
        return Objects.equals(city, that.city)
                && Objects.equals(postalCode, that.postalCode)
                && Objects.equals(streetAddress, that.streetAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, postalCode, streetAddress);
    }
}
