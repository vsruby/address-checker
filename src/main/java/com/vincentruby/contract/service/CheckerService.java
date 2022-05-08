package com.vincentruby.contract.service;

import com.vincentruby.contract.dto.Address;

import java.util.List;
import java.util.Map;

public interface CheckerService {

    /**
     * Check a single address and return the corrected address.
     *
     * @param address The address to check.
     *
     * @return The correct address.
     */
    Address check(Address address) throws Exception;

    /**
     * Check a list of addresses and return a map of the original address to the corrected address.
     *
     * @param addresses The addresses to check.
     *
     * @return A map of initial addresses to the correct addresses.
     */
    Map<Address, Address> checkAll(List<Address> addresses) throws Exception;
}
