package com.blow.jonathan.cnote.plaid.service;

import com.google.gson.Gson;
import com.plaid.client.model.ItemPublicTokenExchangeRequest;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import com.plaid.client.request.PlaidApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import javax.annotation.PostConstruct;

import static java.lang.String.format;

@Slf4j
@Service
@AllArgsConstructor
public class PlaidService {

    private PlaidApi plaidClient;

    @PostConstruct
    public void getTransacationData() throws Exception {
        ItemPublicTokenExchangeRequest request = new ItemPublicTokenExchangeRequest().publicToken("the_link_public_token");
        Response<ItemPublicTokenExchangeResponse> response = plaidClient.itemPublicTokenExchange(request).execute();

        if (response.isSuccessful()) {
            String accessToken = response.body().getAccessToken();
        }

// Decoding an unsuccessful response
        try {
            Gson gson = new Gson();
            Error error = gson.fromJson(response.errorBody().string(), Error.class);
            log.info(error.getMessage());
        } catch (Exception e) {
            throw new Exception(format("Failed converting from API Response Error Body to Error %f", response.errorBody().string()));
        }
    }
}
