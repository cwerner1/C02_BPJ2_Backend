package com.flattery;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration

public class ConfigurationClass {

    public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

    public ConfigurationClass() {
        String activeProfile = System.getProperty(SPRING_PROFILES_ACTIVE);
        if (activeProfile == null) {
            activeProfile = "dev";
        }

        switch (System.getProperty("os.name")) {
            case "Mac OS X":
                activeProfile = "mysql";
                break;
            case "linux":
                activeProfile = "mysql";
                break;
            case "windows":
                activeProfile = "mssql";
                break;

        }
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer
                = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]
                {new ClassPathResource("application.properties"),
                        new ClassPathResource("application-" + activeProfile + ".properties")};
        propertySourcesPlaceholderConfigurer.setLocations(resources);
    }
}
