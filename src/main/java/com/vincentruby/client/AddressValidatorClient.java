package com.vincentruby.client;

import com.vincentruby.contract.dto.Address;
import com.vincentruby.dto.CorrectedAddress;
import com.vincentruby.dto.InvalidAddress;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class AddressValidatorClient {

    private static final String API_URL = "https://api.address-validator.net/api/verify";

    private final String apiKey;
    private final HttpClient httpClient = new DefaultHttpClient();

    public Address check(Address address) throws Exception {
        HttpPost request = new HttpPost(API_URL);

        List<NameValuePair> input = new ArrayList<>();
        input.add(new BasicNameValuePair("StreetAddress", address.getStreetAddress()));
        input.add(new BasicNameValuePair("City", address.getCity()));
        input.add(new BasicNameValuePair("PostalCode", address.getPostalCode()));
        input.add(new BasicNameValuePair("APIKey", apiKey));

        request.setEntity(new UrlEncodedFormEntity(input));

        HttpResponse response = httpClient.execute(request);

        String output = EntityUtils.toString(response.getEntity(), "UTF-8");

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(output);
        JSONObject jsonObject = (JSONObject) obj;

        String status = (String) jsonObject.get("status");
        if (status.equalsIgnoreCase("VALID")) {
            String formattedAddress = (String) jsonObject.get("formattedaddress");
            // do stuff
        } else {
            return new InvalidAddress();
        }

        return new InvalidAddress();
    }
}
