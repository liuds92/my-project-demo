package com.liuds.config;


import com.liuds.config.properties.MycloudProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The class core config.
 *
 * @author
 */
@Configuration
@EnableConfigurationProperties(MycloudProperties.class)
public class MycloudCoreConfig {
}
