package com.swagger.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Configuration
public class DBQueryConfig {

    @Value("${feature.26Apr2019.isConfidentialAvailable:false}")
    boolean isConfidentialInSupportedAvailable;

    public LocalDateTime getCurrentTimestampUTC() {
        throw new UnsupportedOperationException("Should not be used for Oracle");
    }

    public String platform() { return "MySql"; }

    public boolean isConfidentialInSupported() { return isConfidentialInSupportedAvailable; }
}
