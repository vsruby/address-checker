package com.vincentruby.dto;

import com.vincentruby.contract.dto.Address;

public class InvalidAddress implements Address {

    private static final String TO_STRING_MESSAGE = "Invalid Address";

    @Override
    public String getCity() throws Exception {
        throw new Exception("Not Supported");
    }

    @Override
    public String getPostalCode() throws Exception {
        throw new Exception("Not Supported");
    }

    @Override
    public String getStreetAddress() throws Exception {
        throw new Exception("Not Supported");
    }

    @Override
    public String toString() {
        return TO_STRING_MESSAGE;
    }
}
