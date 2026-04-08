package com.myproject.itemlink.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Profile("dev")
@Configuration
public class DevStaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String srcStaticPath = Paths.get(System.getProperty("user.dir"),
                "src", "main", "resources", "static").toUri().toString();

        registry.addResourceHandler("/**")
                .addResourceLocations(srcStaticPath)
                .setCachePeriod(0);
    }
}
