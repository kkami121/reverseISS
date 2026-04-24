package com.myproject.itemlink.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sso")
@Getter
@Setter
public class SsoProperties {

    private String secret;
    private String issuer;
    private String audience;
    private String claimName;
}
