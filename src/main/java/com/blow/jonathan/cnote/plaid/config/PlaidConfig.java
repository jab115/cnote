package com.blow.jonathan.cnote.plaid.config;

import com.plaid.client.ApiClient;
import com.plaid.client.request.PlaidApi;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@AllArgsConstructor
public class PlaidConfig {

    private PlaidCredentials plaidCredentials;

    @Bean
    public PlaidApi plaidClient(){
        HashMap<String, String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", plaidCredentials.getClientId());
        apiKeys.put("secret", plaidCredentials.getClientSecret());

        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(ApiClient.Development); // or equivalent, depending on which environment you're calling into
        return apiClient.createService(PlaidApi.class);
    }
}
