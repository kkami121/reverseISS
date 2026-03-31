package com.myproject.itemlink.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kaccounting")
@Getter
@Setter
public class KaccountingProperties {

    private String baseUrl;
    private String token;
}
