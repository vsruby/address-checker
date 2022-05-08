package com.vincentruby.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@SuperBuilder
public class CorrectedAddress extends InitialAddress {

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
