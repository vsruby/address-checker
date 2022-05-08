package com.vincentruby.service;

import com.vincentruby.client.AddressValidatorClient;
import com.vincentruby.contract.dto.Address;
import com.vincentruby.contract.service.CheckerService;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class AddressValidatorCheckerService implements CheckerService {

    private final AddressValidatorClient client;

    @Override
    public Address check(Address address) throws Exception {
        return null;
    }

    @Override
    public Map<Address, Address> checkAll(List<Address> addresses) throws Exception {
        Map<Address, Address> checked = new HashMap<>();
        for (Address address : addresses) {
            checked.put(address, check(address));
        }

        return checked;
    }
}
