package com.vincentruby.service;

import com.vincentruby.client.AddressValidatorClient;
import com.vincentruby.contract.dto.Address;
import com.vincentruby.dto.CorrectedAddress;
import com.vincentruby.dto.InitialAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressValidatorCheckerServiceTest {

    private AddressValidatorClient mockClient;

    private AddressValidatorCheckerService service;

    @BeforeEach
    public void setup() {
        mockClient = Mockito.mock(AddressValidatorClient.class);

        service = new AddressValidatorCheckerService(mockClient);
    }

    @Test
    public void itShouldCallToTheClientForSingleCheck() throws Exception {
        String initialStreetAddress = "123 e Maine Street";
        String initialCity = "Columbus";
        String initialPostalCode = "43215";

        String correctedStreetAddress = "123 E Main St";
        String correctedCity = "Columbus";
        String correctedPostalCode = "43215-5207";

        Address initialAddress = InitialAddress.builder()
                .city(initialCity)
                .postalCode(initialPostalCode)
                .streetAddress(initialStreetAddress)
                .build();

        Address correctedAddress = CorrectedAddress.builder()
                .city(correctedCity)
                .postalCode(correctedPostalCode)
                .streetAddress(correctedStreetAddress)
                .build();

        Mockito.when(mockClient.check(initialAddress)).thenReturn(correctedAddress);

        assertEquals(correctedAddress, service.check(initialAddress));
    }

    @Test
    public void itShouldCallToTheClientForMultiCheck() throws Exception {
        String initialStreetAddress = "123 e Maine Street";
        String initialCity = "Columbus";
        String initialPostalCode = "43215";

        String correctedStreetAddress = "123 E Main St";
        String correctedCity = "Columbus";
        String correctedPostalCode = "43215-5207";

        Address initialAddress = InitialAddress.builder()
                .city(initialCity)
                .postalCode(initialPostalCode)
                .streetAddress(initialStreetAddress)
                .build();

        Address correctedAddress = CorrectedAddress.builder()
                .city(correctedCity)
                .postalCode(correctedPostalCode)
                .streetAddress(correctedStreetAddress)
                .build();

        Mockito.when(mockClient.check(initialAddress)).thenReturn(correctedAddress);

        Map<Address, Address> addresses = service.checkAll(List.of(initialAddress));

        assertEquals(1, addresses.size());
        assertEquals(initialAddress, addresses.entrySet().stream().findFirst().get().getKey());
        assertEquals(correctedAddress, addresses.entrySet().stream().findFirst().get().getValue());
    }
}
