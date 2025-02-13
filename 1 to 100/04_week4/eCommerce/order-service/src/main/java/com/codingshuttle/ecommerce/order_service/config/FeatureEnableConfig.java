package com.codingshuttle.ecommerce.order_service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RefreshScope
public class FeatureEnableConfig {

    @Value("${user-tracking-enabled}")
    private boolean uSerTrackFeature;

}
