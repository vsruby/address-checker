package com.vincentruby;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.vincentruby.client.AddressValidatorClient;
import com.vincentruby.config.AddressValidatorConfiguration;
import com.vincentruby.contract.dto.Address;
import com.vincentruby.contract.service.CheckerService;
import com.vincentruby.dto.InitialAddress;
import com.vincentruby.service.AddressValidatorCheckerService;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {

    private static final String API_KEY_ENV = "ADDRESS_VERIFICATION_API_KEY";

    public static void main(String[] args) {
        // setup
        Dotenv dotenv = loadEnv();
        AddressValidatorConfiguration configuration = addressValidatorConfiguration(dotenv);
        AddressValidatorClient validatorClient = addressValidatorClient(configuration);
        CheckerService checkerService = checkerService(validatorClient);

        // read in addresses from csv
        List<Address> addresses = readAddresses();

        // run address checks
        if (!addresses.isEmpty()) {
            try {
                Map<Address, Address> results = checkerService.checkAll(addresses);
                results.forEach((key, value) -> System.out.println(key + " -> " + value));
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        } else {
            System.out.println("There were no addresses provided...");
        }
    }

    private static AddressValidatorConfiguration addressValidatorConfiguration(Dotenv dotenv) {
        return new AddressValidatorConfiguration(dotenv.get(API_KEY_ENV));
    }

    private static AddressValidatorClient addressValidatorClient(AddressValidatorConfiguration configuration) {
        return new AddressValidatorClient(configuration.getApiKey());
    }

    private static CheckerService checkerService(AddressValidatorClient client) {
        return new AddressValidatorCheckerService(client);
    }

    private static CSVReader csvReader() {
        // NOTE: 5/8/22 assuming csv has a header
        InputStream inputStream = App.class.getResourceAsStream("/csvs/addresses.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .build();
    }

    private static Dotenv loadEnv() {
        return Dotenv.load();
    }

    private static List<Address> readAddresses() {
        List<List<String>> raw = new ArrayList<>();
        try (CSVReader csvReader = csvReader()) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                raw.add(Arrays.asList(values));
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        List<Address> addresses = new ArrayList<>();
        raw.forEach(item -> {
            Address address = InitialAddress.builder()
                    .streetAddress(item.get(0))
                    .city(item.get(1))
                    .postalCode(item.get(2))
                    .build();

            addresses.add(address);
        });

        return addresses;
    }
}
