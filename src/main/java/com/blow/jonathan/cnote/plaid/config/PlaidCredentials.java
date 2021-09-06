package com.blow.jonathan.cnote.plaid.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "plaid")
public class PlaidCredentials {
    private String clientId;
    private String clientSecret;
}
