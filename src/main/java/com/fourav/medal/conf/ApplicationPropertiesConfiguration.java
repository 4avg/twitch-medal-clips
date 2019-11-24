package com.fourav.medal.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties( prefix = "application", ignoreUnknownFields = true , ignoreInvalidFields = true)
public class ApplicationPropertiesConfiguration {
}
